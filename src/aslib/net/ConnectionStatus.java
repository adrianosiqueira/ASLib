package aslib.net;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

/**
 * <p> Contains the options to represent the statuses of an internet connection. </p>
 *
 * @author Adriano Siqueira
 * @version 3.0.0
 * @since 6.1
 */
public enum ConnectionStatus {

    /**
     * Indicates that the machine has no internet connection.
     */
    OFFLINE,

    /**
     * Indicates that the machine has an internet connection.
     */
    ONLINE;

    /**
     * <p> Automatically checks the internet connection. </p>
     *
     * <p> This method will attempt to connect with up to five different URLs.
     * If one is successful, then it returns ONLINE. If all fails, then it
     * returns OFFLINE. </p>
     *
     * <h2><b> URLs in order </b></h2>
     *
     * <ol>
     *     <li> https://goole.com </li>
     *     <li> https://facebook.com </li>
     *     <li> https://instagram.com </li>
     *     <li> https://microsoft.com </li>
     *     <li> https://ubuntu.com </li>
     * </ol>
     *
     * @return The status of the internet connection.
     */
    public static ConnectionStatus checkConnection() {
        List<URL> list = new ArrayList<>();

        try {
            list.add(new URL("https://google.com"));
            list.add(new URL("https://facebook.com"));
            list.add(new URL("https://instagram.com"));
            list.add(new URL("https://microsoft.com"));
            list.add(new URL("https://ubuntu.com"));
        } catch (MalformedURLException ignored) {
        }

        for (URL url : list) {
            try {
                URLConnection connection = url.openConnection();
                connection.connect();
                return ONLINE;
            } catch (IOException ignored) {
            }
        }

        return OFFLINE;
    }
}