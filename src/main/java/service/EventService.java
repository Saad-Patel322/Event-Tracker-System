package service;

import dao.EventDAO;
import model.Event;

import java.util.List;

public class EventService {
    private final EventDAO dao = new EventDAO();

    public EventService() {
        dao.createTableIfNotExists();
        
        if (getAllEvents().isEmpty()) {
            initializeSampleData();
        }
    }

    public boolean addEvent(Event e) {
        return dao.addEvent(e);
    }

    public List<Event> getAllEvents() {
        return dao.getAllEvents();
    }

    public boolean deleteEvent(int id) {
        return dao.deleteEvent(id);
    }
    
    
    private void initializeSampleData() {
        try {
            Event event1 = new Event();
            event1.setTitle("Tech Conference 2023");
            event1.setCategory("Conference");
            event1.setLocation("Convention Center, New Delhi");
            event1.setStartTime("2023-12-15T09:00");
            event1.setEndTime("2023-12-15T17:00");
            event1.setOrganizerContact("tech@example.com");
            event1.setStatus("upcoming");
            dao.addEvent(event1);
            
            Event event2 = new Event();
            event2.setTitle("Music Festival");
            event2.setCategory("Music");
            event2.setLocation("City Park, Mumbai");
            event2.setStartTime("2023-12-20T14:00");
            event2.setEndTime("2023-12-20T22:00");
            event2.setOrganizerContact("music@example.com");
            event2.setStatus("upcoming");
            dao.addEvent(event2);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}