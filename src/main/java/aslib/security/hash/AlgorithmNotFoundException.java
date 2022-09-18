package aslib.security.hash;

/**
 * <p style="text-align:justify">
 * Indicates that the hash algorithm is not found.
 * </p>
 *
 * @author Adriano Siqueira
 * @version 1.0.0
 * @since 12.0.0
 */
public class AlgorithmNotFoundException extends RuntimeException {

    public AlgorithmNotFoundException() {
    }

    public AlgorithmNotFoundException(String message) {
        super(message);
    }

    public AlgorithmNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public AlgorithmNotFoundException(Throwable cause) {
        super(cause);
    }

    public AlgorithmNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
