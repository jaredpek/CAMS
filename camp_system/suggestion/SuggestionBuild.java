package camp_system.suggestion;

import java.util.ArrayList;

import camp_system.application.IBase;
import camp_system.camp.Camp;
import camp_system.user.User;

/**
 * Used to add a Suggestion by a User from a Camp
 */
public class SuggestionBuild implements IBase {
	/**
	 * Creates a new suggestion, and adds this suggestion to the 
	 * global list of Suggestions
	 * 
	 * @param global the arraylist which contains all the suggestions
	 * @param student the user that is trying to add the suggestion
	 * @param camps	the list of all existing camps
	 */
    public Suggestion build(User student, Camp camp){
		System.out.printf("Suggestion: "); String message = scan.nextLine();
		return new Suggestion(student.getUserID(), camp.getId(), message);
    }
	public Suggestion build(String[] data) {
        if (data.length < 4) return null;
        Status status = Status.fromString(data[0]);
        String user = data[1];
        int camp = Integer.valueOf(data[2]);
        String message = data[3];
        return new Suggestion(status, user, camp, message);
	}
	public ArrayList <Suggestion> buildMany(ArrayList <String[]> data) {
		ArrayList <Suggestion> suggestions = new ArrayList <Suggestion> ();
		for (String[] entry : data) {
			Suggestion suggestion = build(entry);
			if (suggestion == null) continue;
			suggestions.add(suggestion);
		}
		return suggestions;
	}
}