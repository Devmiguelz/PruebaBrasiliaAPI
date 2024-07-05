package api.prueba.brasilia.jwt;

import api.prueba.brasilia.constants.AppConstants;
import api.prueba.brasilia.dto.auth.LoginDto;
import api.prueba.brasilia.dto.auth.LoginUsuarioDto;
import api.prueba.brasilia.exceptions.RecursoNoEncontrado;
import api.prueba.brasilia.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final AuthenticationManager authenticationManager;
    private final JwtService jwtService;

    public LoginUsuarioDto ValidarLoginUsuario(LoginDto loginDto) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword()));
        UserDetails user = usuarioRepository.findByEmail(loginDto.getEmail()).orElseThrow(() -> new RecursoNoEncontrado(AppConstants.USUARIO_NO_LOGIN));
        String token = jwtService.getToken(user);


        return LoginUsuarioDto.builder().Token(token).build();
    }
}
