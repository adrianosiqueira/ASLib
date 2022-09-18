package aslib.ai.genderdetector;

/**
 * <p style="text-align:justify">
 * Defines the structure of the {@link Gender} detector classes.
 * </p>
 *
 * @author Adriano Siqueira
 * @version 1.0.0
 * @since 12.0.0
 */
public interface Detector {

    /**
     * <p style="text-align:justify">
     * Detects the gender through name analysis. If the name cannot be
     * determined, then {@link Gender#UNDEFINED} will be returned.
     * </p>
     *
     * @param name Name that will be analyzed.
     *
     * @return The gender of the name.
     *
     * @throws IllegalArgumentException If the name is null.
     * @since 1.0.0
     */
    Gender detect(String name)
    throws IllegalArgumentException;
}
