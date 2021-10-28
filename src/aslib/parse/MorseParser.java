package aslib.parse;

import aslib.util.BiParsable;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>Morse code encoding class.</p>
 *
 * <p>This class handles encoding and decoding between morse code and natural
 * language.</p>
 *
 * @author Adriano Siqueira
 * @version 1.0.0
 * @since 11.0.0
 */
public class MorseParser implements BiParsable<String, String> {

    /**
     * <p>Dictionary with the list of letters and codes.</p>
     *
     * @since 1.0.0
     */
    private final Map<String, String> dictionary = new HashMap<String, String>() {{
        put("A", ".-");
        put("Á", ".--.-");
        put("À", ".-");
        put("Ã", ".-");
        put("Â", ".-");
        put("B", "-...");
        put("C", "-.-.");
        put("Ç", "-.-..");
        put("D", "-..");
        put("E", ".");
        put("É", "..-..");
        put("Ê", ".");
        put("F", "..-.");
        put("G", "--.");
        put("H", "....");
        put("I", "..");
        put("Í", "..");
        put("J", ".---");
        put("K", "-.-");
        put("L", ".-..");
        put("M", "--");
        put("N", "-.");
        put("Ñ", "--.--");
        put("O", "---");
        put("Ó", "---");
        put("Õ", "---");
        put("Ô", "---");
        put("P", ".--.");
        put("Q", "--.-");
        put("R", ".-.");
        put("S", "...");
        put("T", "-");
        put("U", "..-");
        put("Ú", "..-");
        put("Ü", "..--");
        put("V", "...-");
        put("W", ".--");
        put("X", "-..-");
        put("Y", "-.--");
        put("Z", "--..");
        put("0", "-----");
        put("1", ".----");
        put("2", "..---");
        put("3", "...--");
        put("4", "....-");
        put("5", ".....");
        put("6", "-....");
        put("7", "--...");
        put("8", "---..");
        put("9", "----.");
        put("_", "..--.-");
        put("@", ".--.-.");
        put("$", "...-..-");
        put("&", ".-...");
        put("'", ".----.");
        put("\"", ".-..-.");
        put("+", ".-.-.");
        put("-", "-....-");
        put("/", "-..-.");
        put("=", "-...-");
        put("!", "-.-.--");
        put("?", "..--..");
        put(".", ".-.-.-");
        put(",", "--..--");
        put(";", "-.-.-.");
        put(":", "---...");
        put("(", "-.--.");
        put(")", "-.--.-");
        put(" ", "       ");
    }};


    /**
     * <p>Creates an instance of the {@link MorseParser} class.</p>
     *
     * @since 1.0.0
     */
    public MorseParser() {
    }


    /**
     * <p>Encodes the natural language message into morse code.</p>
     *
     * @param message Message that will be encoded. Not null.
     *
     * @return A string containing the encoded message. The string can be empty,
     * but it will never be null.
     *
     * @since 1.0.0
     */
    @Override
    public String toA(String message) {
        StringBuilder result = new StringBuilder();

        for (char character : message.toUpperCase().toCharArray()) {
            result.append(dictionary.getOrDefault(String.valueOf(character), ""))
                  .append("   ");

            if (character == ' ') {
                // Remove extra white spaces
                result.delete(result.length() - 6, result.length());
            }
        }

        return result.toString().trim();
    }


    /**
     * <p>Decodes the message from morse code to natural language.</p>
     *
     * @param morseCode Message that will be decoded. Not null.
     *
     * @return A string containing the decoded message. The string can be empty,
     * but it will never be null.
     *
     * @since 1.0.0
     */
    @Override
    public String toB(String morseCode) {
        StringBuilder result = new StringBuilder();

        for (String word : morseCode.split(" {7}")) {
            for (String letter : word.split(" {3}")) {
                for (Map.Entry<String, String> entry : dictionary.entrySet()) {
                    if (entry.getValue().equals(letter)) {
                        result.append(entry.getKey());
                        break;
                    }
                }
            }

            result.append(" ");
        }

        return result.toString().trim();
    }
}
