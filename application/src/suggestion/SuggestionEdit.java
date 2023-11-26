package suggestion;

import input.Scan;

/**
 * Used by User to edit any of the suggestions that they have made
 * @author Gokul Ramesh
 */
public class SuggestionEdit {
	/**
	 * Used to edit the User's suggestions
	 * @param suggestion The suggestion to be edited
	 */
    public void edit(Suggestion suggestion){
        // edit suggestion
		System.out.printf("New Suggestion: "); String new_message = Scan.scan.nextLine();
		suggestion.setMessage(new_message);
    }
}
