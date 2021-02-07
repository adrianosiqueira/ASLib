package aslib.os;

/**
 * <p> Contains the options that represent an Operating System. </p>
 *
 * @author Adriano Siqueira
 * @version 3.0.0
 * @since 6.1
 */
public enum OSType {
    LINUX,
    MACOS,
    WINDOWS;

    /**
     * <p> Attempts to detect the operating system automatically. </p>
     *
     * @return The detected OS.
     */
    public static OSType detect() {
        String os = System.getProperty("os.name")
                          .toLowerCase();

        if (os.contains("linux")) {
            return LINUX;
        } else if (os.contains("windows")) {
            return WINDOWS;
        } else {
            return MACOS;
        }
    }
}