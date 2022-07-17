package aslib.convert.numericbase;

/**
 * <p style="text-align:justify">
 * Handles conversions between decimal values and octal values. That is,
 * between <a href="https://en.wikipedia.org/wiki/Decimal">base 10</a> and
 * <a href="https://en.wikipedia.org/wiki/Octal">base 8</a>.
 * </p>
 *
 * @author Adriano Siqueira
 * @version 1.0.0
 * @since 12.0.0
 */
public class Base8Converter implements BaseConverter {

    private final int radix = 8;


    /**
     * <p style="text-align:justify">
     * Creates an instance of {@link Base8Converter} class.
     * </p>
     *
     * @since 1.0.0
     */
    Base8Converter() {}


    @Override
    public long toDecimal(String value) {
        return Long.parseLong(value, radix);
    }

    @Override
    public String toNewBase(long value) {
        return Long.toString(value, radix);
    }
}
