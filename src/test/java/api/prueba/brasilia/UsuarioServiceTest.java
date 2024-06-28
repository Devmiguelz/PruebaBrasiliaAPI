package api.prueba.brasilia;

import api.prueba.brasilia.entity.Usuario;
import api.prueba.brasilia.service.UsuarioService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class UsuarioServiceTest {
    @Autowired
    private UsuarioService _usuarioService;

    @Test
    public void testGuardarUsuario() {
        // Arrange
        Usuario usuario = new Usuario();
        usuario.setNombreUsuario("UsuarioTest");

        // Act
        Usuario createdUser = _usuarioService.guardarUsuario(usuario);

        // Assert
        assertNotNull(createdUser);
        assertEquals("UsuarioTest", createdUser.getNombreUsuario());
    }
}
