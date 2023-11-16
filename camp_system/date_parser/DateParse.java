package camp_system.date_parser;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/** Represents a date parser object to parse String inputs into Date objects */

public class DateParse {
    public static SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");

    /**
     * Returns a date object based on the string input for the date
     * @param source This is the string input for the date
     * @return Date
     * @throws ParseException
     */
    public static Date date(String source) throws ParseException {
        return dateFormatter.parse(source);
    }

    public static String string(Date date) {
        return dateFormatter.format(date);
    }
}
