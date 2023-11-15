package camp_system.user;

import java.util.ArrayList;

import camp_system.csv_parser.CSVParse;

public class UserParse {
    private CSVParse csvParse = new CSVParse();
    private UserBuild userBuild = new UserBuild();

    public ArrayList <User> parse(String file, Role role) {
        ArrayList <User> results = new ArrayList <User> ();
        try {
            ArrayList <String[]> campData = csvParse.read(file);
            results = userBuild.buildMany(campData, role);
        } catch (Exception e) {}
        return results;
    }

    public void write(String file, ArrayList <User> users) {
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
            csvParse.write(file, data);
        } catch (Exception e) {}
    }
}
