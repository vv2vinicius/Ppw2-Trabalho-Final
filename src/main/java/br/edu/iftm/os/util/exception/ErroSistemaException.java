package br.edu.iftm.os.util.exception;

/**
 *
 * @author danilo
 */
public class ErroSistemaException extends Exception {

    public ErroSistemaException(String message) {
        super(message);
    }

    public ErroSistemaException(String message, Throwable cause) {
        super(message, cause);
    }
    
}
