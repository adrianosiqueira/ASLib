package aslib.security.hash;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * <p style="text-align:justify">
 * Tests for the {@link HashChecksumGenerator} class.
 * </p>
 *
 * @author Adriano Siqueira
 * @version 1.0.0
 * @since 12.0.0
 */
@SuppressWarnings("SpellCheckingInspection")
class HashChecksumGeneratorTest {

    private static File   file;
    private static Path   path;
    private static String string;
    private static byte[] bytes;


    @BeforeAll
    static void createScenario()
    throws IOException {
        file   = File.createTempFile("abc_", "_abc");
        path   = Files.createTempFile(null, null);
        string = "hello world!\n";
        bytes  = string.getBytes();

        PrintStream stream = new PrintStream(file);
        stream.print(string);
        stream.close();

        Files.writeString(path, string);
    }

    @SuppressWarnings("ResultOfMethodCallIgnored")
    @AfterAll
    static void deleteScenario()
    throws IOException {
        file.delete();
        Files.deleteIfExists(path);
    }


    @Test
    @DisplayName("Generate: Returns the MD5 from bytes when successful")
    void generate_01() {
        assertEquals("c897d1410af8f2c74fba11b1db511e9e",
                     HashChecksumGenerator.md5().generate(bytes));
    }

    @Test
    @DisplayName("Generate: Returns the MD5 from file when successful")
    void generate_02() {
        assertEquals("c897d1410af8f2c74fba11b1db511e9e",
                     HashChecksumGenerator.md5().generate(file));
    }

    @Test
    @DisplayName("Generate: Returns the MD5 from path when successful")
    void generate_03() {
        assertEquals("c897d1410af8f2c74fba11b1db511e9e",
                     HashChecksumGenerator.md5().generate(path));
    }

    @Test
    @DisplayName("Generate: Returns the MD5 from string when successful")
    void generate_04() {
        assertEquals("c897d1410af8f2c74fba11b1db511e9e",
                     HashChecksumGenerator.md5().generate(string));
    }

    @Test
    @DisplayName("Generate: Returns the SHA1 from bytes when successful")
    void generate_05() {
        assertEquals("f951b101989b2c3b7471710b4e78fc4dbdfa0ca6",
                     HashChecksumGenerator.sha1().generate(bytes));
    }

    @Test
    @DisplayName("Generate: Returns the SHA1 from file when successful")
    void generate_06() {
        assertEquals("f951b101989b2c3b7471710b4e78fc4dbdfa0ca6",
                     HashChecksumGenerator.sha1().generate(file));
    }

    @Test
    @DisplayName("Generate: Returns the SHA1 from path when successful")
    void generate_07() {
        assertEquals("f951b101989b2c3b7471710b4e78fc4dbdfa0ca6",
                     HashChecksumGenerator.sha1().generate(path));
    }

    @Test
    @DisplayName("Generate: Returns the SHA1 from string when successful")
    void generate_08() {
        assertEquals("f951b101989b2c3b7471710b4e78fc4dbdfa0ca6",
                     HashChecksumGenerator.sha1().generate(string));
    }

    @Test
    @DisplayName("Generate: Returns the SHA224 from bytes when successful")
    void generate_09() {
        assertEquals("d301812e62eec9b1e68c0b861e62f374e0d77e8365f5ddd6cccc8693",
                     HashChecksumGenerator.sha224().generate(bytes));
    }

    @Test
    @DisplayName("Generate: Returns the SHA224 from file when successful")
    void generate_10() {
        assertEquals("d301812e62eec9b1e68c0b861e62f374e0d77e8365f5ddd6cccc8693",
                     HashChecksumGenerator.sha224().generate(file));
    }

    @Test
    @DisplayName("Generate: Returns the SHA224 from path when successful")
    void generate_11() {
        assertEquals("d301812e62eec9b1e68c0b861e62f374e0d77e8365f5ddd6cccc8693",
                     HashChecksumGenerator.sha224().generate(path));
    }

    @Test
    @DisplayName("Generate: Returns the SHA224 from string when successful")
    void generate_12() {
        assertEquals("d301812e62eec9b1e68c0b861e62f374e0d77e8365f5ddd6cccc8693",
                     HashChecksumGenerator.sha224().generate(string));
    }

    @Test
    @DisplayName("Generate: Returns the SHA256 from bytes when successful")
    void generate_13() {
        assertEquals("ecf701f727d9e2d77c4aa49ac6fbbcc997278aca010bddeeb961c10cf54d435a",
                     HashChecksumGenerator.sha256().generate(bytes));
    }

    @Test
    @DisplayName("Generate: Returns the SHA256 from file when successful")
    void generate_14() {
        assertEquals("ecf701f727d9e2d77c4aa49ac6fbbcc997278aca010bddeeb961c10cf54d435a",
                     HashChecksumGenerator.sha256().generate(file));
    }

    @Test
    @DisplayName("Generate: Returns the SHA256 from path when successful")
    void generate_15() {
        assertEquals("ecf701f727d9e2d77c4aa49ac6fbbcc997278aca010bddeeb961c10cf54d435a",
                     HashChecksumGenerator.sha256().generate(path));
    }

    @Test
    @DisplayName("Generate: Returns the SHA256 from string when successful")
    void generate_16() {
        assertEquals("ecf701f727d9e2d77c4aa49ac6fbbcc997278aca010bddeeb961c10cf54d435a",
                     HashChecksumGenerator.sha256().generate(string));
    }

