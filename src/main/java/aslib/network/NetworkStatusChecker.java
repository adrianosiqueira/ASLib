package aslib.network;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Collections;
import java.util.List;

/**
 * <p style="text-align:justify">
 * Responsible to check the network status of the computer. It attempts to
 * connect to five URLs, if one is successful then it reports the
 * {@link NetworkStatus#ONLINE} status.
 * </p>
 *
 * @author Adriano Siqueira
 * @version 1.0.0
 * @since 12.0.0
 */
class NetworkStatusChecker {

    /**
     * <p style="text-align:justify">
     * Creates an instance of {@link NetworkStatusChecker} class.
     * </p>
     *
     * @since 1.0.0
     */
    NetworkStatusChecker() {}


    /**
     * <p style="text-align:justify">
     * Checks the network status of the computer.
     * </p>
     *
     * @return The status of the computer.
     *
     * @since 1.0.0
     */
    public NetworkStatus check() {
        boolean anyOnline = createURLList().stream()
                                           .map(this::getURLStatus)
                                           .anyMatch(this::statusIsOnline);

        return anyOnline
               ? NetworkStatus.ONLINE
               : NetworkStatus.OFFLINE;
    }


    /**
     * <p style="text-align:justify">
     * Creates a list with the URLs that will be used to check the connection.
     * </p>
     *
     * @return A list of URLs.
     *
     * @since 1.0.0
     */
    private List<URL> createURLList() {
        try {
            return List.of(new URL("https://facebook.com"),
                           new URL("https://github.com"),
                           new URL("https://google.com"),
                           new URL("https://microsoft.com"),
                           new URL("https://ubuntu.com"));
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    /**
     * <p style="text-align:justify">
     * Connects to the provided URL and returns its status.
     * </p>
     *
     * @param url URL where will be connected.
     *
     * @return The status of the URL.
     *
     * @since 1.0.0
     */
    private NetworkStatus getURLStatus(URL url) {
        try {
            URLConnection connection = url.openConnection();
            connection.setConnectTimeout(3000);
            connection.connect();

            return NetworkStatus.ONLINE;
        } catch (IOException ignored) {
            /*
             * This exception will be thrown due a connection failure with the
             * url, indicating an offline status.
             *
             * Because that, it is safe to ignore this exception because we
             * will process that status later.
             */
            return NetworkStatus.OFFLINE;
        }
    }

    /**
     * <p style="text-align:justify">
     * Checks if the provided status is online.
     * </p>
     *
     * @param status Status that will be checked.
     *
     * @return TRUE if it is online.
     *
     * @since 1.0.0
     */
    private boolean statusIsOnline(NetworkStatus status) {
        return status == NetworkStatus.ONLINE;
    }
}
