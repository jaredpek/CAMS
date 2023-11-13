package camp_system.suggestion;
import java.util.ArrayList;
import java.util.Scanner;

import camp_system.camp.Camp;
import camp_system.camp.CampControl;
import camp_system.user.User;

public class SuggestionAdder{

    protected void add(ArrayList<Suggestion> global, User student, CampControl camps){
        Scanner sc = new Scanner(System.in);
		Suggestion s2 = new Suggestion();
		
		//ask which camp they want to add the suggestion to
		ArrayList<Camp> tempcamp = camps.getCommitteeCamps(student); //get registered camps		
		for (int i=0; i<tempcamp.size(); i++){
			System.out.printf("&d : ", i);
			System.out.println(tempcamp.get(i).getName());
		}
		System.out.println("Enter the index of the camp you want to add a suggestion to: ");
		int camp = sc.nextInt();

		//adding the suggestion
		s2.setUser(student); // need to get from main
		s2.setCamp(tempcamp.get(camp)); // from CampControl i think
		//s2.setStatus(Status Processing); already initialised
		System.out.println("Enter the suggestion you would like to make :");
		s2.setMessage(sc.next()); // suggestion has been set
		
        global.add(s2);  // add the new suggestion to the global suggestion array
		user.addPoint();
		
    }
    
}