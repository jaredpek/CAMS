package camp_system;

import java.io.IOException;
import java.text.ParseException;

import camp_system.camp.CampControl;
import camp_system.enquiry.EnquiryControl;
import camp_system.scanner.Scan;
import camp_system.suggestion.SuggestionControl;
import camp_system.user.Role;
import camp_system.user.User;
import camp_system.user.UserControl;
import camp_system.view.AuthMenu;
import camp_system.view.StaffView;
import camp_system.view.StudentView;

public class CAMS {
    private static User currentUser = null;
    private static Boolean run = true;
    private static UserControl userControl = new UserControl();

    public static void start() {
        EnquiryControl.start();
        SuggestionControl.start();
        CampControl.start();
        UserControl.start();
    }

    public static void close() {
        EnquiryControl.close();
        SuggestionControl.close();
        CampControl.close();
        UserControl.close();
    }

    public static void login() {
        AuthMenu.login();
        System.out.printf("Option: "); int option = Scan.scan.nextInt(); Scan.scan.nextLine();
        switch (option) {
            case 1:
                System.out.printf("Enter User ID: "); String userId = Scan.scan.nextLine();
                System.out.printf("Enter Password: "); String password = Scan.scan.nextLine();
                currentUser = userControl.login(userId, password); break;
            default: run = false; break;
        }
    }
        
    public static void main(String[] args) throws ParseException, IOException {
        start();
        while (run) {
            login();
            if (currentUser == null) continue;
            while (currentUser != null && currentUser.getRole() == Role.STUDENT) currentUser = StudentView.show(currentUser);
            while (currentUser != null && currentUser.getRole() == Role.STAFF) currentUser = StaffView.show(currentUser);
        }
        close();
    }
}
