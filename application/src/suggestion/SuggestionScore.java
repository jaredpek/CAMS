package suggestion;

import java.util.ArrayList;
import java.util.HashMap;

import message.Status;

/** 
 * Represents a class that computes the scores of commitee members based on suggestions
 * @author Gokul Ramesh
 */
public class SuggestionScore {
    /**
     * Computes the scores of students from suggestions
     * @param suggestions The list of suggestions to check
     * @param committee The list of committee members
     * @return HashMap of scores from suggestions
     */
    public HashMap <String, Integer> compute(ArrayList <Suggestion> suggestions, ArrayList <String> committee) {
        HashMap <String, Integer> result = new HashMap <String, Integer> ();
        for (String user : committee) {
            result.put(user, 0);
        }
        for (Suggestion suggestion : suggestions) {
            result.computeIfPresent(suggestion.getUser(), (key, value) -> value + 1);
            if (suggestion.getStatus() == Status.ACCEPTED) result.computeIfPresent(suggestion.getUser(), (key, value) -> value + 1);
        }
        return result;
    }
}
