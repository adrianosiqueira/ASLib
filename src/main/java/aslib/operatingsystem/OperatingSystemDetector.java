package aslib.operatingsystem;

/**
 * <p style="text-align:justify">
 * Responsible to detect the operating system of the computer. It analyzes the
 * name from the system properties to determine it.
 * </p>
 *
 * <p style="text-align:justify">
 * If the name is not recognized, then it reports {@link OperatingSystem#UNKNOWN}.
 * </p>
 *
 * @author Adriano Siqueira
 * @version 1.0.0
 * @since 12.0.0
 */
class OperatingSystemDetector {

    /**
     * <p style="text-align:justify">
     * Creates an instance of {@link OperatingSystemDetector} class.
     * </p>
     *
     * @since 1.0.0
     */
    OperatingSystemDetector() {}


    /**
     * <p style="text-align:justify">
     * Detects the operating system of the computer.
     * </p>
     *
     * @return The operating system of the computer.
     *
     * @since 1.0.0
     */
    public OperatingSystem detect() {
        String name = retrieveOperatingSystemName();

        if (isBSD(name)) return OperatingSystem.BSD;
        if (isLinux(name)) return OperatingSystem.LINUX;
        if (isMacOS(name)) return OperatingSystem.MAC_OS;
        if (isSolaris(name)) return OperatingSystem.SOLARIS;
        if (isWindows(name)) return OperatingSystem.WINDOWS;

        return OperatingSystem.UNKNOWN;
    }

    /**
     * <p style="text-align:justify">
     * Checks if the name corresponds to the BSD.
     * </p>
     *
     * @param name Name that will be checked.
     *
     * @return TRUE if corresponds.
     */
    private boolean isBSD(String name) {
        return name.contains("bsd");
    }

    /**
     * <p style="text-align:justify">
     * Checks if the name corresponds to the Linux.
     * </p>
     *
     * @param name Name that will be checked.
     *
     * @return TRUE if corresponds.
     */
    private boolean isLinux(String name) {
        return name.contains("linux");
    }

    /**
     * <p style="text-align:justify">
     * Checks if the name corresponds to the MacOS.
     * </p>
     *
     * @param name Name that will be checked.
     *
     * @return TRUE if corresponds.
     */
    private boolean isMacOS(String name) {
        return name.contains("mac");
    }

    /**
     * <p style="text-align:justify">
     * Checks if the name corresponds to the Solaris.
     * </p>
     *
     * @param name Name that will be checked.
     *
     * @return TRUE if corresponds.
     */
    private boolean isSolaris(String name) {
        return name.contains("sun");
    }

    /**
     * <p style="text-align:justify">
     * Checks if the name corresponds to the Windows.
     * </p>
     *
     * @param name Name that will be checked.
     *
     * @return TRUE if corresponds.
     */
    private boolean isWindows(String name) {
        return name.contains("windows");
    }

    /**
     * <p style="text-align:justify">
     * Retrieves the name of the operating system through the system properties.
     * </p>
     *
     * @return The name of the operating system in lower case.
     */
    private String retrieveOperatingSystemName() {
        return System.getProperty("os.name")
                     .toLowerCase();
    }
}
