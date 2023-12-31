package view;

import camp.CampControl;
import enquiry.EnquiryControl;
import input.Scan;
import input.integer.IntInput;
import suggestion.SuggestionControl;
import user.Role;
import user.User;
import user.UserControl;

/** 
 * The main CAMS application
 * @author Jared Pek
 */
public class CAMS {
    /** Static reference to current logged-in user */
    private static User currentUser = null;
    /** Application run state */
    private static Boolean run = true;

    /** Initialisation for all control classes */
    public static void start() {
        EnquiryControl.start();
        SuggestionControl.start();
        CampControl.start();
        UserControl.start();
    }

    /** Close and save data for all control classes */
    public static void close() {
        EnquiryControl.close();
        SuggestionControl.close();
        CampControl.close();
        UserControl.close();
    }

    /** Obtains user input and logs in a user if authentication is successful */
    public static void login() {
        AuthMenu.login();
        int option = IntInput.integer("Option");
        switch (option) {
            case 1:
                System.out.printf("User ID: "); String userId = Scan.scan.nextLine();
                System.out.printf("Password: "); String password = Scan.scan.nextLine();
                currentUser = UserControl.instance.login(userId, password);
                if (currentUser == null) {
                    System.out.println("Invalid UserID or Password. Please try again.");
                }
                break;
            case 2: run = false; break;
            default: break;
        }
    }
    
    /** The main method of the application */
    public static void main(String[] args) {
        start();
        while (run) {
            try {
                login();
                if (currentUser == null) continue;
                while (currentUser != null && currentUser.getRole() == Role.STUDENT) currentUser = StudentView.show(currentUser);
                while (currentUser != null && currentUser.getRole() == Role.STAFF) currentUser = StaffView.show(currentUser);
            } catch (Exception e) {
                System.out.println("Error, Restarting CAMs");
                continue;
            }
        }
        System.out.println("Exiting CAMs");
        close();
    }
}
