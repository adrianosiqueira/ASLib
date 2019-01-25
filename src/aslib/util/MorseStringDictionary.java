package aslib.util;

import java.util.HashMap;
import java.util.Map;

/**
 * <p> Contains the functions to convert Morse code into String. </p>
 *
 * @author Adriano Siqueira
 * @version 1.0
 * @since 6.0
 */
public class MorseStringDictionary {
    private static Map<String, Character> dictionary;

    static {
        dictionary = new HashMap<>();
        dictionary.put("- - - - -", '0');
        dictionary.put(". - - - -", '1');
        dictionary.put(". . - - -", '2');
        dictionary.put(". . . - -", '3');
        dictionary.put(". . . . -", '4');
        dictionary.put(". . . . .", '5');
        dictionary.put("- . . . .", '6');
        dictionary.put("- - . . .", '7');
        dictionary.put("- - - . .", '8');
        dictionary.put("- - - - .", '9');
        dictionary.put(". -", 'A');
        dictionary.put("- . . .", 'B');
        dictionary.put("- . - .", 'C');
        dictionary.put("- . .", 'D');
        dictionary.put(".", 'E');
        dictionary.put(". . - .", 'F');
        dictionary.put("- - .", 'G');
        dictionary.put(". . . .", 'H');
        dictionary.put(". .", 'I');
        dictionary.put(". - - -", 'J');
        dictionary.put("- . -", 'K');
        dictionary.put(". - . .", 'L');
        dictionary.put("- -", 'M');
        dictionary.put("- .", 'N');
        dictionary.put("- - -", 'O');
        dictionary.put(". - - .", 'P');
        dictionary.put("- - . -", 'Q');
        dictionary.put(". - .", 'R');
        dictionary.put(". . .", 'S');
        dictionary.put("-", 'T');
        dictionary.put(". . -", 'U');
        dictionary.put(". . . -", 'V');
        dictionary.put(". - -", 'W');
        dictionary.put("- . . -", 'X');
        dictionary.put("- . - -", 'Y');
        dictionary.put("- - . .", 'Z');
        dictionary.put("       ", ' ');
    }

    /**
     * <p> Search for the code and returns the letter for it. </p>
     *
     * @param code Code to be converted.
     * @return The letter referring to the code or null if the code is not found.
     */
    public char getStringLetter(String code) {
        return dictionary.get(code);
    }

    /**
     * <p> Converts the entire message. </p>
     *
     * @param message Message to be converted.
     * @return Entire message converted to morse code or an empty string if the message is null.
     */
    public String getStringMessage(String message) {
        if (message == null)
            return "";

        StringBuilder converted = new StringBuilder();
        String[] words = message.split(" {7}");

        for (String word : words) {
            String[] letters = word.split(" {3}");

            for (String letter : letters)
                converted.append(dictionary.get(letter));

            converted.append(" ");
        }

        // Remove redundant white space
        converted.deleteCharAt(converted.length() - 1);
        return converted.toString();
    }
}
