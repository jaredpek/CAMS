package report;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;

import camp.Camp;
import enquiry.Enquiry;
import enquiry.EnquiryControl;
import enquiry.EnquiryScore;
import scanner.Scan;
import suggestion.Suggestion;
import suggestion.SuggestionControl;
import suggestion.SuggestionScore;

public class Report implements IReport {
    public static Report instance = new Report();

    public void menu() {
        System.out.println("Select Filter Option: ");
        System.out.println("1. Attendee List");
        System.out.println("2. Committee List");
        System.out.println("3. None (Default)");
    }
    /**
     * generates a particpant report for the specified camp
     * report includes Camp Information and the attendee/committee list
     * @param camp is the object for which the participant report is to generate
     */
    public void participant(Camp camp) {
        menu();
        System.out.printf("Option: "); int option = Scan.scan.nextInt(); Scan.scan.nextLine();

        String path = ".\\application\\reports\\participantReport_" + (new Date()).getTime();
        File file = new File(path);

        try {
            FileWriter fw = new FileWriter(file, false);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("Name: " + camp.getName()); bw.newLine();
            bw.write("Start Date: " + String.valueOf(camp.getStartDate())); bw.newLine();
            bw.write("End Date: " + String.valueOf(camp.getEndDate())); bw.newLine();
            bw.write("Registration Closing Date: " + String.valueOf(camp.getRegisterBy())); bw.newLine();
            bw.write("Group: " + camp.getGroup()); bw.newLine();
            bw.write("Location: " + camp.getLocation()); bw.newLine();
            bw.write("Total Slots: " + camp.getTotalSlots()); bw.newLine();
            bw.write("Camp Committee Slots: " + camp.getCommitteeSlots()); bw.newLine();
            bw.write("Description: " + camp.getDescription()); bw.newLine();
            bw.write("Staff in Charge: " + camp.getStaffInCharge()); bw.newLine();
            bw.newLine();

            ArrayList<String> attendees = camp.getAttendeeList();
            Collections.sort(attendees);
            ArrayList<String> committees = camp.getCommitteeList();
            Collections.sort(committees);
            
            if (option == 1 || option == 3) {
                bw.write("Attendee List: "); bw.newLine();
                for (String attendee : attendees) {
                    bw.write(attendee);
                    bw.newLine();
                }
                bw.newLine();
            }
            if (option == 2 || option == 3) {
                bw.write("Committee List: "); bw.newLine();
                for (String committee : committees) {
                    bw.write(committee);
                    bw.newLine();
                }
            }
            
            bw.close();
        } catch (IOException e) {
            System.out.println("Error generating participant report");
        }
    }

    /**
     * generates a performance report for the specified camp. 
     * Report includes a list of committee members and the points obtained from 
     * replying to enquiries and creating/completing suggestions
     * @param camp is the object for which the performance report is to generate
     */
    public void performance(Camp camp) {
        String path = ".\\application\\reports\\performanceReport_"  +  (new Date()).getTime();
        File file = new File(path);
        
        try {
            FileWriter fw = new FileWriter(file, false);
            BufferedWriter bw = new BufferedWriter(fw);
            ArrayList <Enquiry> enquiries = EnquiryControl.instance.getByCamp(camp);
            ArrayList <Suggestion> suggestions = SuggestionControl.instance.getByCamp(camp);
            ArrayList <String> committee = camp.getCommitteeList();
            HashMap <String, Integer> enquiryScores = EnquiryScore.compute(enquiries, committee);
            HashMap <String, Integer> suggestionScores = SuggestionScore.compute(suggestions, committee);

            bw.write("User ID / Total Points"); bw.newLine();
            for (String user : committee) {
                bw.write(user + " / " + (enquiryScores.get(user) + suggestionScores.get(user))); bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            System.out.println("Error generating performance report");
        }
    }    
}
