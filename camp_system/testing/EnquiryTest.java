package camp_system.testing;

import java.util.Date;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

import camp_system.camp.Camp;
import camp_system.camp.CampControl;
import camp_system.date_parser.DateParse;
import camp_system.user.User;
import camp_system.user.Faculty;
import camp_system.user.Role;
import camp_system.enquiry.Enquiry;
import camp_system.enquiry.EnquiryControl;

public class EnquiryTest {
    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) throws ParseException {
        DateParse dateParse = new DateParse();
        User staff1 = new User("staff1", "staff1", "password", Faculty.NTU, Role.STAFF);
        User student1 = new User("student1", "student1", "password", Faculty.CCEB, Role.STUDENT);
        User student2 = new User("student2", "student2", "password", Faculty.SCSE, Role.STUDENT);
        Camp camp1 = new Camp("Camp A","SCSE","AIA","Hallo","11/10/23","10/11/23","30/9/23",2,4,"Ken");
        Camp camp2 = new Camp("Camp B","SCSE","AIA","Heo","11/10/23","10/11/23","30/9/23",2,4,"Ben");
        EnquiryControl enquiryControl = new EnquiryControl();
        while (true) {
            System.out.println("1: View Enquiry");
            System.out.println("2: Add Enquiry");
            System.out.println("3: Edit Enquiry");
            System.out.println("2: Delete Enquiry");
            System.out.printf("Enter Option: ");
            
            int option = scan.nextInt(); scan.nextLine();
            switch (option) {
                case 1: {
                    //if student
                    EnquiryControl e1 = new EnquiryControl();
                    e1 = enquiryControl.getEnquiries(student1);
                    for(int i = 0;i< e1.size();i++){
                        e1.get(i).printEnquiry();
                    }
                    //if committee
                    EnquiryControl e2 = new EnquiryControl();
                    e2 = enquiryControl.getEnquiries(camp1);
                    for(int i = 0;i< e2.size();i++){
                        e2.get(i).printEnquiry();
                    }
                }
                case 2:{
                    //if student
                    enquiryControl.addEnquiry();
                }
                case 3:{
                    //if committee
                    System.out.printf("Edit at index : ");
                    int index = scan.nextInt();
                    enquiryControl.editEnquiry(index);
                }
                case 4:{
                    //if committee
                    System.out.printf("Delete at index : ");
                    int index = scan.nextInt();
                    enquiryControl.deleteEnquiry(index);
                }
            }
        }
    }
}