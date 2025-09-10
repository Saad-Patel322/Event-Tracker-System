package service;

import dao.UserDAO;
import model.User;

public class UserService {
    private UserDAO userDao;
    
    public UserService() {
        userDao = new UserDAO();
    }
    
    public boolean registerUser(String name, String email, String password) {
        
        if (userDao.getUserByEmail(email) != null) {
            return false;
        }
        
        User user = new User(name, email, password);
        return userDao.addUser(user);
    }
    
    public User loginUser(String email, String password) {
        User user = userDao.getUserByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }
}