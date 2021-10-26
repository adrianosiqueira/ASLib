package aslib.cli;

import aslib.os.OperatingSystemDetector;

import java.io.IOException;
import java.util.Optional;

/**
 * <p>Utility class for cleaning the console screen.</p>
 *
 * @author Adriano Siqueira
 * @version 2.0.0
 * @since 1.0.0
 */
public class ClearScreen {

    /**
     * <p>Detects the operating system and executes the appropriate command.</p>
     *
     * <p>If the operating system is not detected, the operation will be cancelled.</p>
     *
     * <p>If something goes wrong during the execution of the command, an exception
     * will be thrown without interfering with the normal execution of the program.</p>
     *
     * @since 1.0.0
     */
    public static void clear() {
        String command;

        switch (OperatingSystemDetector.detect()) {
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

        Optional.ofNullable(command)
                .ifPresent(cmd -> {
                    try {
                        new ProcessBuilder(command).inheritIO().start().waitFor();
                    } catch (InterruptedException | IOException e) {
                        e.printStackTrace();
                    }
                });
    }
}
