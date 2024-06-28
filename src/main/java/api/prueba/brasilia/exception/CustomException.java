package api.prueba.brasilia.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CustomException {

    @ExceptionHandler(RecursoNoEncontrado.class)
    public ResponseEntity<MensajeError> handleResourceNotFoundException(RecursoNoEncontrado ex) {
        MensajeError mensajeError = new MensajeError("NOT_FOUND", ex.getMessage());
        return new ResponseEntity<>(mensajeError, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<MensajeError> handleGenericException(Exception ex) {
        MensajeError mensajeError = new MensajeError("INTERNAL_SERVER_ERROR", ex.getMessage());
        return new ResponseEntity<>(mensajeError, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
