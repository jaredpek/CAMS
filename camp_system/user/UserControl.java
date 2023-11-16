package camp_system.user;

import java.util.ArrayList;

public class UserControl {
    private static ArrayList <User> users = new ArrayList <User> ();

    public static void start() {
        users.addAll(UserParse.parse("camp_system\\data\\users.csv"));
    }

    public static void startCSV() {
        users.addAll(UserParse.parse("camp_system\\data\\original\\students.csv", Role.STUDENT));
        users.addAll(UserParse.parse("camp_system\\data\\staffs.csv", Role.STAFF));
    }

    public static void close() {
        UserParse.write("camp_system\\data\\users.csv", users);
    }
    
    /**
     * return an arraylist of users
     * @return ArrayList
     */
    public static ArrayList<User> getUsers() {
        return users;
    }

    /**
     * to authenticate user
     * @param userID this is the user's ID
     * @param password this is the user's password
     * @return User
     */
    public static User login(String userID, String password) {
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

    public static void resetPassword(User user) {
        UserPassword.reset(user);
    }
}
