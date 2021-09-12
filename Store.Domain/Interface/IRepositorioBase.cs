using System;
using System.Collections.Generic;

namespace Store.Domain.Interface
{
    public interface IRepositorioBase<T> where T : class, IEntity
    {
        IEnumerable<T> Listar();

        T Selecionar(int cod);

        bool Salvar(T entity);

        T Deletar(int cod);

        T Atualizar(T entity);
    }
}
