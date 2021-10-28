package aslib.parse;

import aslib.time.DateTimeFormatterLocale;
import aslib.util.BiParsable;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

/**
 * <p>Class designed to work with conversions between String and LocalDate.</p>
 *
 * @author Adriano Siqueira
 * @version 1.0.0
 * @since 11.0.0
 */
public class StringLocalDateParser implements BiParsable<String, LocalDate> {

    /**
     * <p>Contains a set of valid date patterns by region.</p>
     *
     * @since 1.0.0
     */
    private final DateTimeFormatterLocale formatterLocale;


    /**
     * <p>Creates an instance of the {@link StringLocalDateParser} class using
     * the system default {@link Locale}.</p>
     *
     * <p>It's the same as:</p>
     *
     * <pre>{@code new StringLocalDateParser(
     * Locale.getDefault()
     * )}</pre>
     *
     * @since 1.0.0
     */
    public StringLocalDateParser() {
        this(Locale.getDefault());
    }

    /**
     * <p>Creates an instance of the {@link StringLocalDateParser} class using
     * the provided {@link Locale}.</p>
     *
     * <p>The Locale will be used to get an instance of the
     * {@link DateTimeFormatterLocale} class, which has the set of date patterns
     * that will be used in the conversions.</p>
     *
     * @param locale Must contain country code. Not null.
     *
     * @since 1.0.0
     */
    public StringLocalDateParser(Locale locale) {
        this.formatterLocale = DateTimeFormatterLocale.fromLocale(locale);
    }

    /**
     * <p>Creates an instance of the {@link StringLocalDateParser} class using
     * the provided {@link DateTimeFormatterLocale}.</p>
     *
     * <p>The DateTimeFormatterLocale object contains the set of valid date
     * patterns, which will be used in conversions.</p>
     *
     * @param formatterLocale Contains the set of date patterns. Not null.
     *
     * @since 1.0.0
     */
    public StringLocalDateParser(DateTimeFormatterLocale formatterLocale) {
        this.formatterLocale = formatterLocale;
    }


    /**
     * <p>Converts the {@link LocalDate} object to a {@link String} using the
     * standard format.</p>
     *
     * @param localDate Date that will be converted.
     *
     * @return A string containing the converted and formatted date.
     *
     * @since 1.0.0
     */
    @Override
    public String toA(LocalDate localDate) {
        return localDate.format(formatterLocale.getFormatters()[11]);
    }

    /**
     * <p>Converts the date from {@link String} format to a {@link LocalDate}
     * object.</p>
     *
     * <p>It tries to convert using the various formats supported by the
     * {@link DateTimeFormatterLocale} object. If all fail then returns null.</p>
     *
     * @param date Date that will be converted.
     *
     * @return An object of class LocalDate containing the converted date.
     *
     * @since 1.0.0
     */
    @Override
    public LocalDate toB(String date) {
        for (DateTimeFormatter formatter : formatterLocale.getFormatters()) {
            try {
                return LocalDate.parse(date, formatter);
            } catch (DateTimeParseException ignored) {
            }
        }

        return null;
    }
}
