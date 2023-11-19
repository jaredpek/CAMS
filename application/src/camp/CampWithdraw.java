package camp;

import java.util.ArrayList;

/** Represents a class that handles withdrawls from the camp */
public class CampWithdraw {
    /**
     * Withdraws an attendee from a camp
     * @param user This is the user to withdraw
     */
    public static void attendee(String user, ArrayList <Camp> registered) {
        Camp camp = CampSelect.select(registered, user);
        if (camp != null) camp.removeAttendee(user);
    }
}
