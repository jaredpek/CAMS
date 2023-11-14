package camp_system.suggestion;

import camp_system.IBase;

/**
 * Used by Staff to Approve or Reject a suggestion
 */
public class SuggestionApprove implements IBase {
	/**
	 * It is used by staff to approve/edit a suggestion that was 
	 * directed to the camp that these staff are in charge of
	 * 
	 * @param global the arraylist which contains all the suggestions
	 * @param camp the camp that the Staff is in charge of
	 */
    public void ApproveDelete(Suggestion suggestion){
        System.out.println("What is your decison for this Suggestion");
		System.out.println("1: Approved");
		System.out.println("2: Rejected");
		System.out.println("3: Exit");
		// can just do a swtich statement here
		int num = scan.nextInt(); scan.nextLine();
		do{
			switch(num){
				case 1:
					Status s = Status.ACCEPTED;
					// set status of suggestion to approved
					suggestion.setStatus(s);
					suggestion.getUser().addPoint();
					// add point for the suggestion being accepted
					break;
				case 2:
					Status r = Status.REJECTED;
					// set status of suggestion to rejected
					suggestion.setStatus(r);
					break; 
				default:
				System.out.println("Invalid Choice!");
				break;
			}
		} while (num != 3);			
    }
}
