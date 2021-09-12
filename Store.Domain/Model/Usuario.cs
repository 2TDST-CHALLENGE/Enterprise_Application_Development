using Store.Domain.Interface;

namespace Store.Domain
{
    public class Usuario : IEntity
    {
        public int Cod { get; set; }
        public string Email { get; set; }
        public string UserName { get; set; }
        public string Password { get; set; }
    }
}
