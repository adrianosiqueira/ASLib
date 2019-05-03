package aslib.exceptions;

/**
 * <p> Custom exception to symbolize that some class is invalid to the context. </p>
 *
 * @author Adriano Siqueira
 * @version 2019-05-03
 * @since 4.2
 */
public class InvalidClassException extends RuntimeException {
    public InvalidClassException() {
    }

    public InvalidClassException(String message) {
        super(message);
    }

    public InvalidClassException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidClassException(Throwable cause) {
        super(cause);
    }

    public InvalidClassException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
