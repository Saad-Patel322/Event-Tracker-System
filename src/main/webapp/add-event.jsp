<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Add Event - EventTrackeSystem</title>
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

  <div class="container">
    <h2>Create Event</h2>
    <form action="events" method="post">
      <div class="form-group">
        <input type="text" name="title" placeholder="Event Title" required>
      </div>
      <div class="form-group">
        <input type="text" name="category" placeholder="Category (e.g., Tech, Music)" required>
      </div>
      <div class="form-group">
        <input type="text" name="location" placeholder="Location" required>
      </div>
      <div class="form-group">
        <label>Start Time:</label>
        <input type="datetime-local" name="startTime" required>
      </div>
      <div class="form-group">
        <label>End Time:</label>
        <input type="datetime-local" name="endTime" required>
      </div>
      <div class="form-group">
        <input type="text" name="contact" placeholder="Organizer Contact (email/phone)" required>
      </div>
      <button class="btn" type="submit">Add Event</button>
    </form>
  </div>
</body>
</html>
    