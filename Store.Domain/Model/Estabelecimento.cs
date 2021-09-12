using Store.Domain.Interface;
using System;
using System.Collections.Generic;
using System.Text;

namespace Store.Domain.Model
{
    public class Estabelecimento : IEntity
    {
        public int Cod { get; set; }
        public string NomeFantasia { get; set; }
        public string RazaoSocial { get; set; }
        public int Cnpj { get; set; }
        public string RamoAtuacao { get; set; }
        public int Celular { get; set; }
    }
}
