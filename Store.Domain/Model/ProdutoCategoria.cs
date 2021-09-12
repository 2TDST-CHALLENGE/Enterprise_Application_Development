using Store.Domain.Interface;
using System;
using System.Collections.Generic;
using System.Text;

namespace Store.Domain.Model
{
    public class ProdutoCategoria : IEntity
    {
        public int Cod { get; set; }
        public string NomeCategoria { get; set; }
        public string DescricaoCategoria { get; set; }
    }
}
