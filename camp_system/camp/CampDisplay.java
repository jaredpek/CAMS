package camp_system.camp;

import java.util.ArrayList;
import java.util.Scanner;

public class CampDisplay {
    public static Scanner scan = new Scanner(System.in);
    /**
     * Prints the provided camp objects in the standardized format 
     * @param camps This is the list of camps to print
     */
    public void printCamps(ArrayList <Camp> camps) {
        if (camps.size() <= 0) {
            System.out.println("No Camps Found");
            return;
        }
        for (int i = 0; i < camps.size(); i ++) {
            System.out.printf((i + 1) + " -> ");
            camps.get(i).printCampDetails();
            System.out.println();
        }
    }

    /**
     * Prints the roles of all the students in the specified camp
     * @param camps This is the list of camps to select from
     */
    public void printRoles(ArrayList <Camp> camps) {
        printCamps(camps);
        System.out.printf("Enter Camp Option: "); int option = scan.nextInt(); scan.nextLine();
        camps.get(option).printRoles();
    }
}
