package aslib.util;

/**
 * <p>Functional interface designed to generate objects of type {@link T}.</p>
 *
 * @param <T> Type of object that will be generated.
 *
 * @author Adriano Siqueira
 * @version 1.0.0
 * @since 11.0.0
 */
@FunctionalInterface
public interface Generable<T> {

    /**
     * <p>Generates an object of type {@link T}.</p>
     *
     * @return A new object created.
     *
     * @implNote Implemented classes should give a more precise description of
     * how this method works.
     * @since 1.0.0
     */
    T generate();
}
