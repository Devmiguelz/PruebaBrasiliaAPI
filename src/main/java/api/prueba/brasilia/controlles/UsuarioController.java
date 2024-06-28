package api.prueba.brasilia.controlles;

import api.prueba.brasilia.entity.Usuario;
import api.prueba.brasilia.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioService _usuarioService;

    @GetMapping
    public List<Usuario> listarUsuarios() {
        return _usuarioService.listarUsuarios();
    }

    @GetMapping("/{id}")
    public Usuario buscarUsuarioPorId(@PathVariable Long id) {
        return _usuarioService.buscarUsuarioPorId(id);
    }

    @PostMapping
    public Usuario guardarUsuario(@RequestBody Usuario usuario) {
        return _usuarioService.guardarUsuario(usuario);
    }

    @DeleteMapping("/{id}")
    public void elminarUsuario(@PathVariable Long id) {
        _usuarioService.elminarUsuario(id);
    }
    
}
