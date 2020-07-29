package aslib.util;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p> Handles the conversion between String and Morse code. </p>
 *
 * @author Adriano Siqueira
 * @version 2.0.0
 * @since 6.1.0
 */
public class MorseCodifier {
    /**
     * <p> Relation of letters and Morse code. </p>
     *
     * @since 1.0.0
     */
    public static final Map<String, String> dictionary =
            Collections.unmodifiableMap(
                    new LinkedHashMap<String, String>() {{
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
                    }});

    /**
     * <p> Converts the text to Morse code. </p>
     *
     * @param input String to be converted. If any letter can not be converted, it will be ignored.
     *
     * @return A Morse code converted from text.
     *
     * @throws NullPointerException If input string is null.
     * @since 1.0.0
     */
    public String toMorse(String input) throws NullPointerException {
        Objects.requireNonNull(input, "Input can not be null.");
        input = input.toUpperCase();

        StringBuilder builder = new StringBuilder();
        String morse;

        for (char letter : input.toCharArray()) {
            morse = dictionary.get(String.valueOf(letter));

            if (letter == ' ') {
                builder.append(morse)
                        .delete(builder.length() - 3, builder.length());
            } else {
                builder.append(morse != null ? morse : "")
                        .append("   ");
            }
        }

        return builder.toString().trim();
    }

    /**
     * <p> Converts the Morse code to text. </p>
     *
     * @param input String to be converted. If any letter can not be converted, it will be ignored.
     *
     * @return A text converted from Morse code.
     *
     * @throws NullPointerException If input string is null.
     * @since 1.0.0
     */
    public String toString(String input) throws NullPointerException {
        Objects.requireNonNull(input, "Input can not be null.");

        StringBuilder builder = new StringBuilder();

        for (String word : input.split(" {7}")) {
            for (String letter : word.split(" {3}")) {
                for (Map.Entry<String, String> entry : dictionary.entrySet()) {
                    if (entry.getValue().equals(letter)) {
                        builder.append(entry.getKey());
                        break;
                    }
                }
            }

            builder.append(" ");
        }

        return builder.toString().trim();
    }
}
