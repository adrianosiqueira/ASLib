package library.ai;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * <p> Contains the function to detect the day of the week corresponding to a certain date. </p>
 *
 * @author Adriano Siqueira
 */
public class WeekDayDetector {

    /**
     * <p> Determines the day of the week corresponding to a certain date. </p>
     * <p> For the algorithm to work, the date must be between (01/01/1900 and 12/12/2399),
     * otherwise an exception will be thrown. </p>
     *
     * @param date Date in format (dd/mm/yyyy) to perform the analysis.
     * @return Day of the week corresponding to the date provided. <p> Obs.: 0 = Sunday, ... , 6 = Saturday
     * @throws ParseException           If the date is in an invalid format.
     * @throws IllegalArgumentException If the date are not in the valid range (01/01/1900 - 12/12/2399).
     */
    public static int detect(final String date) throws ParseException, IllegalArgumentException {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new SimpleDateFormat("dd/MM/yyyy").parse(date));

        // Only works in year between 1900 and 2399
        if (calendar.get(Calendar.YEAR) < 1900 || calendar.get(Calendar.YEAR) > 2399)
            throw new IllegalArgumentException("The date must be between 01/jan/1900 and 12/dec/2399");

        int a = calendar.get(Calendar.YEAR) - 1900;
        int b = a / 4;
        int c = 0;
        int d = calendar.get(Calendar.DAY_OF_MONTH) - 1;

        // If it is a leap year, we decrease b
        if (calendar.get(Calendar.YEAR) % 4 == 0 &&
                calendar.get(Calendar.YEAR) % 100 != 0 &&
                calendar.get(Calendar.DAY_OF_MONTH) <= 29) {
            --b;
        }

        // Receives a specific value according to the month
        switch (calendar.get(Calendar.MONTH)) {
            case 1:
            case 2:
            case 10:
                c = 3;
                break;

            case 3:
            case 6:
                c = 6;
                break;

            case 4:
                c = 1;
                break;

            case 5:
                c = 4;
                break;

            case 7:
                c = 2;
                break;

            case 8:
            case 11:
                c = 5;
                break;

            case 0:
            case 9:
            default:
                break;
        }

        // Determines the day of week
        switch ((a + b + c + d) % 7) {
            case 0:
                return 1;

            case 1:
                return 2;

            case 2:
                return 3;

            case 3:
                return 4;

            case 4:
                return 5;

            case 5:
                return 6;

            case 6:
            default:        /* default never will be needed. */
                return 0;
        }
    }
}
