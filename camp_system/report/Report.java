package camp_system.report;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import camp_system.camp.Camp;
import camp_system.user.User;

public class Report {
     public void participantReport (Camp camp) throws IOException
    {
        String path = "camp_system\\report\\generated\\participantReport_" + (new Date()).getTime();
        File file = new File(path);
        
        try (FileWriter fw = new FileWriter(file, false);
                BufferedWriter bw = new BufferedWriter(fw)) 
        {
             bw.write(camp.getName());
             bw.newLine();
               
             bw.write("Start Date: "+String.valueOf(camp.getStartDate()));
             bw.newLine();
            
             bw.write("End Date: "+String.valueOf(camp.getEndDate()));
             bw.newLine();
            
             bw.write("Registration Closing Date: "+String.valueOf(camp.getRegisterBy()));
             bw.newLine();
            
             bw.write("Group: "+camp.getGroup());
             bw.newLine();
            
             bw.write("Location: "+camp.getLocation());
             bw.newLine();
            
             bw.write("Total Slots: "+camp.getTotalSlots());
             bw.newLine();
            
             bw.write("Camp Committee Slots: "+camp.getCommitteeSlots());
             bw.newLine();
            
             bw.write("Description: "+camp.getDescription());
             bw.newLine();
            
             bw.write("Staff in Charge: "+camp.getStaffInCharge());
             bw.newLine();
            
             bw.write("Attendee List: "+camp.getAttendeeList());
             bw.newLine();
            
             bw.write("Camp Committee List: "+camp.getCommitteeList());
             bw.newLine();
               
           }
    }
   public void performanceReport(Camp camp) throws IOException {
       
        String path = "camp_system\\report\\generated\\performanceReport_" + (new Date()).getTime();
        File file = new File(path);

        try (FileWriter fw = new FileWriter(file, false);
             BufferedWriter bw = new BufferedWriter(fw)) {
            List<String> committee = camp.getCommitteeList();

            for (String user : committee) {

                bw.write("Name: " + user);
                bw.newLine();

                // bw.write("Total points: " + user.getPoint());
                // bw.newLine();
            }
        }
    }

    //test
    /*
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");
        Date start = sdf.parse("09/11/23");
        Date end = sdf.parse("30/09/23");
        Date regBy = sdf.parse("30/09/23");

        User staffUser = new User("Rachel", "staff001", "password", Faculty.ADM, Role.STAFF, null, 0);
        User committeeUser = new User("CommitteeMember", "com001", "password", Faculty.SCSE, Role.STUDENT, null, 0);
        User attendeeUser = new User("Attendee", "att001", "password", Faculty.SBS, Role.STUDENT, null, 0);

        Camp camp = new Camp("Camp A", Faculty.EEE, "AIA", "Hallo",start,end,regBy, 5, 4, staffUser);

        camp.addCommittee(committeeUser);
        camp.addAttendee(attendeeUser);

        committeeUser.setPoint(10);
        List<User> committeeList = new ArrayList<>();
        committeeList.add(committeeUser);

        // Create report instance and generate reports
        Report report = new Report();
        try {
            report.participantReport(camp);
            report.performanceReport(camp);
            System.out.println("Reports generated successfully. Check the CSV files.");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("An error occurred while generating the reports.");
        }
    }

     */
    
}
