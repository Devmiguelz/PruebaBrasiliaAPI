package api.prueba.brasilia.service;

import api.prueba.brasilia.entity.Tarea;
import api.prueba.brasilia.entity.Usuario;
import api.prueba.brasilia.exception.RecursoNoEncontrado;
import api.prueba.brasilia.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario guardarUsuario(Usuario user) {
        return usuarioRepository.save(user);
    }

    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    public Usuario buscarUsuarioPorId(Long id) {
        return usuarioRepository.findById(id)
                .orElseThrow(() -> new RecursoNoEncontrado("Usuario no encontrado."));
    }

    public void elminarUsuario(Long id) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        if (usuario == null) {
            throw new RecursoNoEncontrado("Usuario no encontrado.");
        }
        usuarioRepository.deleteById(id);
    }

}
