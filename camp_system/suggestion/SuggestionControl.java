package camp_system.suggestion;
import java.util.ArrayList;


import camp_system.camp.Camp;
import camp_system.camp.CampControl;
import camp_system.user.User;

public class SuggestionControl {
	private ArrayList<Suggestion> suggestionList = new ArrayList<Suggestion>();
	private SuggestionAdder suggestionAdder = new SuggestionAdder();
	private SuggestionDeleter suggestionDeleter = new SuggestionDeleter();
	private SuggestionEditor suggestionEditor = new SuggestionEditor();
	private SuggestionApprove suggestionApprove = new SuggestionApprove();

	public SuggestionControl(){
		this.suggestionList = new ArrayList<Suggestion>();
	}
	public SuggestionControl(ArrayList<Suggestion> suggestion) {
		this.suggestionList = suggestion;
	}
	
	public void addSuggestion(User student, CampControl camps) {
		suggestionAdder.add(this.suggestionList, student, camps); 
	}
	
	public void editSuggestion(User student, CampControl camps) {
		suggestionEditor.edit(this.suggestionList, student, camps);
	}
	
	public void deleteSuggestion(User student) {
		suggestionDeleter.delete(this.suggestionList, student);
	}
	
	public void ApproveRejectSuggestions(Camp camp){
		suggestionApprove.ApproveDelete(this.suggestionList, camp);
	}

	public Suggestion getSuggestion(int index) {
		//using the index we iterate through and return that suggestion
		return this.suggestionList.get(index-1);
	}
	
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
