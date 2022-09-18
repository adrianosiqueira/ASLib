package aslib.document;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * <p>
 * Defines the internal functionalities of all document implementations.
 * </p>
 *
 * @author Adriano Siqueira
 * @version 1.0.0
 * @since 12.0.0
 */
public interface DocumentInternal extends Document {

    /**
     * <p>
     * Calculates the verification digits of the document. If the provided
     * digits are complete, the verification digits will be removed.
     * </p>
     *
     * @param digits Document digits that will be processed. It may or may not
     *               be complete.
     *
     * @return A list with the verification digits only.
     *
     * @since 1.0.0
     */
    List<Integer> calculateVerificationDigits(List<Integer> digits);

    /**
     * <p>
     * Generates a list with the known invalids documents.
     * </p>
     *
     * @param length Length of document with all digits.
     *
     * @return A list with invalids digits.
     *
     * @since 1.0.0
     */
    default List<List<Integer>> invalids(int length) {
        DocumentUtils utils = new DocumentUtils(length, 0);

        return Stream.iterate(0, i -> i <= 9, i -> ++i)
                     .map(String::valueOf)
                     .map(s -> s.repeat(length))
                     .map(utils::extractDigits)
                     .collect(Collectors.toList());
    }
}
