package aslib.time;

import java.time.DayOfWeek;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * <p> Contains the function to calculate the age based in the date of birth. </p>
 *
 * @author Adriano Siqueira
 * @version 2019-05-03
 * @since 1.0
 */
public class WeekDayDetector {
    private Calendar date;

    /**
     * <p> Creates an instance of {@link WeekDayDetector} class. </p>
     *
     * @param date Date to be processed.
     */
    public WeekDayDetector(Date date) {
        if (date != null) {
            this.date = new GregorianCalendar();
            this.date.setTime(date);
        }
    }

    /**
     * <p> Creates an instance of {@link WeekDayDetector} class. </p>
     *
     * @param date Date to be processed.
     */
    public WeekDayDetector(Calendar date) {
        this.date = date;
    }

    /**
     * <p> Calculates the age from the provided date. </p>
     *
     * @return The day of week of the provided date.
     * @throws NullPointerException If the date is null.
     */
    public DayOfWeek getDay() throws NullPointerException {
        if (date == null)
            throw new NullPointerException("The date can not be null.");

        /*
         * The following two lines maintain the compatibility between calendar
         * and the enum DayOfWeek. As show bellow, the index of the week days
         * are not handled in same way.
         *
         * Days:       S M T W T F S
         * Calendar:   1 2 3 4 5 6 7    (index)
         * DayOfWeek:  7 1 2 3 4 5 6    (index)
         */
        int weekDay = date.get(Calendar.DAY_OF_WEEK);
        weekDay = weekDay == 1 ? 7 : --weekDay;

        return DayOfWeek.of(weekDay);
    }
}