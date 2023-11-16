package camp_system.suggestion;

import java.util.ArrayList;

import camp_system.camp.Camp;
import camp_system.user.User;

public interface ISuggestion {
    public void approveRejectSuggestions(Camp camp);
    public ArrayList<Suggestion> getByCamp(Camp camp);
    public ArrayList<Suggestion> getByStudent(User student);
}
