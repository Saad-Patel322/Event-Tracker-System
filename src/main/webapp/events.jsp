<%@ page import="java.util.List" %>
<%@ page import="model.Event" %>
<%
    
    Object eventsObj = request.getAttribute("events");
    List<Event> events = null;
    if (eventsObj instanceof List) {
        events = (List<Event>) eventsObj;
    }
    
    String message = (String) request.getAttribute("message");
    String error = (String) request.getAttribute("error");
%>

<!DOCTYPE html>
<html>
<head>
    <title>Events - EventTrackeSystem</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
    <div class="navbar">
        <h1>EventTrackeSystem</h1>
        <div>
            <a href="index.jsp">Home</a>
            <a href="events">Events</a>
            <a href="add-event.jsp">Create Event</a>
            <a href="contact.jsp">Contact</a>
        </div>
    </div>

    <div class="container mt-4">
        <h2 class="text-center mb-4">All Events</h2>
        
        <!-- Messages -->
        <% if (message != null) { %>
            <div class="alert alert-success alert-dismissible fade show">
                <%= message %>
                <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
            </div>
        <% } %>
        
        <% if (error != null) { %>
            <div class="alert alert-danger alert-dismissible fade show">
                <%= error %>
                <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
            </div>
        <% } %>
        
        <div class="d-flex justify-content-between mb-3">
            <a href="index.jsp" class="btn btn-secondary">Home</a>
            <a href="events?action=add" class="btn btn-primary">Add New Event</a>
        </div>
        
        <% if (events != null && !events.isEmpty()) { %>
            <div class="row">
                <% for (Event event : events) { %>
                    <div class="col-md-6 mb-3">
                        <div class="card h-100">
                            <div class="card-body">
                                <h5 class="card-title"><%= event.getTitle() %></h5>
                                <h6 class="card-subtitle mb-2 text-muted"><%= event.getCategory() %></h6>
                                <p class="card-text">
                                    <strong>Location:</strong> <%= event.getLocation() %><br>
                                    <strong>Start:</strong> <%= event.getStartTime() %><br>
                                    <strong>End:</strong> <%= event.getEndTime() %><br>
                                    <strong>Contact:</strong> <%= event.getOrganizerContact() %><br>
                                    <strong>Status:</strong> 
                                    <span class="badge bg-success"><%= event.getStatus() %></span>
                                </p>
                            </div>
                            <div class="card-footer">
                                <a href="events?action=delete&id=<%= event.getId() %>" 
                                   class="btn btn-danger btn-sm"
                                   onclick="return confirm('Are you sure you want to delete this event?')">
                                    Delete
                                </a>
                            </div>
                        </div>
                    </div>
                <% } %>
            </div>
        <% } else { %>
            <div class="alert alert-info text-center">
                <h4>No events found!</h4>
                <p>Get started by adding your first event.</p>
                <a href="events?action=add" class="btn btn-primary">Add Your First Event</a>
            </div>
        <% } %>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>