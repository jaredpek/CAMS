package camp_system.camp;

import java.util.ArrayList;

public class CampWithdraw {
    private CampSelect campSelect = new CampSelect();
    /**
     * Withdraws an attendee from a camp
     * @param user This is the user to withdraw
     */
    public void attendee(String user, ArrayList <Camp> registered) {
        Camp camp = campSelect.select(registered);
        if (camp != null) camp.removeAttendee(user);
    }
}
