package aslib.time;

import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * <p>Contains a set of valid date patterns according to country.</p>
 *
 * <p>Each country is represented by the ISO-3166 code.</p>
 *
 * @author Adriano Siqueira
 * @version 1.0.0
 * @since 11.0.0
 */
public enum DateTimeFormatterLocale {

    /**
     * <p>Set of patterns for the United States.</p>
     *
     * @since 1.0.0
     */
    US(
            DateTimeFormatter.ofPattern("M/d/uu", new Locale("en", "US")),
            DateTimeFormatter.ofPattern("M/d/uuuu", new Locale("en", "US")),
            DateTimeFormatter.ofPattern("MM/d/uu", new Locale("en", "US")),
            DateTimeFormatter.ofPattern("MM/d/uuuu", new Locale("en", "US")),
            DateTimeFormatter.ofPattern("MMM/d/uu", new Locale("en", "US")),
            DateTimeFormatter.ofPattern("MMM/d/uuuu", new Locale("en", "US")),
            DateTimeFormatter.ofPattern("MMMM/d/uu", new Locale("en", "US")),
            DateTimeFormatter.ofPattern("MMMM/d/uuuu", new Locale("en", "US")),
            DateTimeFormatter.ofPattern("M/dd/uu", new Locale("en", "US")),
            DateTimeFormatter.ofPattern("M/dd/uuuu", new Locale("en", "US")),
            DateTimeFormatter.ofPattern("MM/dd/uu", new Locale("en", "US")),
            DateTimeFormatter.ofPattern("MM/dd/uuuu", new Locale("en", "US")),
            DateTimeFormatter.ofPattern("MMM/dd/uu", new Locale("en", "US")),
            DateTimeFormatter.ofPattern("MMM/dd/uuuu", new Locale("en", "US")),
            DateTimeFormatter.ofPattern("MMMM/dd/uu", new Locale("en", "US")),
            DateTimeFormatter.ofPattern("MMMM/dd/uuuu", new Locale("en", "US"))
    ),

    /**
     * <p>Set of patterns for Brazil.</p>
     *
     * @since 1.0.0
     */
    BR(
            DateTimeFormatter.ofPattern("d/M/uu", new Locale("pt", "BR")),
            DateTimeFormatter.ofPattern("d/M/uuuu", new Locale("pt", "BR")),
            DateTimeFormatter.ofPattern("d/MM/uu", new Locale("pt", "BR")),
            DateTimeFormatter.ofPattern("d/MM/uuuu", new Locale("pt", "BR")),
            DateTimeFormatter.ofPattern("d/MMM/uu", new Locale("pt", "BR")),
            DateTimeFormatter.ofPattern("d/MMM/uuuu", new Locale("pt", "BR")),
            DateTimeFormatter.ofPattern("d/MMMM/uu", new Locale("pt", "BR")),
            DateTimeFormatter.ofPattern("d/MMMM/uuuu", new Locale("pt", "BR")),
            DateTimeFormatter.ofPattern("dd/M/uu", new Locale("pt", "BR")),
            DateTimeFormatter.ofPattern("dd/M/uuuu", new Locale("pt", "BR")),
            DateTimeFormatter.ofPattern("dd/MM/uu", new Locale("pt", "BR")),
            DateTimeFormatter.ofPattern("dd/MM/uuuu", new Locale("pt", "BR")),
            DateTimeFormatter.ofPattern("dd/MMM/uu", new Locale("pt", "BR")),
            DateTimeFormatter.ofPattern("dd/MMM/uuuu", new Locale("pt", "BR")),
            DateTimeFormatter.ofPattern("dd/MMMM/uu", new Locale("pt", "BR")),
            DateTimeFormatter.ofPattern("dd/MMMM/uuuu", new Locale("pt", "BR"))
    );


    /**
     * <p>Set of patterns according to country.</p>
     *
     * @since 1.0.0
     */
    private final DateTimeFormatter[] formatters;


    /**
     * <p>Creates an instance of the {@link DateTimeFormatterLocale} class
     * defining supported patterns.</p>
     *
     * @param formatters Patterns that will be set.
     *
     * @since 1.0.0
     */
    DateTimeFormatterLocale(DateTimeFormatter... formatters) {
        this.formatters = formatters;
    }


    /**
     * <p>Gets an instance of the {@link DateTimeFormatterLocale} class using
     * the provided {@link Locale}.</p>
     *
     * <p>Each enumeration option follows the ISO-3166 standard, so we can use
     * the {@link #valueOf} method to get the option from Locale's country code.</p>
     *
     * <p>The Locale must contain the country code, otherwise the {@link #US}
     * default will be returned.</p>
     *
     * @param locale Locale used to get the instance of the enumeration.
     *
     * @return An object of the DateTimeFormatterLocale class.
     *
     * @since 1.0.0
     */
    public static DateTimeFormatterLocale fromLocale(Locale locale) {
        if (locale == null || locale.getCountry() == null) {
            return US;
        }

        try {
            return DateTimeFormatterLocale.valueOf(locale.getCountry());
        } catch (IllegalArgumentException ignored) {
            return US;
        }
    }


    /**
     * @return The vector with valid patterns.
     *
     * @since 1.0.0
     */
    public DateTimeFormatter[] getFormatters() {
        return formatters;
    }
}
