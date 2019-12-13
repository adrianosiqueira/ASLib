package aslib.time;

import aslib.exceptions.InvalidEnumSearchArgumentException;

import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * <p> Contains a set of valid formats according to certain languages.
 * Used together with {@link DateParser} class. </p>
 *
 * @author Adriano Siqueira
 * @version 1.0.0
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

    public final DateTimeFormatter[] formatters;

    DateTimeFormatterLanguage(DateTimeFormatter... formatters) {
        this.formatters = formatters;
    }

    /**
     * <p> Tries to get an option from the provided locale's language. </p>
     *
     * @param locale Locale to get the language.
     *
     * @return An option of the enum.
     *
     * @throws NullPointerException               If the locale is null.
     * @throws InvalidEnumSearchArgumentException If the language is not supported.
     */
    public static DateTimeFormatterLanguage fromLocale(Locale locale) throws NullPointerException, InvalidEnumSearchArgumentException {
        if (locale == null) {
            throw new NullPointerException("Locale can not be null.");
        }

        switch (locale.getLanguage()) {
            case "en":
                return ENGLISH;
            case "pt":
                return PORTUGUESE;
            default:
                throw new InvalidEnumSearchArgumentException("There is no enum option for the provided locale: " + locale);
        }
    }
}
