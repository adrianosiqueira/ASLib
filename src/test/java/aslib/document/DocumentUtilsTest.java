package aslib.document;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * <p style="text-align:justify">
 * Tests for the {@link DocumentUtils} class.
 * </p>
 *
 * @author Adriano Siqueira
 * @version 1.0.0
 * @since 12.0.0
 */
class DocumentUtilsTest {

    private final DocumentUtils documentUtils = new DocumentUtils(5, 1);


    @Test
    @DisplayName("ExtractDigits: Returns list of integer when successful")
    void extractDigits_0() {
        assertEquals(List.of(1, 2, 3), documentUtils.extractDigits("123abc"));
    }

    @Test
    @DisplayName("ExtractDigits: Returns empty list when there is no valid digits")
    void extractDigits_1() {
        List<Integer> list = documentUtils.extractDigits("abc");

        assertEquals(0, list.size());
        assertEquals(Collections.emptyList(), list);
    }

    @Test
    @DisplayName("ExtractDigits: Throws 'NullPointerException' when value is null")
    void extractDigits_2() {
        assertThrows(NullPointerException.class, () -> documentUtils.extractDigits(null));
    }


    @Test
    @DisplayName("ExtractVerificationDigits: Returns list of integer when successful")
    void extractVerificationDigits_0() {
        assertEquals(List.of(3), documentUtils.extractVerificationDigits(List.of(1, 2, 3)));
    }

    @Test
    @DisplayName("ExtractVerificationDigits: Throws 'IndexOutOfBoundsException' when value has not enough size")
    void extractVerificationDigits_1() {
        assertThrows(IndexOutOfBoundsException.class, () -> documentUtils.extractVerificationDigits(Collections.emptyList()));
    }

    @Test
    @DisplayName("ExtractVerificationDigits: Throws 'NullPointerException' when value is null")
    @SuppressWarnings("ConstantConditions")
    void extractVerificationDigits_2() {
        assertThrows(NullPointerException.class, () -> documentUtils.extractVerificationDigits(null));
    }


    @Test
    @DisplayName("GenerateRandomDigits: Returns list of integer when successful")
    void generateRandomDigits_0() {
        assertEquals(10, documentUtils.generateRandomDigits(10).size());
    }

    @Test
    @DisplayName("generateRandomDigits: Returns empty list when value is '0'")
    void generateRandomDigits_1() {
        List<Integer> list = documentUtils.generateRandomDigits(0);

        assertEquals(0, list.size());
        assertEquals(Collections.emptyList(), list);
    }

    @Test
    @DisplayName("generateRandomDigits: Throws 'IllegalArgumentException' when value is negative")
    void generateRandomDigits_2() {
        assertThrows(IllegalArgumentException.class, () -> documentUtils.generateRandomDigits(-1));
    }


    @Test
    @DisplayName("InsertLeadingZeros: Returns '01111' when value is '1111'")
    void insertLeadingZeros_0() {
        assertEquals("01111", documentUtils.insertLeadingZeros("1111"));
    }

    @Test
    @DisplayName("insertLeadingZeros: Returns '11111' when value is '11111'")
    void insertLeadingZeros_1() {
        assertEquals("11111", documentUtils.insertLeadingZeros("11111"));
    }

    @Test
    @DisplayName("insertLeadingZeros: Returns '111111' when value is '111111'")
    void insertLeadingZeros_2() {
        assertEquals("111111", documentUtils.insertLeadingZeros("111111"));
    }


    @Test
    @DisplayName("JoinDigits: Returns string containing the digits when successful")
    void joinDigits_0() {
        assertEquals("111", documentUtils.joinDigits(List.of(1, 1, 1)));
    }

    @Test
    @DisplayName("JoinDigits: Returns empty list when value is empty")
    void joinDigits_1() {
        assertEquals("", documentUtils.joinDigits(Collections.emptyList()));
    }

    @Test
    @DisplayName("JoinDigits: Throws 'NullPointerException' when value is null")
    @SuppressWarnings("ConstantConditions")
    void joinDigits_2() {
        assertThrows(NullPointerException.class, () -> documentUtils.joinDigits(null));
    }


    @Test
    @DisplayName("RemoveNonDigits: Returns '111' when value is '111abc'")
    void removeNonDigits_0() {
        assertEquals("111", documentUtils.removeNonDigits("111abc"));
    }

    @Test
    @DisplayName("RemoveNonDigits: Returns '' when value is 'abc'")
    void removeNonDigits_1() {
        assertEquals("", documentUtils.removeNonDigits("abc"));
    }

    @Test
    @DisplayName("RemoveNonDigits: Throws 'NullPointerException' when value is null")
    @SuppressWarnings("ConstantConditions")
    void removeNonDigits_2() {
        assertThrows(NullPointerException.class, () -> documentUtils.removeNonDigits(null));
    }


    @Test
    @DisplayName("RemoveTrailingDigits: Returns '11111' when value is '11111'")
    void removeTrailingDigits_0() {
        assertEquals("11111", documentUtils.removeTrailingDigits("11111"));
    }

    @Test
    @DisplayName("RemoveTrailingDigits: Returns '111' when value is '111'")
    void removeTrailingDigits_1() {
        assertEquals("111", documentUtils.removeTrailingDigits("111"));
    }

    @Test
    @DisplayName("RemoveTrailingDigits: Returns '11111' when value is '111111'")
    void removeTrailingDigits_2() {
        assertEquals("11111", documentUtils.removeTrailingDigits("111111"));
    }

    @Test
    @DisplayName("RemoveTrailingDigits: Throws 'NullPointerException' when value is null")
    @SuppressWarnings("ConstantConditions")
    void removeTrailingDigits_3() {
        assertThrows(NullPointerException.class, () -> documentUtils.removeTrailingDigits(null));
    }


    @Test
    @DisplayName("RemoveVerificationDigits: Returns list of integer when successful")
    void removeVerificationDigits_0() {
        assertEquals(List.of(1, 2, 3, 4), documentUtils.removeVerificationDigits(List.of(1, 2, 3, 4, 5)));
    }

    @Test
    @DisplayName("RemoveVerificationDigits: Returns empty list when value has not enough size")
    void removeVerificationDigits_1() {
        List<Integer> list = documentUtils.removeVerificationDigits(List.of(1));

        assertEquals(0, list.size());
        assertEquals(Collections.emptyList(), list);
    }

    @Test
    @DisplayName("RemoveVerificationDigits: Throws 'IllegalArgumentException' when digits size is less than the verification digits count")
    void removeVerificationDigits_2() {
        assertThrows(IllegalArgumentException.class, () -> documentUtils.removeVerificationDigits(Collections.emptyList()));
    }

    @Test
    @DisplayName("RemoveVerificationDigits: Throws 'NullPointerException' when value is null")
    @SuppressWarnings("ConstantConditions")
    void removeVerificationDigits_3() {
        assertThrows(NullPointerException.class, () -> documentUtils.removeVerificationDigits(null));
    }
}
