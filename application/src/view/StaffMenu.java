package view;

public class StaffMenu {
    public static void main() {
        Header.main();
        System.out.println("Available Options:");
        System.out.println("1: Reset Password");
        System.out.println("2: View All Camps");
        System.out.println("3: Create a Camp");
        System.out.println("4: Edit a Camp");
        System.out.println("5: Delete a Camp");
        System.out.println("6: View Student Roles");
        System.out.println("7: Manage Camp Enquiries");
        System.out.println("8: Manage Camp Suggestions");
        System.out.println("9: Generate Camp Report");
        System.out.println("10: Logout");
    }
    public static void enquiry() {
        Header.main();
        System.out.println("Available Options:");
        System.out.println("1: View all Enquiries for a Camp");
        System.out.println("2: Reply to an Enquiry for a Camp");
    }
	public static void suggestion(){
        Header.main();
        System.out.println("Available Options:");
        System.out.println("1: View all Suggestions for a Camp");
        System.out.println("2: Review a Suggestion for a Camp");
    }
    public static void report() {
        Header.main();
	    System.out.println("Available Options:");
        System.out.println("1. Participant Report");
        System.out.println("2. Performance Report");
    }
}
