package suggestion;

import java.util.ArrayList;

import camp.Camp;
import user.User;

/** 
 * Represents an interface that the suggestion control must implement 
 * @author Gokul Ramesh
 */
public interface ISuggestion {
    /**
     * Method to set a new status for a suggestion
     * @param camp The camp that the suggestions to filter by
     */
    public void approveRejectSuggestions(Camp camp);
    /**
     * Get a list of suggestions for a specific camp
     * @param camp The camp to filter by
     * @return Arraylist of suggestion objects
     */
    public ArrayList<Suggestion> getByCamp(Camp camp);
    /**
     * Get a list of suggestions for a specific student
     * @param student The student to filter by
     * @return Arraylist of suggestion objects
     */
    public ArrayList<Suggestion> getByStudent(User student);
}
