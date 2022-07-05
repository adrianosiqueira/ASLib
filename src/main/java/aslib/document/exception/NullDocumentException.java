package aslib.document.exception;

/**
 * <p>
 * Indicates that the provided document is null.
 * </p>
 *
 * @author Adriano Siqueira
 * @version 1.0.0
 * @since 12.0.0
 */
public class NullDocumentException extends RuntimeException {

    public NullDocumentException() {}

    public NullDocumentException(String message) {
        super(message);
    }

    public NullDocumentException(String message, Throwable cause) {
        super(message, cause);
    }

    public NullDocumentException(Throwable cause) {
        super(cause);
    }

    public NullDocumentException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
