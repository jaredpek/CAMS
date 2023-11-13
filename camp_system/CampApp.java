package camp_system;

import java.util.ArrayList;
import java.util.Scanner;

import camp_system.camp.Camp;
import camp_system.camp.CampControl;
import camp_system.enquiry.EnquiryControl;
import camp_system.report.Report;
import camp_system.suggestion.SuggestionControl;
import camp_system.user.Role;
import camp_system.user.User;
import camp_system.user.UserControl;

public class CampApp {
    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) {
        UserControl userControl = new UserControl(null);
        User currentUser = null;
        SuggestionControl suggestionControl = new SuggestionControl();
        EnquiryControl enquiryControl = new EnquiryControl();
        CampControl campControl = new CampControl();
        CampMenu campMenu = new CampMenu();
        Report report = new Report();
        Boolean run = true;

        while (run) {
            campMenu.loginMenu();
            System.out.printf("Enter User ID: "); String userId = scan.nextLine();
            System.out.printf("Enter Password: "); String password = scan.nextLine();
            currentUser = userControl.login(userId, password);
            if (currentUser == null) continue;

            while (currentUser != null && currentUser.getRole() == Role.STUDENT) {
                campMenu.studentMenu();
                System.out.printf("Select Option: "); int option = scan.nextInt(); scan.nextLine();
                switch (option) {
                    case 1: userControl.resetPassword(currentUser); break;
                    case 2: {
                        ArrayList <Camp> availableCamps = campControl.getGroupCamps(currentUser.getFaculty());
                        campControl.printCamps(availableCamps); break;
                    }
                    case 3: {
                        ArrayList <Camp> registeredCamps = campControl.getStudentCamps(currentUser);
                        campControl.printCamps(registeredCamps); break;
                    }
                    case 4: campControl.registerCamp(currentUser); break;
                    case 5: campControl.withdrawAttendee(currentUser); break;
                    case 6: {
                        campMenu.studentEnquiryMenu(currentUser); break;
                    }
                    case 7: {
                        campMenu.StudentSuggestionMenu(); break;
                    }
                    case 8: {
                        ArrayList <Camp> committeeCamps = campControl.getCommitteeCamps(currentUser);
                        if (committeeCamps.size() <= 0) break;
                        campControl.printCamps(committeeCamps);
                        campMenu.reportMenu(); break;
                    }
                    case 9: currentUser = null; break;
                    default: continue;
                }
            }

            while (currentUser != null && currentUser.getRole() == Role.STAFF) {
                campMenu.staffMenu();
                System.out.printf("Select Option: "); int option = scan.nextInt(); scan.nextLine();
                switch (option) {
                    case 1: userControl.resetPassword(currentUser); break;
                    case 2: {
                        ArrayList <Camp> camps = campControl.getAllCamps(currentUser);
                        campControl.printCamps(camps); break;
                    }
                    case 3: campControl.addCamp(currentUser); break;
                    case 4: campControl.editCamp(currentUser); break;
                    case 5: campControl.deleteCamp(currentUser); break;
                    case 6: {
                        ArrayList <Camp> camps = campControl.getAllCamps(currentUser);
                        campControl.viewRoles(camps); break;
                    }
                    case 7: {
                        ArrayList <Camp> camps = campControl.getAllCamps(currentUser);
                        campMenu.CommitteeEnquiryMenu(camps); break;
                    case 8: {
                        campMenu.StaffSuggestionMenu(); break;
                    }
                    case 9: {
                        campMenu.reportMenu(); break;
                    }
                    case 10: currentUser = null; break;
                    default: continue;
                }
            }
        }
    }
}
