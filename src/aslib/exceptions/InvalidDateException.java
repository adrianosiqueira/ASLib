package aslib.exceptions;

/**
 * <p> Custom exception to symbolize that some date is invalid. </p>
 *
 * @author Adriano Siqueira
 * @version 1.0
 * @since 6.0
 */
public class InvalidDateException extends RuntimeException {
    public InvalidDateException() {
    }

    public InvalidDateException(String message) {
        super(message);
    }

    public InvalidDateException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidDateException(Throwable cause) {
        super(cause);
    }

    public InvalidDateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
