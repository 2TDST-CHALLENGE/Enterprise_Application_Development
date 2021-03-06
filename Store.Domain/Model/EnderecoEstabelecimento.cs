using Store.Domain.Interface;
using System;
using System.Collections.Generic;
using System.Text;

namespace Store.Domain.Model
{
    public class EnderecoEstabelecimento : IEntity
    {
        public int Cod { get; set; }
        public int Cep { get; set; }
        public string UF { get; set; }
        public string Bairro { get; set; }
        public string Logradouro { get; set; }
        public int Numero { get; set; }
        public string Complemento { get; set; }
        public string Cidade { get; set; }
    }
}
