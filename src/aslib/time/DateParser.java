package aslib.time;

import aslib.exceptions.InvalidDateException;
import aslib.util.Parser;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Locale;

/**
 * <p> Contains the methods to parse between {@link LocalDate} and {@link String}. </p>
 *
 * @author Adriano Siqueira
 * @version 1.0.0
 * @since 8.0.0
 */
public class DateParser implements Parser<LocalDate> {

    private Locale locale;
    private DateTimeFormatterLanguage formatterLanguage;

    /**
     * <p> Creates an instance of {@link DateParser} using default {@link Locale}. </p>
     */
    public DateParser() {
        this(Locale.getDefault());
    }

    /**
     * <p> Creates an instance of {@link DateParser} using the provided {@link Locale}. </p>
     *
     * @param locale Locale used to select the {@link DateTimeFormatterLanguage} option.
     */
    public DateParser(Locale locale) {
        this.locale = locale;
        this.formatterLanguage = DateTimeFormatterLanguage.fromLocale(locale);
    }

    /**
     * <p> Parses the {@link String} object to {@link LocalDate} format. </p>
     *
     * @param date Date to be parsed.
     *
     * @return A {@link LocalDate} object from the provided {@link String}.
     *
     * @throws NullPointerException If the date is null.
     * @throws InvalidDateException If the date is not in a valid format.
     */
    public LocalDate fromString(String date) throws NullPointerException, InvalidDateException {
        if (date == null) {
            throw new NullPointerException("Date string can not be null.");
        }

        for (DateTimeFormatter formatter : formatterLanguage.formatters) {
            try {
                return LocalDate.parse(date, formatter);
            } catch (Exception ignored) {
            }
        }

        throw new InvalidDateException("Provided string is not in a valid format.");
    }

    /**
     * <p> Parses the {@link LocalDate} object to {@link String} format. </p>
     *
     * @param date Date to be parsed.
     *
     * @return The date parsed with the default formatter.
     *
     * @throws NullPointerException   If the date is null.
     * @throws DateTimeParseException If the parse fails.
     */
    public String toString(LocalDate date) throws NullPointerException, DateTimeParseException {
        if (date == null) {
            throw new NullPointerException("Date can not be null.");
        }

        DateTimeFormatter formatter = formatterLanguage.formatters[13];
        return formatter.format(date);
    }

    public Locale getLocale() {
        return locale;
    }

    public DateTimeFormatterLanguage getFormatterLanguage() {
        return formatterLanguage;
    }
}