package api.prueba.brasilia.service;

import api.prueba.brasilia.constants.AppConstants;
import api.prueba.brasilia.dto.usuario.UsuarioCrearDto;
import api.prueba.brasilia.dto.usuario.UsuarioListarDto;
import api.prueba.brasilia.entity.Usuario;
import api.prueba.brasilia.exceptions.RecursoNoEncontrado;
import api.prueba.brasilia.mapper.UsuarioMapper;
import api.prueba.brasilia.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    public UsuarioService(UsuarioRepository usuarioRepository, UsuarioMapper usuarioMapper) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioMapper = usuarioMapper;
    }

    public UsuarioListarDto guardarUsuario(UsuarioCrearDto usuarioDto) {
        Usuario usuario = usuarioMapper.ToEntidad(usuarioDto);
        usuario.setCreatedAt(new Date());
        return usuarioMapper.ToDto(usuarioRepository.save(usuario));
    }

    public List<UsuarioListarDto> listarUsuarios() {
        return usuarioMapper.ToDtoList(usuarioRepository.findAll());
    }

    public UsuarioListarDto buscarUsuarioPorId(Long id) {
        Usuario usuario = getUsuarioById(id);
        return usuarioMapper.ToDto(usuario);
    }

    public boolean elminarUsuario(Long id) {
        Usuario usuario = getUsuarioById(id);
        usuarioRepository.deleteById(usuario.getId());
        return true;
    }

    private Usuario getUsuarioById(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isEmpty()) {
            throw new RecursoNoEncontrado(AppConstants.USUARIO_NO_ENCONTRADO);
        }
        return usuario.get();
    }
}
