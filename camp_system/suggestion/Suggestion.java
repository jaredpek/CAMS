package camp_system.suggestion;
import java.util.Scanner;

import camp_system.camp.Camp;
import camp_system.user.User;

public class Suggestion {
	private Status status;
	private User student;
	private Camp camp;
	private String message;
	
	public void printSuggestion() {
		System.out.println(this.message);
	}
	public Suggestion() {
		
	}
	public User getStudent() {
		return student;
	}
	public void setStudent(User student) {
		this.student = student;
	}
	public Camp getCamp() {
		return camp;
	}
	public void setCamp(Camp camp) {
		this.camp = camp;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	
	// composition
	// whenever new message
	
	
	/*public static void main(String[] args) {
		
	
		// assume that the current user already logged in and then chose to
		// create/edit the suggestions
		// all the options that user can do
		System.out.println("Input the status of the user :");
		System.out.println("Input the name of the student");
		
		do {
		// from main, user chose to "create/edit suggestions"
		System.out.println("0: Create a new suggestion");
		System.out.println("1: Edit your suggestions");
		System.out.println("2: Delete a suggestion");
		System.out.println("3: Show all current suggestions");
		System.out.println("4: Quit Suggestions Interface");
		
		Scanner sc = new Scanner(System.in);
		int choice = sc.nextInt();
		
		switch(choice) {
		case 0:
			// create new suggestion
			Suggestion s = new Suggestion(1);
			
			addSuggestion();
			break;
		case 1:
			// edit a existing suggestion
			// so must show all of users current suggestions
			// user can choose which one they want to delete
			editSuggestion();
			break;
		case 2:
			// delete a suggestion
			// again show all of the users suggestions
			// then can ask which one they want to delete
			deleteSuggestion();
			break;
		case 3:
			// print out all the suggestions and thier status -> Accepted or Rejected\
			
		case 4: System.out.println("Exitting Suggestions Interface...");
		}
		} while (choice < 4);
		
		
	}
	*/
		
	}	


