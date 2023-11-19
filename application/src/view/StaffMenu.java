package view;

/** Represents the menu that is rqeuired for Staff */
public class StaffMenu {
    /** The main menu that staff will see */
    public static void main() {
        Header.main();
        System.out.println("Available Options:");
        System.out.println("1 - View Profile");
        System.out.println("2 - Reset Password");
        System.out.println("3 - View All Camps");
        System.out.println("4 - View Student Roles");
        System.out.println("5 - Manage Camps");
        System.out.println("6 - Manage Camp Enquiries");
        System.out.println("7 - Manage Camp Suggestions");
        System.out.println("8 - Generate Camp Report");
        System.out.println("9 - Logout");
    }
    /** The menu for camp management */
    public static void camp() {
        Header.main();
        System.out.println("Available Options:");
        System.out.println("1 - Create a Camp");
        System.out.println("2 - Edit a Camp");
        System.out.println("3 - Delete a Camp");
    }
    /** The menu for enquiry management */
    public static void enquiry() {
        Header.main();
        System.out.println("Available Options:");
        System.out.println("1 - View all Enquiries for a Camp");
        System.out.println("2 - Reply to an Enquiry for a Camp");
    }
    /** The menu for suggestion management */
	public static void suggestion(){
        Header.main();
        System.out.println("Available Options:");
        System.out.println("1 - View all Suggestions for a Camp");
        System.out.println("2 - Review a Suggestion for a Camp");
    }
    /** The menu for report generation */
    public static void report() {
        Header.main();
	    System.out.println("Available Options:");
        System.out.println("1 - Participant Report");
        System.out.println("2 - Performance Report");
    }
}
