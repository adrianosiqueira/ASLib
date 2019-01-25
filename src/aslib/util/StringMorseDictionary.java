package aslib.util;

import java.util.HashMap;
import java.util.Map;

/**
 * <p> Contains the functions to convert String into Morse code. </p>
 *
 * @author Adriano Siqueira
 * @version 1.0
 * @since 6.0
 */
public class StringMorseDictionary {
    private static Map<Character, String> dictionary;

    static {
        dictionary = new HashMap<>();
        dictionary.put('0', "- - - - -");
        dictionary.put('1', ". - - - -");
        dictionary.put('2', ". . - - -");
        dictionary.put('3', ". . . - -");
        dictionary.put('4', ". . . . -");
        dictionary.put('5', ". . . . .");
        dictionary.put('6', "- . . . .");
        dictionary.put('7', "- - . . .");
        dictionary.put('8', "- - - . .");
        dictionary.put('9', "- - - - .");
        dictionary.put('A', ". -");
        dictionary.put('Ã', ". -");
        dictionary.put('Â', ". -");
        dictionary.put('Á', ". -");
        dictionary.put('À', ". -");
        dictionary.put('B', "- . . .");
        dictionary.put('C', "- . - .");
        dictionary.put('Ç', "- . - .");
        dictionary.put('D', "- . .");
        dictionary.put('E', ".");
        dictionary.put('Ê', ".");
        dictionary.put('É', ".");
        dictionary.put('F', ". . - .");
        dictionary.put('G', "- - .");
        dictionary.put('H', ". . . .");
        dictionary.put('I', ". .");
        dictionary.put('Í', ". .");
        dictionary.put('J', ". - - -");
        dictionary.put('K', "- . -");
        dictionary.put('L', ". - . .");
        dictionary.put('M', "- -");
        dictionary.put('N', "- .");
        dictionary.put('Ñ', "- .");
        dictionary.put('O', "- - -");
        dictionary.put('Õ', "- - -");
        dictionary.put('Ô', "- - -");
        dictionary.put('Ó', "- - -");
        dictionary.put('P', ". - - .");
        dictionary.put('Q', "- - . -");
        dictionary.put('R', ". - .");
        dictionary.put('S', ". . .");
        dictionary.put('T', "-");
        dictionary.put('U', ". . -");
        dictionary.put('Ú', ". . -");
        dictionary.put('Ü', ". . -");
        dictionary.put('V', ". . . -");
        dictionary.put('W', ". - -");
        dictionary.put('X', "- . . -");
        dictionary.put('Y', "- . - -");
        dictionary.put('Z', "- - . .");
        dictionary.put(' ', "       ");
    }

    /**
     * <p> Search for the letter and returns the morse code for it. </p>
     *
     * @param letter Letter to be converted.
     * @return The morse referring to the letter or null if the letter is not found.
     */
    public String getMorseLetter(char letter) {
        return dictionary.get(Character.toUpperCase(letter));
    }

    /**
     * <p> Converts the entire message. </p>
     *
     * @param message Message to be converted.
     * @return Entire message converted to morse code or an empty string if the message is null.
     */
    public String getMorseMessage(String message) {
        if (message == null)
            return "";

        StringBuilder converted = new StringBuilder();

        for (char letter : message.toCharArray()) {
            converted.append(dictionary.get(Character.toUpperCase(letter)));
            if (letter != ' ')
                converted.append("   ");
            else
                converted.delete(converted.length() - 3, converted.length());
        }

        // Remove redundant white space
        converted.delete(converted.length() - 3, converted.length());
        return converted.toString();
    }
}