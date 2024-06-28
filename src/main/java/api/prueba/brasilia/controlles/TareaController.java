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
    private TareaService tareaService;

    @PostMapping
    public Tarea guardarTarea(@PathVariable Long usuarioId, @RequestBody Tarea tarea) {
        return tareaService.guardarTarea(usuarioId, tarea);
    }

    @GetMapping
    public List<Tarea> buscarTareasPorUsuarioId(@PathVariable Long usuarioId) {
        return tareaService.buscarTareasPorUsuarioId(usuarioId);
    }

    @PutMapping("/{tareaId}/estado")
    public Tarea actualizarEstadoTarea(@PathVariable Long usuarioId, @PathVariable Long tareaId, @RequestParam boolean completa) {
        return tareaService.actualizarEstadoTarea(usuarioId, tareaId, completa);
    }

    @DeleteMapping("/{tareaId}")
    public void eliminarTarea(@PathVariable Long usuarioId, @PathVariable Long tareaId) {
        tareaService.eliminarTarea(usuarioId, tareaId);
    }
}
