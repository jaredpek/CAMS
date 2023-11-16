package camp_system.enquiry;

public enum Status {
    PROCESSING, REPLIED;

    public String toString() {
        switch (this) {
            case PROCESSING: return "PROCESSING";
            case REPLIED: return "REPLIED";
            default: return null;
        }
    }

    public static Status fromString(String status) {
        switch (status.toUpperCase()) {
            case "PROCESSING": return PROCESSING;
            case "REPLIED": return REPLIED;
            default: return null;
        }
    }
}
