package aslib.security.hash;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * <p style="text-align:justify">
 * Tests for the {@link StringGenerator} class.
 * </p>
 *
 * @author Adriano Siqueira
 * @version 1.0.0
 * @since 12.0.0
 */
class StringGeneratorTest {

    private final String            string    = "hello world!\n";
    private final Generator<String> generator = new StringGenerator();


    @Test
    @DisplayName("Generate: Returns the MD5 when successful")
    void generate_1() {
        assertEquals("c897d1410af8f2c74fba11b1db511e9e", generator.generate("MD5", string));
    }

    @Test
    @DisplayName("Generate: Returns the SHA1 when successful")
    void generate_2() {
        assertEquals("f951b101989b2c3b7471710b4e78fc4dbdfa0ca6", generator.generate("SHA-1", string));
    }

    @Test
    @DisplayName("Generate: Returns the SHA224 when successful")
    void generate_3() {
        assertEquals("d301812e62eec9b1e68c0b861e62f374e0d77e8365f5ddd6cccc8693", generator.generate("SHA-224", string));
    }

    @Test
    @DisplayName("Generate: Returns the SHA256 when successful")
    void generate_4() {
        assertEquals("ecf701f727d9e2d77c4aa49ac6fbbcc997278aca010bddeeb961c10cf54d435a", generator.generate("SHA-256", string));
    }

    @Test
    @DisplayName("Generate: Returns the SHA384 when successful")
    void generate_5() {
        assertEquals("ec8d147738b2e4bf6f5c5ac50a9a7593fb1ee2de01474d6f8a6c7fdb7ac945580772a5225a4c7251a7c0697acb7b8405", generator.generate("SHA-384", string));
    }

    @Test
    @DisplayName("Generate: Returns the SHA512 when successful")
    void generate_6() {
        assertEquals("f5408390735bf3ef0bb8aaf66eff4f8ca716093d2fec50996b479b3527e5112e3ea3b403e9e62c72155ac1e08a49b476f43ab621e1a5fc2bbb0559d8258a614d", generator.generate("SHA-512", string));
    }

    @Test
    @DisplayName("Generate: Throws 'NullPointerException' when algorithm is null")
    void generate_7() {
        assertThrows(NullPointerException.class, () -> generator.generate(null, string));
    }

    @Test
    @DisplayName("Generate: Throws 'NullPointerException' when bytes is null")
    void generate_8() {
        assertThrows(NullPointerException.class, () -> generator.generate("", null));
    }
}
