package camp_system.suggestion;
import java.util.ArrayList;
import java.util.Scanner;

import camp_system.camp.CampControl;
import camp_system.user.User;

/**
 * Used by User to edit any of the suggestions that they have made
 */
public class SuggestionEditor{
	/**
	 * Used to edit the User's suggestions
	 * 
	 * @param global the arraylist which contains all the suggestions
	 * @param student the User that is deleting the suggestion
	 * @param camps the camp that the Staff is in charge of
	 */
    protected void edit(ArrayList<Suggestion> global, User student, CampControl camps){
        // print all suggestions, and show which camp they are a part of
        // edit suggestion
        
		ArrayList<Suggestion> temp = new ArrayList<Suggestion>(); // all suggestions by this student
		
		for (int i=0; i<global.size(); i++){
			if (global.get(i).getUser() == student) {
				temp.add(global.get(i)); // matching suggestions are added in
			}
		} // all of user suggestions are now in temp

		for (int i=0; i<temp.size(); i++) {
			System.out.printf("&d : ", i);
			temp.get(i).printSuggestion();
		} // print all the suggestions
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the index of the suggestion you want to edit"); int num = sc.nextInt();
		System.out.println("Enter your edited suggestion"); String new_message = sc.next();
		temp.get(num).setMessage(new_message); // update to new suggestion
		
		sc.close();
    }
}