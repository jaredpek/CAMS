package suggestion;

import java.util.ArrayList;

import input.integer.IntInput;

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
        int index = IntInput.integer("Option");
        if (1 <= index && index <= suggestions.size()) return suggestions.get(index - 1);
        return null;
    }
}
