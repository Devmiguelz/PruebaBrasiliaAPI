package api.prueba.brasilia;

import api.prueba.brasilia.dto.usuario.UsuarioCrearDto;
import api.prueba.brasilia.dto.usuario.UsuarioListarDto;
import api.prueba.brasilia.entity.Usuario;
import api.prueba.brasilia.dto.mapper.UsuarioMapper;
import api.prueba.brasilia.repository.UsuarioRepository;
import api.prueba.brasilia.service.Impl.UsuarioServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.password.PasswordEncoder;

class UsuarioServiceImplTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @Mock
    private UsuarioMapper usuarioMapper;

    @InjectMocks
    private UsuarioServiceImpl usuarioService;

    @Mock
    private PasswordEncoder passwordEncoder;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void testGuardarUsuario() {
        UsuarioCrearDto usuarioDto = new UsuarioCrearDto();
        usuarioDto.setNombreUsuario("Usuario test");

        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNombreUsuario(usuarioDto.getNombreUsuario());

        UsuarioListarDto usuarioListarDto = new UsuarioListarDto();
        usuarioListarDto.setId(1L);
        usuarioListarDto.setNombreUsuario("Usuario test");

        Mockito.when(passwordEncoder.encode(Mockito.any(CharSequence.class))).thenReturn("hashedPassword");
        Mockito.when(usuarioMapper.ToEntidad(Mockito.any(UsuarioCrearDto.class))).thenReturn(usuario);
        Mockito.when(usuarioRepository.save(Mockito.any(Usuario.class))).thenReturn(usuario);
        Mockito.when(usuarioMapper.ToDto(Mockito.any(Usuario.class))).thenReturn(usuarioListarDto);

        UsuarioListarDto usuarioGuardado = usuarioService.guardarUsuario(usuarioDto);

        Assertions.assertEquals(usuario.getId(), usuarioGuardado.getId());
        Assertions.assertEquals(usuario.getNombreUsuario(), usuarioGuardado.getNombreUsuario());
    }
}
