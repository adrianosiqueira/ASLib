package aslib.convert.numericbase;

/**
 * <p style="text-align:justify">
 * Handles conversions between decimal values and binary values. That is,
 * between <a href="https://en.wikipedia.org/wiki/Decimal">base 10</a> and
 * <a href="https://en.wikipedia.org/wiki/Binary_number">base 2</a>.
 * </p>
 *
 * @author Adriano Siqueira
 * @version 1.0.1
 * @since 12.0.0
 */
class Base2Converter implements BaseConverter {

    private final int radix = 2;


    /**
     * <p style="text-align:justify">
     * Creates an instance of {@link Base2Converter} class.
     * </p>
     *
     * @since 1.0.0
     */
    Base2Converter() {}


    @Override
    public long toDecimal(String value) {
        return Long.parseLong(value, radix);
    }

    @Override
    public String toNewBase(long value) {
        return Long.toString(value, radix);
    }
}
