package aslib.time;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

/**
 * <p> Contains the functions to calculate the difference between two dates. </p>
 *
 * @author Adriano Siqueira
 * @version 1.0
 * @since 6.0
 */
public class TimeBetween {
    private LocalDate startDate;
    private LocalDate endDate;

    /**
     * <p> Creates an instance of {@link TimeBetween} class. </p>
     *
     * @param startDate Start date for processing. If it comes after the end date, the result will be negative.
     * @param endDate   End date for processing.
     */
    public TimeBetween(Date startDate, Date endDate) {
        if (startDate != null) {
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(startDate);
            this.startDate = LocalDate.ofInstant(calendar.toInstant(), calendar.getTimeZone().toZoneId());
        }

        if (endDate != null) {
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(endDate);
            this.endDate = LocalDate.ofInstant(calendar.toInstant(), calendar.getTimeZone().toZoneId());
        }
    }

    /**
     * <p> Creates an instance of {@link TimeBetween} class. </p>
     *
     * @param startDate Start date for processing. If it comes after the end date, the result will be negative.
     * @param endDate   End date for processing.
     */
    public TimeBetween(Calendar startDate, Calendar endDate) {
        if (startDate != null)
            this.startDate = LocalDate.ofInstant(startDate.toInstant(), startDate.getTimeZone().toZoneId());

        if (endDate != null)
            this.endDate = LocalDate.ofInstant(endDate.toInstant(), endDate.getTimeZone().toZoneId());
    }

    /**
     * <p> Creates an instance of {@link TimeBetween} class. </p>
     *
     * @param startDate Start date for processing. If it comes after the end date, the result will be negative.
     * @param endDate   End date for processing.
     */
    public TimeBetween(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }

    /**
     * <p> Calculates the difference between dates, including years, months
     * and days. </p>
     *
     * <p> Each field corresponds to an integer that complements. </p>
     *
     * <p> The DIA field complements the MONTH field, which complements the
     * YEAR field. </p>
     *
     * @return A map with the fields as key and the values.
     */
    public Map<ChronoUnit, Integer> getCompleteTime() {
        Period period = Period.between(startDate, endDate);

        Map<ChronoUnit, Integer> time = new HashMap<>();
        time.put(ChronoUnit.DAYS, period.getDays());
        time.put(ChronoUnit.MONTHS, period.getMonths());
        time.put(ChronoUnit.YEARS, period.getYears());

        return time;
    }

    /**
     * <p> Calculates the amount of years between the dates. </p>
     *
     * @return The amount of years between the dates.
     */
    public int getTotalYears() {
        if (startDate == null || endDate == null)
            throw new NullPointerException("None of dates can be null.");

        return Period.between(startDate, endDate).getYears();
    }

    /**
     * <p> Calculates the amount of months between the dates. </p>
     *
     * @return The amount of months between the dates.
     */
    public long getTotalMonths() {
        if (startDate == null)
            throw new NullPointerException("Date can not be null.");

        return Period.between(startDate, endDate).toTotalMonths();
    }
}
