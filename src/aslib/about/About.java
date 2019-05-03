package aslib.about;

/**
 * <p> Show info about the aslib. </p>
 *
 * @author Adriano Siqueira
 * @version 2019-05-03
 * @since 4.2
 */
public class About {
    public static final String VERSION = "6.1";
    public static final String DATE = "03/may/2019";

    /**
     * <p> Show info about the aslib. </p>
     */
    public static void show() {
        System.out.println("       AS Lib");
        System.out.println("Version: " + VERSION);
        System.out.println("   Date: " + DATE);
    }
}