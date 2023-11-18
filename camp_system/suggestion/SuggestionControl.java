package camp_system.suggestion;
import java.util.ArrayList;

import camp_system.application.IControl;
import camp_system.camp.Camp;
import camp_system.camp.CampControl;
import camp_system.camp.CampSelect;
import camp_system.user.User;

/**
 * Represents the suggestion manager that contains the controls for
 * all of the suggestions that can be used by User
 */
public class SuggestionControl implements IControl, ISuggestion {
	private static ArrayList<Suggestion> suggestions = new ArrayList<Suggestion>();
	public static SuggestionControl instance = new SuggestionControl();

	public static void start() {
		suggestions.addAll(SuggestionParse.parse("camp_system\\data\\suggestions.csv"));
	}

	public static void close() {
		SuggestionParse.write("camp_system\\data\\suggestions.csv", suggestions);
	}

	/**
	 * Used by User to add a new suggestion
	 * 
	 * @param student the user that is trying to add the suggestion
	 * @param camps the list of all existing camps
	 */
	public void add(User student) {
		ArrayList <Camp> camps = CampControl.campControl.getByCommittee(student);
		Camp camp = CampSelect.select(camps, student.getUserID());
		if (camp == null || !camp.enrolledCommittee(student.getUserID())) return;
		Suggestion suggestion = SuggestionBuild.build(student, camp);
		suggestions.add(suggestion);
	}
	
	/**
	 * Used by User to edit on of thier existing suggestions
	 * 
	 * @param student the user that is trying to add the suggestion
	 * @param camps the list of all existing camps
	 */
	public void edit(User student) {
		ArrayList <Suggestion> studentSuggestions = getByStudent(student);
		Suggestion suggestion = SuggestionSelect.select(studentSuggestions);
		if (suggestion == null || student.getUserID() != suggestion.getUser()) return;
		SuggestionEdit.edit(suggestion);
	}
	
	/**
	 * Used by User to delete on of thier existing Suggestions
	 * 
	 * @param student the user that is trying to add the suggestion
	 */
	public void delete(User student) {
		ArrayList <Suggestion> studentSuggestions = getByStudent(student);
		Suggestion suggestion = SuggestionSelect.select(studentSuggestions);
		if (suggestion == null || student.getUserID() != suggestion.getUser()) return;
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
		Suggestion suggestion = SuggestionSelect.select(campSuggestions);
		if (suggestion == null) return;
		SuggestionApprove.ApproveDelete(suggestion);
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
