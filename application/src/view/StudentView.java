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
import input.integer.IntInput;
import report.Report;
import suggestion.Suggestion;
import suggestion.SuggestionControl;
import suggestion.SuggestionDisplay;
import user.User;
import user.UserControl;
import user.UserDisplay;

/** 
 * Represents the main view class for students
 * @author Jared Pek
 */
public class StudentView {
    /** 
     * The logic flow for students after login 
     * @param user The current user that is logged in
     * @return The user object if still logged in
     */
    public static User show(User user) {
        StudentMenu.main();
        int option = IntInput.integer("Option");
        switch (option) {
            case 1:  (new UserDisplay()).user(user); break;
            case 2: UserControl.instance.resetPassword(user); return null;
            case 3: {
                ArrayList <Camp> availableCamps = CampControl.instance.getByGroup(user.getFaculty());
                availableCamps = (new CampFilter()).filterCamps(availableCamps);
                (new CampSort()).sortCamps(availableCamps);
                (new CampDisplay()).camps(availableCamps, user.getUserID()); break;
            }
            case 4: {
                ArrayList <Camp> registeredCamps = CampControl.instance.getByStudent(user);
                (new CampDisplay()).camps(registeredCamps, user.getUserID()); break;
            }
            case 5: {
                StudentMenu.enrolment();
                int choice = IntInput.integer("Option");
                switch (choice) {
                    case 1: CampControl.instance.registerCamp(user); break;
                    case 2: CampControl.instance.withdrawAttendee(user); break;
                    default: break;
                }
                break;
            }
            case 6: {
                StudentMenu.enquiry();
                int choice = IntInput.integer("Option");
                switch (choice) {
                    case 1: 
                        ArrayList <Enquiry> enquiries = EnquiryControl.instance.getByStudent(user); 
                        (new EnquiryDisplay()).enquiries(enquiries); break;
                    case 2: EnquiryControl.instance.add(user); break;
                    case 3: EnquiryControl.instance.edit(user); break;
                    case 4: EnquiryControl.instance.delete(user); break;
                    case 5: EnquiryControl.instance.reply(user); break;
                    default: break;
                }
                break;
            }
            case 7: {
                StudentMenu.suggestion();
                int choice = IntInput.integer("Option");
                switch (choice) {
                    case 1: 
                        ArrayList <Suggestion> suggestions = SuggestionControl.instance.getByStudent(user);
                        (new SuggestionDisplay()).suggestions(suggestions); break;
                    case 2: SuggestionControl.instance.add(user); break;
                    case 3: SuggestionControl.instance.edit(user); break;
                    case 4: SuggestionControl.instance.delete(user); break;
                    default: break;
                }
                break;
            }
            case 8: {
                ArrayList <Camp> committeeCamps = CampControl.instance.getByCommittee(user);
                if (committeeCamps.size() <= 0) break;
                Camp camp = (new CampSelect()).select(committeeCamps, user.getUserID());
                Report.instance.participant(camp, user);
                break;
            }
            case 9: return null;
            default: break;
        }
        return user;
    }
}
