package user;

import java.util.ArrayList;

import csv_parser.CSVParse;
import date.DateParse;

/**
 * methods to read users  and write from the database
 * @author Qiang ZhiQin
 */
public class UserParse {
    /**
     * Builds an arraylist of user objects from a CSV file
     * @param file The CSV file to parse as user data
     * @return Arraylist of new user objects
     */
    public ArrayList <User> parse(String file) {
        ArrayList <User> results = new ArrayList <User> ();
        try {
            ArrayList <String[]> campData = CSVParse.read(file);
            results = (new UserBuild()).buildMany(campData);
        } catch (Exception e) {}
        return results;
    }
    /**
     * Builds an arraylist of user objects of a specific role based on a CSV file
     * @param file The path to the CSV file
     * @param role The role to create the students for
     * @return Arraylist of new user objects
     */
    public ArrayList <User> parse(String file, Role role) {
        ArrayList <User> results = new ArrayList <User> ();
        try {
            ArrayList <String[]> campData = CSVParse.read(file);
            results = (new UserBuild()).buildMany(campData, role);
        } catch (Exception e) {}
        return results;
    }
    /**
     * A method to write the data to a new csv file
     * @param file file name
     * @param users the array list that contains all users
     */
    public void write(String file, ArrayList <User> users) {
        ArrayList <String> data = new ArrayList <String> ();
        for (User user : users) {
            data.add(
                user.getName() + "," +
                user.getUserID() + "," +
                user.getPassword() + "," +
                user.getFaculty() + "," +
                user.getRole() + "," +
                DateParse.string(user.getLastLogin())
            );
        }
        try {
            CSVParse.write(file, data);
        } catch (Exception e) {}
    }
}
