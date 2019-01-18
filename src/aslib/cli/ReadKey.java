package aslib.cli;

import java.util.Scanner;


/**
 * <p> Contains the function to get the readkey from console. </p>
 *
 * @author Adriano Siqueira
 */
public class ReadKey {

    /**
     * <p> Pauses the execution until the [ ENTER ] key is pressed. </p>
     *
     * @param scanner Object to catch the data input from console.
     * @deprecated Use readkey() instead.
     */
    @Deprecated
    public void readKey(Scanner scanner) {
        if (scanner.hasNextLine()) scanner.nextLine();
        scanner.nextLine();
    }

    /**
     * <p> Pauses the execution until the [ ENTER ] key is pressed. </p>
     */
    public static void readKey() {
        new Scanner(System.in).nextLine();
    }
}
