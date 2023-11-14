package camp_system.suggestion;

import java.util.ArrayList;

import camp_system.application.IBase;

public class SuggestionSelect implements IBase {
    private SuggestionDisplay suggestionDisplay = new SuggestionDisplay();

    public Suggestion select(ArrayList <Suggestion> suggestions) {
        suggestionDisplay.printSuggestions(suggestions);
        System.out.printf("Suggestion: "); int index = scan.nextInt(); scan.nextLine();
        return suggestions.get(index - 1);
    }
}
