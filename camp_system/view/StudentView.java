package camp_system.view;

import java.io.IOException;
import java.util.ArrayList;

import camp_system.camp.Camp;
import camp_system.camp.CampControl;
import camp_system.camp.CampDisplay;
import camp_system.camp.CampSelect;
import camp_system.enquiry.EnquiryControl;
import camp_system.report.Report;
import camp_system.scanner.Scan;
import camp_system.suggestion.SuggestionControl;
import camp_system.user.User;
import camp_system.user.UserControl;

public class StudentView {
    public static User show(User currentUser) throws IOException {
        StudentMenu.main();
        System.out.printf("Select Option: "); int option = Scan.scan.nextInt(); Scan.scan.nextLine();
        switch (option) {
            case 1: UserControl.resetPassword(currentUser); break;
            case 2: {
                ArrayList <Camp> availableCamps = CampControl.getByGroup(currentUser.getFaculty());
                CampDisplay.printCamps(availableCamps); break;
            }
            case 3: {
                ArrayList <Camp> registeredCamps = CampControl.getByStudent(currentUser);
                CampDisplay.printCamps(registeredCamps); break;
            }
            case 4: CampControl.registerCamp(currentUser); break;
            case 5: CampControl.withdrawAttendee(currentUser); break;
            case 6: {
                StudentMenu.enquiry();
                System.out.printf("Option: "); int choice = Scan.scan.nextInt(); Scan.scan.nextLine();
                switch (choice) {
                    case 1:
                        EnquiryControl.add(currentUser); break;
                    case 2:
                        EnquiryControl.edit(currentUser); break;
                    case 3:
                        EnquiryControl.delete(currentUser); break;
                    case 4:
                        EnquiryControl.reply(currentUser); break;
                    default: break;
                }
                break;
            }
            case 7: {
                StudentMenu.suggestion();
                System.out.printf("Option: "); int choice = Scan.scan.nextInt(); Scan.scan.nextLine();
                switch (choice) {
                    case 1:
                        SuggestionControl.add(currentUser); break;
                    case 2:
                        SuggestionControl.edit(currentUser); break;
                    case 3:
                        SuggestionControl.delete(currentUser); break;
                    default: break;
                }
                break;
            }
            case 8: {
                ArrayList <Camp> committeeCamps = CampControl.getByCommittee(currentUser);
                if (committeeCamps.size() <= 0) break;
                CampDisplay.printCamps(committeeCamps);
                Camp camp = CampSelect.select(committeeCamps);
                Report.participantReport(camp);
                break;
            }
            case 9: currentUser = null; break;
            default: break;
        }
        return currentUser;
    }

}
