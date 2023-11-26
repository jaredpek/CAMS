package camp;

import java.util.ArrayList;

import scan.Scan;

/** 
 * Represents a class that sorts a list of camps in the required order
 * @author Jared Pek, Rachel Phuar Yi Ling
 */
public class CampSort {
    /** The sort methods available to the user */
    public void sortMenu() {
        System.out.println("Select Sort Method:");
        System.out.println("1 - Group");
        System.out.println("2 - Location");
        System.out.println("3 - Start Date");
        System.out.println("4 - End Date");
        System.out.println("5 - Alphabetical Order (Default)");
    }
    /** The order of sorting available to the user */
    public void orderMenu() {
        System.out.println("Select Order:");
        System.out.println("1 - Ascending (Default)");
        System.out.println("2 - Descending");
    }

    /**
     * Sorts a list of camps by the group
     * @param camps List of camps to sort
     * @param orderOption Order of camps to sort by (1 = Ascending, Others = Descneding)
     * @return ArrayList
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
     * @return ArrayList
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
     * @return ArrayList
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
     * @return ArrayList
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
     * @return ArrayList
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
     * @return ArrayList
     */
    public ArrayList <Camp> sortCamps(ArrayList <Camp> camps) {
        sortMenu();
        System.out.printf("Option: "); int sortOption = Scan.scan.nextInt(); Scan.scan.nextLine();
        orderMenu();
        System.out.printf("Option: "); int orderOption = Scan.scan.nextInt(); Scan.scan.nextLine();
        switch (sortOption) {
            case 1: return sortByGroup(camps, orderOption);
            case 2: return sortByLocation(camps, orderOption);
            case 3: return sortByStartDate(camps, orderOption);
            case 4: return sortByEndDate(camps, orderOption);
            default: return sortByAlphabetical(camps, orderOption);
        }
    }
}
