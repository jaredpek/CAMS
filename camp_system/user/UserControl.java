package camp_system.user;

import java.util.ArrayList;

public class UserControl {
    private ArrayList <User> users = new ArrayList <User> ();
    private UserPassword userPassword = new UserPassword();
    private UserParse userParse = new UserParse();

    /** Creates a new CampControl object with a default empty list */
    public UserControl() {
        users.addAll(userParse.parse("camp_system\\data\\users.csv", Role.STUDENT));
        users.addAll(userParse.parse("camp_system\\data\\users.csv", Role.STAFF));
    }

    public void close() {
        userParse.write("camp_system\\data\\users.csv", users);
    }
    
    /**
     * return an arraylist of users
     * @return ArrayList
     */
    public ArrayList<User> getUsers() {
        return users;
    }

    /**
     * to authenticate user
     * @param userID this is the user's ID
     * @param password this is the user's password
     * @return User
     */
    public User login(String userID, String password) {
        for (User user : users) {
            // Check if the user ID and password match.
            if (user.verifyCredentials(userID, password)) {
                // Return the user object.
                return user;
            }
        }
        // If the user ID and password do not match, return null.
        return null;
    }

    public void resetPassword(User user) {
        userPassword.reset(user);
    }
}
