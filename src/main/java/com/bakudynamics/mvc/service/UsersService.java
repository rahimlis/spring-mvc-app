package com.bakudynamics.mvc.service;

import com.bakudynamics.mvc.dao.User;
import com.bakudynamics.mvc.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    private UserDao userDao;

    public void create(User user) {
        userDao.create(user);
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public boolean exists(User user) {
        return userDao.exists(user);
    }


//    @Secured("ROLE_ADMIN")
    public List<User> getUsers() {
        return userDao.getUsers();
    }

}
