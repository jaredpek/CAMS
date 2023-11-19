package suggestion;

import java.util.ArrayList;

import camp.Camp;
import camp.CampControl;

/** The display class for suggestion objects */
public class SuggestionDisplay {
    /** The table header to be printed */
    public void header() {
        System.out.printf("SUGGESTIONS ");
        for (int i = 0; i < 110; i ++) System.out.printf("-"); System.out.println();

        System.out.printf("%-2s |", "ID");
        System.out.printf(" %-10s |", "Status");
        System.out.printf(" %-15s |", "Camp");
        System.out.printf(" %-10s |", "User");
        System.out.printf(" %-50s\n", "Suggestion");
    }
    /**
     * Prints the suggestion entry
     * @param suggestion The suggestion to be printed
     */
    public void suggestion(Suggestion suggestion) {
        Camp camp = CampControl.instance.getCamp(suggestion.getCamp());
        if (camp == null) return;
        System.out.printf(" %-10s |", suggestion.getStatus());
        System.out.printf(" %-15s |", camp.getName());
        System.out.printf(" %-10s |", suggestion.getUser());
        System.out.printf(" %-50s\n", suggestion.getMessage());
    }
    /**
     * Prints all the suggestion entries
     * @param suggestions The list of suggestions to print
     */
    public void suggestions(ArrayList <Suggestion> suggestions) {
        if (suggestions.size() <= 0) {
            System.out.println("No Suggestions Found");
            return;
        }
        header();
        for (int i = 0; i < suggestions.size(); i ++) {
            System.out.printf("%-2d |", i + 1);
            suggestion(suggestions.get(i));
        }
    }
}
