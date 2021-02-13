package aslib.filemanager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

/**
 * <p> Handles all file read operations. </p>
 *
 * @author Adriano Siqueira
 * @version 3.0.0
 * @since 6.1.0
 */
public class FileReader {

    /**
     * <p> Creates an instance of {@link FileReader}. </p>
     *
     * @since 1.0.0
     */
    public FileReader() {
    }

    /**
     * <p> Reads the entire contents of the file. </p>
     *
     * <p> This method returns an Optional containing the contents of the file.
     * If the file is null or does not exist, an empty Optional is returned. </p>
     *
     * @param file File to read.
     *
     * @return An Optional containing the contents of the file.
     *
     * @since 3.0.0
     */
    public Optional<String> read(File file) {
        return file != null
               ? read(file.toPath())
               : Optional.empty();
    }

    /**
     * <p> Reads the entire contents of the path. </p>
     *
     * <p> This method returns an Optional containing the contents of the path.
     * If the path is null or does not exist, an empty Optional is returned. </p>
     *
     * @param path Path to read.
     *
     * @return An Optional containing the contents of the path.
     *
     * @since 3.0.0
     */
    public Optional<String> read(Path path) {
        Optional<List<String>> optional = this.readLines(path);

        if (optional.isPresent()) {
            StringBuilder builder = new StringBuilder();

            List<String> list = optional.get();
            list.forEach(line -> builder.append(line)
                                        .append(System.lineSeparator()));

            return Optional.of(builder.toString());
        } else {
            return Optional.empty();
        }
    }

    /**
     * <p> Reads the entire contents of the file. </p>
     *
     * <p> This method returns an Optional containing a list of lines of the file.
     * If the file is null or does not exist, an empty Optional is returned. </p>
     *
     * @param file File to read.
     *
     * @return An Optional containing a list of lines of the file.
     *
     * @since 3.0.0
     */
    public Optional<List<String>> readLines(File file) {
        return file != null
               ? readLines(file.toPath())
               : Optional.empty();
    }

    /**
     * <p> Reads the entire contents of the path. </p>
     *
     * <p> This method returns an Optional containing a list of lines of the path.
     * If the path is null or does not exist, an empty Optional is returned. </p>
     *
     * @param path Path to read.
     *
     * @return An Optional containing a list of lines of the path.
     *
     * @since 3.0.0
     */
    public Optional<List<String>> readLines(Path path) {
        if (path == null || Files.notExists(path)) {
            return Optional.empty();
        }

        List<String> list = null;

        try {
            list = Files.readAllLines(path);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Optional.ofNullable(list);
    }
}