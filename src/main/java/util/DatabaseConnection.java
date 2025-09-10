package util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    
    private static final String URL = "jdbc:mysql://localhost:3306/eventdb?useSSL=false&serverTimezone=UTC";
    private static final String USER = "root";
    private static final String PASS = "muhammad@"; 
    
    public static Connection getConnection() {
        try {
            System.out.println("Attempting to connect to database...");
            System.out.println("URL: " + URL);
            System.out.println("User: " + USER);
            
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("MySQL Driver loaded successfully");
            
            
            Connection conn = DriverManager.getConnection(URL, USER, PASS);
            System.out.println("Database connection successful!");
            return conn;
            
        } catch (ClassNotFoundException e) {
            System.err.println("MySQL JDBC Driver not found!");
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            System.err.println("Database connection failed!");
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}