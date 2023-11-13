package camp_system.suggestion;
import java.util.ArrayList;
import java.util.Scanner;

import camp_system.camp.Camp;

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
    protected void ApproveDelete(ArrayList<Suggestion> global, Camp camp){
        ArrayList<Suggestion> temp = new ArrayList<Suggestion>();
		for (int i=0; i<global.size(); i++) {
			if (global.get(i).getCamp() == camp) {
				temp.add(global.get(i));
			}
		}
		
		for (int i=0; i<temp.size();i++) {
			System.out.printf("&d : ", i);
			temp.get(i).printSuggestion();
		}

		System.out.println("Enter the Index of the Suggestion to Approve/Reject");
		System.out.println("Enter -1 to exit the Approve/Rejects Suggestion Menu");
		
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		while (num >= temp.size()) { // edge case
			System.out.println("Please enter a valid index!");
			num = sc.nextInt(); // if they input valid index, exit on next iteration
		}
		if (num >=0 || num < temp.size()){
			// prompt the user for their decision abot the suggestion
			decide(temp, num);
		}	
		sc.close();								
    }
	/**
	 * Extension of the previous method, but split for cleaner implementation
	 * 
	 * @param temp the list of suggestions that was directed to the camp that the staff is a part of
	 * @param index the index of the suggestion that the staff wants to approve/reject
	 */
	private void decide(ArrayList<Suggestion> temp, int index){

		
		System.out.println("What is your decison for this Suggestion");
		System.out.println("1: Approved");
		System.out.println("2: Rejected");
		System.out.println("3: Exit");
		// can just do a swtich statement here
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		do{
			switch(num){
				case 1:
					Status s = Status.ACCEPTED;
					// set status of suggestion to approved
					temp.get(index).setStatus(s);
					temp.get(num).getUser().addPoint();
					// add point for the suggestion being accepted
					break;
				case 2:
					Status r = Status.REJECTED;
					// set status of suggestion to rejected
					temp.get(index).setStatus(r);
					break; 
				default:
				System.out.println("Invalid Choice!");
				break;
			}
		} while (num != 3);

		sc.close();
	}
}
