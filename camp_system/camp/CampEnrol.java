package camp_system.camp;

import java.util.ArrayList;

import camp_system.scanner.Scan;

public class CampEnrol {
    /**
     * Registers an attendee to a camp
     * @param user This is the user to register
     */
    public static void attendee(String user, ArrayList <Camp> available) {
        Camp camp = CampSelect.select(available);
        if (camp != null) camp.addAttendee(user);
    }

    /**
     * Registers a committee member to a camp
     * @param user This is the user to register
     */
    public static void committee(String user, ArrayList <Camp> available) {
        for (int i = 0; i < available.size(); i ++) {
            if (available.get(i).enrolledCommittee(user)) return;
        }
        Camp camp = CampSelect.select(available);
        if (camp != null) camp.addCommittee(user);
    }

    private static void menu() {
        System.out.println("Available Roles:");
        System.out.println("1: Attendee");
        System.out.println("2: Committee");
    }
    /**
     * Registers a user to a camp, user can select whether or not to enrol as attendee or committee
     * @param user This is the user to register
     */
    public static void register(String user, ArrayList <Camp> available) {
        menu();
        System.out.printf("Enter Option: "); int option = Scan.scan.nextInt(); Scan.scan.nextLine();
        switch (option) {
            case 1: attendee(user, available); break;
            case 2: committee(user, available); break;
        }
    }
}
