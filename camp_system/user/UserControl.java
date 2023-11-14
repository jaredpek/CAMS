package camp_system.user;

import java.util.ArrayList;

import camp_system.csv_parser.CSVParse;

public class UserControl {
    private ArrayList<User> users;
    private UserBuild userBuild = new UserBuild();
    private UserPassword userPassword = new UserPassword();
    private CSVParse csvParse = new CSVParse();

    public UserControl() {
        users = new ArrayList <User> ();
        ArrayList <String[]> studentData = csvParse.read("camp_system\\data\\students.csv");
        ArrayList <String[]> staffData = csvParse.read("camp_system\\data\\staffs.csv");
        users.addAll(userBuild.buildMany(studentData, Role.STUDENT));
        users.addAll(userBuild.buildMany(staffData, Role.STAFF));
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
    


