package api.prueba.brasilia.controlles;

import api.prueba.brasilia.constants.AppConstants;
import api.prueba.brasilia.dto.tarea.TareaCrearDto;
import api.prueba.brasilia.dto.tarea.TareaListarDto;
import api.prueba.brasilia.service.TareaService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/usuario/{usuarioId}/tarea")
public class TareaController {

    private final TareaService tareaService;

    public TareaController(TareaService tareaService) {
        this.tareaService = tareaService;
    }

    @PostMapping
    public ResponseEntity<TareaListarDto> guardarTarea(@NotNull(message = AppConstants.PROPIEDAD_REQUERIDA) @PathVariable Long usuarioId, @Valid @RequestBody TareaCrearDto tarea) {
        return new ResponseEntity<>(tareaService.guardarTarea(usuarioId, tarea), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<TareaListarDto>> buscarTareasPorUsuarioId(@NotNull(message = AppConstants.PROPIEDAD_REQUERIDA) @PathVariable Long usuarioId) {
        return new ResponseEntity<>(tareaService.buscarTareasPorUsuarioId(usuarioId), HttpStatus.OK);
    }

    @PutMapping("/{tareaId}/estado")
    public ResponseEntity<TareaListarDto> actualizarEstadoTarea(@NotNull(message = AppConstants.PROPIEDAD_REQUERIDA) @PathVariable Long usuarioId, @NotNull(message = AppConstants.PROPIEDAD_REQUERIDA) @PathVariable Long tareaId, @RequestParam boolean completa) {
        return new ResponseEntity<>(tareaService.actualizarEstadoTarea(usuarioId, tareaId, completa), HttpStatus.OK);
    }

    @DeleteMapping("/{tareaId}")
    public ResponseEntity<Boolean> eliminarTarea(@NotNull(message = AppConstants.PROPIEDAD_REQUERIDA) @PathVariable Long usuarioId,@NotNull(message = AppConstants.PROPIEDAD_REQUERIDA) @PathVariable Long tareaId) {
        return new ResponseEntity<>(tareaService.eliminarTarea(usuarioId, tareaId), HttpStatus.OK);
    }
}
