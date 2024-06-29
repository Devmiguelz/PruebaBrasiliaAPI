package api.prueba.brasilia.controlles;

import api.prueba.brasilia.dto.usuario.UsuarioCrearDto;
import api.prueba.brasilia.dto.usuario.UsuarioListarDto;
import api.prueba.brasilia.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioRepository;

    public UsuarioController(UsuarioService usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping
    public List<UsuarioListarDto> listarUsuarios() {
        return usuarioRepository.listarUsuarios();
    }

    @GetMapping("/{id}")
    public UsuarioListarDto buscarUsuarioPorId(@PathVariable Long id) {
        return usuarioRepository.buscarUsuarioPorId(id);
    }

    @PostMapping
    public UsuarioListarDto guardarUsuario(@RequestBody UsuarioCrearDto usuario) {
        return usuarioRepository.guardarUsuario(usuario);
    }

    @DeleteMapping("/{id}")
    public boolean elminarUsuario(@PathVariable Long id) {
        return usuarioRepository.elminarUsuario(id);
    }
    
}
