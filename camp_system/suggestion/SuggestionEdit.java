package camp_system.suggestion;

import camp_system.IBase;

/**
 * Used by User to edit any of the suggestions that they have made
 */
public class SuggestionEdit implements IBase {
	/**
	 * Used to edit the User's suggestions
	 * 
	 * @param global the arraylist which contains all the suggestions
	 * @param student the User that is deleting the suggestion
	 * @param camps the camp that the Staff is in charge of
	 */
    public void edit(Suggestion suggestion){
        // print all suggestions, and show which camp they are a part of
        // edit suggestion
		System.out.println("Enter your edited suggestion"); String new_message = scan.nextLine();
		suggestion.setMessage(new_message);
    }
}
