package message;

/**
 * The four possible statuses that a message may have
 * @author Jared Pek
 */
public enum Status {
    PROCESSING, REPLIED, REJECTED, ACCEPTED;

    /** 
     * Converts the enum to a string 
     * @return The String for the respective enum
     */
    public String toString() {
        switch (this) {
            case PROCESSING: return "PROCESSING";
            case REPLIED: return "REPLIED";
            case REJECTED: return "REJECTED";
            case ACCEPTED: return "ACCEPTED";
            default: return null;
        }
    }

    /**
     * Converts a string to an enum, returns null if no matches
     * @param status The status to convert
     * @return Status enum
     */
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
