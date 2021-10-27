package aslib.util;

/**
 * <p>Interface designed to work with two-way conversions, that is, an object
 * of type {@link A} will be converted to an object of type {@link B} and vice
 * versa.</p>
 *
 * @param <A> First data type.
 * @param <B> Second data type.
 *
 * @author Adriano Siqueira
 * @version 1.0.0
 * @since 11.0.0
 */
public interface BiParsable<A, B> {

    /**
     * <p>Converts the object of type {@link B} to an object of type {@link A}.</p>
     *
     * @param b Object that will be converted.
     *
     * @return An object of type {@link A}.
     *
     * @implNote Implemented classes should give a more precise description of
     * how this method works.
     * @since 1.0.0
     */
    A toA(B b);

    /**
     * <p>Converts the object of type {@link A} to an object of type {@link B}.</p>
     *
     * @param a Object that will be converted.
     *
     * @return An object of type {@link B}.
     *
     * @implNote Implemented classes should give a more precise description of
     * how this method works.
     * @since 1.0.0
     */
    B toB(A a);
}
