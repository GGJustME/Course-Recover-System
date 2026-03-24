package com.epda.crs.bean;

import com.epda.crs.model.User;
import com.epda.crs.service.UserService;
import java.io.Serializable;
import java.util.List;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;

@Named
@ViewScoped
public class UserBean implements Serializable {
    private final UserService userService = new UserService();

    public List<User> getUsers() { return userService.getUsers(); }
}
