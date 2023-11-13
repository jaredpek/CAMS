package camp_system.suggestion;
import java.util.ArrayList;
import java.util.Scanner;

import camp_system.user.User;

/**
 * Used by the User to delete a suggestion that they have made
 */
public class SuggestionDeleter{
	/**
	 * Used to delete a suggestion that the User has made
	 * 
	 * @param global the arraylist which contains all the suggestions
	 * @param student the User that is deleting the suggestion
	 */
    protected void delete(ArrayList<Suggestion> global, User student){
        //get all suggestions
		// ask which one they want to delete
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
		
		System.out.println("Enter the index of the suggestion you want to delete");
		int num = sc.nextInt();
		
		global.remove(temp.get(num)); // removes the specific suggestion from global list
		sc.close();
    }
}