package api.prueba.brasilia.controlles;

import api.prueba.brasilia.dto.tarea.TareaCrearDto;
import api.prueba.brasilia.dto.tarea.TareaListarDto;
import api.prueba.brasilia.service.TareaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario/{usuarioId}/tarea")
public class TareaController {

    private final TareaService tareaService;

    public TareaController(TareaService tareaService) {
        this.tareaService = tareaService;
    }

    @PostMapping
    public TareaListarDto guardarTarea(@PathVariable Long usuarioId, @RequestBody TareaCrearDto tarea) {
        return tareaService.guardarTarea(usuarioId, tarea);
    }

    @GetMapping
    public List<TareaListarDto> buscarTareasPorUsuarioId(@PathVariable Long usuarioId) {
        return tareaService.buscarTareasPorUsuarioId(usuarioId);
    }

    @PutMapping("/{tareaId}/estado")
    public TareaListarDto actualizarEstadoTarea(@PathVariable Long usuarioId, @PathVariable Long tareaId, @RequestParam boolean completa) {
        return tareaService.actualizarEstadoTarea(usuarioId, tareaId, completa);
    }

    @DeleteMapping("/{tareaId}")
    public boolean eliminarTarea(@PathVariable Long usuarioId, @PathVariable Long tareaId) {
        return tareaService.eliminarTarea(usuarioId, tareaId);
    }
}
