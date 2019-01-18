package aslib.util;

/**
 * <p> Contains the functions that convert string/morse. </p>
 * <p> Some accented characters may be encoded but will not be decoded back to string, so some letters may lose their accent. </p>
 *
 * @author Adriano Siqueira
 */
public class MorseCodifier {

    /**
     * <p> Converts the morse code to string. </p>
     * <p> Obs.: Some special characters are not supported and will be replaced by the question mark (?). </p>
     *
     * @param message Message to be converted.
     * @return Fully converted message.
     * @throws IndexOutOfBoundsException If the algorithm tries to access an invalid position in the message.
     */
    public static String morseToString(final String message) throws IndexOutOfBoundsException {
        final StringBuilder convertedMessage = new StringBuilder();
        final String[] words = message.split(" {7}");            // The words are delimited by 7 white spaces

        for (String word : words) {                                     // Travels all words in the message
            final String[] letters = word.split(" {3}");         // The letters are delimited by 3 white spaces
            for (String letter : letters)                               // Travels all letters in the word
                convertedMessage.append(dictionaryToString(letter));
            convertedMessage.append(" ");                               // Add the space between the words
        }

        convertedMessage.deleteCharAt(convertedMessage.length() - 1);   // Removes the unnecessary white space at last position
        return convertedMessage.toString();
    }

    /**
     * <p> Converts the string to morse code. </p>
     * <p> Obs.: Some special characters are not supported and will be replaced by question mark (?). </p>
     *
     * @param message Message to be converted.
     * @return Fully converted message.
     * @throws IndexOutOfBoundsException If the algorithm tries to access an invalid position in the message.
     */
    public static String stringToMorse(final String message) throws IndexOutOfBoundsException {
        final StringBuilder convertedMessage = new StringBuilder();
        final String[] words = message.split(" ");

        for (String word : words) {                                                 // Travels all words in the message
            for (char letter : word.toCharArray())                                  // Travels all letters in the word
                convertedMessage.append(dictionaryToMorse(letter)).append("   ");
            convertedMessage.append("    ");                                        // Add 4 more white spaces to result 7 (word break)
        }

        convertedMessage.delete(convertedMessage.length() - 7, convertedMessage.length());  // Removes the 7 unnecessary white spaces in the end
        return convertedMessage.toString();
    }

    /**
     * <p> Converts the letter to the corresponding morse code. </p>
     * <p> Obs.: Some special characters are not supported and will be replaced by question mark (?). </p>
     *
     * @param letter Letter to be converted.
     * @return The morse code corresponding to the provided letter.
     */
    private static String dictionaryToMorse(final char letter) {
        switch (letter) {
            case 'a':
            case 'ã':
            case 'â':
            case 'á':
            case 'à':
                return ". -";
            case 'b':
                return "- . . .";
            case 'c':
            case 'ç':
                return "- . - .";
            case 'd':
                return "- . .";
            case 'e':
            case 'ê':
            case 'é':
                return ".";
            case 'f':
                return ". . - .";
            case 'g':
                return "- - .";
            case 'h':
                return ". . . .";
            case 'i':
            case 'í':
                return ". .";
            case 'j':
                return ". - - -";
            case 'k':
                return "- . -";
            case 'l':
                return ". - . .";
            case 'm':
                return "- -";
            case 'n':
                return "- .";
            case 'o':
            case 'õ':
            case 'ô':
            case 'ó':
                return "- - -";
            case 'p':
                return ". - - .";
            case 'q':
                return "- - . -";
            case 'r':
                return ". - .";
            case 's':
                return ". . .";
            case 't':
                return "-";
            case 'u':
            case 'ú':
            case 'ü':
                return ". . -";
            case 'v':
                return ". . . -";
            case 'w':
                return ". - -";
            case 'x':
                return "- . . -";
            case 'y':
                return "- . - -";
            case 'z':
                return "- - . .";
            case '0':
                return "- - - - -";
            case '1':
                return ". - - - -";
            case '2':
                return ". . - - -";
            case '3':
                return ". . . - -";
            case '4':
                return ". . . . -";
            case '5':
                return ". . . . .";
            case '6':
                return "- . . . .";
            case '7':
                return "- - . . .";
            case '8':
                return "- - - . .";
            case '9':
                return "- - - - .";
            case ' ':
                return "       ";
            default:
                return "?";
        }
    }

    /**
     * <p> Converts the morse code letter back to string. </p>
     * <p> Obs.: Some special characters are not supported and will be replaced by question mark (?). </p>
     *
     * @param letter Letter to be converted.
     * @return The letter corresponding to the provided morse code.
     */
    private static char dictionaryToString(final String letter) {
        switch (letter) {
            case ". -":
                return 'a';
            case "- . . .":
                return 'b';
            case "- . - .":
                return 'c';
            case "- . .":
                return 'd';
            case ".":
                return 'e';
            case ". . - .":
                return 'f';
            case "- - .":
                return 'g';
            case ". . . .":
                return 'h';
            case ". .":
                return 'i';
            case ". - - -":
                return 'j';
            case "- . -":
                return 'k';
            case ". - . .":
                return 'l';
            case "- -":
                return 'm';
            case "- .":
                return 'n';
            case "- - -":
                return 'o';
            case ". - - .":
                return 'p';
            case "- - . -":
                return 'q';
            case ". - .":
                return 'r';
            case ". . .":
                return 's';
            case "-":
                return 't';
            case ". . -":
                return 'u';
            case ". . . -":
                return 'v';
            case ". - -":
                return 'w';
            case "- . . -":
                return 'x';
            case "- . - -":
                return 'y';
            case "- - . .":
                return 'z';
            case "- - - - -":
                return '0';
            case ". - - - -":
                return '1';
            case ". . - - -":
                return '2';
            case ". . . - -":
                return '3';
            case ". . . . -":
                return '4';
            case ". . . . .":
                return '5';
            case "- . . . .":
                return '6';
            case "- - . . .":
                return '7';
            case "- - - . .":
                return '8';
            case "- - - - .":
                return '9';
            case "       ":
                return ' ';
            default:
                return '?';
        }
    }
}