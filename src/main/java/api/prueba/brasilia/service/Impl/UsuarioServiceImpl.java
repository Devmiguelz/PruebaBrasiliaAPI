package api.prueba.brasilia.service.Impl;

import api.prueba.brasilia.constants.AppConstants;
import api.prueba.brasilia.dto.usuario.UsuarioCrearDto;
import api.prueba.brasilia.dto.usuario.UsuarioListarDto;
import api.prueba.brasilia.entity.Role;
import api.prueba.brasilia.entity.Usuario;
import api.prueba.brasilia.exceptions.RecursoNoEncontrado;
import api.prueba.brasilia.dto.mapper.UsuarioMapper;
import api.prueba.brasilia.repository.UsuarioRepository;
import api.prueba.brasilia.service.UsuarioService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;
    private final PasswordEncoder passwordEncoder;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepositoryParam, UsuarioMapper usuarioMapper, PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepositoryParam;
        this.usuarioMapper = usuarioMapper;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails getUsuarioPorEmail(String email){
        Optional<Usuario> usuario = usuarioRepository.findByEmail(email);
        if (usuario.isEmpty()) {
            throw new RecursoNoEncontrado(AppConstants.USUARIO_NO_ENCONTRADO);
        }
        return usuario.get();
    }

    @Override
    public UsuarioListarDto guardarUsuario(UsuarioCrearDto usuarioDto) {
        Usuario usuario = usuarioMapper.ToEntidad(usuarioDto);
        usuario.setPassword(passwordEncoder.encode(usuarioDto.getPassword()));
        usuario.setRole(Role.USER);
        usuario.setCreatedAt(new Date());
        return usuarioMapper.ToDto(usuarioRepository.save(usuario));
    }

    @Override
    public List<UsuarioListarDto> listarUsuarios() {
        return usuarioMapper.ToDtoList(usuarioRepository.findAll());
    }

    @Override
    public UsuarioListarDto buscarUsuarioPorId(Long id) {
        Usuario usuario = getUsuarioById(id);
        return usuarioMapper.ToDto(usuario);
    }

    @Override
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
