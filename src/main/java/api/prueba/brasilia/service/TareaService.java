package api.prueba.brasilia.service;

import api.prueba.brasilia.entity.Tarea;
import api.prueba.brasilia.entity.Usuario;
import api.prueba.brasilia.exception.RecursoNoEncontrado;
import api.prueba.brasilia.repository.TareaRepository;
import api.prueba.brasilia.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaService {

    @Autowired
    private TareaRepository tareaRepository;
    @Autowired
    private UsuarioRepository usuarioRepository;

    public Tarea guardarTarea(Long usuarioId, Tarea tarea) {
        Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(() -> new RecursoNoEncontrado("Usuario no encontrado"));
        tarea.setUsuario(usuario);
        return tareaRepository.save(tarea);
    }

    public List<Tarea> buscarTareasPorUsuarioId(Long usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId).orElseThrow(() -> new RecursoNoEncontrado("Usuario no encontrada"));
        return usuario.getTareas();
    }

    public Tarea actualizarEstadoTarea(Long usuarioId, Long tareaId, boolean completa) {
        Tarea tarea = tareaRepository.findById(tareaId).orElseThrow(() -> new RecursoNoEncontrado("Tarea no encontrada"));
        if (!tarea.getUsuario().getId().equals(usuarioId)) {
            throw new RecursoNoEncontrado("La tarea no pertenece al usuario");
        }
        tarea.setCompleta(completa);
        return tareaRepository.save(tarea);
    }

    public void eliminarTarea(Long usuarioId, Long tareaId) {
        Tarea tarea = tareaRepository.findById(tareaId).orElseThrow(() -> new RecursoNoEncontrado("Tarea no encontrada"));
        if (!tarea.getUsuario().getId().equals(usuarioId)) {
            throw new RecursoNoEncontrado("La tarea no pertenece al usuario");
        }
        tareaRepository.delete(tarea);
    }
}
