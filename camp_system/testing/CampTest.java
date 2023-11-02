package camp_system.testing;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

import camp_system.camp.Camp;
import camp_system.camp.CampControl;
import camp_system.user.User;
import camp_system.user.Faculty;
import camp_system.user.Role;

public class CampTest {
    public static Scanner scan = new Scanner(System.in);
    public static void main(String[] args) throws ParseException {
        User staff1 = new User("staff1", "staff1", "password", Faculty.NTU, Role.STAFF);
        User student1 = new User("student1", "student1", "password", Faculty.CCEB, Role.STUDENT);
        User student2 = new User("student2", "student2", "password", Faculty.SCSE, Role.STUDENT);
        CampControl campControl = new CampControl();
        while (true) {
            System.out.println("1: Add Camp");
            System.out.println("2: Add Template Camp");
            System.out.println("3: View Available Camps");
            System.out.println("4: View Involved Camps");
            System.out.println("5: Edit Camp");
            System.out.println("6: Delete Camp");
            System.out.println("7: Register Attendee");
            System.out.println("8: Register Committee");
            System.out.println("9: Withdraw Camp");
            System.out.printf("Enter Option: ");
            int option = scan.nextInt(); scan.nextLine();
            switch (option) {
                case 1: {
                    campControl.addCamp(staff1);
                    break;
                }
                case 2: {
                    campControl.addTemplate(staff1);
                    break;
                }
                case 3: {
                    ArrayList <Camp> availableCamps = campControl.getCamps(student1.getFaculty());
                    if (availableCamps.size() <= 0) {
                        System.out.println("No Camps Available");
                        break;
                    }
                    campControl.printCamps(availableCamps);
                    break;
                }
                case 4: {
                    ArrayList <Camp> registeredCamps = campControl.getCamps(student2);
                    if (registeredCamps.size() <= 0) {
                        System.out.println("No Camps Registered");
                        break;
                    }
                    campControl.printCamps(registeredCamps);
                    break;
                }
                case 5: {
                    campControl.editCamp(staff1);
                    break;
                }
                case 6: {
                    campControl.deleteCamp(staff1);
                    break;
                }
                case 7: {
                    campControl.registerAttendee(student2);
                    break;
                }
                case 8: {
                    campControl.registerCommittee(student2);
                    break;
                }
                case 9: {
                    campControl.withdrawAttendee(student2);
                    break;
                }
            }
        }
    }
}
