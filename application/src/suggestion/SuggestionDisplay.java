package suggestion;

import java.util.ArrayList;

import camp.Camp;
import camp.CampControl;

public class SuggestionDisplay {
    public static void header() {
        System.out.println("Suggestions");
        for (int i = 0; i < 180; i ++) System.out.printf("-"); System.out.println();
        System.out.printf("%-2s |", "ID");
        System.out.printf(" %-10s |", "Status");
        System.out.printf(" %-15s |", "Camp");
        System.out.printf(" %-10s |", "User");
        System.out.printf(" %-50s\n", "Suggestion");
    }
    public static void suggestion(Suggestion suggestion) {
        Camp camp = CampControl.campControl.getCamp(suggestion.getCamp());
        if (camp == null) return;
        System.out.printf(" %-10s |", suggestion.getStatus());
        System.out.printf(" %-15s |", camp.getName());
        System.out.printf(" %-10s |", suggestion.getUser());
        System.out.printf(" %-50s\n", suggestion.getMessage());
    }
    public static void printSuggestions(ArrayList <Suggestion> suggestions) {
        if (suggestions.size() <= 0) {
            System.out.println("No Suggestions Found");
            return;
        }
        header();
        for (int i = 0; i < suggestions.size(); i ++) {
            System.out.printf("%-2d |", i + 1);
            suggestion(suggestions.get(i));
            System.out.println();
        }
    }
}
