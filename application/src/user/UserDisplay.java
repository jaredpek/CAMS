package user;

import java.util.ArrayList;

import camp.Camp;
import camp.CampControl;
import camp.CampSort;
import input.date.DateParse;

/** 
 * Represents a class to display user objects 
 * @author Qiang ZhiQin
 */
public class UserDisplay {
    /**
     * Methods to print the details of a specific user
     * @param user The user to print
     */
    public void user(User user) {
        System.out.printf(
            "%s (%s), %s of %s\n", 
            user.getName(),
            user.getUserID(),
            user.getRole().toString(),
            user.getFaculty().toString()
        );
        System.out.println("Last Login: " + DateParse.string(user.getLastLogin()));
        if (user.getRole() == Role.STAFF) return;

        ArrayList <Camp> camps = CampControl.instance.getByCommittee(user);
        if (camps.size() <= 0) return;
        camps = (new CampSort()).sortByEndDate(camps, 0);
        System.out.println("Committee Of: " + camps.get(0).getName());
    }
}
