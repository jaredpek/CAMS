package suggestion;

import java.util.ArrayList;

import camp.Camp;
import user.User;

public interface ISuggestion {
    public void approveRejectSuggestions(Camp camp);
    public ArrayList<Suggestion> getByCamp(Camp camp);
    public ArrayList<Suggestion> getByStudent(User student);
}
