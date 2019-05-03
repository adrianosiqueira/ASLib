package aslib.net;

import aslib.exceptions.InvalidEnumSearchArgumentException;

/**
 * <p> Contains the options to represent the statuses of a connection. </p>
 *
 * @author Adriano Siqueira
 * @version 2019-05-03
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
     * @return The option of enum that status matches the argument.
     * @throws InvalidEnumSearchArgumentException If the status code does not exists.
     */
    public static ConnectionStatus getByStatus(int status) throws InvalidEnumSearchArgumentException {
        for (ConnectionStatus value : values())
            if (value.status == status)
                return value;

        throw new InvalidEnumSearchArgumentException("The status code does not exists.");
    }
}
