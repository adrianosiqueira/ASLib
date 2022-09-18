package aslib.convert.morsecodifier;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <p style="text-align:justify">
 * Handles de conversion of
 * <a href="https://wikipedia.org/wiki/Morse-code">Morse code</a> to text.
 * </p>
 *
 * @author Adriano Siqueira
 * @version 1.0.0
 * @since 12.0.0
 */
class MorseToTextConverter implements Converter {

    /**
     * <p style="text-align:justify">
     * Converts the Morse code word to text word.
     * </p>
     *
     * @param word Morse code that will be converted.
     *
     * @return The word converted to text.
     *
     * @since 1.0.0
     */
    private String convertWord(String word) {
        return Stream.of(word)
                     .map(s -> s.split(" {3}"))
                     .flatMap(Stream::of)
                     .map(DICTIONARY::getLetter)
                     .filter(Optional::isPresent)
                     .map(Optional::get)
                     .collect(Collectors.joining())
                     .trim();
    }


    @Override
    public String convert(String morse) {
        return Stream.of(morse)
                     .map(s -> s.split(" {7}"))
                     .flatMap(Stream::of)
                     .map(this::convertWord)
                     .collect(Collectors.joining(" "))
                     .trim();
    }
}
