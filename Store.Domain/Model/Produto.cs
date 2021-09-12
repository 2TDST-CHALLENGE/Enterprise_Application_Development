using Store.Domain.Interface;
using System;
using System.Collections.Generic;
using System.Text;

namespace Store.Domain.Model
{
    public class Produto : IEntity
    {
        public int Cod { get; set; }
        public int CodEstabelecimento { get; set; }
        public string NomeProduto { get; set; }
        public string DescricaoProduto { get; set; }
        public int QuantidadeProduto { get; set; }
        public string ValorProduto { get; set; }
        public DateTime ValidadeProduto { get; set; }
        public DateTime DataEntrada { get; set; }
        public DateTime DataSaida { get; set; }
        public int CodCategoria { get; set; }
    }
}
