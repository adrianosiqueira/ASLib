package library.about;

/**
 * <p> Show info about the library. </p>
 *
 * @author Adriano Siqueira
 */
public class About {
    public static final String VERSION = "5.0";
    public static final String DATE = "13/dec/2018";

    /**
     * <p> Show info about the library. </p>
     */
    public static void show() {
        System.out.println("Library");
        System.out.println("Version: " + VERSION);
        System.out.println("Date: " + DATE);
    }
}