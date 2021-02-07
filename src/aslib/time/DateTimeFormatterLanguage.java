package aslib.time;

import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * <p> Contains a set of valid formats according to certain languages.
 * Used together with {@link DateParser} class. </p>
 *
 * @author Adriano Siqueira
 * @version 1.0.1
 * @since 8.0.0
 */
public enum DateTimeFormatterLanguage {

    ENGLISH(
            DateTimeFormatter.ofPattern("M/d/uu"),
            DateTimeFormatter.ofPattern("M/d/uuuu"),
            DateTimeFormatter.ofPattern("MM/d/uu"),
            DateTimeFormatter.ofPattern("MM/d/uuuu"),
            DateTimeFormatter.ofPattern("MMM/d/uu"),
            DateTimeFormatter.ofPattern("MMM/d/uuuu"),
            DateTimeFormatter.ofPattern("MMMM/d/uu"),
            DateTimeFormatter.ofPattern("MMMM/d/uuuu"),
            DateTimeFormatter.ofPattern("M/dd/uu"),
            DateTimeFormatter.ofPattern("M/dd/uuuu"),
            DateTimeFormatter.ofPattern("MM/dd/uu"),
            DateTimeFormatter.ofPattern("MM/dd/uuuu"),
            DateTimeFormatter.ofPattern("MMM/dd/uu"),
            DateTimeFormatter.ofPattern("MMM/dd/uuuu"),
            DateTimeFormatter.ofPattern("MMMM/dd/uu"),
            DateTimeFormatter.ofPattern("MMMM/dd/uuuu")
    ),

    PORTUGUESE(
            DateTimeFormatter.ofPattern("d/M/uu"),
            DateTimeFormatter.ofPattern("d/M/uuuu"),
            DateTimeFormatter.ofPattern("d/MM/uu"),
            DateTimeFormatter.ofPattern("d/MM/uuuu"),
            DateTimeFormatter.ofPattern("d/MMM/uu"),
            DateTimeFormatter.ofPattern("d/MMM/uuuu"),
            DateTimeFormatter.ofPattern("d/MMMM/uu"),
            DateTimeFormatter.ofPattern("d/MMMM/uuuu"),
            DateTimeFormatter.ofPattern("dd/M/uu"),
            DateTimeFormatter.ofPattern("dd/M/uuuu"),
            DateTimeFormatter.ofPattern("dd/MM/uu"),
            DateTimeFormatter.ofPattern("dd/MM/uuuu"),
            DateTimeFormatter.ofPattern("dd/MMM/uu"),
            DateTimeFormatter.ofPattern("dd/MMM/uuuu"),
            DateTimeFormatter.ofPattern("dd/MMMM/uu"),
            DateTimeFormatter.ofPattern("dd/MMMM/uuuu")
    );

    private final DateTimeFormatter[] formatters;

    DateTimeFormatterLanguage(DateTimeFormatter... formatters) {
        this.formatters = formatters;
    }

    /**
     * <p> Attempts to get the option for the provided locale's language. If the
     * locale if null, or the language is null or empty, then it returns ENGLISH,
     * otherwise it will return the appropriate option. </p>
     *
     * @param locale Locale to get the language.
     *
     * @return An option that better fits the language.
     *
     * @since 1.0.0
     */
    public static DateTimeFormatterLanguage fromLocale(Locale locale) {
        if (locale == null ||
            locale.getLanguage() == null ||
            locale.getLanguage().isEmpty()) {
            return ENGLISH;
        }

        switch (locale.getLanguage()) {
            case "pt":
                return PORTUGUESE;
            case "en":
            default:
                return ENGLISH;
        }
    }

    /**
     * <p> Gets the formatters for the language. </p>
     *
     * @return The formatters of the enum option.
     */
    public DateTimeFormatter[] getFormatters() {
        return formatters;
    }
}