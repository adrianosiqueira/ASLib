package aslib.document;

import aslib.document.bra.BrazilianDocument;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * <p style="text-align:justify">
 * Tests for the {@link Document} class.
 * </p>
 *
 * @author Adriano Siqueira
 * @version 1.0.0
 * @since 12.0.0
 */
class DocumentTest {

    @Test
    @DisplayName("Brazil: Returns instance of 'BrazilianDocument' when successful")
    void brazil() {
        Assertions.assertInstanceOf(BrazilianDocument.class, Document.brazil());
    }
}
