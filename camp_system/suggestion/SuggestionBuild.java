package camp_system.suggestion;

import camp_system.application.IBase;
import camp_system.camp.Camp;
import camp_system.user.User;

/**
 * Used to add a Suggestion by a User from a Camp
 */
public class SuggestionBuild implements IBase {
	/**
	 * Creates a new suggestion, and adds this suggestion to the 
	 * global list of Suggestions
	 * 
	 * @param global the arraylist which contains all the suggestions
	 * @param student the user that is trying to add the suggestion
	 * @param camps	the list of all existing camps
	 */
    public Suggestion build(User student, Camp camp){
		System.out.printf("Suggestion: "); String message = scan.nextLine();
		return new Suggestion(student, camp, message);
    }
}