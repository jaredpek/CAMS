package date;

import java.util.Date;

import scan.Scan;

/** Represents a class to obtain a date input */
public class DateInput {
    /**
     * Obtains user input and returns a new date object
     * @param field The field that the date object is for
     * @return New date object
     */
    public static Date date(String field) {
        Date date = null;
        do {
            System.out.printf("%s: ", field);
            date = DateParse.date(Scan.scan.nextLine());
        } while (date == null);
        return date;
    }
}
