package camp_system.view;

public class StaffMenu {
    public static void main() {
        System.out.println("Welcome to NTU CAMS!");
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
        System.out.println("Staff Enquiry Menu");
        System.out.println("--------------------------");
        System.out.println("1: Get all Enquiries for Camp");
        System.out.println("2: Reply to Enquiries");
    }
	public static void suggestion(){
        System.out.println("Staff Suggestion Menu");
        System.out.println("--------------------------");
        System.out.println("1: Get all Suggestions for Camp");
        System.out.println("2: View/Approve Suggestions");
    }
    public static void report() {
	    System.out.println("Report Menu");
        System.out.println("1. Participant Report");
        System.out.println("2. Performance Report");
    }
}
