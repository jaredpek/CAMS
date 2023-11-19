package camp;

import java.util.ArrayList;

import date.DateParse;

/** Represents a display class that is responsible for printing the camps */
public class CampDisplay {
    /** This is the table header to be printed */
    public void header() {
        System.out.printf("CAMPS "); for (int i = 0; i < 26; i ++) System.out.printf("-");
        System.out.printf("%s", " |       Vacancies      | "); 
        for (int i = 0; i < 100; i ++) System.out.printf("-"); System.out.println();

        System.out.printf("%-2s |", "ID");
        System.out.printf(" %-9s |", "Role");
        System.out.printf(" %-15s |", "Name");
        System.out.printf(" %-8s |", "Attendee");
        System.out.printf(" %-9s |", "Committee");
        System.out.printf(" %-17s |", "Start Date");
        System.out.printf(" %-17s |", "End Date");
        System.out.printf(" %-17s |", "Register By");
        System.out.printf(" %-6s |", "Group");
        System.out.printf(" %-15s |", "Location");
        System.out.printf(" %s\n", "Description");
    }
    /**
     * Prints the details of the camp
     * @param camp This is the camp to print
     * @param user This is the user printing the camp details
     */
    public void camp(Camp camp, String user) {
        if (camp == null) return;
        Role role = camp.getCampRole(user);
        System.out.printf(" %-9s |", (role != null) ? role : "");
        System.out.printf(" %-15s |", camp.getName());
        System.out.printf(" %-8s |", (camp.getTotalSlots() - camp.getCommitteeSlots() - camp.getAttendeeList().size()));
        System.out.printf(" %-9s |", (camp.getCommitteeSlots() - camp.getCommitteeList().size()));
        System.out.printf(" %-17s |", DateParse.string(camp.getStartDate()));
        System.out.printf(" %-17s |", DateParse.string(camp.getEndDate()));
        System.out.printf(" %-17s |", DateParse.string(camp.getRegisterBy()));
        System.out.printf(" %-6s |", camp.getGroup());
        System.out.printf(" %-15s |", camp.getLocation());
        System.out.printf(" %s\n", camp.getDescription());
    }
    /**
     * Prints the provided camp objects in the standardized format 
     * @param camps This is the list of camps to print
     * @param user This is the user printing the camps
     */
    public void camps(ArrayList <Camp> camps, String user) {
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
     * @param camp This is the selected camp
     */
    public void roles(Camp camp) {
        if (camp == null) return;
        ArrayList <String> committeeList = camp.getCommitteeList();
        ArrayList <String> attendeeList = camp.getAttendeeList();

        System.out.printf("Total Slots = %d\n", camp.getTotalSlots());
        System.out.printf("Committee (%d / %d)\n", committeeList.size(), camp.getCommitteeSlots());
        for (String user : committeeList) System.out.println(user);

        System.out.printf("Attendee (%d / %d)\n", attendeeList.size(), camp.getTotalSlots() - camp.getCommitteeSlots());
        for (String user : attendeeList) System.out.println(user);
    }
}
