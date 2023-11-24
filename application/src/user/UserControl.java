package user;

import java.util.ArrayList;

/** The control class for user objects */
public class UserControl implements IUser {
    /** The list of user objects */
    private static ArrayList <User> users = new ArrayList <User> ();

    /** Static instance to UserControl */
    public static UserControl instance = new UserControl();

    /** Initialise the list of users from CSV file */
    public static void start() {
        users.addAll((new UserParse()).parse("application\\data\\users.csv"));
    }

    /** Writes the list of users to CSV file */
    public static void close() {
        (new UserParse()).write("application\\data\\users.csv", users);
    }

    /** 
     * Prompts the user to reset his password if first login
     * @param user The user to prompt a password reset
     */
    private void promptReset(User user) {
        if (user.getLastLogin() != null) return;
        System.out.println("Please reset your default password");
        resetPassword(user);
    }

    /**
     * to authenticate user
     * @param userID this is the user's ID
     * @param password this is the user's password
     * @return user object for the user that is logged in
     */
    public User login(String userID, String password) {
        for (User user : users) {
            // Check if the user ID and password match.
            if (user.verifyCredentials(userID, password)) {
                promptReset(user);
                user.updateLastLogin();
                return user;
            }
        }
        // If the user ID and password do not match, return null.
        //System.out.println("Invalid UserID or password. Please try again.");
        return null;
    }

    /** 
     * Resets the password of a specific user
     * @param user The user to reset password for
     */
    public void resetPassword(User user) {
        UserPassword.reset(user);
    }
}
