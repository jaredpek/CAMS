package camp_system.application.view;

import java.io.IOException;
import java.util.ArrayList;

import camp_system.camp.Camp;
import camp_system.camp.CampControl;
import camp_system.camp.CampDisplay;
import camp_system.camp.CampSelect;
import camp_system.enquiry.Enquiry;
import camp_system.enquiry.EnquiryControl;
import camp_system.enquiry.EnquiryDisplay;
import camp_system.report.Report;
import camp_system.scanner.Scan;
import camp_system.suggestion.Suggestion;
import camp_system.suggestion.SuggestionControl;
import camp_system.suggestion.SuggestionDisplay;
import camp_system.user.User;
import camp_system.user.UserControl;

public class StudentView {
    private static UserControl userControl = new UserControl();
    private static CampControl campControl = new CampControl();
    private static EnquiryControl enquiryControl = new EnquiryControl();
    private static SuggestionControl suggestionControl = new SuggestionControl();
    private static Report report = new Report();

    public static User show(User currentUser) throws IOException {
        StudentMenu.main();
        System.out.printf("Select Option: "); int option = Scan.scan.nextInt(); Scan.scan.nextLine();
        switch (option) {
            case 1: userControl.resetPassword(currentUser); break;
            case 2: {
                ArrayList <Camp> availableCamps = campControl.getByGroup(currentUser.getFaculty());
                CampDisplay.printCamps(availableCamps, currentUser.getUserID()); break;
            }
            case 3: {
                ArrayList <Camp> registeredCamps = campControl.getByStudent(currentUser);
                CampDisplay.printCamps(registeredCamps, currentUser.getUserID()); break;
            }
            case 4: campControl.registerCamp(currentUser); break;
            case 5: campControl.withdrawAttendee(currentUser); break;
            case 6: {
                StudentMenu.enquiry();
                System.out.printf("Option: "); int choice = Scan.scan.nextInt(); Scan.scan.nextLine();
                switch (choice) {
                    case 1: 
                        ArrayList <Enquiry> enquiries = enquiryControl.getByStudent(currentUser); 
                        EnquiryDisplay.printEnquiries(enquiries); break;
                    case 2: enquiryControl.add(currentUser); break;
                    case 3: enquiryControl.edit(currentUser); break;
                    case 4: enquiryControl.delete(currentUser); break;
                    case 5: enquiryControl.reply(currentUser); break;
                    default: break;
                }
                break;
            }
            case 7: {
                StudentMenu.suggestion();
                System.out.printf("Option: "); int choice = Scan.scan.nextInt(); Scan.scan.nextLine();
                switch (choice) {
                    case 1: 
                        ArrayList <Suggestion> suggestions = suggestionControl.getByStudent(currentUser);
                        SuggestionDisplay.printSuggestions(suggestions); break;
                    case 2: suggestionControl.add(currentUser); break;
                    case 3: suggestionControl.edit(currentUser); break;
                    case 4: suggestionControl.delete(currentUser); break;
                    default: break;
                }
                break;
            }
            case 8: {
                ArrayList <Camp> committeeCamps = campControl.getByCommittee(currentUser);
                if (committeeCamps.size() <= 0) break;
                CampDisplay.printCamps(committeeCamps, currentUser.getUserID());
                Camp camp = CampSelect.select(committeeCamps, currentUser.getUserID());
                report.participant(camp);
                break;
            }
            case 9: currentUser = null; break;
            default: break;
        }
        return currentUser;
    }
}
