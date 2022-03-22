package com.onlineauction.onlineauctionservlet.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.onlineauction.onlineauctionservlet.exceptions.UserNotFoundException;
import com.onlineauction.onlineauctionservlet.model.beans.User;
import com.onlineauction.onlineauctionservlet.model.service.UserService;
import com.onlineauction.onlineauctionservlet.model.service.UserServiceImpl;

@WebServlet("/login")
public class LoginController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    UserService userService = new UserServiceImpl();

    public LoginController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        User userInSession = (User) session.getAttribute("user");
        if (userInSession == null) {
            request.getRequestDispatcher("/accounts/login.jsp").forward(request, response);
        } else {
            if (userInSession.getUserType() == 1) {
                System.out.println("In seller:" + (User) session.getAttribute("user"));
                response.sendRedirect("sellerhistory");
            } else if (userInSession.getUserType() == 0) {
                System.out.println("In buyer:" + (User) session.getAttribute("user"));
                response.sendRedirect("home");
            } else {
                System.out.println("something error from loginservlet");
            }
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        HttpSession session = request.getSession();
        User sessionuser = (User) session.getAttribute("user");
        if (sessionuser == null) {
            User temp;
            try {
                temp = userService.getUser(username, password);
                if (temp != null) {
                    session.setAttribute("user", temp);
                    session.setAttribute("isUserAuthenticated", true);
                    session.setAttribute("userType", temp.getUserType());
                    if (temp.getUserType() == 1) {
                        System.out.println("In seller:" + (User) session.getAttribute("user"));
                        response.setStatus(200);
                    } else if (temp.getUserType() == 0) {
                        System.out.println("In buyer:" + (User) session.getAttribute("user"));
                        response.setStatus(200);
                    } else {
                        response.setStatus(999);
                        System.out.println("something error from login-servlet");
                    }
                }
            } catch (UserNotFoundException e) {
                //USER NOT FOUND
                response.setStatus(999);
                System.out.println("Exception::" + e.getMessage());


            }

        } else {
            System.out.println("session is not null");
//			User userInSession = (User) session.getAttribute("user");
//			if(userInSession.getUserType()==1) {
//				System.out.println("In seller:"+userInSession);
//				request.getRequestDispatcher("/seller/SellerProfile.jsp").forward(request, response);
//			}
//			else if(userInSession.getUserType()==0) {
//				System.out.println("In buyer:"+userInSession);
//
//				request.getRequestDispatcher("/buyer/BuyerProfile.jsp").forward(request, response);
//				//response.sendRedirect(request.getContextPath() + "/buyer/BuyerProfile.jsp");
//			}
        }
    }

}
