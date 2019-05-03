package aslib.util;

import java.util.Map;

/**
 * <p> Contains the functions to convert String into Morse code. </p>
 *
 * @author Adriano Siqueira
 * @version 2019-05-03
 * @since 6.0
 */
public class StringMorseDictionary implements MorseDictionary {

    /**
     * <p> Encodes the input message into morse code. </p>
     *
     * @param input String message to be encoded.
     * @return Entire message converted to morse code.
     * @throws NullPointerException If the input is null.
     */
    public String get(String input) throws NullPointerException {
        if (input == null)
            throw new NullPointerException("Input can not be null.");

        input = input.toUpperCase();
        StringBuilder message = new StringBuilder();

        for (char letter : input.toCharArray()) {
            String s = "";

            for (Map.Entry<String, String> entry : dictionary.entrySet()) {
                if (entry.getKey().equals(String.valueOf(letter))) {
                    s = entry.getValue();
                    break;
                }
            }

            message.append(s);

            /* Automatically adds three spaces between letters. But when the
             * character is a white space, these three spaces will be remaining.
             * So we delete the last three white spaces in that case.
             */
            if (letter != ' ')
                message.append("   ");
            else
                message.delete(message.length() - 3, message.length());
        }

        // Remove redundant white space
        message.delete(message.length() - 3, message.length());
        return message.toString();
    }
}