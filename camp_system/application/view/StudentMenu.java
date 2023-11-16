package camp_system.application.view;

public class StudentMenu {
    public static void main() {
        Header.main();
        System.out.println("Available Options:");
        System.out.println("1: Reset Password");
        System.out.println("2: View Available Camps");
        System.out.println("3: View Registered Camps");
        System.out.println("4: Register for a Camp");
        System.out.println("5: Withdraw from a Camp");
        System.out.println("6: Manage Camp Enquiries");
        System.out.println("7: Manage Camp Suggestions");
        System.out.println("8: Generate Participant Report");
        System.out.println("9: Logout");
    }
    public static void enquiry() {
        Header.main();
        System.out.println("Available Options:");
	    System.out.println("1: Add an Enquiry");    
        System.out.println("2: Edit an Enquiry");
        System.out.println("3: Delete an Enquiry");
        System.out.println("4: Reply an Enquiry");
    }
    public static void suggestion() {
        Header.main();
        System.out.println("Available Options:");
        System.out.println("1: Add a Suggestion");
        System.out.println("2: Edit a Suggestion");
        System.out.println("3: Delete a Suggestion");
    }
}
