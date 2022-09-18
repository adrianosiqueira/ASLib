package aslib.convert.morsecodifier;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <p style="text-align:justify">
 * Tests for the {@link MorseCodifier} class.
 * </p>
 *
 * @author Adriano Siqueira
 * @version 1.0.0
 * @since 12.0.0
 */
class MorseCodifierTest {

    @Test
    @DisplayName("ToMorse convert: Returns '...   ---   ...' when input is 'SOS'")
    void toMorseConvert() {
        assertEquals("...   ---   ...", MorseCodifier.toMorse().convert("SOS"));
    }

    @Test
    @DisplayName("ToText convert: Returns 'SOS' when input is '...   ---   ...'")
    void toTextConvert() {
        assertEquals("SOS", MorseCodifier.toText().convert("...   ---   ..."));
    }
}
