package aslib.document.bra;

import aslib.document.Document;
import aslib.document.NullDocumentException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * <p style="text-align:justify">
 * Tests for the {@link RG} class.
 * </p>
 *
 * @author Adriano Siqueira
 * @version 1.0.2
 * @since 12.0.0
 */
class RGTest {

    private final Document document = BrazilianDocument.rg();


    @Test
    @DisplayName("Format: Returns '01.111.111-1' when value is '11.111.111'")
    void format_0() {
        assertEquals("01.111.111-1", document.format("11.111.111"));
    }

    @Test
    @DisplayName("Format: Returns '11.111.111-1' when value is '11.111.111-11'")
    void format_1() {
        assertEquals("11.111.111-1", document.format("11.111.111-11"));
    }

    @Test
    @DisplayName("Format: Returns '11.111.111-1' when value is '111111111'")
    void format_2() {
        assertEquals("11.111.111-1", document.format("111111111"));
    }

    @Test
    @DisplayName("Format: Returns '11.111.111-X' when value is '11111111X'")
    void format_3() {
        assertEquals("11.111.111-X", document.format("11111111X"));
    }

    @Test
    @DisplayName("Format: Throws 'NullDocumentException' when value is null")
    void format_4() {
        assertThrows(NullDocumentException.class, () -> document.format(null));
    }

    @Test
    @DisplayName("Generate: Returns new valid document when successful")
    void generate_0() {
        assertTrue(document.isValid(document.generate()));
    }

    @Test
    @DisplayName("IsValid: Returns 'false' when value is '58.396.330-5'")
    void isValid_0() {
        assertFalse(document.isValid("58.396.330-5"));
    }

    @Test
    @DisplayName("IsValid: Returns 'true' when value is '58.396.330-4'")
    void isValid_1() {
        assertTrue(document.isValid("58.396.330-4"));
    }

    @Test
    @DisplayName("IsValid: Throws 'NullDocumentException' when value is null")
    void isValid_2() {
        assertThrows(NullDocumentException.class, () -> document.isValid(null));
    }
}
