package aslib.util;

/**
 * <p>Functional interface designed to work with one-way conversions, that is,
 * an object of type {@link T} will be converted to an object of type {@link R}
 * only.</p>
 *
 * @param <T> Input data type.
 * @param <R> Output data type.
 *
 * @author Adriano Siqueira
 * @version 1.0.0
 * @since 11.0.0
 */
@FunctionalInterface
public interface Parsable<T, R> {

    /**
     * <p>Converts the object of type {@link T} to an object of type {@link R}.</p>
     *
     * @param t Element that will be parsed.
     *
     * @return A {@link R} element parsed from the provided parameter.
     *
     * @implNote Implemented classes should give a more precise description of
     * how this method works.
     * @since 1.0.0
     */
    R parse(T t);
}
