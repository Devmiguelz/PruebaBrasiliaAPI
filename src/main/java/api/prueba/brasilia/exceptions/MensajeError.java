package api.prueba.brasilia.exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MensajeError {

    private int statusCode;
    private String message;
    private String description;

    public MensajeError(int statusCode, String message, String description) {
        this.statusCode = statusCode;
        this.message = message;
        this.description = description;
    }
}
