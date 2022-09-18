package aslib.network;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * <p>
 * Tests for the {@link NetworkStatus} class.
 * </p>
 *
 * @author Adriano Siqueira
 * @version 1.0.0
 * @since 12.0.0
 */
class NetworkStatusTest {

    @Test
    @DisplayName("Check: Returns the network status when successful")
    void check_1() {
        Assertions.assertNotNull(NetworkStatus.check());
    }
}
