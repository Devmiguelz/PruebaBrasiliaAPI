package api.prueba.brasilia.dto.usuario;

import api.prueba.brasilia.constants.AppConstants;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class UsuarioCrearDto {

    @NotNull(message = "NombreUsuario" + AppConstants.PROPIEDAD_REQUERIDA)
    @Size(min = 2, max = 100, message = "NombreUsuario" + AppConstants.LONGITUD_MIN_MAX)
    public String NombreUsuario;

    @NotNull(message = "Email" + AppConstants.PROPIEDAD_REQUERIDA)
    @Email(message = AppConstants.EMAIL_NO_VALIDO)
    public String Email;

    @NotNull(message = "Password" + AppConstants.PROPIEDAD_REQUERIDA)
    @Size(min = 8, message = AppConstants.MIN_PASSWORD)
    public String Password;
}
