package aslib.util;

/**
 * <p>Functional interface designed to check the validity of a given object.</p>
 *
 * @param <T> Object data type.
 *
 * @author Adriano Siqueira
 * @version 1.0.0
 * @since 11.0.0
 */
@FunctionalInterface
public interface Validatable<T> {

    /**
     * <p>Checks if the object is valid.</p>
     *
     * @param t Object that will be checked.
     *
     * @return True if the object is valid, or false otherwise.
     *
     * @implNote Implemented classes should give a more precise description of
     * how this method works.
     * @since 1.0.0
     */
    boolean isValid(T t);
}
