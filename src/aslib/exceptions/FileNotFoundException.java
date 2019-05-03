package aslib.exceptions;

/**
 * <p> Custom exception to symbolize that some file was not found. </p>
 *
 * @author Adriano Siqueira
 * @version 2019-05-03
 * @since 6.1
 */
public class FileNotFoundException extends RuntimeException {
    public FileNotFoundException() {
    }

    public FileNotFoundException(String message) {
        super(message);
    }

    public FileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public FileNotFoundException(Throwable cause) {
        super(cause);
    }

    public FileNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
