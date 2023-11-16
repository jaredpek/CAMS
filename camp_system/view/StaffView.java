package camp_system.view;

import java.io.IOException;
import java.text.ParseException;
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

public class StaffView {
    public static User show(User currentUser) throws ParseException, IOException {
        StaffMenu.main();
        System.out.printf("Select Option: "); int option = Scan.scan.nextInt(); Scan.scan.nextLine();
        switch (option) {
            case 1: UserControl.resetPassword(currentUser); break;
            case 2: {
                ArrayList <Camp> camps = CampControl.getAll(currentUser);
                CampDisplay.printCamps(camps); break;
            }
            case 3: CampControl.add(currentUser); break;
            case 4: CampControl.edit(currentUser); break;
            case 5: CampControl.delete(currentUser); break;
            case 6: {
                ArrayList <Camp> camps = CampControl.getAll(currentUser);
                Camp camp = CampSelect.select(camps);
                if (camp != null) CampDisplay.printRoles(camp); 
                break;
            }
            case 7: {
                StaffMenu.enquiry();
                System.out.printf("Option: "); int choice = Scan.scan.nextInt(); Scan.scan.nextLine();
                switch (choice) {
                    case 1: 
                        ArrayList <Camp> camps = CampControl.getByStaff(currentUser);
                        Camp camp = CampSelect.select(camps);
                        ArrayList <Enquiry> enquiries = EnquiryControl.getByCamp(camp);
                        EnquiryDisplay.printEnquiries(enquiries);
                        break;
                    case 2: 
                        EnquiryControl.reply(currentUser);
                        break;
                    default: break;
                }
                break;
            }
            case 8: {
                StaffMenu.suggestion();
                System.out.printf("Option: "); int choice = Scan.scan.nextInt(); Scan.scan.nextLine();
                ArrayList <Camp> camps = CampControl.getByStaff(currentUser);
                Camp camp = CampSelect.select(camps);
                switch (choice) {
                    case 1:
                        ArrayList <Suggestion> suggestions = SuggestionControl.getByCamp(camp);
                        SuggestionDisplay.printSuggestions(suggestions);
                        break;
                    case 2:
                        SuggestionControl.approveRejectSuggestions(camp);
                        break;
                    default:
                        break;
                }
                break;
            }
            case 9: {
                StaffMenu.report();
                System.out.printf("Option: "); int choice = Scan.scan.nextInt(); Scan.scan.nextLine();
                ArrayList <Camp> camps = CampControl.getByStaff(currentUser);
                Camp camp = CampSelect.select(camps);
                switch (choice) {
                    case 1:
                        Report.participantReport(camp);
                        break;
                    case 2:
                        Report.performanceReport(camp);
                        break;
                    default:
                        break;
                }
                break;
            }
            case 10: currentUser = null; break;
            default: break;
        }
        return currentUser;
    }

}
