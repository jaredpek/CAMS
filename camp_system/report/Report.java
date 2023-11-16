package camp_system.report;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import camp_system.camp.Camp;
import camp_system.enquiry.Enquiry;
import camp_system.enquiry.EnquiryControl;
import camp_system.enquiry.EnquiryScore;
import camp_system.suggestion.Suggestion;
import camp_system.suggestion.SuggestionControl;
import camp_system.suggestion.SuggestionScore;

public class Report {
    public static void participantReport (Camp camp) throws IOException {
        String path = "camp_system\\report\\generated\\participantReport_" + (new Date()).getTime();
        File file = new File(path);
        
        try (
            FileWriter fw = new FileWriter(file, false);
            BufferedWriter bw = new BufferedWriter(fw);
        ) {
            bw.write("Name: " + camp.getName());
            bw.newLine();
            
            bw.write("Start Date: " + String.valueOf(camp.getStartDate()));
            bw.newLine();
        
            bw.write("End Date: " + String.valueOf(camp.getEndDate()));
            bw.newLine();
        
            bw.write("Registration Closing Date: " + String.valueOf(camp.getRegisterBy()));
            bw.newLine();
        
            bw.write("Group: " + camp.getGroup());
            bw.newLine();
        
            bw.write("Location: " + camp.getLocation());
            bw.newLine();
        
            bw.write("Total Slots: " + camp.getTotalSlots());
            bw.newLine();
        
            bw.write("Camp Committee Slots: " + camp.getCommitteeSlots());
            bw.newLine();
        
            bw.write("Description: " + camp.getDescription());
            bw.newLine();
        
            bw.write("Staff in Charge: " + camp.getStaffInCharge());
            bw.newLine();
        
            bw.write("Attendee List: " + camp.getAttendeeList());
            bw.newLine();
        
            bw.write("Camp Committee List: " + camp.getCommitteeList());
            bw.newLine();
        }
    }
   public static void performanceReport(Camp camp) throws IOException {
        String path = "camp_system\\report\\generated\\performanceReport_"  +  (new Date()).getTime();
        File file = new File(path);

        try (
            FileWriter fw = new FileWriter(file, false);
            BufferedWriter bw = new BufferedWriter(fw);
        ) {
            ArrayList <Enquiry> enquiries = EnquiryControl.getByCamp(camp);
            ArrayList <Suggestion> suggestions = SuggestionControl.getByCamp(camp);
            ArrayList <String> committee = camp.getCommitteeList();
            HashMap <String, Integer> enquiryScores = EnquiryScore.compute(enquiries, committee);
            HashMap <String, Integer> suggestionScores = SuggestionScore.compute(suggestions, committee);

            bw.write("User ID / Total Points");
            for (String user : committee) {
                bw.write(user + " / " + (enquiryScores.get(user) + suggestionScores.get(user)));
                bw.newLine();
            }
        }
    }    
}
