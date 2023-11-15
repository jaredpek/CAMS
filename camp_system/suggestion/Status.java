package camp_system.suggestion;

/**
 * The three possible statuses that a suggestion may have
 */
public enum Status {
    PROCESSING, REJECTED, ACCEPTED;

    public String toString() {
        switch (this) {
            case PROCESSING: return "PROCESSING";
            case REJECTED: return "REJECTED";
            case ACCEPTED: return "ACCEPTED";
            default: return null;
        }
    }

    public static Status fromString(String status) {
        switch (status) {
            case "PROCESSING": return PROCESSING;
            case "REJECTED": return REJECTED;
            case "ACCEPTED": return ACCEPTED;
            default: return null;
        }
    }
}
