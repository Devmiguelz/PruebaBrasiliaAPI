package api.prueba.brasilia.dto.usuario;

import api.prueba.brasilia.constants.AppConstants;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UsuarioCrearDto {

    @NotNull(message = "NombreUsuario" + AppConstants.PROPIEDAD_REQUERIDA)
    @Size(min = 2, max = 100, message = "NombreUsuario" + AppConstants.LONGITUD_MIN_MAX)
    public String NombreUsuario;
}
