package aslib.convert.morsecodifier;

import java.util.Map;
import java.util.Optional;

/**
 * <p style="text-align:justify">
 * Contains the relationship of the letters with their respective Morse codes,
 * literally working like a dictionary.
 * </p>
 *
 * @author Adriano Siqueira
 * @version 1.0.0
 * @since 12.0.0
 */
public class Dictionary {

    /**
     * <p style="text-align:justify">
     * Relation of characters and Morse codes.
     * </p>
     *
     * @since 1.0.0
     */
    private Map<String, String> dictionary = Map.ofEntries(
            Map.entry("A", ".-"),
            Map.entry("Á", ".--.-"),
            Map.entry("À", ".-"),
            Map.entry("Ã", ".-"),
            Map.entry("Â", ".-"),
            Map.entry("B", "-..."),
            Map.entry("C", "-.-."),
            Map.entry("Ç", "-.-.."),
            Map.entry("D", "-.."),
            Map.entry("E", "."),
            Map.entry("É", "..-.."),
            Map.entry("Ê", "."),
            Map.entry("F", "..-."),
            Map.entry("G", "--."),
            Map.entry("H", "...."),
            Map.entry("I", ".."),
            Map.entry("Í", ".."),
            Map.entry("J", ".---"),
            Map.entry("K", "-.-"),
            Map.entry("L", ".-.."),
            Map.entry("M", "--"),
            Map.entry("N", "-."),
            Map.entry("Ñ", "--.--"),
            Map.entry("O", "---"),
            Map.entry("Ó", "---"),
            Map.entry("Õ", "---"),
            Map.entry("Ô", "---"),
            Map.entry("P", ".--."),
            Map.entry("Q", "--.-"),
            Map.entry("R", ".-."),
            Map.entry("S", "..."),
            Map.entry("T", "-"),
            Map.entry("U", "..-"),
            Map.entry("Ú", "..-"),
            Map.entry("Ü", "..--"),
            Map.entry("V", "...-"),
            Map.entry("W", ".--"),
            Map.entry("X", "-..-"),
            Map.entry("Y", "-.--"),
            Map.entry("Z", "--.."),
            Map.entry("0", "-----"),
            Map.entry("1", ".----"),
            Map.entry("2", "..---"),
            Map.entry("3", "...--"),
            Map.entry("4", "....-"),
            Map.entry("5", "....."),
            Map.entry("6", "-...."),
            Map.entry("7", "--..."),
            Map.entry("8", "---.."),
            Map.entry("9", "----."),
            Map.entry("_", "..--.-"),
            Map.entry("@", ".--.-."),
            Map.entry("$", "...-..-"),
            Map.entry("&", ".-..."),
            Map.entry("'", ".----."),
            Map.entry("\"", ".-..-."),
            Map.entry("+", ".-.-."),
            Map.entry("-", "-....-"),
            Map.entry("/", "-..-."),
            Map.entry("=", "-...-"),
            Map.entry("!", "-.-.--"),
            Map.entry("?", "..--.."),
            Map.entry(".", ".-.-.-"),
            Map.entry(",", "--..--"),
            Map.entry(";", "-.-.-."),
            Map.entry(":", "---..."),
            Map.entry("(", "-.--."),
            Map.entry(")", "-.--.-"),
            Map.entry(" ", "       ")
    );


    /**
     * <p style="text-align:justify">
     * Searches the dictionary for the character corresponding to the given
     * Morse code.
     * </p>
     *
     * <p style="text-align:justify">
     * This method returns an {@link Optional} containing the character. If
     * the Morse code is not found, then an {@link Optional#empty} will be
     * returned.
     * </p>
     *
     * <p style="text-align:justify">
     * Because accented letters have the same Morse code, there is a high
     * chance that the returned letter will not be accented because of
     * dictionary sorting.
     * </p>
     *
     * @param morse Morse code that will be searched.
     *
     * @return An {@link Optional} containing the character.
     *
     * @since 1.0.0
     */
    public Optional<String> getLetter(String morse) {
        return dictionary.entrySet()
                         .stream()
                         .sorted(Map.Entry.comparingByKey())
                         .filter(e -> e.getValue().equals(morse))
                         .map(Map.Entry::getKey)
                         .findFirst();
    }

    /**
     * <p style="text-align:justify">
     * Searches the dictionary for the Morse code corresponding to the given
     * character.
     * </p>
     *
     * <p style="text-align:justify">
     * This method returns an {@link Optional} containing the Morse code. If
     * the character is not found, then an {@link Optional#empty} will be
     * returned.
     * </p>
     *
     * <p style="text-align:justify">
     * Accented letters have the same Morse code as unaccented letters.
     * </p>
     *
     * @param letter Character that will be searched.
     *
     * @return An {@link Optional} containing the Morse code.
     *
     * @since 1.0.0
     */
    public Optional<String> getMorse(String letter) {
        return Optional.ofNullable(letter)
                       .map(String::toUpperCase)
                       .map(dictionary::get);
    }
}
