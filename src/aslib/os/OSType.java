package aslib.os;

/**
 * <p> Contains the OS options. </p>
 *
 * @author Adriano Siqueira
 * @version 2019-05-03
 * @since 6.1
 */
public enum OSType {
    LINUX,
    MACOS,
    WINDOWS;

    /**
     * <p> Detect the OS automatically. </p>
     *
     * @return The detected option.
     */
    public static OSType detect() {
        String os = System.getProperty("os.name").toLowerCase();

        if (os.contains("linux"))
            return LINUX;
        else if (os.contains("windows"))
            return WINDOWS;
        else
            return MACOS;
    }
}
