package com.onlineauction.onlineauctionservlet.model.service;


import com.onlineauction.onlineauctionservlet.exceptions.UserNotFoundException;
import com.onlineauction.onlineauctionservlet.model.beans.User;
import com.onlineauction.onlineauctionservlet.model.dao.UserDao;
import com.onlineauction.onlineauctionservlet.model.dao.UserDaoImpl;

public class UserServiceImpl implements UserService {

    UserDao userDao = new UserDaoImpl();

    @Override
    public int addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public User getUser(String username, String password) throws UserNotFoundException {
        return userDao.getUser(username, password);
    }

    @Override
    public int deleteUser() {
        return 0;
    }

    @Override
    public int updateUser() {
        return 0;
    }

}
