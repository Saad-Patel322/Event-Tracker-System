<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>EventTrackeSystem</title>
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
    
    <div style="margin-left: auto;">
      <a href="signup.jsp">
        <button style="background-color: #4CAF50; color: white; padding: 8px 15px; border: none; border-radius: 4px; margin-right: 10px;">
            Sign Up
        </button>
      </a>
      <a href="login.jsp">
        <button style="background-color: #008CBA; color: white; padding: 8px 15px; border: none; border-radius: 4px;">
            Login
        </button>
      </a>
    </div>
  </div>

  <div class="container">
    <div class="hero">
      <h2>Find events nearby — fast & simple</h2>
      <form action="events" method="get">
        <input type="text" name="search" placeholder="Search events by name or category...">
        <button type="submit">Search</button>
      </form>
    </div>
    <p style="text-align:center; color:#666">Use Events → Create Event to add demo events.</p>
  </div>
</body>
</html>
