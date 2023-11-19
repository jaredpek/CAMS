package view;


import java.io.IOException;
import java.text.ParseException;

import camp.CampControl;
import enquiry.EnquiryControl;
import scanner.Scan;
import suggestion.SuggestionControl;
import user.Role;
import user.User;
import user.UserControl;

public class CAMS {
    public static User currentUser = null;
    private static Boolean run = true;

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
                currentUser = UserControl.userControl.login(userId, password); break;
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
