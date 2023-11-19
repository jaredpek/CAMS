package camp;

import java.util.ArrayList;

import date_parser.DateParse;
import scanner.Scan;
import user.Faculty;

/** Represents a filter class that filters a list of camps based on certain requirements */
public class CampFilter {
    /** The filter methods available to the user */
    public static void filterMenu() {
        System.out.println("Select Filter Field:");
        System.out.println("1: Group");
        System.out.println("2: Location");
        System.out.println("3: Start after Specific Date");
        System.out.println("4: End before Specific Date");
        System.out.println("5: None (Default)");
    }

    /**
     * Filters a list of camps by a specified group
     * @param camps List of camps to filter
     * @param group Specified group to filter by
     * @return ArrayList
     */
    public static ArrayList <Camp> filterByGroup(ArrayList <Camp> camps, Faculty group) {
        ArrayList <Camp> result = new ArrayList <Camp> ();
        for (Camp camp: camps) {
            if (camp.getGroup() == group) {
                result.add(camp);
            }
        }
        return result;
    }
    
    /**
     * Filters a list of camps by a specified location
     * @param camps List of camps to filter
     * @param location Specified location to filter by
     * @return ArrayList
     */
    public static ArrayList <Camp> filterByLocation(ArrayList <Camp> camps, String location) {
        ArrayList <Camp> result = new ArrayList <Camp> ();
        for (Camp camp: camps) {
            if (camp.getLocation().toLowerCase() == location.toLowerCase()) {
                result.add(camp);
            }
        }
        return result;
    }
    
    /**
     * Filters a list of camps by a specified start date
     * @param camps List of camps to filter
     * @param startDate Specified start date to filter by
     * @return ArrayList
     */
    public static ArrayList <Camp> filterByStartDate(ArrayList <Camp> camps, String startDate) {
        ArrayList <Camp> result = new ArrayList <Camp> ();
        for (Camp camp: camps) {
            if (camp.getStartDate().compareTo(DateParse.date(startDate)) > 0) {
                result.add(camp);
            }
        }
        return result;
    }
    
    /**
     * Filters a list of camps by a specified end date
     * @param camps List of camps to filter
     * @param endDate Specified end date to filter by
     * @return ArrayList
     */
    public static ArrayList <Camp> filterByEndDate(ArrayList <Camp> camps, String endDate) {
        ArrayList <Camp> result = new ArrayList <Camp> ();
        for (Camp camp: camps) {
            if (camp.getEndDate().compareTo(DateParse.date(endDate)) < 0) {
                result.add(camp);
            }
        }
        return result;
    }
    
    /**
     * Filters a list of camps based on a selected attribute
     * @param camps List of camps to filter
     * @param option Camp attribute to filter by
     * @return ArrayList
     */
    public static ArrayList <Camp> filterCamps(ArrayList <Camp> camps) {
        filterMenu();
        System.out.printf("Filter Option: "); int option = Scan.scan.nextInt();
        switch (option) {
            case 1: {
                System.out.printf("Enter Group: "); String group = Scan.scan.nextLine();
                return filterByGroup(camps, Faculty.fromString(group));
            }
            case 2: {
                System.out.printf("Enter Location: "); String location = Scan.scan.nextLine();
                return filterByLocation(camps, location);
            }
            case 3: {
                System.out.printf("Enter Start Date: "); String startDate = Scan.scan.nextLine();
                return filterByStartDate(camps, startDate);
            }
            case 4: {
                System.out.printf("Enter End Date: "); String endDate = Scan.scan.nextLine();
                return filterByEndDate(camps, endDate);
            }
            default: return camps;
        }
    }
}
