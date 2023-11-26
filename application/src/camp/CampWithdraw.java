package camp;

import java.util.ArrayList;

/** 
 * Represents a class that handles withdrawls from the camp
 * @author Jared Pek
 */
public class CampWithdraw {
    /**
     * Withdraws an attendee from a camp
     * @param user This is the user to withdraw
     * @param registered This is the list of camps to select from
     */
    public void attendee(String user, ArrayList <Camp> registered) {
        Camp camp = (new CampSelect()).select(registered, user);
        if (camp != null) camp.removeAttendee(user);
    }
}
