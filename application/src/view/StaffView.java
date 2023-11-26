package view;

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
import scan.Scan;
import suggestion.Suggestion;
import suggestion.SuggestionControl;
import suggestion.SuggestionDisplay;
import user.User;
import user.UserControl;
import user.UserDisplay;

/** 
 * Represents the main view class for staff
 * @author Jared Pek
 */
public class StaffView {
    /** 
     * The logic flow for staff after login
     * @param user The current user that is logged in
     * @return User object if user is still logged in
     */
    public static User show(User user) {
        StaffMenu.main();
        System.out.printf("Option: "); int option = Scan.scan.nextInt(); Scan.scan.nextLine();
        switch (option) {
            case 1: (new UserDisplay()).user(user); break;
            case 2: UserControl.instance.resetPassword(user); return null;
            case 3: {
                ArrayList <Camp> availableCamps = CampControl.instance.getAll(user);
                availableCamps = (new CampFilter()).filterCamps(availableCamps);
                (new CampSort()).sortCamps(availableCamps);
                (new CampDisplay()).camps(availableCamps, user.getUserID()); break;
            }
            case 4: {
                ArrayList <Camp> camps = CampControl.instance.getAll(user);
                Camp camp = (new CampSelect()).select(camps, user.getUserID());
                (new CampDisplay()).roles(camp); break;
            }
            case 5: {
                StaffMenu.camp();
                System.out.printf("Option: "); int choice = Scan.scan.nextInt(); Scan.scan.nextLine();
                switch (choice) {
                    case 1: CampControl.instance.add(user); break;
                    case 2: CampControl.instance.edit(user); break;
                    case 3: CampControl.instance.delete(user); break;
                    default: break;
                }
                break;
            }
            case 6: {
                StaffMenu.enquiry();
                System.out.printf("Option: "); int choice = Scan.scan.nextInt(); Scan.scan.nextLine();
                switch (choice) {
                    case 1: 
                        ArrayList <Camp> camps = CampControl.instance.getByStaff(user);
                        Camp camp = (new CampSelect()).select(camps, user.getUserID());
                        if (camp == null) break;
                        ArrayList <Enquiry> enquiries = EnquiryControl.instance.getByCamp(camp);
                        (new EnquiryDisplay()).enquiries(enquiries); break;
                    case 2:  EnquiryControl.instance.reply(user); break;
                    default: break;
                }
                break;
            }
            case 7: {
                StaffMenu.suggestion();
                System.out.printf("Option: "); int choice = Scan.scan.nextInt(); Scan.scan.nextLine();
                ArrayList <Camp> camps = CampControl.instance.getByStaff(user);
                Camp camp = (new CampSelect()).select(camps, user.getUserID());
                if (camp == null) break;
                switch (choice) {
                    case 1:
                        ArrayList <Suggestion> suggestions = SuggestionControl.instance.getByCamp(camp);
                        (new SuggestionDisplay()).suggestions(suggestions); break;
                    case 2: SuggestionControl.instance.approveRejectSuggestions(camp); break;
                    default: break;
                }
                break;
            }
            case 8: {
                StaffMenu.report();
                System.out.printf("Option: "); int choice = Scan.scan.nextInt(); Scan.scan.nextLine();
                ArrayList <Camp> camps = CampControl.instance.getByStaff(user);
                Camp camp = (new CampSelect()).select(camps, user.getUserID());
                if (camp == null) break;
                switch (choice) {
                    case 1: Report.instance.participant(camp, user); break;
                    case 2: Report.instance.performance(camp, user); break;
                    default: break;
                }
                break;
            }
            case 9: return null;
            default: break;
        }
        return user;
    }
}
