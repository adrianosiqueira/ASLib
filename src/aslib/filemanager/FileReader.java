package aslib.filemanager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

/**
 * <p> Handles all file read operations. </p>
 *
 * @author Adriano Siqueira
 * @version 2.0.0
 * @since 6.1.0
 */
public class FileReader {

    /**
     * <p> Creates a {@link FileReader} instance. </p>
     *
     * @since 1.0.0
     */
    public FileReader() {
    }

    /**
     * <p> Reads the content of the file. </p>
     *
     * @param file Where the content will be read from.
     *
     * @return The content of the file in a string format.
     *
     * @since 2.0.0
     */
    public String read(File file) {
        return read(file.toPath());
    }

    /**
     * <p> Reads the content of the file. </p>
     *
     * @param path Where the content will be read from.
     *
     * @return The content of the file in a string format.
     *
     * @since 2.0.0
     */
    public String read(Path path) {
        try {
            List<String> lines = Files.readAllLines(path);
            StringBuilder builder = new StringBuilder();

            for (String line : lines) {
                builder.append(line)
                        .append(System.lineSeparator());
            }

            return builder.toString();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * <p> Reads the content of the file. </p>
     *
     * @param file Where the content will be read from.
     *
     * @return A list with each item being a line from the file.
     *
     * @since 2.0.0
     */
    public List<String> readLines(File file) {
        return readLines(file.toPath());
    }

    /**
     * <p> Reads the content of the file. </p>
     *
     * @param path Where the content will be read from.
     *
     * @return A list with each item being a line from the file.
     *
     * @since 2.0.0
     */
    public List<String> readLines(Path path) {
        try {
            return Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
