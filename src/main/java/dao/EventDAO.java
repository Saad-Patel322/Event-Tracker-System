package dao;


import model.Event;
import util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EventDAO {

    public void createTableIfNotExists() {
        String sql = "CREATE TABLE IF NOT EXISTS events ("
                + "id INT AUTO_INCREMENT PRIMARY KEY, "
                + "title VARCHAR(255), "
                + "category VARCHAR(100), "
                + "location VARCHAR(255), "
                + "start_time VARCHAR(50), "
                + "end_time VARCHAR(50), "
                + "organizer_contact VARCHAR(255), "
                + "status VARCHAR(20) DEFAULT 'upcoming')";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement st = conn.createStatement()) {
            st.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean addEvent(Event e) {
        String sql = "INSERT INTO events (title, category, location, start_time, end_time, organizer_contact, status) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, e.getTitle());
            ps.setString(2, e.getCategory());
            ps.setString(3, e.getLocation());
            ps.setString(4, e.getStartTime());
            ps.setString(5, e.getEndTime());
            ps.setString(6, e.getOrganizerContact());
            ps.setString(7, e.getStatus() == null ? "upcoming" : e.getStatus());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public List<Event> getAllEvents() {
        List<Event> list = new ArrayList<>();
        String sql = "SELECT * FROM events ORDER BY id DESC";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Event e = new Event(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("category"),
                        rs.getString("location"),
                        rs.getString("start_time"),
                        rs.getString("end_time"),
                        rs.getString("organizer_contact"),
                        rs.getString("status")
                );
                list.add(e);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public boolean deleteEvent(int id) {
        String sql = "DELETE FROM events WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
