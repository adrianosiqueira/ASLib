package aslib.net;

import aslib.exceptions.InvalidEnumSearchArgumentException;

import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

/**
 * <p> Contains the options to represent the statuses of a connection. </p>
 *
 * <h2> Codes </h2>
 * <table>
 *     <tr>
 *         <th> Status </th>
 *         <th> Code </th>
 *     </tr>
 *     <tr>
 *         <td> Invalid </td>
 *         <td> -1 </td>
 *     </tr>
 *     <tr>
 *         <td> Online </td>
 *         <td> 0 </td>
 *     </tr>
 *     <tr>
 *         <td> Offline </td>
 *         <td> 1 </td>
 *     </tr>
 * </table>
 *
 * @author Adriano Siqueira
 * @version 2019-07-12
 * @since 6.1
 */
public enum ConnectionStatus {
    INVALID(-1),
    ONLINE(0),
    OFFLINE(1);

    public final int status;

    ConnectionStatus(int status) {
        this.status = status;
    }

    /**
     * <p> Searches the option of enum that its status code matches the parameter. </p>
     *
     * @param status Status code to searched for.
     *
     * @return The option of enum that status matches the argument.
     *
     * @throws InvalidEnumSearchArgumentException If the status code does not exists.
     */
    public static ConnectionStatus getByStatus(int status) throws InvalidEnumSearchArgumentException {
        for (ConnectionStatus value : values())
            if (value.status == status)
                return value;

        throw new InvalidEnumSearchArgumentException("The status code does not exists.");
    }

    /**
     * <p> Automatically checks the internet connection. </p>
     *
     * @return The status of the internet connection.
     */
    public static ConnectionStatus checkConnection() {
        ConnectionStatus status;

        try {
            URL url = new URL("https://www.google.com");
            URLConnection connection = url.openConnection();
            connection.setConnectTimeout(250);
            connection.connect();
            status = ConnectionStatus.ONLINE;
        } catch (IOException e) {
            status = OFFLINE;
        }

        return status;
    }
}