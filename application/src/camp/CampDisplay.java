package camp;

import java.util.ArrayList;

/** Represents a display class that is responsible for printing the camps */
public class CampDisplay {
    public static void header() {
        System.out.println("Camps");
        for (int i = 0; i < 220; i ++) System.out.printf("-"); System.out.println();
        System.out.printf("%-2s |", "ID");
        System.out.printf(" %-9s |", "Role");
        System.out.printf(" %-15s |", "Name");
        System.out.printf(" %-8s |", "Attendee");
        System.out.printf(" %-9s |", "Committee");
        System.out.printf(" %-29s |", "Start Date");
        System.out.printf(" %-29s |", "End Date");
        System.out.printf(" %-29s |", "Register By");
        System.out.printf(" %-6s |", "Group");
        System.out.printf(" %-15s |", "Location");
        System.out.printf(" %s\n", "Description");
    }
    /**
     * Prints the details of the camp
     * @param user This is the user object printing the camp details
     */
    public static void camp(Camp camp, String user) {
        Role role = camp.getCampRole(user);
        System.out.printf(" %-9s |", (role != null) ? role : "");
        System.out.printf(" %-15s |", camp.getName());
        System.out.printf(" %-8s |", (camp.getTotalSlots() - camp.getCommitteeSlots() - camp.getAttendeeList().size()));
        System.out.printf(" %-9s |", (camp.getCommitteeSlots() - camp.getCommitteeList().size()));
        System.out.printf(" %-29s |", camp.getStartDate().toString());
        System.out.printf(" %-29s |", camp.getEndDate().toString());
        System.out.printf(" %-29s |", camp.getRegisterBy().toString());
        System.out.printf(" %-6s |", camp.getGroup());
        System.out.printf(" %-15s |", camp.getLocation());
        System.out.printf(" %s\n", camp.getDescription());
    }
    /**
     * Prints the provided camp objects in the standardized format 
     * @param camps This is the list of camps to print
     */
    public static void camps(ArrayList <Camp> camps, String user) {
        if (camps.size() <= 0) {
            System.out.println("No Camps Found");
            return;
        }
        header();
        for (int i = 0; i < camps.size(); i ++) {
            System.out.printf("%-2d |", (i + 1));
            camp(camps.get(i), user);
        }
    }

    /**
     * Prints the roles of all the students in the specified camp
     * @param camps This is the list of camps to select from
     */
    public static void roles(Camp camp) {
        camp.printRoles();
    }
}
