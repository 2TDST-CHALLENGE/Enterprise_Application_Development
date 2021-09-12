using Microsoft.AspNetCore.Mvc;
using Store.Data;
using Store.Domain;

namespace Store.Api.Controllers
{
    [Route("api/[controller]")]
    [ApiController]
    public class UsuarioController : ControllerBase
    {
        private readonly RepositorioBase<Usuario> UsuarioRepo;
    }
}
