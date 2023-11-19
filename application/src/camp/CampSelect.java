package camp;

import java.util.ArrayList;

import scan.Scan;

/** Represents a class that selects a specific camp */
public class CampSelect {
    /**
     * Obtains user input and selects a camp from the list
     * @param camps The list of camps available
     * @param user The user selecting the camp
     * @return Camp
     */
    public Camp select(ArrayList <Camp> camps, String user) {
        (new CampDisplay()).camps(camps, user);
        if (camps.size() == 0) return null;
        System.out.printf("Camp: "); int index = Scan.scan.nextInt(); Scan.scan.nextLine();
        if (1 <= index && index <= camps.size()) return camps.get(index - 1);
        return null;
    }
}
