package aslib.util;

/**
 * <p>Functional interface designed to work with object formatting.</p>
 *
 * @param <T> Input data type.
 * @param <R> Output data type.
 *
 * @author Adriano Siqueira
 * @version 1.0.0
 * @since 11.0.0
 */
@FunctionalInterface
public interface Formattable<T, R> {

    /**
     * <p>Formats the provided object and returns an object of type {@link R}.</p>
     *
     * @param t Object that will be formatted.
     *
     * @return A formatted object of type {@link R}.
     *
     * @implNote Implemented classes should give a more precise description of
     * how this method works.
     * @since 1.0.0
     */
    R format(T t);
}
