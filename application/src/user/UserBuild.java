package user;

import java.util.ArrayList;
import java.util.Date;

import date.DateParse;
import interfaces.IBuild;

/**
 * A class that build new user to an arraylist
 */
public class UserBuild implements IBuild {
    /**
     * Builds a new user object based on a list of strings
     * @param data The list of strings to parse
     * @return A new user object
     */
    public User build(String[] data) {
        if (data.length < 5) return null;
        String name = data[0];
        String userID = data[1];
        String password = data[2];
        Faculty faculty = Faculty.fromString(data[3]);
        Role role = Role.fromString(data[4]);
        Date lastLogin = DateParse.date(data[5]);

        if (name == null || userID == null || faculty == null) return null;
        return new User(name, userID, password, faculty, role, lastLogin);
    }
    /**
     * Builds a new user object based on a list of strings
     * @param data The list of strings to parse
     * @param role The user's role to be created
     * @return A new user object
     */
    public User build(String[] data, Role role) {
        if (data.length < 3) return null;
        String name = data[0];
        String userID = data[1].split("@")[0];
        Faculty faculty = Faculty.fromString(data[2]); // Convert the string to the Faculty enum

        if (name == null || userID == null || faculty == null) return null;
        return new User(name, userID, faculty, role);
    }
    /**
     * Builds an arraylist of user objects
     * @param userData An arraylist of a list of strings to parse as user data
     * @return An arraylist of user objects
     */
    public ArrayList <User> buildMany(ArrayList <String[]> userData) {
        ArrayList <User> users = new ArrayList <User> ();
        for (String[] data : userData) {
            User user = build(data);
            if (user == null) continue;
            users.add(user);
        }
        return users;
    }
    /**
     * Builds an arraylist of user objects
     * @param userData An arraylist of a list of strings to parse as user data
     * @param role The role to create the user for
     * @return An arraylist of user objects
     */
    public ArrayList <User> buildMany(ArrayList <String[]> userData, Role role) {
        ArrayList <User> users = new ArrayList <User> ();
        for (String[] data : userData) {
            User user = build(data, role);
            if (user == null) continue;
            users.add(user);
        }
        return users;
    }
}
