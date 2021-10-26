package aslib.net;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Class designed to check the machine's internet connection status.</p>
 *
 * @author Adriano Siqueira
 * @version 1.0.0
 * @since 11.0.0
 */
public class ConnectionChecker {

    /**
     * <p> Automatically checks the internet connection. </p>
     *
     * <p> This method will attempt to connect with up to five different URLs.
     * If one is successful, then it returns {@link ConnectionStatus#ONLINE}.
     * If all fails, then it returns {@link ConnectionStatus#OFFLINE}. </p>
     *
     * <p> Each URL has 3 seconds to respond before failing. </p>
     *
     * <h2><b> URLs in order </b></h2>
     *
     * <ol>
     *     <li> https://google.com </li>
     *     <li> https://facebook.com </li>
     *     <li> https://instagram.com </li>
     *     <li> https://microsoft.com </li>
     *     <li> https://ubuntu.com </li>
     * </ol>
     *
     * @return The status of the internet connection.
     *
     * @since 1.0.0
     */
    public static ConnectionStatus check() {
        List<URL> urls = new ArrayList<>();

        try {
            urls.add(new URL("https://google.com"));
            urls.add(new URL("https://facebook.com"));
            urls.add(new URL("https://instagram.com"));
            urls.add(new URL("https://microsoft.com"));
            urls.add(new URL("https://ubuntu.com"));
        } catch (MalformedURLException exception) {
            exception.printStackTrace();
        }

        for (URL url : urls) {
            try {
                URLConnection connection = url.openConnection();
                connection.setConnectTimeout(3000);
                connection.connect();
                return ConnectionStatus.ONLINE;
            } catch (IOException ignored) {
            }
        }

        return ConnectionStatus.OFFLINE;
    }
}
