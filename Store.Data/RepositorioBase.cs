using Dapper;
using Microsoft.Extensions.Configuration;
using Store.Domain.Interface;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Reflection;
using System.Text;

namespace Store.Data
{
    public class RepositorioBase<T> : IRepositorioBase<T> where T : class, IEntity
    {
        private readonly IConfiguration _config;
        private readonly string _tabela;

        public RepositorioBase(IConfiguration config, string tabela)
        {
            _config = config;
            _tabela = tabela;
        }

        public T Atualizar(T entity)
        {
            using (var con = new SqlConnection(GetConnection()))
            {
                var sqlComand = GerarUpdateQuery();
                con.Execute(sqlComand, entity);
            }

            return Selecionar(entity.Cod);
        }

        public T Deletar(int cod)
        {
            T entity = Selecionar(cod);
            using (var con = new SqlConnection(GetConnection()))
            {
                var sqlComand = $"DELETE FROM {_tabela} WHERE Guid=@Guid";
                var RowsAffect = con.Execute(sqlComand, new { Cod = cod });

                if (RowsAffect <= 0)
                {
                    con.Close();
                    throw new Exception();
                }
            }

            return entity;
        }

        public IEnumerable<T> Listar()
        {
            IEnumerable<T> entitys;
            using (var con = new SqlConnection(GetConnection()))
            {
                var query = $"select * from {_tabela}";
                entitys = con.Query<T>(query);
            }

            return entitys;
        }

        public bool Salvar(T entity)
        {
            bool isSucesso = false;
            using (var con = new SqlConnection(GetConnection()))
            {
                var sqlComand = GerarInsertQuery();
                var RowsAffect = con.Execute(sqlComand, entity);

                isSucesso = (RowsAffect > 0);
            }

            return isSucesso;
        }

        public T Selecionar(int cod)
        {
            T entity;
            using (var con = new SqlConnection(GetConnection()))
            {
                var querys = $"select * from {_tabela} where Guid=@Guid";
                entity = con.Query<T>(querys, new { Cod = cod }).FirstOrDefault();
            }
            return entity;
        }

        private IEnumerable<PropertyInfo> GetProperties => typeof(T).GetProperties();

        private string GerarInsertQuery()
        {
            var insertQuery = new StringBuilder($"INSERT INTO {_tabela} ");

            insertQuery.Append("(");

            var properties = GenerateListOfProperties(GetProperties);
            properties.ForEach(prop => { insertQuery.Append($"[{prop}],"); });

            insertQuery
                .Remove(insertQuery.Length - 1, 1)
                .Append(") VALUES (");

            properties.ForEach(prop => { insertQuery.Append($"@{prop},"); });

            insertQuery
                .Remove(insertQuery.Length - 1, 1)
                .Append(")");

            return insertQuery.ToString();
        }

        private string GerarUpdateQuery()
        {
            var updateQuery = new StringBuilder($"UPDATE {_tabela} SET ");
            var properties = GenerateListOfProperties(GetProperties);

            properties.ForEach(property =>
            {
                if (!property.Equals("Id"))
                {
                    updateQuery.Append($"{property}=@{property},");
                }
            });

            updateQuery.Remove(updateQuery.Length - 1, 1);
            updateQuery.Append(" WHERE Guid=@Guid");

            return updateQuery.ToString();
        }

        private List<string> GenerateListOfProperties(IEnumerable<PropertyInfo> listOfProperties)
        {
            return (from prop in listOfProperties
                    let attributes = prop.GetCustomAttributes(typeof(DescriptionAttribute), false)
                    where attributes.Length <= 0 || prop.Name != "Guid"
                    select prop.Name).ToList();
        }
        public string GetConnection()
        {
            var conn = _config.GetSection("ConnectionString").GetSection("db").Value;
            return conn;
        }
    }

    internal static class DapperHelper
    {
        public static IEnumerable<TParent> QueryParentChild<TParent, TChild, TParentKey>(
            this IDbConnection connection,
            string sql,
            Func<TParent, TParentKey> parentKeySelector,
            Func<TParent, IList<TChild>> childSelector,
            dynamic param = null, IDbTransaction transaction = null, bool buffered = true, string splitOn = "Id", int? commandTimeout = null, CommandType? commandType = null)
        {
            Dictionary<TParentKey, TParent> cache = new Dictionary<TParentKey, TParent>();

            connection.Query<TParent, TChild, TParent>(
                sql,
                (parent, child) =>
                {
                    if (!cache.ContainsKey(parentKeySelector(parent)))
                    {
                        cache.Add(parentKeySelector(parent), parent);
                    }

                    TParent cachedParent = cache[parentKeySelector(parent)];
                    IList<TChild> children = childSelector(cachedParent);
                    children.Add(child);
                    return cachedParent;
                },
                param as object, transaction, buffered, splitOn, commandTimeout, commandType);

            return cache.Values;
        }
    }
}
