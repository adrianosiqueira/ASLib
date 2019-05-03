package aslib.cli;

import aslib.os.OSType;

import java.io.IOException;

/**
 * <p> Contains the function to clear the screen when running in the console. </p>
 *
 * @author Adriano Siqueira
 * @version 2019-05-03
 * @since 1.0
 */
public class ClearScreen {

    /**
     * <p> Runs the command according to operating system. </p>
     *
     * @throws IOException          If the ProcessBuilder fail to start the task.
     * @throws InterruptedException If the wait command is blocked by another process.
     */
    public static void clear() throws IOException, InterruptedException {
        String command;

        switch (OSType.detect()) {
            case LINUX:
            case MACOS:
                command = "clear";
                break;
            case WINDOWS:
                command = "cls";
                break;
            default:
                command = null;
                break;
        }

        if (command != null)
            new ProcessBuilder(command).inheritIO().start().waitFor();
    }
}
