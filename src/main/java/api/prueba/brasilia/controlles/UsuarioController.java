package api.prueba.brasilia.controlles;

import api.prueba.brasilia.constants.AppConstants;
import api.prueba.brasilia.dto.usuario.UsuarioCrearDto;
import api.prueba.brasilia.dto.usuario.UsuarioListarDto;
import api.prueba.brasilia.service.UsuarioService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioRepository;

    public UsuarioController(UsuarioService usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping
    public ResponseEntity<List<UsuarioListarDto>> listarUsuarios() {
        return new ResponseEntity<>(usuarioRepository.listarUsuarios(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioListarDto> buscarUsuarioPorId(@PathVariable Long id) {
        return new ResponseEntity<>(usuarioRepository.buscarUsuarioPorId(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UsuarioListarDto> guardarUsuario(@RequestBody @Valid UsuarioCrearDto usuario) {
        return new ResponseEntity<>(usuarioRepository.guardarUsuario(usuario), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> elminarUsuario(@PathVariable Long id) {
        return new ResponseEntity<>(usuarioRepository.elminarUsuario(id), HttpStatus.OK);
    }
    
}
