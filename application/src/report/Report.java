package report;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;

import camp.Camp;
import date.DateParse;
import enquiry.Enquiry;
import enquiry.EnquiryControl;
import enquiry.EnquiryScore;
import scan.Scan;
import suggestion.Suggestion;
import suggestion.SuggestionControl;
import suggestion.SuggestionScore;
import user.User;

/** Represents a report class that users can use to generate reports */
public class Report implements IReport {
    /** Static instance of Report */
    public static Report instance = new Report();

    /**
     * method to print some general information about the report
     * @param out the printwriter object to write to txt file
     * @param camp the camp to generate the report on
     * @param user the user generating the report
     */
    private void general(PrintWriter out, Camp camp, User user) {
        out.printf("Participant Report for '%s'\n\n", camp.getName());
        out.printf("Generated By: %s\n", user.getUserID());
        out.printf("Generated On: %s\n\n", DateParse.string(new Date()));
    }

    /** The available options on report filtering */
    public void menu() {
        System.out.println("Select Filter Option: ");
        System.out.println("1 - Attendee List");
        System.out.println("2 - Committee List");
        System.out.println("3 - None (Default)");
    }
    /**
     * generates a particpant report for the specified camp
     * report includes Camp Information and the attendee/committee list
     * @param camp is the object for which the participant report is to generate
     * @param user the user generating the report
     */
    public void participant(Camp camp, User user) {
        if (camp == null) return;
        menu();
        System.out.printf("Option: "); int option = Scan.scan.nextInt(); Scan.scan.nextLine();
        if (option < 1 || option > 3) return;
        String path = "reports\\participantReport_" + (new Date()).getTime() + ".txt";
        try {
            PrintWriter out = new PrintWriter(new FileWriter(path));
            general(out, camp, user);
            out.printf("Camp Details:\n");
            out.printf("Name: %s\n", camp.getName());
            out.printf("Start Date: %s\n", DateParse.string(camp.getStartDate())); 
            out.printf("End Date: %s\n", DateParse.string(camp.getEndDate())); 
            out.printf("Registration Closing Date: %s\n", DateParse.string(camp.getRegisterBy())); 
            out.printf("Group: %s\n", camp.getGroup().toString()); 
            out.printf("Location: %s\n", camp.getLocation()); 
            out.printf("Total Slots: %s\n", camp.getTotalSlots()); 
            out.printf("Camp Committee Slots: %s\n", camp.getCommitteeSlots()); 
            out.printf("Description: %s\n", camp.getDescription()); 
            out.printf("Staff in Charge: %s\n\n", camp.getStaffInCharge());             

            ArrayList<String> attendees = camp.getAttendeeList();
            Collections.sort(attendees);
            ArrayList<String> committees = camp.getCommitteeList();
            Collections.sort(committees);
            
            if (option == 1 || option == 3) {
                out.printf("Attendees (%d / %d):\n", attendees.size(), camp.getTotalSlots() - camp.getCommitteeSlots()); 
                for (String attendee : attendees) {
                    out.println(attendee);
                }
                out.println();
                
            }
            if (option == 2 || option == 3) {
                out.printf("Committee Members (%d / %d):\n", committees.size(), camp.getCommitteeSlots()); 
                for (String committee : committees) {
                    out.println(committee);
                }
            }
            
            out.close();
        } catch (IOException e) {
            System.out.println("Error generating participant report");
        }
    }

    /**
     * generates a performance report for the specified camp. 
     * Report includes a list of committee members and the points obtained from 
     * replying to enquiries and creating/completing suggestions
     * @param camp is the object for which the performance report is to generate
     * @param user the user generating the report
     */
    public void performance(Camp camp, User user) {
        if (camp == null) return;
        String path = "reports\\performanceReport_"  +  (new Date()).getTime() + ".txt";
        try {
            PrintWriter out = new PrintWriter(new FileWriter(path));
            ArrayList <Enquiry> enquiries = EnquiryControl.instance.getByCamp(camp);
            ArrayList <Suggestion> suggestions = SuggestionControl.instance.getByCamp(camp);
            ArrayList <String> committees = camp.getCommitteeList();
            HashMap <String, Integer> enquiryScores = (new EnquiryScore()).compute(enquiries, committees);
            HashMap <String, Integer> suggestionScores = (new SuggestionScore()).compute(suggestions, committees);

            general(out, camp, user);
            out.printf("User ID | Enquiry Points | Suggestion Points | Total Points\n");
            for (String committee : committees) {
                out.printf(
                    "%-7s | %-14d | %-17d | %d\n", 
                    committee, 
                    enquiryScores.get(committee), 
                    suggestionScores.get(committee), 
                    (enquiryScores.get(committee) + suggestionScores.get(committee))
                );
            }
            out.close();
        } catch (IOException e) {
            System.out.println("Error generating performance report");
        }
    }    
}
