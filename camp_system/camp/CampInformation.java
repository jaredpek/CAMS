package camp_system.camp;

import java.util.Date;

import camp_system.user.Faculty;

/**
 * Represents the core camp information for a camp
 */
public class CampInformation {
    /** Name of the camp */
    private String name; 

    /** Location of the camp */
    private String location; 

    /** Description of the camp */
    private String description;

    /** Start date of the camp */
    private Date startDate;

    /** End date of the camp */
    private Date endDate;

    /** Latest date to register for the camp */
    private Date registerBy;

    /** Total numbe of slots in the camp (committee and attendee) */
    private int totalSlots;

    /** Number of slots for committee members */
    private int committeeSlots;

    /** Staff in charge of the camp */
    private String staffInCharge;

    /** Group the camp is open to */
    Faculty group;
    
    /**
     * Creates a new CampInformation object with the relevant details
     * @param name This is the camp's name
     * @param group This is the group the camp is open to
     * @param location This is where the camp will be held
     * @param description This is the description of the camp
     * @param startDate This is when the camp starts
     * @param endDate This is the when the camp ends
     * @param registerBy This is when students must register for the camp
     * @param totalSlots This is the total number of slots available for the camp (both committee and attendees)
     * @param committeeSlots This is the number of slots available for committee members
     * @param staffInCharge This is the staff that is in charge of the entire camp
     */
    public CampInformation(
        String name,
        Faculty group,
        String location,
        String description,
        Date startDate,
        Date endDate,
        Date registerBy,
        int totalSlots,
        int committeeSlots,
        String staffInCharge
    ) {
        this.name = name;
        this.group = group;
        this.location = location;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.registerBy = registerBy;
        this.totalSlots = totalSlots;
        this.committeeSlots = committeeSlots;
        this.staffInCharge = staffInCharge;
    }

    /**
     * Returns the current name of the camp
     * @return String
     */
    public String getName() { return name; }

    /**
     * Sets a new name for the camp
     * @param name This is the new name of the camp
     */
    protected void setName(String name) { this.name = name; }

    /**
     * Returns the current start date of the camp
     * @return Date
     */
    public Date getStartDate() { return startDate; }

    /**
     * Sets a new start date for the camp
     * @param startDate This is the new start date
     */
    protected void setStartDate(Date startDate) { this.startDate = startDate; }

    /**
     * Returns the current end date for the camp
     * @return Date
     */
    public Date getEndDate() { return endDate; }

    /**
     * Sets a new end date for the camp
     * @param endDate This is the new end date
     */
    protected void setEndDate(Date endDate) { this.endDate = endDate; }

    /**
     * Returns the current latest registration date for the camp
     * @return Date
     */
    public Date getRegisterBy() { return registerBy; }

    /**
     * Sets a new registration date that students must register by
     * @param registerBy This is the new registration date
     */
    protected void setRegisterBy(Date registerBy) { this.registerBy = registerBy; }

    /**
     * Returns the group that the camp is open to
     * @return Faculty
     */
    public Faculty getGroup() { return group; }

    /**
     * Sets a new group that the camp is open to
     * @param group This is the new group
     */
    protected void setGroup(Faculty group) { this.group = group; }

    /**
     * Returns the current location the camp will be held at
     * @return String
     */
    public String getLocation() { return location; }

    /**
     * Sets a new location where the camp will be held at
     * @param location This is the new location
     */
    protected void setLocation(String location) { this.location = location; }

    /**
     * Returns the current total number of slots for the camp (committee and attendees)
     * @return int
     */
    public int getTotalSlots() { return totalSlots; }

    /**
     * Sets a new total number of slots for the camp
     * @param totalSlots This is the new number of slots
     */
    protected void setTotalSlots(int totalSlots) { this.totalSlots = totalSlots; }

    /**
     * Returns the current number of committee members slots for the camp
     * @return int
     */
    public int getCommitteeSlots() { return committeeSlots; }

    /**
     * Sets a new number of committee slots for the camp
     * @param committeeSlots This is the new number of slots
     */
    protected void setCommitteeSlots(int committeeSlots) { this.committeeSlots = committeeSlots; }
    
    /**
     * Returns the current description of the camp
     * @return String
     */
    public String getDescription() { return description; }

    /**
     * Sets a new description for the camp
     * @param description This is the new description
     */
    protected void setDescription(String description) { this.description = description; }

    /**
     * Returns the current staff that is in charge of the camp
     * @return User
     */
    public String getStaffInCharge() { return staffInCharge; }
}
