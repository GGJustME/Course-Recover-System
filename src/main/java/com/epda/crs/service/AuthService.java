package com.epda.crs.service;

import com.epda.crs.dao.UserDAO;
import com.epda.crs.exception.AuthenticationException;
import com.epda.crs.model.User;
import com.epda.crs.enums.AccountStatus;
import java.util.Optional;
import jakarta.ejb.Stateless;

@Stateless
public class AuthService {
    private final UserDAO userDAO = new UserDAO();

    public User login(String username, String password) {
        Optional<User> user = userDAO.findByUsername(username);
        
        if (user.isPresent() && user.get().getPassword().equals(password)) {
            // Check if the account was deactivated by the Admin
            if (user.get().getStatus() == AccountStatus.INACTIVE) {
                throw new AuthenticationException("Account is inactive. Please contact the administrator.");
            }
            return user.get();
        }
        throw new AuthenticationException("Invalid username or password.");
    }
}