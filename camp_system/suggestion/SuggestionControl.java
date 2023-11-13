package camp_system.suggestion;
import java.util.ArrayList;


import camp_system.camp.Camp;
import camp_system.camp.CampControl;
import camp_system.user.User;

/**
 * Represents the suggestion manager that contains the controls for
 * all of the suggestions that can be used by User
 */
public class SuggestionControl {
	private ArrayList<Suggestion> suggestionList = new ArrayList<Suggestion>();
	private SuggestionAdder suggestionAdder = new SuggestionAdder();
	private SuggestionDeleter suggestionDeleter = new SuggestionDeleter();
	private SuggestionEditor suggestionEditor = new SuggestionEditor();
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
	public void addSuggestion(User student, CampControl camps) {
		suggestionAdder.add(this.suggestionList, student, camps); 
	}
	
	/**
	 * Used by User to edit on of thier existing suggestions
	 * 
	 * @param student the user that is trying to add the suggestion
	 * @param camps the list of all existing camps
	 */
	public void editSuggestion(User student, CampControl camps) {
		suggestionEditor.edit(this.suggestionList, student, camps);
	}
	
	/**
	 * Used by User to delete on of thier existing Suggestions
	 * 
	 * @param student the user that is trying to add the suggestion
	 */
	public void deleteSuggestion(User student) {
		suggestionDeleter.delete(this.suggestionList, student);
	}
	
	/**
	 * Used by Staff to approve or reject a suggestion, that was
	 * directed to the camp the Staff is in-charge of
	 * 
	 * @param camp the camp that the Staff is in-charge of
	 */
	public void ApproveRejectSuggestions(Camp camp){
		suggestionApprove.ApproveDelete(this.suggestionList, camp);
	}

	/**
	 * Used to get a specific suggestion from the arraylist of suggestions
	 * 
	 * @param index the index of a specific suggestion in arraylist
	 * @return the Suggestion object with that index in arraylist
	 */
	public Suggestion getSuggestion(int index) {
		//using the index we iterate through and return that suggestion
		return this.suggestionList.get(index-1);
	}
	
	/**
	 * Used to get all suggestions that were directed to a specific camp
	 * 
	 * @param camp the camp which we will get the suggestions for
	 * @return arraylist of suggestions for the camp
	 */
	public ArrayList<Suggestion> getSuggestion(Camp camp){
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
	public ArrayList<Suggestion> getSuggestion(User student){
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
