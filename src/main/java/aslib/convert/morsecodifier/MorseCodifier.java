package aslib.convert.morsecodifier;

import java.util.Optional;

/**
 * <p style="text-align:justify">
 * Handles conversions between text and
 * <a href="https://en.wikipedia.org/wiki/Morse_code">Morse code</a>.
 * </p>
 *
 * @author Adriano Siqueira
 * @version 1.0.0
 * @since 12.0.0
 */
public class MorseCodifier implements Converter {

    private Converter converter;


    /**
     * <p style="text-align:justify">
     * Creates an instance of {@link MorseCodifier}.
     * </p>
     *
     * @param converter Implementation of the converter.
     *
     * @since 1.0.0
     */
    MorseCodifier(Converter converter) {
        this.converter = converter;
    }


    /**
     * <p style="text-align:justify">
     * Gets the implementation to convert text to Morse code.
     * </p>
     *
     * @return An instance of {@link MorseCodifier}.
     *
     * @since 1.0.0
     */
    public static MorseCodifier toMorse() {
        return new MorseCodifier(new TextToMorseConverter());
    }

    /**
     * <p style="text-align:justify">
     * Gets the implementation to convert Morse code to text.
     * </p>
     *
     * @return An instance of {@link MorseCodifier}.
     *
     * @since 1.0.0
     */
    public static MorseCodifier toText() {
        return new MorseCodifier(new MorseToTextConverter());
    }


    /**
     * <p style="text-align:justify">
     * If the instance was obtained from {@link MorseCodifier#toMorse}, then
     * this method will convert the input string <b>to Morse code</b>.
     * </p>
     *
     * <p style="text-align:justify">
     * If the instance was obtained from {@link MorseCodifier#toText}, then
     * this method will convert the input string <b>to text</b>.
     * </p>
     *
     * @param input String that will be converted.
     *
     * @return Either text or morse code, depending on the implementation.
     *
     * @throws NullPointerException If the input string is null.
     * @since 1.0.0
     */
    @Override
    public String convert(String input)
    throws NullPointerException {
        return Optional.ofNullable(input)
                       .map(converter::convert)
                       .orElseThrow(() -> new NullPointerException("Input data cannot be null."));
    }
}
