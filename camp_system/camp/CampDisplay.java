package camp_system.camp;

import java.util.ArrayList;

import camp_system.user.User;

public class CampDisplay {
    /**
     * Prints the provided camp objects in the standardized format 
     * @param camps This is the list of camps to print
     */
    public static void printCamps(ArrayList <Camp> camps) {
        if (camps.size() <= 0) {
            System.out.println("No Camps Found");
            return;
        }
        for (int i = 0; i < camps.size(); i ++) {
            System.out.printf("%d -> ", (i + 1));
            camps.get(i).printCampDetails();
            System.out.println();
        }
    }

    public static void printCamps(ArrayList <Camp> camps, User user) {
        if (camps.size() <= 0) {
            System.out.println("No Camps Found");
            return;
        }
        for (int i = 0; i < camps.size(); i ++) {
            System.out.printf("%d -> ", (i + 1));
            camps.get(i).printCampDetails(user.getUserID());
            System.out.println();
        }
    }

    /**
     * Prints the roles of all the students in the specified camp
     * @param camps This is the list of camps to select from
     */
    public static void printRoles(Camp camp) {
        camp.printRoles();
    }
}
