package camp;

/** An enumeration of the possible roles in the camp */
public enum Role {
    ATTENDEE, COMMITTEE, STAFF;

    /** Returns the string representation of the enumerable */
    public String toString() {
        switch (this) {
            case ATTENDEE: return "ATTENDEE";
            case COMMITTEE: return "COMMITTEE";
            case STAFF: return "STAFF";
            default: return null;
        }
    }

    /**
     * Returns an enumerable from a string
     * @param role String input
     * @return Role
     */
    public Role fromString(String role) {
        switch (role.toUpperCase()) {
            case "ATTENDEE": return ATTENDEE;
            case "COMMITTEE": return COMMITTEE;
            case "STAFF": return STAFF;
            default: return null;
        }
    }
}
