package api.prueba.brasilia.controlles;

import api.prueba.brasilia.dto.usuario.UsuarioCrearDto;
import api.prueba.brasilia.dto.usuario.UsuarioListarDto;
import api.prueba.brasilia.service.Impl.UsuarioServiceImpl;
import api.prueba.brasilia.service.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/usuario")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioServiceParam) {
        this.usuarioService = usuarioServiceParam;
    }

    @GetMapping
    public ResponseEntity<List<UsuarioListarDto>> listarUsuarios() {
        return new ResponseEntity<>(usuarioService.listarUsuarios(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioListarDto> buscarUsuarioPorId(@PathVariable Long id) {
        return new ResponseEntity<>(usuarioService.buscarUsuarioPorId(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<UsuarioListarDto> guardarUsuario(@RequestBody @Valid UsuarioCrearDto usuario) {
        return new ResponseEntity<>(usuarioService.guardarUsuario(usuario), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> elminarUsuario(@PathVariable Long id) {
        return new ResponseEntity<>(usuarioService.elminarUsuario(id), HttpStatus.OK);
    }
    
}
