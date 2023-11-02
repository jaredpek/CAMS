package camp_system;

import camp_system.camp.CampControl;
import camp_system.enquiry.EnquiryControl;
import camp_system.suggestion.SuggestionControl;
import camp_system.user.UserControl;

public class CampApp {
    UserControl userControl = new UserControl(null);
    SuggestionControl suggestoiControl = new SuggestionControl(null);
    EnquiryControl enquiryControl = new EnquiryControl(null);
    CampControl campControl = new CampControl();
    CampMenu camppMenu = new CampMenu();
}
