package camp_system.camp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import camp_system.user.Faculty;

/**
 * Represents a filter and sorter class that modifies a list of camps based on certain requirements and in a specified order
 */
public class CampFilter {
    public Scanner scan = new Scanner(System.in);

    public static SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
    public static Date date(String source) throws ParseException {
        return dateFormatter.parse(source);
    }

    public void filterMenu() {
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
    public ArrayList <Camp> filterByGroup(ArrayList <Camp> camps, Faculty group) {
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
    public ArrayList <Camp> filterByLocation(ArrayList <Camp> camps, String location) {
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
    public ArrayList <Camp> filterByStartDate(ArrayList <Camp> camps, String startDate) throws ParseException {
        ArrayList <Camp> result = new ArrayList <Camp> ();
        for (Camp camp: camps) {
            if (camp.getStartDate().compareTo(date(startDate)) > 0) {
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
    public ArrayList <Camp> filterByEndDate(ArrayList <Camp> camps, String endDate) throws ParseException {
        ArrayList <Camp> result = new ArrayList <Camp> ();
        for (Camp camp: camps) {
            if (camp.getEndDate().compareTo(date(endDate)) < 0) {
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
    public ArrayList <Camp> filterCamps(ArrayList <Camp> camps, int option) throws ParseException {
        switch (option) {
            case 1: {
                System.out.printf("Enter Group: "); String group = scan.nextLine();
                return filterByGroup(camps, Faculty.fromString(group));
            }
            case 2: {
                System.out.printf("Enter Location: "); String location = scan.nextLine();
                return filterByLocation(camps, location);
            }
            case 3: {
                System.out.printf("Enter Start Date: "); String startDate = scan.nextLine();
                return filterByStartDate(camps, startDate);
            }
            case 4: {
                System.out.printf("Enter End Date: "); String endDate = scan.nextLine();
                return filterByEndDate(camps, endDate);
            }
            default: return camps;
        }
    }

    public void sortMenu() {
        System.out.println("Select Sort Method:");
        System.out.println("1: Group");
        System.out.println("2: Location");
        System.out.println("3: Start Date");
        System.out.println("4: End Date");
        System.out.println("5: Alphabetical Order (Default)");
    }
    public void orderMenu() {
        System.out.println("Select Order:");
        System.out.println("1: Ascending (Default)");
        System.out.println("2: Descending");
    }

    /**
     * Sorts a list of camps by the group
     * @param camps List of camps to sort
     * @param orderOption Order of camps to sort by (1 = Ascending, Others = Descneding)
     * @return
     */
    public ArrayList <Camp> sortByGroup(ArrayList <Camp> camps, int orderOption) {
        switch (orderOption) {
            case 1: camps.sort((camp1, camp2) -> camp1.getGroup().toString().compareTo(camp2.getGroup().toString())); break;
            default: camps.sort((camp1, camp2) -> - camp1.getGroup().toString().compareTo(camp2.getGroup().toString())); break;
        }
        return camps;
    }
    
    /**
     * Sorts a list of camps by the location
     * @param camps List of camps to sort
     * @param orderOption Order of camps to sort by (1 = Ascending, Others = Descneding)
     * @return
     */
    public ArrayList <Camp> sortByLocation(ArrayList <Camp> camps, int orderOption) {
        switch (orderOption) {
            case 1: camps.sort((camp1, camp2) -> camp1.getLocation().toLowerCase().compareTo(camp2.getLocation().toLowerCase())); break;
            default: camps.sort((camp1, camp2) -> - camp1.getLocation().toLowerCase().compareTo(camp2.getLocation().toLowerCase())); break;
        }
        return camps;
    }
    
    /**
     * Sorts a list of camps by the start date
     * @param camps List of camps to sort
     * @param orderOption Order of camps to sort by (1 = Ascending, Others = Descneding)
     * @return
     */
    public ArrayList <Camp> sortByStartDate(ArrayList <Camp> camps, int orderOption) {
        switch (orderOption) {
            case 1: camps.sort((camp1, camp2) -> camp1.getStartDate().compareTo(camp2.getStartDate())); break;
            default: camps.sort((camp1, camp2) -> - camp1.getStartDate().compareTo(camp2.getStartDate())); break;
        }
        return camps;
    }
    
    /**
     * Sorts a list of camps by the end date
     * @param camps List of camps to sort
     * @param orderOption Order of camps to sort by (1 = Ascending, Others = Descneding)
     * @return
     */
    public ArrayList <Camp> sortByEndDate(ArrayList <Camp> camps, int orderOption) {
        switch (orderOption) {
            case 1: camps.sort((camp1, camp2) -> camp1.getEndDate().compareTo(camp2.getEndDate())); break;
            default: camps.sort((camp1, camp2) -> - camp1.getEndDate().compareTo(camp2.getEndDate())); break;
        }
        return camps;
    }

    /**
     * Sorts a list of camps in alphabetical order
     * @param camps List of camps to sort
     * @param orderOption Order of camps to sort by (1 = Ascending, Others = Descneding)
     * @return
     */
    public ArrayList <Camp> sortByAlphabetical(ArrayList <Camp> camps, int orderOption) {
        switch (orderOption) {
            case 1: camps.sort((camp1, camp2) -> camp1.getName().toLowerCase().compareTo(camp2.getName().toLowerCase())); break;
            default: camps.sort((camp1, camp2) -> - camp1.getName().toLowerCase().compareTo(camp2.getName().toLowerCase())); break;
        }
        return camps;
    }

    /**
     * Sorts a list of camps by a specified attribute and order
     * @param camps List of camps to sort
     * @param sortOption Attribute to sort the camps by
     * @param orderOption Order of camps to sort by (1 = Ascending, Others = Descneding)
     * @return
     */
    public ArrayList <Camp> sortCamps(ArrayList <Camp> camps, int sortOption, int orderOption) {
        switch (sortOption) {
            case 1: return sortByGroup(camps, orderOption);
            case 2: return sortByLocation(camps, orderOption);
            case 3: return sortByStartDate(camps, orderOption);
            case 4: return sortByEndDate(camps, orderOption);
            default: return sortByAlphabetical(camps, orderOption);
        }
    }
}
