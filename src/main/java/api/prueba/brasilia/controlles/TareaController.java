package api.prueba.brasilia.controlles;

import api.prueba.brasilia.entity.Tarea;
import api.prueba.brasilia.service.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuario/{usuarioId}/tarea")
public class TareaController {

    @Autowired
    private TareaService _tareaService;

    @PostMapping
    public Tarea guardarTarea(@PathVariable Long usuarioId, @RequestBody Tarea tarea) {
        return _tareaService.guardarTarea(usuarioId, tarea);
    }

    @GetMapping
    public List<Tarea> buscarTareasPorUsuarioId(@PathVariable Long userId) {
        return _tareaService.buscarTareasPorUsuarioId(userId);
    }

    @PutMapping("/{tareaId}/estado")
    public Tarea actualizarEstadoTarea(@PathVariable Long usuarioId, @PathVariable Long tareaId, @RequestParam boolean completa) {
        return _tareaService.actualizarEstadoTarea(usuarioId, tareaId, completa);
    }

    @DeleteMapping("/{tareaId}")
    public void eliminarTarea(@PathVariable Long usuarioId, @PathVariable Long tareaId) {
        _tareaService.eliminarTarea(usuarioId, tareaId);
    }
}
