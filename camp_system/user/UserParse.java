package camp_system.user;

import java.util.ArrayList;

import camp_system.csv_parser.CSVParse;

public class UserParse {
    public static ArrayList <User> parse(String file) {
        ArrayList <User> results = new ArrayList <User> ();
        try {
            ArrayList <String[]> campData = CSVParse.read(file);
            results = UserBuild.buildMany(campData);
        } catch (Exception e) {}
        return results;
    }
    public static ArrayList <User> parse(String file, Role role) {
        ArrayList <User> results = new ArrayList <User> ();
        try {
            ArrayList <String[]> campData = CSVParse.read(file);
            results = UserBuild.buildMany(campData, role);
        } catch (Exception e) {}
        return results;
    }

    public static void write(String file, ArrayList <User> users) {
        ArrayList <String> data = new ArrayList <String> ();
        for (User user : users) {
            data.add(
                user.getName() + "," +
                user.getUserID() + "," +
                user.getPassword() + "," +
                user.getFaculty() + "," +
                user.getRole()
            );
        }
        try {
            CSVParse.write(file, data);
        } catch (Exception e) {}
    }
}
