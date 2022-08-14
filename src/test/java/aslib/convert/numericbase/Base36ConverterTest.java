package aslib.convert.numericbase;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * <p style="text-align:justify">
 * Tests for the {@link Base36Converter} class.
 * </p>
 *
 * @author Adriano Siqueira
 * @version 1.0.0
 * @since 12.0.0
 */
class Base36ConverterTest {

    private final BaseConverter converter = NumericBaseConverter.base36();

    @Test
    @DisplayName("ToDecimal: Returns '0' when value is '0'")
    void toDecimal_0() {
        assertEquals(0, converter.toDecimal("0"));
    }

    @Test
    @DisplayName("ToDecimal: Returns '35' when value is 'Z'")
    void toDecimal_1() {
        assertEquals(35, converter.toDecimal("Z"));
    }

    @Test
    @DisplayName("ToDecimal: Returns '-35' when value is '-Z'")
    void toDecimal_2() {
        assertEquals(-35, converter.toDecimal("-Z"));
    }

    @Test
    @DisplayName("ToDecimal: Throws 'NumberFormatException' when value is ''")
    void toDecimal_3() {
        assertThrows(NumberFormatException.class, () -> converter.toDecimal(""));
    }

    @Test
    @DisplayName("ToDecimal: Throws 'NumberFormatException' when value is not valid")
    void toDecimal_4() {
        assertThrows(NumberFormatException.class, () -> converter.toDecimal("!"));
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
    @DisplayName("ToNewBase: Returns 'Z' when value is '35'")
    void toNewBase_1() {
        assertEquals("Z", converter.toNewBase(35));
    }

    @Test
    @DisplayName("ToNewBase: Returns '-Z' when value is '-35'")
    void toNewBase_2() {
        assertEquals("-Z", converter.toNewBase(-35));
    }
}
