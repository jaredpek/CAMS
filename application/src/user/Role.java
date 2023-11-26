package user;
/**
 * possible role for the user
 * @author Qiang ZhiQin
 */
public enum Role {
    STUDENT, STAFF;
    /**
     * A method to convert enum Role to String type
     * @return The respective String for the enum
     */
    public String toString() {
        switch (this) {
            case STUDENT: return "STUDENT";
            case STAFF: return "STAFF";
            default: return null;
        }
    }
    /**
     * A method to convert String to enum Role
     * @param role The string to convert to enum
     * @return The respective Role enum
     */
    public static Role fromString(String role) {
        role = role.toUpperCase();
        switch (role.toUpperCase()) {
            case "STUDENT": return STUDENT;
            case "STAFF": return STAFF;
            default: return null;
        }
    }
}
