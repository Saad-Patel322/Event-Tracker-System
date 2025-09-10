package model;


public class Event {
    private int id;
    private String title;
    private String category;
    private String location;
    private String startTime; 
    private String endTime;
    private String organizerContact;
    private String status; 

    public Event() {}

    public Event(int id, String title, String category, String location,
                 String startTime, String endTime, String organizerContact, String status) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.location = location;
        this.startTime = startTime;
        this.endTime = endTime;
        this.organizerContact = organizerContact;
        this.status = status;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public String getStartTime() { return startTime; }
    public void setStartTime(String startTime) { this.startTime = startTime; }

    public String getEndTime() { return endTime; }
    public void setEndTime(String endTime) { this.endTime = endTime; }

    public String getOrganizerContact() { return organizerContact; }
    public void setOrganizerContact(String organizerContact) { this.organizerContact = organizerContact; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
