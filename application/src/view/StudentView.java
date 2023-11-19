package view;

import java.io.IOException;
import java.util.ArrayList;

import camp.Camp;
import camp.CampControl;
import camp.CampDisplay;
import camp.CampFilter;
import camp.CampSelect;
import camp.CampSort;
import enquiry.Enquiry;
import enquiry.EnquiryControl;
import enquiry.EnquiryDisplay;
import report.Report;
import scanner.Scan;
import suggestion.Suggestion;
import suggestion.SuggestionControl;
import suggestion.SuggestionDisplay;
import user.User;
import user.UserControl;

public class StudentView {
    public static User show(User currentUser) throws IOException {
        StudentMenu.main();
        System.out.printf("Select Option: "); int option = Scan.scan.nextInt(); Scan.scan.nextLine();
        switch (option) {
            case 1: {
                UserControl.userControl.resetPassword(currentUser);
                currentUser = null; break;
            }
            case 2: {
                ArrayList <Camp> availableCamps = CampControl.campControl.getByGroup(currentUser.getFaculty());
                CampFilter.filterCamps(availableCamps);
                CampSort.sortCamps(availableCamps);
                CampDisplay.camps(availableCamps, currentUser.getUserID()); break;
            }
            case 3: {
                ArrayList <Camp> registeredCamps = CampControl.campControl.getByStudent(currentUser);
                CampDisplay.camps(registeredCamps, currentUser.getUserID()); break;
            }
            case 4: CampControl.campControl.registerCamp(currentUser); break;
            case 5: CampControl.campControl.withdrawAttendee(currentUser); break;
            case 6: {
                StudentMenu.enquiry();
                System.out.printf("Option: "); int choice = Scan.scan.nextInt(); Scan.scan.nextLine();
                switch (choice) {
                    case 1: 
                        ArrayList <Enquiry> enquiries = EnquiryControl.instance.getByStudent(currentUser); 
                        EnquiryDisplay.enquiries(enquiries); break;
                    case 2: EnquiryControl.instance.add(); break;
                    case 3: EnquiryControl.instance.edit(); break;
                    case 4: EnquiryControl.instance.delete(); break;
                    case 5: EnquiryControl.instance.reply(); break;
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
                    case 2: SuggestionControl.instance.add(); break;
                    case 3: SuggestionControl.instance.edit(); break;
                    case 4: SuggestionControl.instance.delete(); break;
                    default: break;
                }
                break;
            }
            case 8: {
                ArrayList <Camp> committeeCamps = CampControl.campControl.getByCommittee(currentUser);
                if (committeeCamps.size() <= 0) break;
                Camp camp = CampSelect.select(committeeCamps, currentUser.getUserID());
                Report.instance.participant(camp);
                break;
            }
            case 9: currentUser = null; break;
            default: break;
        }
        return currentUser;
    }
}
