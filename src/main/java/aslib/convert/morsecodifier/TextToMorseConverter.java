package aslib.convert.morsecodifier;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <p style="text-align:justify">
 * Handles the conversion of text to
 * <a href="https://wikipedia.org/wiki/Morse-code">Morse code</a>.
 * </p>
 *
 * @author Adriano Siqueira
 * @version 1.0.0
 * @since 12.0.0
 */
class TextToMorseConverter implements Converter {

    @Override
    public String convert(String text) {
        return Stream.of(text)
                     .map(s -> s.split(""))
                     .flatMap(Stream::of)
                     .map(DICTIONARY::getMorse)
                     .filter(Optional::isPresent)
                     .map(Optional::get)
                     .collect(Collectors.joining("   "))
                     .replaceAll(" {8,}", "       ")
                     .trim();
    }
}
