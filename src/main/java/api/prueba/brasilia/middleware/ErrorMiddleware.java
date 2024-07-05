package api.prueba.brasilia.middleware;

import api.prueba.brasilia.exceptions.MensajeError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorMiddleware {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleGlobalException(Exception ex) {
        MensajeError message = new MensajeError(
                HttpStatus.NOT_FOUND.value(),
                ex.getMessage(),
                ex.getLocalizedMessage());
        return new ResponseEntity<>(message, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
