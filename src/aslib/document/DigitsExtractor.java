package aslib.document;

import aslib.util.Parsable;

import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>Handles the conversion of a string to a list of numeric digits.</p>
 *
 * @author Adriano Siqueira
 * @version 1.0.0
 * @since 11.0.0
 */
public class DigitsExtractor implements Parsable<String, List<Integer>> {

    /**
     * <p>Extracts numeric digits from a string. All non-numeric characters are
     * ignored.</p>
     *
     * @param s Where the digits will be extracted from. Not null.
     *
     * @return A list of extracted digits. The list can be empty, but it will
     * never be null.
     *
     * @since 1.0.0
     */
    @Override
    public List<Integer> parse(String s) {
        return s.codePoints()
                .filter(Character::isDigit)
                .map(Character::getNumericValue)
                .boxed()
                .collect(Collectors.toList());
    }
}
