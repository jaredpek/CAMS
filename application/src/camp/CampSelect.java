package camp;

import java.util.ArrayList;

import input.integer.IntInput;

/** 
 * Represents a class that selects a specific camp
 * @author Jared Pek
 */
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
        int index = IntInput.integer("Camp");
        if (1 <= index && index <= camps.size()) return camps.get(index - 1);
        return null;
    }
}
