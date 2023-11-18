package camp_system.suggestion;

import java.util.ArrayList;
import java.util.HashMap;

import camp_system.message.Status;

public class SuggestionScore {
    public static HashMap <String, Integer> compute(ArrayList <Suggestion> suggestions, ArrayList <String> committee) {
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
