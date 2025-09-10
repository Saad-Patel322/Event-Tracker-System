package controller;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession; 

import model.Event;
import service.EventService;

public class EventController extends HttpServlet {
    private EventService service;

    @Override
    public void init() {
        service = new EventService();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
       
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("login.jsp");
            return;
        }
        
        String action = request.getParameter("action");
        if (action == null) action = "list";

        switch (action) {
            case "add":
                showAddForm(request, response);
                break;
            case "delete":
                deleteEvent(request, response);
                break;
            default:
                listEvents(request, response);
                break;
        }
    }

    private void showAddForm(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("add-event.jsp");
        rd.forward(request, response);
    }

    private void deleteEvent(HttpServletRequest request, HttpServletResponse response) 
            throws IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            service.deleteEvent(id);
            request.getSession().setAttribute("message", "Event deleted successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            request.getSession().setAttribute("error", "Error deleting event: " + e.getMessage());
        }
        response.sendRedirect("events");
    }

    private void listEvents(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        List<Event> events = service.getAllEvents();
        request.setAttribute("events", events);
        
        
        String message = (String) request.getSession().getAttribute("message");
        String error = (String) request.getSession().getAttribute("error");
        
        if (message != null) {
            request.setAttribute("message", message);
            request.getSession().removeAttribute("message");
        }
        if (error != null) {
            request.setAttribute("error", error);
            request.getSession().removeAttribute("error");
        }
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("events.jsp");
        dispatcher.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws IOException, ServletException {
        
       
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect("login.jsp");
            return;
        }
        
        try {
            Event e = new Event();
            e.setTitle(request.getParameter("title"));
            e.setCategory(request.getParameter("category"));
            e.setLocation(request.getParameter("location"));
            e.setStartTime(request.getParameter("startTime"));
            e.setEndTime(request.getParameter("endTime"));
            e.setOrganizerContact(request.getParameter("contact"));
            e.setStatus("upcoming");

            service.addEvent(e);
            request.getSession().setAttribute("message", "Event added successfully!");
            response.sendRedirect("events");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Error adding event: " + e.getMessage());
            RequestDispatcher rd = request.getRequestDispatcher("add-event.jsp");
            rd.forward(request, response);
        }
    }
}