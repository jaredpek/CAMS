package camp_system.suggestion;
import java.util.ArrayList;
import java.util.Scanner;

import camp_system.camp.Camp;
import camp_system.user.User;

public class SuggestionControl {
	private ArrayList<Suggestion> suggestionList = new ArrayList<Suggestion>();
	
	public SuggestionControl(ArrayList<Suggestion> suggestion) {
		this.suggestionList = suggestion;
	}
	
	public void addSuggestion(User student, Camp camp, String message) {

		Scanner sc = new Scanner(System.in);
		Suggestion s2 = new Suggestion();

		s2.setStudent(Student); // need to get from main
		s2.setCamp(getCamps(student)); // from CampControl i think
		s2.setStatus(Status.PROCESSING);
		System.out.println("Enter the suggestion you would like to make :");
		s2.setMessage(sc.next()); // suggestion has been set
		
		
		this.suggestionList.add(s2); // add into the global array of suggestions
		
		
	}
	
	public void editSuggestion(int index) {
		//get all the existing suggestions
		//get all suggestions filtering using student
		//ask which one they want to edit
		//edit by doing "Enter your edited suggestion"
		ArrayList<Suggestion> temp = getSuggestions(student); // all suggestions by this student
		
		for (int i=0; i<temp.size(); i++) {
			System.out.printf("&d : ", i);
			temp.get(i).printSuggestion();
		}
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the index of the suggestion you want to edit"); int num = sc.nextInt();
		System.out.println("Enter your edited suggestion"); String new_message = sc.next();
		temp.get(num-1).setMessage(new_message); // update to new suggestion
	}
	
	public void deleteSuggestion(int index) {
		//get all suggestions
		// ask which one they want to delete
		ArrayList<Suggestion> temp = getSuggestions(student); // all suggestions by this student
		
		for (int i=0; i<temp.size(); i++) {
			System.out.printf("&d : ", i);
			temp.get(i).printSuggestion();
		}
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the index of the suggestion you want to delete"); int num = sc.nextInt();
		temp.remove(num-1); // not sure if this also deletes from the global list
		//OTHER METHOD
		/*for (int i=0; i<this.suggestionList.size(); i++) {
			if (User.getUserID() == suggestionList.get(i).getStudent().getUserID()) {
				num--;
			}
			if (num == 0) {
				this.suggestionList.remove(i);//ensure that you remove from the global list
			}
		} */
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
	
	public ArrayList<Suggestion> getSuggestions(Student student){
		//filter global array by student
		ArrayList<Suggestion> temp = new ArrayList<Suggestion>();
		for (int i=0; i<this.suggestionList.size(); i++ ) {
			if (student.getUserID() == this.suggestionList.get(i).getStudent().getUserID()) {
				temp.add(this.suggestionList.get(i)); // matching suggestions are added in
			}
		}
		return temp;
	}
}
