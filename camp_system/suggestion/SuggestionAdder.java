package camp_system.suggestion;
import java.util.ArrayList;
import java.util.Scanner;

public class SuggestionAdder{
    protected void add(SuggestionControl global){
        Scanner sc = new Scanner(System.in);
		Suggestion s2 = new Suggestion();

		s2.setStudent(Student); // need to get from main
		s2.setCamp(getCamps(student)); // from CampControl i think
		//s2.setStatus(Status Processing); already initialised
		System.out.println("Enter the suggestion you would like to make :");
		s2.setMessage(sc.next()); // suggestion has been set
		
        global.add(s2)  // add the new suggestion to the global suggestion array
		
    }
    
}