package api.prueba.brasilia.service;

import api.prueba.brasilia.constants.AppConstants;
import api.prueba.brasilia.dto.tarea.TareaCrearDto;
import api.prueba.brasilia.dto.tarea.TareaListarDto;
import api.prueba.brasilia.entity.Tarea;
import api.prueba.brasilia.entity.Usuario;
import api.prueba.brasilia.exceptions.RecursoNoEncontrado;
import api.prueba.brasilia.mapper.TareaMapper;
import api.prueba.brasilia.repository.TareaRepository;
import api.prueba.brasilia.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TareaService {

    private final TareaRepository tareaRepository;
    private final UsuarioRepository usuarioRepository;
    private final TareaMapper tareaMapper;

    public TareaService(TareaRepository tareaRepository, UsuarioRepository usuarioRepository, TareaMapper tareaMapper) {
        this.tareaRepository = tareaRepository;
        this.usuarioRepository = usuarioRepository;
        this.tareaMapper = tareaMapper;
    }

    public TareaListarDto guardarTarea(Long usuarioId, TareaCrearDto tareaDto) {
        Usuario usuario = getUsuarioById(usuarioId);
        Tarea tarea = tareaMapper.ToEntidad(tareaDto);
        tarea.setUsuario(usuario);
        tarea.setCreatedAt(new Date());
        return tareaMapper.ToDto(tareaRepository.save(tarea));
    }

    public List<TareaListarDto> buscarTareasPorUsuarioId(Long usuarioId) {
        Usuario usuario = getUsuarioById(usuarioId);
        return tareaMapper.ToDtoList(usuario.getTareas());
    }

    public TareaListarDto actualizarEstadoTarea(Long usuarioId, Long tareaId, boolean completa) {
        Tarea tarea = getTareaById(tareaId);
        if (!tarea.getUsuario().getId().equals(usuarioId)) {
            throw new RecursoNoEncontrado(AppConstants.TAREA_NO_USUARIO);
        }
        tarea.setCompleta(completa);
        tarea.setUpdatedAt(new Date());
        return tareaMapper.ToDto(tareaRepository.save(tarea));
    }

    public Boolean eliminarTarea(Long usuarioId, Long tareaId) {
        Tarea tarea = getTareaById(tareaId);
        if (!tarea.getUsuario().getId().equals(usuarioId)) {
            throw new RecursoNoEncontrado(AppConstants.TAREA_NO_USUARIO);
        }
        tareaRepository.delete(tarea);
        return true;
    }

    private Usuario getUsuarioById(Long id) {
        Optional<Usuario> usuario = usuarioRepository.findById(id);
        if (usuario.isEmpty()) {
            throw new RecursoNoEncontrado(AppConstants.USUARIO_NO_ENCONTRADO);
        }
        return usuario.get();
    }

    private Tarea getTareaById(Long id) {
        Optional<Tarea> tarea = tareaRepository.findById(id);
        if (tarea.isEmpty()) {
            throw new RecursoNoEncontrado(AppConstants.TAREA_NO_ENCONTRADA);
        }
        return tarea.get();
    }
}
