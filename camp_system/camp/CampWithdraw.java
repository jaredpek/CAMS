package camp_system.camp;

import java.util.ArrayList;

public class CampWithdraw {
    /**
     * Withdraws an attendee from a camp
     * @param user This is the user to withdraw
     */
    public static void attendee(String user, ArrayList <Camp> registered) {
        Camp camp = CampSelect.select(registered);
        if (camp != null) camp.removeAttendee(user);
    }
}
