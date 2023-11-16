package camp_system.user;

import java.util.ArrayList;
/**
 * A class that build new user to an arraylist
 */
public class UserBuild {
    public static User build(String[] data) {
        if (data.length < 5) return null;
        String name = data[0];
        String userID = data[1];
        String password = data[2];
        Faculty faculty = Faculty.fromString(data[3]);
        Role role = Role.fromString(data[4]);

        if (name == null || userID == null || faculty == null) return null;
        return new User(name, userID, password, faculty, role);
    }

    public static User build(String[] data, Role role) {
        if (data.length < 3) return null;
        String name = data[0];
        String userID = data[1].split("@")[0];
        Faculty faculty = Faculty.fromString(data[2]); // Convert the string to the Faculty enum

        if (name == null || userID == null || faculty == null) return null;
        return new User(name, userID, faculty, role);
    }

    public static ArrayList <User> buildMany(ArrayList <String[]> userData) {
        ArrayList <User> users = new ArrayList <User> ();
        for (String[] data : userData) {
            User user = build(data);
            if (user == null) continue;
            users.add(user);
        }
        return users;
    }

    public static ArrayList <User> buildMany(ArrayList <String[]> userData, Role role) {
        ArrayList <User> users = new ArrayList <User> ();
        for (String[] data : userData) {
            User user = build(data, role);
            if (user == null) continue;
            users.add(user);
        }
        return users;
    }
}
