package aslib.os;

/**
 * <p>Class designed to detect the machine's operating system.</p>
 *
 * @author Adriano Siqueira
 * @version 1.0.0
 * @since 11.0.0
 */
public class OperatingSystemDetector {

    /**
     * <p>Attempts to detect the operating system by reading the corresponding
     * JVM property.</p>
     *
     * @return The detected OS.
     */
    public static OperatingSystem detect() {
        String os = System.getProperty("os.name")
                          .toLowerCase();

        if (os.contains("linux")) {
            return OperatingSystem.LINUX;
        } else if (os.contains("windows")) {
            return OperatingSystem.WINDOWS;
        } else {
            return OperatingSystem.MACOS;
        }
    }
}
