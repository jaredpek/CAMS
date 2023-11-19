package view;

/** Represents the menus required by students */
public class StudentMenu {
    /** The main menu for students */
    public static void main() {
        Header.main();
        System.out.println("Available Options:");
        System.out.println("1 - View Profile");
        System.out.println("2 - Reset Password");
        System.out.println("3 - View Available Camps");
        System.out.println("4 - View Registered Camps");
        System.out.println("5 - Manage Camp Enrolment");
        System.out.println("6 - Manage Camp Enquiries");
        System.out.println("7 - Manage Camp Suggestions");
        System.out.println("8 - Generate Participant Report");
        System.out.println("9 - Logout");
    }
    /** The menu for enrolment management */
    public static void enrolment() {
        Header.main();
        System.out.println("Available Options:");
        System.out.println("1 - Register for a Camp");
        System.out.println("2 - Withdraw from a Camp");
    }
    /** The menu for enquiry management */
    public static void enquiry() {
        Header.main();
        System.out.println("Available Options:");
        System.out.println("1 - View my Enquiries");
	    System.out.println("2 - Add an Enquiry");    
        System.out.println("3 - Edit an Enquiry");
        System.out.println("4 - Delete an Enquiry");
        System.out.println("5 - Reply an Enquiry");
    }
    /** The menu for suggestion management */
    public static void suggestion() {
        Header.main();
        System.out.println("Available Options:");
        System.out.println("1 - View my Suggestions");
        System.out.println("2 - Add a Suggestion");
        System.out.println("3 - Edit a Suggestion");
        System.out.println("4 - Delete a Suggestion");
    }
}
