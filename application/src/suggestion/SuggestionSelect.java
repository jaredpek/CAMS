package suggestion;

import java.util.ArrayList;

import scan.Scan;

/** 
 * Represents a class used to select a specific suggestion
 * @author Gokul Ramesh
 */
public class SuggestionSelect {
    /**
     * Obtains input and returns a suggestion object
     * @param suggestions The list of suggestions to select from
     * @return The selected suggestion object
     */
    public Suggestion select(ArrayList <Suggestion> suggestions) {
        (new SuggestionDisplay()).suggestions(suggestions);
        if (suggestions.size() == 0) return null;
        System.out.printf("Option: "); int index = Scan.scan.nextInt(); Scan.scan.nextLine();
        if (1 <= index && index <= suggestions.size()) return suggestions.get(index - 1);
        return null;
    }
}
