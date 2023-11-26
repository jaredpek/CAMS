package suggestion;

import java.util.ArrayList;

import camp.Camp;
import interfaces.IBuild;
import message.Status;
import scan.Scan;
import user.User;

/**
 * Used to add a Suggestion by a User from a Camp
 * @author Gokul Ramesh
 */
public class SuggestionBuild implements IBuild {
	/**
	 * Creates a new suggestion, and adds this suggestion to the 
	 * global list of Suggestions
	 * 
	 * @param student the user that is trying to add the suggestion
	 * @param camp	the camp to make suggestion about
	 * @return A new suggestion object
	 */
    public Suggestion build(User student, Camp camp){
		System.out.printf("Suggestion: "); String message = Scan.scan.nextLine();
		return new Suggestion(student.getUserID(), camp.getId(), message);
    }
	/**
	 * Builds a new suggestion object from a list of strings
	 * @param data The list of strings to parse
	 * @return A new suggestion object
	 */
	public Suggestion build(String[] data) {
        if (data.length < 4) return null;
        Status status = Status.fromString(data[0]);
        String user = data[1];
        long camp = Long.valueOf(data[2]);
        String message = data[3];
        return new Suggestion(status, user, camp, message);
	}
	/**
	 * Builds an arraylist of new suggestion objects
	 * @param data The arraylist of a list of strings to parse
	 * @return An arraylist of new suggestion objects
	 */
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