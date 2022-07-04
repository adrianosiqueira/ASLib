package aslib.document;

/**
 * <p>
 * Defines the core functionalities of all document implementations.
 * </p>
 *
 * @author Adriano Siqueira
 * @version 1.0.0
 * @since 12.0.0
 */
public interface DocumentCoreUtil {

    /**
     * <p>
     * Formats the document according to its standards.
     * </p>
     *
     * @param document Document that will be formatted.
     *
     * @return The document formatted.
     *
     * @since 1.0.0
     */
    String format(String document);

    /**
     * <p>
     * Generates a new document. The implementation guarantees that the
     * document will be mathematically valid and the result will be formatted.
     * </p>
     *
     * @return A new mathematically valid and formatted document.
     *
     * @since 1.0.0
     */
    String generate();

    /**
     * <p>
     * Checks if the document is mathematically valid.
     * </p>
     *
     * @param document Document that will be checked.
     *
     * @return TRUE if it is valid.
     *
     * @since 1.0.0
     */
    boolean isValid(String document);
}
