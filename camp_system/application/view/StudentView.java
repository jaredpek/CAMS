package camp_system.application.view;

import java.io.IOException;
import java.util.ArrayList;

import camp_system.camp.Camp;
import camp_system.camp.CampControl;
import camp_system.camp.CampDisplay;
import camp_system.camp.CampFilter;
import camp_system.camp.CampSelect;
import camp_system.camp.CampSort;
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
    public static User show(User currentUser) throws IOException {
        StudentMenu.main();
        System.out.printf("Select Option: "); int option = Scan.scan.nextInt(); Scan.scan.nextLine();
        switch (option) {
            case 1: UserControl.userControl.resetPassword(currentUser); break;
            case 2: {
                ArrayList <Camp> availableCamps = CampControl.campControl.getByGroup(currentUser.getFaculty());
                CampFilter.filterCamps(availableCamps);
                CampSort.sortCamps(availableCamps);
                CampDisplay.printCamps(availableCamps, currentUser.getUserID()); break;
            }
            case 3: {
                ArrayList <Camp> registeredCamps = CampControl.campControl.getByStudent(currentUser);
                CampDisplay.printCamps(registeredCamps, currentUser.getUserID()); break;
            }
            case 4: CampControl.campControl.registerCamp(currentUser); break;
            case 5: CampControl.campControl.withdrawAttendee(currentUser); break;
            case 6: {
                StudentMenu.enquiry();
                System.out.printf("Option: "); int choice = Scan.scan.nextInt(); Scan.scan.nextLine();
                switch (choice) {
                    case 1: 
                        ArrayList <Enquiry> enquiries = EnquiryControl.instance.getByStudent(currentUser); 
                        EnquiryDisplay.printEnquiries(enquiries); break;
                    case 2: EnquiryControl.instance.add(currentUser); break;
                    case 3: EnquiryControl.instance.edit(currentUser); break;
                    case 4: EnquiryControl.instance.delete(currentUser); break;
                    case 5: EnquiryControl.instance.reply(currentUser); break;
                    default: break;
                }
                break;
            }
            case 7: {
                StudentMenu.suggestion();
                System.out.printf("Option: "); int choice = Scan.scan.nextInt(); Scan.scan.nextLine();
                switch (choice) {
                    case 1: 
                        ArrayList <Suggestion> suggestions = SuggestionControl.instance.getByStudent(currentUser);
                        SuggestionDisplay.printSuggestions(suggestions); break;
                    case 2: SuggestionControl.instance.add(currentUser); break;
                    case 3: SuggestionControl.instance.edit(currentUser); break;
                    case 4: SuggestionControl.instance.delete(currentUser); break;
                    default: break;
                }
                break;
            }
            case 8: {
                ArrayList <Camp> committeeCamps = CampControl.campControl.getByCommittee(currentUser);
                if (committeeCamps.size() <= 0) break;
                CampDisplay.printCamps(committeeCamps, currentUser.getUserID());
                Camp camp = CampSelect.select(committeeCamps, currentUser.getUserID());
                Report.report.participant(camp);
                break;
            }
            case 9: currentUser = null; break;
            default: break;
        }
        return currentUser;
    }
}
