package camp_system.suggestion;

import java.util.ArrayList;

import camp_system.scanner.Scan;

public class SuggestionSelect {
    public static Suggestion select(ArrayList <Suggestion> suggestions) {
        SuggestionDisplay.printSuggestions(suggestions);
        if (suggestions.size() == 0) return null;
        System.out.printf("Suggestion: "); int index = Scan.scan.nextInt(); Scan.scan.nextLine();
        return suggestions.get(index - 1);
    }
}
