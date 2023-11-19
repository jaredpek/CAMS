package view;

import java.io.IOException;
import java.text.ParseException;
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

public class StaffView {
    public static User show(User currentUser) throws ParseException, IOException {
        StaffMenu.main();
        System.out.printf("Select Option: "); int option = Scan.scan.nextInt(); Scan.scan.nextLine();
        switch (option) {
            case 1: {
                UserControl.userControl.resetPassword(currentUser);
                currentUser = null; break;
            }
            case 2: {
                ArrayList <Camp> availableCamps = CampControl.campControl.getAll();
                CampFilter.filterCamps(availableCamps);
                CampSort.sortCamps(availableCamps);
                CampDisplay.camps(availableCamps, currentUser.getUserID()); break;
            }
            case 3: CampControl.campControl.add(); break;
            case 4: CampControl.campControl.edit(); break;
            case 5: CampControl.campControl.delete(); break;
            case 6: {
                ArrayList <Camp> camps = CampControl.campControl.getAll();
                Camp camp = CampSelect.select(camps, currentUser.getUserID());
                if (camp != null) CampDisplay.roles(camp); break;
            }
            case 7: {
                StaffMenu.enquiry();
                System.out.printf("Option: "); int choice = Scan.scan.nextInt(); Scan.scan.nextLine();
                switch (choice) {
                    case 1: 
                        ArrayList <Camp> camps = CampControl.campControl.getByStaff(currentUser);
                        Camp camp = CampSelect.select(camps, currentUser.getUserID());
                        ArrayList <Enquiry> enquiries = EnquiryControl.instance.getByCamp(camp);
                        EnquiryDisplay.enquiries(enquiries); break;
                    case 2:  EnquiryControl.instance.reply(); break;
                    default: break;
                }
                break;
            }
            case 8: {
                StaffMenu.suggestion();
                System.out.printf("Option: "); int choice = Scan.scan.nextInt(); Scan.scan.nextLine();
                ArrayList <Camp> camps = CampControl.campControl.getByStaff(currentUser);
                Camp camp = CampSelect.select(camps, currentUser.getUserID());
                switch (choice) {
                    case 1:
                        ArrayList <Suggestion> suggestions = SuggestionControl.instance.getByCamp(camp);
                        SuggestionDisplay.printSuggestions(suggestions); break;
                    case 2: SuggestionControl.instance.approveRejectSuggestions(camp); break;
                    default: break;
                }
                break;
            }
            case 9: {
                StaffMenu.report();
                System.out.printf("Option: "); int choice = Scan.scan.nextInt(); Scan.scan.nextLine();
                ArrayList <Camp> camps = CampControl.campControl.getByStaff(currentUser);
                Camp camp = CampSelect.select(camps, currentUser.getUserID());
                switch (choice) {
                    case 1: Report.instance.participant(camp); break;
                    case 2: Report.instance.performance(camp); break;
                    default: break;
                }
                break;
            }
            case 10: currentUser = null; break;
            default: break;
        }
        return currentUser;
    }

}
