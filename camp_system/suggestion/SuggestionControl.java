package camp_system.suggestion;
import java.util.ArrayList;

import camp_system.camp.Camp;
import camp_system.camp.CampSelect;
import camp_system.user.User;

/**
 * Represents the suggestion manager that contains the controls for
 * all of the suggestions that can be used by User
 */
public class SuggestionControl {
	private ArrayList<Suggestion> suggestions = new ArrayList<Suggestion>();
	private SuggestionBuild suggestionBuild = new SuggestionBuild();
	private SuggestionEdit suggestionEdit = new SuggestionEdit();
	private SuggestionSelect suggestionSelect = new SuggestionSelect();
	private CampSelect campSelect = new CampSelect();
	private SuggestionApprove suggestionApprove = new SuggestionApprove();
    
    /** Creates a new CampControl object with a default empty list */
    public SuggestionControl() { this.suggestions = new ArrayList<Suggestion>(); }

	/**
	 * Used to set to set the suggestions attribute 
	 * with another arraylist of suggestions
	 * 
	 * @param suggestion arraylist of suggestions that use
	 */

	public void setSuggestions(ArrayList<Suggestion> suggestion){
		this.suggestions = suggestion;
	}

	/**
	 * Used by User to add a new suggestion
	 * 
	 * @param student the user that is trying to add the suggestion
	 * @param camps the list of all existing camps
	 */
	public void addSuggestion(User student, ArrayList <Camp> camps) {
		Camp camp = campSelect.select(camps);
		if (!camp.enrolledCommittee(student.getUserID())) return;
		Suggestion suggestion = suggestionBuild.build(student, camp);
		suggestions.add(suggestion);
	}
	
	/**
	 * Used by User to edit on of thier existing suggestions
	 * 
	 * @param student the user that is trying to add the suggestion
	 * @param camps the list of all existing camps
	 */
	public void editSuggestion(User student) {
		ArrayList <Suggestion> studentSuggestions = getStudentSuggestions(student);
		Suggestion suggestion = suggestionSelect.select(studentSuggestions);
		if (suggestion == null || student.getUserID() != suggestion.getUser()) return;
		suggestionEdit.edit(suggestion);
	}
	
	/**
	 * Used by User to delete on of thier existing Suggestions
	 * 
	 * @param student the user that is trying to add the suggestion
	 */
	public void deleteSuggestion(User student) {
		ArrayList <Suggestion> studentSuggestions = getStudentSuggestions(student);
		Suggestion suggestion = suggestionSelect.select(studentSuggestions);
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
		ArrayList <Suggestion> campSuggestions = getCampSuggestions(camp);
		Suggestion suggestion = suggestionSelect.select(campSuggestions);
		suggestionApprove.ApproveDelete(suggestion);
	}
	
	/**
	 * Used to get all suggestions that were directed to a specific camp
	 * 
	 * @param camp the camp which we will get the suggestions for
	 * @return arraylist of suggestions for the camp
	 */
	public ArrayList<Suggestion> getCampSuggestions(Camp camp){
		// filter global array by camp
		ArrayList<Suggestion> temp = new ArrayList<Suggestion>();
		for (int i=0; i<this.suggestions.size(); i++) {
			if (camp.getId() == this.suggestions.get(i).getCamp()) {
				temp.add(this.suggestions.get(i));
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
	public ArrayList<Suggestion> getStudentSuggestions(User student){
		//filter global array by student
		ArrayList<Suggestion> temp = new ArrayList<Suggestion>();
		for (int i=0; i<this.suggestions.size(); i++ ) {
			if (this.suggestions.get(i).getUser() == student.getUserID()) {
				temp.add(this.suggestions.get(i)); // matching suggestions are added in
			}
		}
		return temp;
	}

}
