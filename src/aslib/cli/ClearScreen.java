package aslib.cli;

import java.io.IOException;

/**
 * <p> Contains the function to clear the screen when running in the console. </p>
 *
 * @author Adriano Siqueira
 */
public class ClearScreen {

    /**
     * <p> Runs the command according to operating system. </p>
     *
     * @throws IOException          If the ProcessBuilder fail to start the task.
     * @throws InterruptedException If the wait command is blocked by another process.
     */
    public static void clear() throws IOException, InterruptedException {
        final String os = System.getProperty("os.name").toLowerCase();
        final String command = os.contains("windows") ? "cls" : "clear";

        new ProcessBuilder(command).inheritIO().start().waitFor();
    }
}
