package camp_system.message;

/**
 * The four possible statuses that a message may have
 */
public enum Status {
    PROCESSING, REPLIED, REJECTED, ACCEPTED;

    public String toString() {
        switch (this) {
            case PROCESSING: return "PROCESSING";
            case REPLIED: return "REPLIED";
            case REJECTED: return "REJECTED";
            case ACCEPTED: return "ACCEPTED";
            default: return null;
        }
    }

    public static Status fromString(String status) {
        switch (status.toUpperCase()) {
            case "PROCESSING": return PROCESSING;
            case "REPLIED": return REPLIED;
            case "REJECTED": return REJECTED;
            case "ACCEPTED": return ACCEPTED;
            default: return null;
        }
    }
}
