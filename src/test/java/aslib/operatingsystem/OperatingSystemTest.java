package aslib.operatingsystem;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * <p>
 * Tests for the {@link OperatingSystem} class.
 * </p>
 *
 * @author Adriano Siqueira
 * @version 1.0.0
 * @since 12.0.0
 */
class OperatingSystemTest {

    @Test
    @DisplayName("Detect: Returns the operating system when successful")
    void detect_1() {
        Assertions.assertNotNull(OperatingSystem.detect());
    }
}
