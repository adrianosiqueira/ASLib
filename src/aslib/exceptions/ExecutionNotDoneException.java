package aslib.exceptions;

/**
 * <p> Custom exception to symbolize that some execution is not done yet. </p>
 *
 * @author Adriano Siqueira
 * @version 2019-05-03
 * @since 6.1
 */
public class ExecutionNotDoneException extends RuntimeException {
    public ExecutionNotDoneException() {
    }

    public ExecutionNotDoneException(String message) {
        super(message);
    }

    public ExecutionNotDoneException(String message, Throwable cause) {
        super(message, cause);
    }

    public ExecutionNotDoneException(Throwable cause) {
        super(cause);
    }

    public ExecutionNotDoneException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
