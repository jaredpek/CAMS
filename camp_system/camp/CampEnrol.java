package camp_system.camp;

import java.util.ArrayList;

import camp_system.application.IBase;
import camp_system.user.User;

public class CampEnrol implements IBase {
    public CampDisplay campDisplay = new CampDisplay();
    public CampSelect campSelect = new CampSelect();
    /**
     * Registers an attendee to a camp
     * @param user This is the user to register
     */
    public void attendee(User user, ArrayList <Camp> available) {
        Camp camp = campSelect.select(available);
        camp.addAttendee(user);
    }

    /**
     * Registers a committee member to a camp
     * @param user This is the user to register
     */
    public void committee(User user, ArrayList <Camp> available) {
        for (int i = 0; i < available.size(); i ++) {
            if (available.get(i).enrolledCommittee(user)) return;
        }
        Camp camp = campSelect.select(available);
        camp.addCommittee(user);
    }

    private void menu() {
        System.out.println("Available Roles:");
        System.out.println("1: Attendee");
        System.out.println("2: Committee");
    }
    /**
     * Registers a user to a camp, user can select whether or not to enrol as attendee or committee
     * @param user This is the user to register
     */
    public void register(User user, ArrayList <Camp> available) {
        menu();
        System.out.printf("Enter Option: "); int option = scan.nextInt(); scan.nextLine();
        switch (option) {
            case 1: attendee(user, available); break;
            case 2: committee(user, available); break;
        }
    }
}
