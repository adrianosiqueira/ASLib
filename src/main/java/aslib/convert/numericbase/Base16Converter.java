package aslib.convert.numericbase;

/**
 * <p style="text-align:justify">
 * Handles conversions between decimal values and hexadecimal values. That is,
 * between <a href="https://en.wikipedia.org/wiki/Decimal">base 10</a> and
 * <a href="https://en.wikipedia.org/wiki/Hexadecimal">base 16</a>.
 * </p>
 *
 * @author Adriano Siqueira
 * @version 1.0.1
 * @since 12.0.0
 */
class Base16Converter implements BaseConverter {

    private final int radix = 16;


    /**
     * <p style="text-align:justify">
     * Creates an instance of {@link Base16Converter} class.
     * </p>
     *
     * @since 1.0.0
     */
    Base16Converter() {}


    @Override
    public long toDecimal(String value) {
        return Long.parseLong(value, radix);
    }

    @Override
    public String toNewBase(long value) {
        return Long.toString(value, radix)
                   .toUpperCase();
    }
}
