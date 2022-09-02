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
 * Tests for the {@link CPF} class.
 * </p>
 *
 * @author Adriano Siqueira
 * @version 1.0.1
 * @since 12.0.0
 */
class CPFTest {

    private final DocumentCoreUtil document = new BrazilianDocument().cpf();

    @Test
    @DisplayName("Format: Returns '011.111.111/11' when value is '111.111.111/1'")
    void format_0() {
        assertEquals("011.111.111/11", document.format("111.111.111/1"));
    }

    @Test
    @DisplayName("Format: Returns '111.111.111/11' when value is '111.111.111/111'")
    void format_1() {
        assertEquals("111.111.111/11", document.format("111.111.111/111"));
    }

    @Test
    @DisplayName("Format: Returns '111.111.111/11' when value is '11111111111'")
    void format_2() {
        assertEquals("111.111.111/11", document.format("11111111111"));
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
    @DisplayName("IsValid: Returns 'false' when value is '106.694.192/07'")
    void isValid_0() {
        assertFalse(document.isValid("106.694.192/07"));
    }

    @Test
    @DisplayName("IsValid: Returns 'true' when value is '106.694.192/06'")
    void isValid_1() {
        assertTrue(document.isValid("106.694.192/06"));
    }

    @Test
    @DisplayName("IsValid: Throws 'NullDocumentException' when value is null")
    void isValid_2() {
        assertThrows(NullDocumentException.class, () -> document.isValid(null));
    }
}
