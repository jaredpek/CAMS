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
	
	public void addSuggestion() {

		Scanner sc = new Scanner(System.in);
		Suggestion s2 = new Suggestion();

		s2.setStudent(Student); // need to get from main
		s2.setCamp(getCamps(student)); // from CampControl i think
		//s2.setStatus(Status Processing); already initialised
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
		temp.get(num).setMessage(new_message); // update to new suggestion
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
		
		this.suggestionList.remove(temp.get(num)); // removes the specific suggestion from global list
		
		
		
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
	public void menu() {
		if (user.getRole() == STUDENT) { // interface for student
			System.out.println("Suggestion Menu");
			System.out.println("1: Add Suggestion");
			System.out.println("2: Edit Suggestion");
			System.out.println("3: Delete Suggestion");
			System.out.println("4: Get all Suggestions");
		}
		
		if (user.getRole() == STAFF) { // interface for staff
		System.out.println("1: Get all Suggestions by Camp");
		System.out.println("2: View/Approve Suggestions");
		}
	}
	public void ApproveRejectSuggestions(Camp camp){
		ArrayList<Suggestion> temp = new ArrayList<Suggestion>();
		temp = getSuggestions(camp);
		
		for (int i=0; i<temp.size();i++) {
			System.out.printf("&d : ", i);
			temp.get(i).printSuggestion();
		}
		
		//System.out.println("Select an Option: ");

		while (true) {
			System.out.println("Enter the Index of the Suggestion to Approve/Reject");
			System.out.println("Enter -1 to exit the Approve/Rejects Suggestion Menu");
			
			Scanner sc = new Scanner(System.in);
			int num = sc.nextInt();
			while (num >= temp.size() || num < 0) { // edge case
				System.out.println("Please enter a valid index!");
					num = sc.nextInt(); // if they input valid index, exit on next iteration
				}
			
			if (num < 0) break; // exit menu
			
			else {
				System.out.println("What is your decison for this Suggestion");
				System.out.println("1: Approved");
				System.out.println("2: Rejected");
				System.out.println("3: Exit the menu for the Suggestion");
							
				int dec = sc.nextInt();
				while(dec < 1 || dec > 3) {
					System.out.println("Please enter a valid number!");
						dec = sc.nextInt(); // if they input valid index, exit on next iteration
				}
				// we have a valid index now
				if (dec == 1) {
					Status s = Status.ACCEPTED;
					temp.get(num).setStatus(s); // set status of suggestion to approved
				}
				else if (dec == 2) {
					Status r = Status.REJECTED;
					temp.get(num).setStatus(r); // set status of suggestion to rejected
				}
				else { break; } // exit else
										
		}
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}






