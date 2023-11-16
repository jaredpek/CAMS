package camp_system.camp;

/**
 * An enumeration of the possible roles in the camp
 */
public enum Role {
    ATTENDEE, COMMITTEE, STAFF;

    public String toString() {
        switch (this) {
            case ATTENDEE: return "ATTENDEE";
            case COMMITTEE: return "COMMITTEE";
            case STAFF: return "STAFF";
            default: return null;
        }
    }

    public Role fromString(String role) {
        switch (role.toUpperCase()) {
            case "ATTENDEE": return ATTENDEE;
            case "COMMITTEE": return COMMITTEE;
            case "STAFF": return STAFF;
            default: return null;
        }
    }
}
