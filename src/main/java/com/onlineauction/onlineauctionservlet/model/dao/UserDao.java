package com.onlineauction.onlineauctionservlet.model.dao;


import com.onlineauction.onlineauctionservlet.exceptions.UserNotFoundException;
import com.onlineauction.onlineauctionservlet.model.beans.User;

public interface UserDao {
    int addUser(User user);

    User getUser(String username, String password) throws UserNotFoundException;

    int deleteUser();

    int updateUser();

    boolean getUserIfExist(String username, String email);
}
