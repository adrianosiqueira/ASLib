package aslib.about;

/**
 * <p> Show info about the aslib. </p>
 *
 * @author Adriano Siqueira
 */
public class About {
    public static final String VERSION = "5.1";
    public static final String DATE = "18/jan/2019";

    /**
     * <p> Show info about the aslib. </p>
     */
    public static void show() {
        System.out.println("Library");
        System.out.println("Version: " + VERSION);
        System.out.println("Date: " + DATE);
    }
}