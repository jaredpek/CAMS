package user;
/**
 * possible role for the user
 */
public enum Role {
    STUDENT, STAFF;
    /**
     * A method to convert enum Role to String type
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
