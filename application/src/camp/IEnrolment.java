package camp;

import user.User;

/** 
 * An interface that represents the required methods for camp participant management
 * @author Jared Pek
 */
public interface IEnrolment {
    /** A CampEnrol object */
    public CampEnrol campEnrol = new CampEnrol();
    /** A CampWithdraw object */
    public CampWithdraw campWithdraw = new CampWithdraw();
    /**
     * Registers a user to the camp
     * @param user The user to register to the camp
     */
    public void registerCamp(User user);
    /**
     * Withdraws a user from the camp
     * @param user The user to withdraw from the camp
     */
    public void withdrawAttendee(User user);
}
