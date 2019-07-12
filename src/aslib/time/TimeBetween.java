package aslib.time;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p> Contains the functions to calculate the difference between two dates. </p>
 *
 * @author Adriano Siqueira
 * @version 2019-07-12
 * @since 6.0
 */
public class TimeBetween {
    private LocalDate startDate;
    private LocalDate endDate;

    private Period period;

    /**
     * <p> Creates an instance of {@link TimeBetween} class. </p>
     *
     * @param startDate Start date for processing. If it comes after the end date, the result will be negative.
     * @param endDate   End date for processing.
     */
    public TimeBetween(LocalDate startDate, LocalDate endDate) {
        Objects.requireNonNull(startDate, "Start date can not be null.");
        Objects.requireNonNull(startDate, "End date ca not be null.");

        this.startDate = startDate;
        this.endDate = endDate;
        this.period = calculatePeriod();
    }

    /**
     * <p> Calculates the difference between dates, including years, months
     * and days. </p>
     *
     * <p> Each field corresponds to an integer that complements. </p>
     *
     * <p> The DAY field complements the MONTH field, which complements the
     * YEAR field. </p>
     *
     * @return A map with the fields as key and the values.
     *
     * @throws NullPointerException If some of the dates are null.
     */
    public Map<ChronoUnit, Integer> getCompleteTime() throws NullPointerException {
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
     *
     * @throws NullPointerException If some of the dates are null.
     */
    public int getTotalYears() throws NullPointerException {
        return period.getYears();
    }

    /**
     * <p> Calculates the amount of months between the dates. </p>
     *
     * @return The amount of months between the dates.
     *
     * @throws NullPointerException If some of the dates are null.
     */
    public long getTotalMonths() throws NullPointerException {
        return period.toTotalMonths();
    }

    /**
     * <p> Calculates the amount time between the dates and keeps it ready to
     * read the data as needed.. </p>
     *
     * @return Period calculated with the dates provided.
     */
    private Period calculatePeriod() {
        return Period.between(startDate, endDate);
    }
}
