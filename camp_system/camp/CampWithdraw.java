package camp_system.camp;

import java.util.ArrayList;

import camp_system.user.User;

public class CampWithdraw {
    private CampSelect campSelect = new CampSelect();
    /**
     * Withdraws an attendee from a camp
     * @param user This is the user to withdraw
     */
    public void attendee(User user, ArrayList <Camp> registered) {
        Camp camp = campSelect.select(registered);
        camp.removeAttendee(user);
    }
}
