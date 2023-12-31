package suggestion;
import java.util.ArrayList;

import camp.Camp;
import camp.CampControl;
import interfaces.IControl;
import message.Message;
import user.User;

/**
 * Represents the suggestion manager that contains the controls for all of the suggestions that can be used by User
 * @author Gokul Ramesh
 */
public class SuggestionControl implements IControl, ISuggestion {
	/** The list of suggestion objects */
	private static ArrayList<Suggestion> suggestions = new ArrayList<Suggestion>();

	/** Static instance to SuggestionControl */
	public static SuggestionControl instance = new SuggestionControl();

	/** Initialises the list of suggestions */
	public static void start() {
		suggestions.addAll(suggestionParse.parse("data\\suggestions.csv"));
	}

	/** Saves the list of suggestions */
	public static void close() {
		suggestionParse.write("data\\suggestions.csv", suggestions);
	}

	/** 
	 * Used by User to add a new suggestion 
     * @param student The student adding a suggestion
	 */
	public void add(User student) {
		ArrayList <Camp> camps = CampControl.instance.getByCommittee(student);
		Camp camp = campSelect.select(camps, student.getUserID());
        if (camp == null) return;
		Suggestion suggestion = suggestionBuild.build(student, camp);
		suggestions.add(suggestion);
	}
	
	/** 
	 * Used by User to edit on of their existing suggestions
     * @param student The student editting a suggestion 
	 */
	public void edit(User student) {
		ArrayList <Suggestion> studentSuggestions = getByStudent(student);
		Suggestion suggestion = suggestionSelect.select(studentSuggestions);
		if (suggestion == null || Message.reviewed(suggestion) || suggestion.getUser().compareTo(student.getUserID()) != 0) return;
		suggestionEdit.edit(suggestion);
	}
	
	/** 
	 * Used by User to delete on of thier existing Suggestions 
     * @param student The student deleting a suggestion
	 */
	public void delete(User student) {
		ArrayList <Suggestion> studentSuggestions = getByStudent(student);
		Suggestion suggestion = suggestionSelect.select(studentSuggestions);
		if (suggestion == null || Message.reviewed(suggestion) || suggestion.getUser().compareTo(student.getUserID()) != 0) return;
		suggestions.remove(suggestion);
	}
	
	/**
	 * Used by Staff to approve or reject a suggestion, that was
	 * directed to the camp the Staff is in-charge of
	 * 
	 * @param camp the camp that the Staff is in-charge of
	 */
	public void approveRejectSuggestions(Camp camp){
		ArrayList <Suggestion> campSuggestions = getByCamp(camp);
		Suggestion suggestion = suggestionSelect.select(campSuggestions);
		if (suggestion == null) return;
		if (!Message.reviewed(suggestion)) suggestionApproveReject.ApproveReject(suggestion);
	}
	
	/**
	 * Used to get all suggestions that were directed to a specific camp
	 * 
	 * @param camp the camp which we will get the suggestions for
	 * @return arraylist of suggestions for the camp
	 */
	public ArrayList<Suggestion> getByCamp(Camp camp){
		// filter global array by camp
		ArrayList<Suggestion> temp = new ArrayList<Suggestion>();
		for (int i=0; i<suggestions.size(); i++) {
			if (camp.getId() == suggestions.get(i).getCamp()) {
				temp.add(suggestions.get(i));
			}
		}
		return temp; // array of all suggestions belonging to one camp
	}
	
	/**
	 * Used to get all suggestions made by a User
	 * 
	 * @param student the student whose suggestions we are getting
	 * @return arraylist of suggestions made by that student
	 */
	public ArrayList<Suggestion> getByStudent(User student){
		//filter global array by student
		ArrayList<Suggestion> temp = new ArrayList<Suggestion>();
		for (int i=0; i<suggestions.size(); i++ ) {
			if (suggestions.get(i).getUser().compareTo(student.getUserID()) == 0) {
				temp.add(suggestions.get(i)); // matching suggestions are added in
			}
		}
		return temp;
	}

}
