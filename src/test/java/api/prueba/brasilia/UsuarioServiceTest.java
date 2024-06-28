package api.prueba.brasilia;

import api.prueba.brasilia.entity.Usuario;
import api.prueba.brasilia.repository.UsuarioRepository;
import api.prueba.brasilia.service.UsuarioService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UsuarioServiceTest {

    @Mock
    private UsuarioRepository usuarioRepository;

    @InjectMocks
    private UsuarioService usuarioService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGuardarUsuario() {
        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNombreUsuario("Usuario test");

        Mockito.when(usuarioRepository.save(Mockito.any(Usuario.class))).thenReturn(usuario);

        Usuario usuarioGuardado = usuarioService.guardarUsuario(usuario);

        Assertions.assertEquals(usuario.getId(), usuarioGuardado.getId());
        Assertions.assertEquals(usuario.getNombreUsuario(), usuarioGuardado.getNombreUsuario());
    }
}
