package controller;

import service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/auth/*")
public class AuthController extends HttpServlet {
    private UserService userService;
    
    @Override
    public void init() {
        userService = new UserService();
    }
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String path = request.getPathInfo();
        
        if (path == null) path = "/";
        
        switch (path) {
            case "/signup":
                request.getRequestDispatcher("/signup.jsp").forward(request, response);
                break;
            case "/login":
                request.getRequestDispatcher("/login.jsp").forward(request, response);
                break;
            default:
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
    
   
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String path = request.getPathInfo();
        
        if (path == null) path = "/";
        
        switch (path) {
            case "/signup":
                handleSignup(request, response);
                break;
            case "/login":
                handleLogin(request, response);
                break;
            default:
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
    
    private void handleSignup(HttpServletRequest request, HttpServletResponse response) 
            throws IOException, ServletException {
        
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        boolean isRegistered = userService.registerUser(name, email, password);
        
        if (isRegistered) {
            request.getSession().setAttribute("message", "Registration successful! Please login.");
            response.sendRedirect("../login.jsp"); 
        } else {
            request.setAttribute("error", "Email already exists or registration failed");
            request.getRequestDispatcher("/signup.jsp").forward(request, response);
        }
    }
    
    private void handleLogin(HttpServletRequest request, HttpServletResponse response) 
            throws IOException, ServletException {
        
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        var user = userService.loginUser(email, password);
        
        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            session.setAttribute("message", "Welcome back, " + user.getName() + "!");
            response.sendRedirect("../events"); 
        } else {
            request.setAttribute("error", "Invalid email or password");
            request.getRequestDispatcher("/login.jsp").forward(request, response);
        }
    }
}