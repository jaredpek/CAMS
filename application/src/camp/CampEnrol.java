package camp;

import java.util.ArrayList;

import input.integer.IntInput;

/** 
 * Represents a class that handles the enrolment to the camp
 * @author Jared Pek
 */
public class CampEnrol {
    /**
     * Registers an attendee to a camp
     * @param user This is the user to register
     * @param available This is the list of camps open to the user
     */
    public void attendee(String user, ArrayList <Camp> available) {
        Camp camp = (new CampSelect()).select(available, user);
        if (camp != null) camp.addAttendee(user);
    }

    /**
     * Registers a committee member to a camp
     * @param user This is the user to register
     * @param available This is the list of camps open to the user
     */
    public void committee(String user, ArrayList <Camp> available) {
        for (Camp camp : available) {
            if (camp.enrolledCommittee(user)) {
                System.out.printf("Already a committee member of '%s'\n", camp.getName());
                return;
            }
        }
        Camp toEnrol = (new CampSelect()).select(available, user);
        if (toEnrol != null) toEnrol.addCommittee(user);
    }

    /** These are the roles available to students */
    private void menu() {
        System.out.println("Available Roles:");
        System.out.println("1 - Attendee");
        System.out.println("2 - Committee");
    }
    /**
     * Registers a user to a camp, user can select whether or not to enrol as attendee or committee
     * @param user This is the user to register
     * @param available This is the list of camps open to the user
     */
    public void register(String user, ArrayList <Camp> available) {
        menu();
        int option = IntInput.integer("Option");
        switch (option) {
            case 1: attendee(user, available); break;
            case 2: committee(user, available); break;
            default: break;
        }
    }
}
