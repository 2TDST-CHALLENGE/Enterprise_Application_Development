using Store.Domain.Interface;
using System;

namespace Store.Domain.Model
{
    public class EstabelecimentoSaldo : IEntity
    {
        public int Cod { get; set; }
        public decimal Saldo { get; set; }
        public DateTime DataSaldo { get; set;
        }
    }
}
