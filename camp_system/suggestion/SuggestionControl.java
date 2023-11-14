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
	private ArrayList<Suggestion> suggestionList = new ArrayList<Suggestion>();
	private SuggestionBuild suggestionBuild = new SuggestionBuild();
	private SuggestionEdit suggestionEdit = new SuggestionEdit();
	public static SuggestionSelect suggestionSelect = new SuggestionSelect();
	public static CampSelect campSelect = new CampSelect();
	private SuggestionApprove suggestionApprove = new SuggestionApprove();
	/**
	 * Default constructor for the SuggestionControl
	 */
	public SuggestionControl(){
		this.suggestionList = new ArrayList<Suggestion>();
	}
	/**
	 * Used to set to set the suggestionlist attribute 
	 * with another arraylist of suggestions
	 * 
	 * @param suggestion arraylist of suggestions that use
	 */

	public void setSuggestionList(ArrayList<Suggestion> suggestion){
		this.suggestionList = suggestion;
	}

	/**
	 * Used by User to add a new suggestion
	 * 
	 * @param student the user that is trying to add the suggestion
	 * @param camps the list of all existing camps
	 */
	public void addSuggestion(User student, ArrayList <Camp> camps) {
		Camp camp = campSelect.select(camps);
		if (!camp.enrolledCommittee(student)) return;
		Suggestion suggestion = suggestionBuild.build(student, camp);
		suggestionList.add(suggestion);
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
		if (student != suggestion.getUser()) return;
		if (suggestion != null) suggestionEdit.edit(suggestion);
	}
	
	/**
	 * Used by User to delete on of thier existing Suggestions
	 * 
	 * @param student the user that is trying to add the suggestion
	 */
	public void deleteSuggestion(User student) {
		ArrayList <Suggestion> studentSuggestions = getStudentSuggestions(student);
		Suggestion suggestion = suggestionSelect.select(studentSuggestions);
		if (suggestion != null) suggestionList.remove(suggestion);
	}
	
	/**
	 * Used by Staff to approve or reject a suggestion, that was
	 * directed to the camp the Staff is in-charge of
	 * 
	 * @param camp the camp that the Staff is in-charge of
	 */
	public void ApproveRejectSuggestions(Camp camp){
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
		for (int i=0; i<this.suggestionList.size(); i++) {
			if (camp == this.suggestionList.get(i).getCamp()) {
				temp.add(this.suggestionList.get(i));
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
		for (int i=0; i<this.suggestionList.size(); i++ ) {
			if (this.suggestionList.get(i).getUser() == student) {
				temp.add(this.suggestionList.get(i)); // matching suggestions are added in
			}
		}
		return temp;
	}

}
