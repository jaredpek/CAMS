package input.integer;

import input.Scan;

/** 
 * Represents a class to obtain a date input
 * @author Jared Pek
 */
public class IntInput {
    /**
     * Obtains user input and returns an integer
     * @param field The field that the integer input is for
     * @return New integer
     */
    public static int integer(String field) {
        int number = '\0';
        do {
            System.out.printf("%s: ", field);
            try {
                number = Scan.scan.nextInt(); Scan.scan.nextLine();
            } catch (Exception e) {
                if (Scan.scan.hasNext()) Scan.scan.nextLine();
                System.out.println("Invalid integer input.");
            }
        } while (number == '\0');
        return number;
    }
}
