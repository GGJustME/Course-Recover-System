package com.epda.crs.service;

import com.epda.crs.dao.UserDAO;
import com.epda.crs.model.User;
import jakarta.ejb.Stateless;
import java.util.List;

@Stateless
public class UserService {
    private final UserDAO userDAO = new UserDAO();

    public List<User> getUsers() { 
        return userDAO.findAll(); 
    }

    public void saveUser(User user) {
        if (user.getId() == null || user.getId() == 0) {
            userDAO.save(user); // Insert new user
        } else {
            userDAO.update(user); // Update existing user
        }
    }

    public void toggleUserStatus(Long userId, boolean activate) {
        userDAO.setActiveStatus(userId, activate);
    }
}