package aslib.convert.morsecodifier;

/**
 * <p style="text-align:justify">
 * Defines the contract of the classes that handles conversions between text
 * and morse code.
 * </p>
 *
 * @author Adriano Siqueira
 * @version 1.0.0
 * @since 12.0.0
 */
interface Converter {

    Dictionary DICTIONARY = new Dictionary();

    /**
     * <p style="text-align:justify">
     * Converts the input string to text or to morse code according to the
     * implementation class.
     * </p>
     *
     * @param input String that will be converted.
     *
     * @return The conversion result.
     *
     * @throws NullPointerException If the input string is null.
     * @since 1.0.0
     */
    String convert(String input)
    throws NullPointerException;
}
