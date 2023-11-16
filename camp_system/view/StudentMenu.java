package camp_system.view;

public class StudentMenu {
    public static void main() {
        System.out.println("Welcome to NTU CAMS!");
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
	    System.out.println("Enquiry Menu");
        System.out.println("---------------------------------");
	    System.out.println("1: Add Enquiry");    
        System.out.println("2: Edit Enquiry");
        System.out.println("3: Delete Enquiry");
        System.out.println("4: Reply Enquiries");
    }
    public static void suggestion() {
        System.out.println("Committee Member Suggestion Menu");
        System.out.println("------------------------------------");
        System.out.println("1: Add Suggestion");
        System.out.println("2: Edit Suggestion");
        System.out.println("3: Delete Suggestion");
    }
}
