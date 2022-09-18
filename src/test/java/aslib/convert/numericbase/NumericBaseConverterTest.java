package aslib.convert.numericbase;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * <p style="text-align:justify">
 * Tests for the {@link NumericBaseConverter} class.
 * </p>
 *
 * @author Adriano Siqueira
 * @version 1.0.0
 * @since 12.0.0
 */
class NumericBaseConverterTest {

    @Test
    @DisplayName("Base 16: Returns instance of 'Base16Converter' when successful")
    void base16() {
        Assertions.assertInstanceOf(Base16Converter.class, NumericBaseConverter.base16());
    }

    @Test
    @DisplayName("Base 2: Returns instance of 'Base2Converter' when successful")
    void base2() {
        Assertions.assertInstanceOf(Base2Converter.class, NumericBaseConverter.base2());
    }

    @Test
    @DisplayName("Base 36: Returns instance of 'Base36Converter' when successful")
    void base36() {
        Assertions.assertInstanceOf(Base36Converter.class, NumericBaseConverter.base36());
    }

    @Test
    @DisplayName("Base 8: Returns instance of 'Base8Converter' when successful")
    void base8() {
        Assertions.assertInstanceOf(Base8Converter.class, NumericBaseConverter.base8());
    }
}
