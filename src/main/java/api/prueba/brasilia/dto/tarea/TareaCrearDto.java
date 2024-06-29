package api.prueba.brasilia.dto.tarea;

import api.prueba.brasilia.constants.AppConstants;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class TareaCrearDto {

    @NotNull(message = "Titulo" + AppConstants.PROPIEDAD_REQUERIDA)
    @Size(min = 2, max = 100, message = "Titulo" + AppConstants.LONGITUD_MIN_MAX)
    private String Titulo;

    @NotNull(message = "Descripcion" + AppConstants.PROPIEDAD_REQUERIDA)
    @Size(min = 2, max = 100, message = "Descripcion" + AppConstants.LONGITUD_MIN_MAX)
    private String Descripcion;
}
