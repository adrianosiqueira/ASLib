package aslib.convert.morsecodifier;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * <p style="text-align:justify">
 * Tests for the {@link Dictionary} class.
 * </p>
 *
 * @author Adriano Siqueira
 * @version 1.0.0
 * @since 12.0.0
 */
@SuppressWarnings("OptionalGetWithoutIsPresent")
class DictionaryTest {

    private final Dictionary dictionary = new Dictionary();

    @Test
    @DisplayName("GetLetter: Returns an empty optional when input is null")
    void getLetter_0() {
        assertTrue(dictionary.getLetter(null).isEmpty());
    }

    @Test
    @DisplayName("GetLetter: Returns an empty optional when input is ''")
    void getLetter_1() {
        assertTrue(dictionary.getLetter("").isEmpty());
    }

    @Test
    @DisplayName("GetLetter: Returns 'S' when input is '...'")
    void getLetter_2() {
        assertEquals("S", dictionary.getLetter("...").get());
    }

    @Test
    @DisplayName("GetLetter: Returns 'A' when input is '.-'")
    void getLetter_3() {
        assertEquals("A", dictionary.getLetter(".-").get());
    }


    @Test
    @DisplayName("GetMorse: Returns an empty optional when input is null")
    void getMorse_0() {
        assertTrue(dictionary.getMorse(null).isEmpty());
    }

    @Test
    @DisplayName("GetMorse: Returns an empty optional when input is ''")
    void getMorse_1() {
        assertTrue(dictionary.getMorse("").isEmpty());
    }

    @Test
    @DisplayName("GetMorse: Returns '...' when input is 'S'")
    void getMorse_2() {
        assertEquals("...", dictionary.getMorse("S").get());
    }

    @Test
    @DisplayName("GetMorse: Returns '.-' when input is 'A'")
    void getMorse_3() {
        assertEquals(".-", dictionary.getMorse("A").get());
    }

    @Test
    @DisplayName("GetMorse: Returns '.-' when input is 'Ã'")
    void getMorse_4() {
        assertEquals(".-", dictionary.getMorse("Ã").get());
    }
}
