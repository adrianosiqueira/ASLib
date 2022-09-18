package aslib.security.hash;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * <p style="text-align:justify">
 * Tests for the {@link Generator} class.
 * </p>
 *
 * @author Adriano Siqueira
 * @version 1.0.0
 * @since 12.0.0
 */
class GeneratorTest {

    private final Generator<String> generator = (algorithm, input) -> null;


    @Test
    @DisplayName("ConvertHexadecimalToString: Returns a string result when successful")
    void convertHexadecimalToString_1() {
        byte[] bytes = new byte[]{121, -33, 100, -9, 62, -85, -101, -64, -41, -76, 72, -46, 0, -115, -121, 110};

        assertEquals("79df64f73eab9bc0d7b448d2008d876e", generator.convertHexadecimalToString(bytes));
    }

    @Test
    @DisplayName("ConvertHexadecimalToString: Throws 'NullPointerException' when array is null")
    void convertHexadecimalToString_2() {
        assertThrows(NullPointerException.class, () -> generator.convertHexadecimalToString(null));
    }


    @Test
    @DisplayName("CreateMessageDigest: Returns a message digest when successful")
    void createMessageDigest_1() {
        assertNotNull(generator.createMessageDigest("MD5"));
    }

    @Test
    @DisplayName("CreateMessageDigest: Throws 'AlgorithmNotFoundException' when algorithm is not found")
    void createMessageDigest_2() {
        assertThrows(AlgorithmNotFoundException.class, () -> generator.createMessageDigest(""));
    }

    @Test
    @DisplayName("CreateMessageDigest: Throws 'AlgorithmNotFoundException' when algorithm is null")
    void createMessageDigest_3() {
        assertThrows(AlgorithmNotFoundException.class, () -> generator.createMessageDigest(null));
    }
}
