package api.prueba.brasilia.exception;

public class MensajeError {

    private String errorCode;
    private String errorMessage;

    public MensajeError(String errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
