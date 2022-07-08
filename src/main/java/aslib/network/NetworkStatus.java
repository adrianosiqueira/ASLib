package aslib.network;

/**
 * <p style="text-align:justify">
 * Represents the status of the computer's network connection.
 * </p>
 *
 * @author Adriano Siqueira
 * @version 1.0.0
 * @since 12.0.0
 */
public enum NetworkStatus {

    OFFLINE, ONLINE;

    /**
     * <p style="text-align:justify">
     * Checks the status of the network.
     * </p>
     *
     * @return The status of the network.
     *
     * @see NetworkStatusChecker#check()
     * @since 1.0.0
     */
    public static NetworkStatus check() {
        return new NetworkStatusChecker().check();
    }
}
