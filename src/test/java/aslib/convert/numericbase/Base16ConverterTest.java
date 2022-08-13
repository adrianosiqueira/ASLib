package aslib.convert.numericbase;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * <p style="text-align:justify">
 * Tests for the {@link Base16Converter} class.
 * </p>
 *
 * @author Adriano Siqueira
 * @version 1.0.0
 * @since 12.0.0
 */
class Base16ConverterTest {

    private final BaseConverter converter = NumericBaseConverter.base16();

    @Test
    @DisplayName("ToDecimal: Returns '0' when value is '0'")
    void toDecimal_0() {
        assertEquals(0, converter.toDecimal("0"));
    }

    @Test
    @DisplayName("ToDecimal: Returns '10' when value is 'A'")
    void toDecimal_1() {
        assertEquals(10, converter.toDecimal("A"));
    }

    @Test
    @DisplayName("ToDecimal: Returns '-10' when value is '-A'")
    void toDecimal_2() {
        assertEquals(-10, converter.toDecimal("-A"));
    }

    @Test
    @DisplayName("ToDecimal: Throws 'NumberFormatException' when value is ''")
    void toDecimal_3() {
        assertThrows(NumberFormatException.class, () -> converter.toDecimal(""));
    }

    @Test
    @DisplayName("ToDecimal: Throws 'NumberFormatException' when value is not valid")
    void toDecimal_4() {
        assertThrows(NumberFormatException.class, () -> converter.toDecimal("x"));
    }

    @Test
    @DisplayName("ToDecimal: Throws 'NumberFormatException' when value is null")
    void toDecimal_5() {
        assertThrows(NumberFormatException.class, () -> converter.toDecimal(null));
    }


    @Test
    @DisplayName("ToNewBase: Returns '0' when value is '0'")
    void toNewBase_0() {
        assertEquals("0", converter.toNewBase(0));
    }

    @Test
    @DisplayName("ToNewBase: Returns 'A' when value is '10'")
    void toNewBase_1() {
        assertEquals("A", converter.toNewBase(10));
    }

    @Test
    @DisplayName("ToNewBase: Returns '-A' when value is '-10'")
    void toNewBase_2() {
        assertEquals("-A", converter.toNewBase(-10));
    }
}
