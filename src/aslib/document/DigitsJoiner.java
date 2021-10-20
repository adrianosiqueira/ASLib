package aslib.document;

import aslib.util.Parsable;

import java.util.List;

/**
 * <p>Handles the process of joining numeric digits into a string.</p>
 *
 * @author Adriano Siqueira
 * @version 1.0.0
 * @since 11.0.0
 */
public class DigitsJoiner implements Parsable<List<Integer>, String> {

    /**
     * <p>Joins the digits from the list into a single string.</p>
     *
     * @param integers List of digits that will be joined. Not null.
     *
     * @return A string formed by joining all the digits in the list. The string
     * can be empty, but it will never be null.
     *
     * @since 1.0.0
     */
    @Override
    public String parse(List<Integer> integers) {
        return integers.stream()
                       .map(Object::toString)
                       .reduce(String::concat)
                       .orElse("");
    }
}
