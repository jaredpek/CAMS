package camp_system.suggestion;
import java.util.ArrayList;
import java.util.Scanner;

public class SuggestionDeleter{
    protected void delete(SuggestionControl global, ){
        //get all suggestions
		// ask which one they want to delete
		ArrayList<Suggestion> temp = getSuggestions(student); // all suggestions by this student
		
		for (int i=0; i<temp.size(); i++) {
			System.out.printf("&d : ", i);
			temp.get(i).printSuggestion();
		}
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the index of the suggestion you want to delete"); int num = sc.nextInt();
		
		this.suggestionList.remove(temp.get(num)); // removes the specific suggestion from global list
		
    }
}