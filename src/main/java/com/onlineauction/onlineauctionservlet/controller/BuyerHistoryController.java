
package com.onlineauction.onlineauctionservlet.controller;

import com.onlineauction.onlineauctionservlet.model.beans.ProductForAuction;
import com.onlineauction.onlineauctionservlet.model.beans.User;
import com.onlineauction.onlineauctionservlet.model.service.ProductService;
import com.onlineauction.onlineauctionservlet.utility.ObjectFactory;

import java.io.IOException;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/buyerhistory")
public class BuyerHistoryController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public BuyerHistoryController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        User userInSession = (User) session.getAttribute("user");
        if (userInSession == null)
            request.getRequestDispatcher("/accounts/login.jsp").forward(request, response);
        else {
            if (userInSession.getUserType() == 1) {
                System.out.println("In seller:" + (User) session.getAttribute("user"));
                response.sendRedirect("sellerhistory");
            } else if (userInSession.getUserType() == 0) {
                System.out.println("In buyer:" + (User) session.getAttribute("user"));
                int uid = userInSession.getUserid();
                ObjectFactory objectFactory = new ObjectFactory();
                ProductService productService = objectFactory.createProductServiceImplObj();
                List<ProductForAuction> test = productService.getProductHistory(uid);
                for (ProductForAuction t : test) {
                    System.out.println("buyer history::" + t);
                }
                request.setAttribute("products", test);
                request.getRequestDispatcher("/buyer/buyerHistory.jsp").forward(request, response);

            } else {
                System.out.println("something error from login-servlet");
            }
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
