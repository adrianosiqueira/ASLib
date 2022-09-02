package aslib.document.bra;

import aslib.document.DocumentCoreUtil;
import aslib.document.NullDocumentException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * <p style="text-align:justify">
 * Tests for the {@link VoterTitle} class.
 * </p>
 *
 * @author Adriano Siqueira
 * @version 1.0.1
 * @since 12.0.0
 */
class VoterTitleTest {

    private final DocumentCoreUtil document = new BrazilianDocument().voterTitle();


    @Test
    @DisplayName("Format: Returns '0111 1111 11 11' when value is '1111 1111 11 1'")
    void format_0() {
        assertEquals("0111 1111 11 11", document.format("1111 1111 11 1"));
    }

    @Test
    @DisplayName("Format: Returns '1111 1111 11 11' when value is '1111 1111 11 111'")
    void format_1() {
        assertEquals("1111 1111 11 11", document.format("1111 1111 11 111"));
    }

    @Test
    @DisplayName("Format: Returns '1111 1111 11 11' when value is '111111111111'")
    void format_2() {
        assertEquals("1111 1111 11 11", document.format("111111111111"));
    }

    @Test
    @DisplayName("Format: Throws 'NullDocumentException' when value is null")
    void format_3() {
        assertThrows(NullDocumentException.class, () -> document.format(null));
    }

    @Test
    @DisplayName("Generate: Returns new valid document when successful")
    void generate_0() {
        assertTrue(document.isValid(document.generate()));
    }

    @Test
    @DisplayName("IsValid: Returns 'false' when value is '8370 4987 13 34'")
    void isValid_0() {
        assertFalse(document.isValid("8370 4987 13 34"));
    }

    @Test
    @DisplayName("IsValid: Returns 'true' when value is '8370 4987 13 33'")
    void isValid_1() {
        assertTrue(document.isValid("8370 4987 13 33"));
    }

    @Test
    @DisplayName("IsValid: Throws 'NullDocumentException' when value is null")
    void isValid_2() {
        assertThrows(NullDocumentException.class, () -> document.isValid(null));
    }
}
