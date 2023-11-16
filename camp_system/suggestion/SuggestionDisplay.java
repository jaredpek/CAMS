package camp_system.suggestion;

import java.util.ArrayList;

public class SuggestionDisplay {
    public static void printSuggestions(ArrayList <Suggestion> suggestions) {
        if (suggestions.size() <= 0) {
            System.out.println("No Suggestions Found");
            return;
        }
        for (int i = 0; i < suggestions.size(); i ++) {
            System.out.printf("%d -> ", i + 1);
            suggestions.get(i).printSuggestion();
            System.out.println();
        }
    }
}
