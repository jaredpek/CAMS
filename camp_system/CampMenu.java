package camp_system;

public class CampMenu {
    public void loginMenu() {
        
    }
    public void studentMenu() {
        System.out.println("Welcome to NTU CAMS!");
        System.out.println("1: Reset Password");
        System.out.println("2: View Available Camps");
        System.out.println("3: View Registered Camps");
        System.out.println("4: Register for a Camp");
        System.out.println("5: Withdraw from a Camp");
        System.out.println("6: Manage Camp Enquiries");
        System.out.println("7: Manage Camp Suggestions");
        System.out.println("8: Generate Camp Report");
        System.out.println("9: Logout");
    }
    public void staffMenu() {
        System.out.println("Welcome to NTU CAMS!");
        System.out.println("1: Reset Password");
        System.out.println("2: View All Camps");
        System.out.println("3: Create a Camp");
        System.out.println("4: Edit a Camp");
        System.out.println("5: Delete a Camp");
        System.out.println("6: View Student Roles");
        System.out.println("7: Manage Camp Suggestions");
        System.out.println("8: Generate Camp Report");
        System.out.println("9: Logout");
    }
    public void CommitteeEnquiryMenu() {
	System.out.println("Committee Member Enquiry Menu");
        System.out.println("---------------------------------");
        System.out.println("1: Edit Enquiry");
        System.out.println("2: Delete Enquiry");
        System.out.println("3: Get all Enquiries");
    }

    public void StudentEnquiryMenu() {
	System.out.println("Enquiry Menu");
        System.out.println("---------------------------------");
	System.out.println("1: Add Enquiry");    
        System.out.println("2: Edit Enquiry");
        System.out.println("3: Delete Enquiry");
        System.out.println("4: Get all Enquiries");
    }
    public void CommitteeSuggestionMenu() {
    System.out.println("Committee Member Suggestion Menu");
	System.out.println("------------------------------------");
	System.out.println("1: Add Suggestion");
	System.out.println("2: Edit Suggestion");
	System.out.println("3: Delete Suggestion");
	System.out.println("4: Get all Suggestions");
    }
	public void StaffSuggestionMenu(){
	System.out.println("Staff Suggestion Menu");
	System.out.println("--------------------------");
	System.out.println("1: Get all Suggestions for Camp");
	System.out.println("2: View/Approve Suggestions");
    }
    public void reportMenu() {
	System.out.println("Report Menu");
        System.out.println("1. Participant Report");
        System.out.println("2. Performance Report");

    }
}
