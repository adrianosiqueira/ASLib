package aslib.convert.numericbase;

/**
 * <p style="text-align:justify">
 * Defines the contract of the classes that handles numeric base conversions.
 * </p>
 *
 * @author Adriano Siqueira
 * @version 1.0.0
 * @since 12.0.0
 */
public interface BaseConverter {

    /**
     * <p style="text-align:justify">
     * Converts the specific numeric base value to a decimal value. Decimal
     * places are not supported.
     * </p>
     *
     * @param value Value that will be converted.
     *
     * @return The value in base decimal.
     *
     * @since 1.0.0
     */
    long toDecimal(String value);

    /**
     * <p style="text-align:justify">
     * Converts the decimal value to a specific numeric base value. This method
     * returns a String value because some numeric base use letters in their
     * values.
     * </p>
     *
     * @param value Value that will be converted.
     *
     * @return The value in a specific numeric base and in upper case.
     *
     * @since 1.0.0
     */
    String toNewBase(long value);
}
