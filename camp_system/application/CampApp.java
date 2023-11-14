package camp_system.application;

import java.text.ParseException;
import java.util.ArrayList;

import camp_system.camp.Camp;
import camp_system.camp.CampControl;
import camp_system.camp.CampDisplay;
import camp_system.enquiry.EnquiryControl;
import camp_system.report.Report;
import camp_system.suggestion.SuggestionControl;
import camp_system.user.Role;
import camp_system.user.User;
import camp_system.user.UserControl;

public class CampApp implements IBase {
        private static UserControl userControl = new UserControl();
        private static User currentUser = null;
        private static SuggestionControl suggestionControl = new SuggestionControl();
        private static EnquiryControl enquiryControl = new EnquiryControl();
        private static CampControl campControl = new CampControl();
        private static CampDisplay campDisplay = new CampDisplay();
        private static CampMenu campMenu = new CampMenu();
        private static Report report = new Report();
        private static Boolean run = true;
        
    public static void main(String[] args) throws ParseException {
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
                        campDisplay.printCamps(availableCamps); break;
                    }
                    case 3: {
                        ArrayList <Camp> registeredCamps = campControl.getStudentCamps(currentUser);
                        campDisplay.printCamps(registeredCamps); break;
                    }
                    case 4: campControl.registerCamp(currentUser); break;
                    case 5: campControl.withdrawAttendee(currentUser); break;
                    case 6: {
                        campMenu.studentEnquiryMenu();; break;
                    }
                    case 7: {
                        campMenu.studentSuggestionMenu(); break;
                    }
                    case 8: {
                        ArrayList <Camp> committeeCamps = campControl.getCommitteeCamps(currentUser);
                        if (committeeCamps.size() <= 0) break;
                        campDisplay.printCamps(committeeCamps);
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
                        campDisplay.printCamps(camps); break;
                    }
                    case 3: campControl.addCamp(currentUser); break;
                    case 4: campControl.editCamp(currentUser); break;
                    case 5: campControl.deleteCamp(currentUser); break;
                    case 6: {
                        ArrayList <Camp> camps = campControl.getAllCamps(currentUser);
                        campDisplay.printRoles(camps); break;
                    }
                    case 7: {
                        ArrayList <Camp> camps = campControl.getAllCamps(currentUser);
                        campMenu.committeeEnquiryMenu(); break;
                    }
                    case 8: {
                        campMenu.staffSuggestionMenu(); break;
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
