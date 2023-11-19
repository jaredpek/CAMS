package user;

import java.util.ArrayList;

public class UserControl implements IUser {
    private static ArrayList <User> users = new ArrayList <User> ();
    public static UserControl userControl = new UserControl();

    public static void start() {
        users.addAll(UserParse.parse(".\\application\\data\\users.csv"));
    }

    public static void startCSV() {
        users.addAll(UserParse.parse(".\\application\\data\\original\\students.csv", Role.STUDENT));
        users.addAll(UserParse.parse(".\\application\\data\\original\\staffs.csv", Role.STAFF));
    }

    public static void close() {
        UserParse.write(".\\data\\users.csv", users);
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
        UserPassword.reset(user);
    }
}
