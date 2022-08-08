package aslib.convert.morsecodifier;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * <p style="text-align:justify">
 * Tests for the {@link MorseToTextConverter} class.
 * </p>
 *
 * @author Adriano Siqueira
 * @version 1.0.0
 * @since 12.0.0
 */
class MorseToTextConverterTest {

    private final Converter converter = MorseCodifier.toText();

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
    @DisplayName("Convert: Returns 'SOS' when input is '...   ---   ...'")
    void convert_2() {
        assertEquals("SOS", converter.convert("...   ---   ..."));
    }

    @Test
    @DisplayName("Convert: Returns 'S S' when input is '...       ...'")
    void convert_3() {
        assertEquals("S S", converter.convert("...       ..."));
    }
}
