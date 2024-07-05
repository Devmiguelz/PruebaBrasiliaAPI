package api.prueba.brasilia.service;

import api.prueba.brasilia.dto.tarea.TareaCrearDto;
import api.prueba.brasilia.dto.tarea.TareaListarDto;

import java.util.List;

public interface TareaService {
    TareaListarDto guardarTarea(Long usuarioId, TareaCrearDto tareaDto);
    List<TareaListarDto> buscarTareasPorUsuarioId(Long usuarioId);
    TareaListarDto actualizarEstadoTarea(Long usuarioId, Long tareaId, boolean completa);
    Boolean eliminarTarea(Long usuarioId, Long tareaId);
}
