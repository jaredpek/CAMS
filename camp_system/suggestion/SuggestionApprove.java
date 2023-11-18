package camp_system.suggestion;

import camp_system.scanner.Scan;
import camp_system.message.Status;

/**
 * Used by Staff to Approve or Reject a suggestion
 */
public class SuggestionApprove {
	/**
	 * It is used by staff to approve/edit a suggestion that was 
	 * directed to the camp that these staff are in charge of
	 * 
	 * @param global the arraylist which contains all the suggestions
	 * @param camp the camp that the Staff is in charge of
	 */
    public static void ApproveDelete(Suggestion suggestion){
        System.out.println("What is your decison for this Suggestion");
		System.out.println("1: Approved");
		System.out.println("2: Rejected");
		System.out.println("3: Exit");
		// can just do a swtich statement here
		int num = Scan.scan.nextInt(); Scan.scan.nextLine();
		switch(num){
			case 1:
				suggestion.setStatus(Status.ACCEPTED);
				break;
			case 2:
				suggestion.setStatus(Status.REJECTED);
				break; 
			default:
				System.out.println("Invalid Choice!");
				break;
		}
    }
}
