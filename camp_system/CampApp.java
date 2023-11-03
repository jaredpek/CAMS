package camp_system;

import java.util.Scanner;

import camp_system.camp.CampControl;
import camp_system.enquiry.EnquiryControl;
import camp_system.suggestion.SuggestionControl;
import camp_system.user.UserControl;

public class CampApp {
    public static void main(String[] args) {
        UserControl userControl = new UserControl(null);
        SuggestionControl suggestoiControl = new SuggestionControl();
        EnquiryControl enquiryControl = new EnquiryControl();
        CampControl campControl = new CampControl();
        CampMenu campMenu = new CampMenu();
        Scanner scan = new Scanner(System.in);

        campMenu.studentMenu();
        System.out.printf("Select Option: "); int option = scan.nextInt(); scan.nextLine();
    }
}
