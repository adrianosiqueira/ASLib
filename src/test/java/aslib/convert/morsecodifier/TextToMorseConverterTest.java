package aslib.convert.morsecodifier;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * <p style="text-align:justify">
 * Tests for the {@link TextToMorseConverter} class.
 * </p>
 *
 * @author Adriano Siqueira
 * @version 1.0.0
 * @since 12.0.0
 */
class TextToMorseConverterTest {

    private final Converter converter = MorseCodifier.toMorse();

    @Test
    @DisplayName("Convert: Throws 'NullPointerException' when input is null")
    void convert_0() {
        assertThrows(NullPointerException.class, () -> converter.convert(null));
    }

    @Test
    @DisplayName("Convert: Returns '' when input is ''")
    void convert_1() {
        assertEquals("", converter.convert(""));
    }

    @Test
    @DisplayName("Convert: Returns '...   ---   ...' when input is 'SOS'")
    void convert_2() {
        assertEquals("...   ---   ...", converter.convert("sos"));
    }

    @Test
    @DisplayName("Convert: Returns '...       ...' when input is 'S S'")
    void convert_3() {
        assertEquals("...       ...", converter.convert("s s"));
    }

    @Test
    @DisplayName("Convert: Returns '...' when input is 'Sº'")
    void convert_4() {
        assertEquals("...", converter.convert("sº"));
    }

    @Test
    @DisplayName("Convert: Returns '' when input is 'º'")
    void convert_5() {
        assertEquals("", converter.convert("º"));
    }
}
