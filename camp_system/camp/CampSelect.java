package camp_system.camp;

import java.util.ArrayList;

import camp_system.scanner.Scan;

/** Represents a class that selects a specific camp */
public class CampSelect {
    /**
     * Obtains user input and selects a camp from the list
     * @param camps The list of camps available
     * @param user The user selecting the camp
     * @return Camp
     */
    public static Camp select(ArrayList <Camp> camps, String user) {
        CampDisplay.printCamps(camps, user);
        if (camps.size() == 0) return null;
        System.out.printf("Camp: "); int index = Scan.scan.nextInt(); Scan.scan.nextLine();
        return camps.get(index - 1);
    }
}
