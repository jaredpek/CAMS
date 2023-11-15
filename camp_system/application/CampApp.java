package camp_system.application;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import camp_system.camp.Camp;
import camp_system.camp.CampControl;
import camp_system.camp.CampDisplay;
import camp_system.camp.CampSelect;
import camp_system.enquiry.EnquiryControl;
import camp_system.report.Report;
import camp_system.suggestion.Suggestion;
import camp_system.suggestion.SuggestionControl;
import camp_system.suggestion.SuggestionDisplay;
import camp_system.user.Role;
import camp_system.user.User;
import camp_system.user.UserControl;

public class CampApp implements IBase {
    private static UserControl userControl = new UserControl();
    private static User currentUser = null;
    private static SuggestionControl suggestionControl = new SuggestionControl();
    private static SuggestionDisplay suggestionDisplay = new SuggestionDisplay();
    private static EnquiryControl enquiryControl = new EnquiryControl();
    private static CampControl campControl = new CampControl();
    private static CampDisplay campDisplay = new CampDisplay();
    private static CampSelect campSelect = new CampSelect();
    private static CampMenu campMenu = new CampMenu();
    private static Report report = new Report();
    private static Boolean run = true;
        
    public static void main(String[] args) throws ParseException, IOException {
        while (run) {
            campMenu.loginMenu();
            System.out.printf("Option: "); int authChoice = scan.nextInt(); scan.nextLine();
            switch (authChoice) {
                case 1:
                    System.out.printf("Enter User ID: "); String userId = scan.nextLine();
                    System.out.printf("Enter Password: "); String password = scan.nextLine();
                    currentUser = userControl.login(userId, password); break;
                default: return;
            }
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
                        campMenu.studentEnquiryMenu();
                        System.out.printf("Option: "); int choice = scan.nextInt(); scan.nextLine();
                        switch (choice) {
                            case 1:
                                ArrayList <Camp> camps = campControl.getGroupCamps(currentUser.getFaculty());
                                enquiryControl.addEnquiry(currentUser, camps); break;
                            case 2:
                                enquiryControl.editEnquiry(currentUser); break;
                            case 3:
                                enquiryControl.deleteEnquiry(currentUser); break;
                            case 4:
                                enquiryControl.replyEnquiry(currentUser); break;
                            default: break;
                        }
                        break;
                    }
                    case 7: {
                        campMenu.studentSuggestionMenu();
                        System.out.printf("Option: "); int choice = scan.nextInt(); scan.nextLine();
                        switch (choice) {
                            case 1:
                                ArrayList <Camp> camps = campControl.getCommitteeCamps(currentUser);
                                suggestionControl.addSuggestion(currentUser, camps); break;
                            case 2:
                                suggestionControl.editSuggestion(currentUser); break;
                            case 3:
                                suggestionControl.deleteSuggestion(currentUser); break;
                            default: break;
                        }
                        break;
                    }
                    case 8: {
                        ArrayList <Camp> committeeCamps = campControl.getCommitteeCamps(currentUser);
                        if (committeeCamps.size() <= 0) break;
                        campDisplay.printCamps(committeeCamps);
                        Camp camp = campSelect.select(committeeCamps);
                        report.participantReport(camp);
                        break;
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
                        Camp camp = campSelect.select(camps);
                        if (camp != null) campDisplay.printRoles(camp); 
                        break;
                    }
                    case 7: {
                        campMenu.staffSuggestionMenu(); 
                        System.out.printf("Option: "); int choice = scan.nextInt(); scan.nextLine();
                        ArrayList <Camp> camps = campControl.getStaffCamps(currentUser);
                        Camp camp = campSelect.select(camps);
                        switch (choice) {
                            case 1:
                                ArrayList <Suggestion> suggestions = suggestionControl.getCampSuggestions(camp);
                                suggestionDisplay.printSuggestions(suggestions);
                                break;
                            case 2:
                                suggestionControl.approveRejectSuggestions(camp);
                                break;
                            default:
                                break;
                        }
                        break;
                    }
                    case 8: {
                        campMenu.staffReportMenu();
                        System.out.printf("Option: "); int choice = scan.nextInt(); scan.nextLine();
                        ArrayList <Camp> camps = campControl.getStaffCamps(currentUser);
                        Camp camp = campSelect.select(camps);
                        switch (choice) {
                            case 1:
                                report.participantReport(camp);
                                break;
                            case 2:
                                report.performanceReport(camp);
                                break;
                            default:
                                break;
                        }
                        break;
                    }
                    case 9: currentUser = null; break;
                    default: continue;
                }
            }
        }
    }
}
