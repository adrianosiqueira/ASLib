package aslib.exceptions;

/**
 * <p> Custom exception to symbolize that the argument used to perform a search
 * in an enum is invalid. </p>
 *
 * @author Adriano Siqueira
 * @version 2019-05-03
 * @since 6.0
 */
public class InvalidEnumSearchArgumentException extends RuntimeException {
    public InvalidEnumSearchArgumentException() {
    }

    public InvalidEnumSearchArgumentException(String message) {
        super(message);
    }

    public InvalidEnumSearchArgumentException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidEnumSearchArgumentException(Throwable cause) {
        super(cause);
    }

    public InvalidEnumSearchArgumentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
