package api.prueba.brasilia.service;

import api.prueba.brasilia.entity.Usuario;
import api.prueba.brasilia.exception.RecursoNoEncontrado;
import api.prueba.brasilia.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository _usuarioRepository;

    public Usuario guardarUsuario(Usuario user) {
        return _usuarioRepository.save(user);
    }

    public List<Usuario> listarUsuarios() {
        return _usuarioRepository.findAll();
    }

    public Usuario buscarUsuarioPorId(Long id) {
        return _usuarioRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontrado("Usuario no encontrado."));
    }

    public void elminarUsuario(Long id) {
        _usuarioRepository.deleteById(id);
    }

}
