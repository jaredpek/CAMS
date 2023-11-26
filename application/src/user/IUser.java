package user;

/** 
 * Represents an interface that UserControl must implement
 * @author Qiang ZhiQin
 */
public interface IUser {
    /**
     * Authenticates a user using userId and password
     * @param userID The userID of the student
     * @param password The password entry of the student
     * @return The user object for current logged-in user
     */
    public User login(String userID, String password);
    /** 
     * Resets the password of the current user 
     * @param user The user to reset password for
     */
    public void resetPassword(User user);
}
