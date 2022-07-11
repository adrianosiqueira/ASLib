package aslib.operatingsystem;

/**
 * <p style="text-align:justify">
 * Represents the operating system.
 * </p>
 *
 * @author Adriano Siqueira
 * @version 1.0.0
 * @since 12.0.0
 */
public enum OperatingSystem {

    BSD, LINUX, MAC_OS, SOLARIS, UNKNOWN, WINDOWS;


    /**
     * <p style="text-align:justify">
     * Detects the operating system of the computer.
     * </p>
     *
     * @return The operating system of the computer.
     *
     * @see OperatingSystemDetector#detect()
     * @since 1.0.0
     */
    public static OperatingSystem detect() {
        return new OperatingSystemDetector().detect();
    }
}
