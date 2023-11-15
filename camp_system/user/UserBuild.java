package camp_system.user;

import java.util.ArrayList;

public class UserBuild {
    public User build(String[] data, Role role) {
        if (data.length < 3) return null;
        String name = data[0];
        String userID = data[1].split("@")[0];
        Faculty faculty = Faculty.fromString(data[2]); // Convert the string to the Faculty enum

        if (name == null || userID == null || faculty == null) return null;
        return new User(name, userID, faculty, role);
    }

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
