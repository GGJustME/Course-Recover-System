package com.epda.crs.service;

import com.epda.crs.dao.UserDAO;
import com.epda.crs.model.User;
import java.util.List;
import jakarta.ejb.Stateless;

@Stateless
public class UserService {
    private final UserDAO userDAO = new UserDAO();

    public List<User> getUsers() { return userDAO.findAll(); }
}
