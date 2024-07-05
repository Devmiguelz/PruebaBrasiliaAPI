package api.prueba.brasilia.service;

import api.prueba.brasilia.dto.usuario.UsuarioCrearDto;
import api.prueba.brasilia.dto.usuario.UsuarioListarDto;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;

public interface UsuarioService {
    UserDetails getUsuarioPorEmail(String email);
    UsuarioListarDto guardarUsuario(UsuarioCrearDto usuarioDto);
    List<UsuarioListarDto> listarUsuarios();
    UsuarioListarDto buscarUsuarioPorId(Long id);
    boolean elminarUsuario(Long id);
}
