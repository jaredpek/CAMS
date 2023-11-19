package suggestion;

import message.Status;
import scan.Scan;

/**
 * Used by Staff to Approve or Reject a suggestion
 */
public class SuggestionApproveReject {
	/**
	 * It is used by staff to approve/edit a suggestion that was 
	 * directed to the camp that these staff are in charge of
	 * 
	 * @param suggestion The suggestion to update the status of
	 */
    public void ApproveReject(Suggestion suggestion){
        System.out.println("Actions");
		System.out.println("1 - Approve Suggestion");
		System.out.println("2 - Reject Suggestion");
		System.out.println("3 - Exit");
		// can just do a swtich statement here
		System.out.printf("Option: "); int num = Scan.scan.nextInt(); Scan.scan.nextLine();
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
