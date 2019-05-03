package aslib.util;

import java.util.Map;

/**
 * <p> Contains the functions to convert Morse code into String. </p>
 *
 * @author Adriano Siqueira
 * @version 2019-05-03
 * @since 6.0
 */
public class MorseStringDictionary implements MorseDictionary {

    @Override
    public String get(String morse) {
        if (morse == null)
            return "";

        StringBuilder message = new StringBuilder();
        String[] words = morse.split(" {7}");

        for (String word : words) {
            String[] letters = word.split(" {3}");

            for (String letter : letters) {
                String s = "";

                for (Map.Entry<String, String> entry : dictionary.entrySet()) {
                    if (entry.getValue().equals(letter)) {
                        s = entry.getKey();
                        break;
                    }
                }

                message.append(s);
            }

            message.append(" ");
        }

        // Remove redundant white space
        message.deleteCharAt(message.length() - 1);
        return message.toString();
    }
}