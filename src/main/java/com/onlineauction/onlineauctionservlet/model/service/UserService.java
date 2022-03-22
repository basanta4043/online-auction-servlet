package com.onlineauction.onlineauctionservlet.model.service;


import com.onlineauction.onlineauctionservlet.exceptions.UserNotFoundException;
import com.onlineauction.onlineauctionservlet.model.beans.User;

public interface UserService {
    int addUser(User user);

    User getUser(String username, String password) throws UserNotFoundException;

    int deleteUser();

    int updateUser();
}
