package aslib.document;

import aslib.document.bra.BrazilianDocument;

/**
 * <p>
 * Entry point to the API. Its methods give access to the implementation of a
 * particular country.
 * </p>
 *
 * @author Adriano Siqueira
 * @version 1.0.0
 * @since 12.0.0
 */
public class Document {

    /**
     * <p>
     * Access the implementation of Brazilian documents.
     * </p>
     *
     * @return An instance of {@link BrazilianDocument}.
     *
     * @since 1.0.0
     */
    public static BrazilianDocument brazil() {
        return new BrazilianDocument();
    }
}
