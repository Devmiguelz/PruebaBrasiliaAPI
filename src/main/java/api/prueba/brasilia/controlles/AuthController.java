package api.prueba.brasilia.controlles;

import api.prueba.brasilia.dto.auth.LoginDto;
import api.prueba.brasilia.dto.auth.LoginUsuarioDto;
import api.prueba.brasilia.jwt.AuthService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginUsuarioDto> guardarTarea(@RequestBody @Valid LoginDto login) {
        return new ResponseEntity<>(authService.ValidarLoginUsuario(login), HttpStatus.OK);
    }
}
