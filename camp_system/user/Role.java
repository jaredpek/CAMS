package camp_system.user;

public enum Role {
    STUDENT, STAFF;

    public String toString() {
        switch (this) {
            case STUDENT: return "STUDENT";
            case STAFF: return "STAFF";
            default: return null;
        }
    }
    public static Role fromString(String role) {
        role = role.toUpperCase();
        switch (role.toUpperCase()) {
            case "STUDENT": return STUDENT;
            case "STAFF": return STAFF;
            default: return null;
        }
    }
}