    @Test
    @DisplayName("Generate: Returns the SHA384 from bytes when successful")
    void generate_17() {
        assertEquals("ec8d147738b2e4bf6f5c5ac50a9a7593fb1ee2de01474d6f8a6c7fdb7ac945580772a5225a4c7251a7c0697acb7b8405",
                     HashChecksumGenerator.sha384().generate(bytes));
    }

    @Test
    @DisplayName("Generate: Returns the SHA384 from file when successful")
    void generate_18() {
        assertEquals("ec8d147738b2e4bf6f5c5ac50a9a7593fb1ee2de01474d6f8a6c7fdb7ac945580772a5225a4c7251a7c0697acb7b8405",
                     HashChecksumGenerator.sha384().generate(file));
    }

    @Test
    @DisplayName("Generate: Returns the SHA384 from path when successful")
    void generate_19() {
        assertEquals("ec8d147738b2e4bf6f5c5ac50a9a7593fb1ee2de01474d6f8a6c7fdb7ac945580772a5225a4c7251a7c0697acb7b8405",
                     HashChecksumGenerator.sha384().generate(path));
    }

    @Test
    @DisplayName("Generate: Returns the SHA384 from string when successful")
    void generate_20() {
        assertEquals("ec8d147738b2e4bf6f5c5ac50a9a7593fb1ee2de01474d6f8a6c7fdb7ac945580772a5225a4c7251a7c0697acb7b8405",
                     HashChecksumGenerator.sha384().generate(string));
    }

    @Test
    @DisplayName("Generate: Returns the SHA512 from bytes when successful")
    void generate_21() {
        assertEquals("f5408390735bf3ef0bb8aaf66eff4f8ca716093d2fec50996b479b3527e5112e3ea3b403e9e62c72155ac1e08a49b476f43ab621e1a5fc2bbb0559d8258a614d",
                     HashChecksumGenerator.sha512().generate(bytes));
    }

    @Test
    @DisplayName("Generate: Returns the SHA512 from file when successful")
    void generate_22() {
        assertEquals("f5408390735bf3ef0bb8aaf66eff4f8ca716093d2fec50996b479b3527e5112e3ea3b403e9e62c72155ac1e08a49b476f43ab621e1a5fc2bbb0559d8258a614d",
                     HashChecksumGenerator.sha512().generate(file));
    }

    @Test
    @DisplayName("Generate: Returns the SHA512 from path when successful")
    void generate_23() {
        assertEquals("f5408390735bf3ef0bb8aaf66eff4f8ca716093d2fec50996b479b3527e5112e3ea3b403e9e62c72155ac1e08a49b476f43ab621e1a5fc2bbb0559d8258a614d",
                     HashChecksumGenerator.sha512().generate(path));
    }

    @Test
    @DisplayName("Generate: Returns the SHA512 from string when successful")
    void generate_24() {
        assertEquals("f5408390735bf3ef0bb8aaf66eff4f8ca716093d2fec50996b479b3527e5112e3ea3b403e9e62c72155ac1e08a49b476f43ab621e1a5fc2bbb0559d8258a614d",
                     HashChecksumGenerator.sha512().generate(string));
    }


    @Test
    @DisplayName("GetByLength: Detects MD5 when successful")
    void getByLength_1() {
        assertEquals("c897d1410af8f2c74fba11b1db511e9e",
                     HashChecksumGenerator.getByLength(32).generate(string));
    }

    @Test
    @DisplayName("GetByLength: Detects SHA1 when successful")
    void getByLength_2() {
        assertEquals("f951b101989b2c3b7471710b4e78fc4dbdfa0ca6",
                     HashChecksumGenerator.getByLength(40).generate(string));
    }

    @Test
    @DisplayName("GetByLength: Detects SHA224 when successful")
    void getByLength_3() {
        assertEquals("d301812e62eec9b1e68c0b861e62f374e0d77e8365f5ddd6cccc8693",
                     HashChecksumGenerator.getByLength(56).generate(string));
    }

    @Test
    @DisplayName("GetByLength: Detects SHA256 when successful")
    void getByLength_4() {
        assertEquals("ecf701f727d9e2d77c4aa49ac6fbbcc997278aca010bddeeb961c10cf54d435a",
                     HashChecksumGenerator.getByLength(64).generate(string));
    }

    @Test
    @DisplayName("GetByLength: Detects SHA384 when successful")
    void getByLength_5() {
        assertEquals("ec8d147738b2e4bf6f5c5ac50a9a7593fb1ee2de01474d6f8a6c7fdb7ac945580772a5225a4c7251a7c0697acb7b8405",
                     HashChecksumGenerator.getByLength(96).generate(string));
    }

    @Test
    @DisplayName("GetByLength: Detects SHA512 when successful")
    void getByLength_6() {
        assertEquals("f5408390735bf3ef0bb8aaf66eff4f8ca716093d2fec50996b479b3527e5112e3ea3b403e9e62c72155ac1e08a49b476f43ab621e1a5fc2bbb0559d8258a614d",
                     HashChecksumGenerator.getByLength(128).generate(string));
    }

    @Test
    @DisplayName("GetByLength: Throws 'AlgorithmNotFoundException' when algorithm is not found")
    void getByLength_7() {
        assertThrows(AlgorithmNotFoundException.class,
                     () -> HashChecksumGenerator.getByLength(0).generate(string));
    }
}
