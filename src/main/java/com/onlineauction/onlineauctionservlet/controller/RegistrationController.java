package com.onlineauction.onlineauctionservlet.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.onlineauction.onlineauctionservlet.model.beans.User;
import com.onlineauction.onlineauctionservlet.model.service.UserService;
import com.onlineauction.onlineauctionservlet.utility.ObjectFactory;
import com.onlineauction.onlineauctionservlet.utility.PasswordEncrypter;

@WebServlet("/register")
public class RegistrationController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public RegistrationController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/accounts/registration.jsp").forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String username = request.getParameter("username");
        String mobile = request.getParameter("mobile");
        LocalDate dob = LocalDate.parse(request.getParameter("dob"));

        String password = request.getParameter("password");
        String address = request.getParameter("address");
        int usertype = Integer.parseInt(request.getParameter("userType"));
        double walletAmount = Double.parseDouble(request.getParameter("walletAmount"));

        ObjectFactory objectFactory = new ObjectFactory();
        UserService userService = objectFactory.createUserServiceImplObj();

        User user = new User();
        user.setName(name);
        user.setUsername(username.toLowerCase());
        user.setEmail(email.toLowerCase());
        user.setPhonenumber(mobile);
        user.setDob(dob);
        user.setPassword(PasswordEncrypter.getSHA(password));
        user.setAddress(address);
        user.setUserType(usertype);
        user.setWallet(walletAmount);
        response.setStatus(userService.addUser(user) == 1 ? 200 : 999);

    }

}
