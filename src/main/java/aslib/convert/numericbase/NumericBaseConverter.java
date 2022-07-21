package aslib.convert.numericbase;

/**
 * <p style="text-align:justify">
 * Entry point to the Numeric Base converter API. Its methods gives access to
 * the implementation of a particular numeric base.
 * </p>
 *
 * @author Adriano Siqueira
 * @version 1.0.0
 * @since 12.0.0
 */
public class NumericBaseConverter {

    /**
     * <p style="text-align:justify">
     * Access the implementation of {@link Base16Converter}.
     * </p>
     *
     * @return The base 16 implementation.
     *
     * @since 1.0.0
     */
    public static BaseConverter base16() {
        return new Base16Converter();
    }

    /**
     * <p style="text-align:justify">
     * Access the implementation of {@link Base2Converter}.
     * </p>
     *
     * @return The base 2 implementation.
     *
     * @since 1.0.0
     */
    public static BaseConverter base2() {
        return new Base2Converter();
    }

    /**
     * <p style="text-align:justify">
     * Access the implementation of {@link Base36Converter}.
     * </p>
     *
     * @return The base 36 implementation.
     *
     * @since 1.0.0
     */
    public static BaseConverter base36() {
        return new Base36Converter();
    }

    /**
     * <p style="text-align:justify">
     * Access the implementation of {@link Base8Converter}.
     * </p>
     *
     * @return The base 8 implementation.
     *
     * @since 1.0.0
     */
    public static BaseConverter base8() {
        return new Base8Converter();
    }
}
