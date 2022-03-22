package com.onlineauction.onlineauctionservlet.controller;

import java.io.IOException;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.onlineauction.onlineauctionservlet.model.beans.Bid;
import com.onlineauction.onlineauctionservlet.model.beans.Category;
import com.onlineauction.onlineauctionservlet.model.beans.ProductForAuction;
import com.onlineauction.onlineauctionservlet.model.beans.User;
import com.onlineauction.onlineauctionservlet.model.service.ProductService;
import com.onlineauction.onlineauctionservlet.utility.MyTimerTask;
import com.onlineauction.onlineauctionservlet.utility.ObjectFactory;


@WebServlet("/home")
public class DefaultController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    public void init() throws ServletException {
        MyTimerTask.scheduleAcution();
    }

    public DefaultController() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User userInSession = (User) session.getAttribute("user");
        if (userInSession == null) {
            System.out.println("session null");
            ObjectFactory objectFactory = new ObjectFactory();
            ProductService productService = objectFactory.createProductServiceImplObj();
            List<ProductForAuction> test = productService.getBidProducts();
            for (ProductForAuction t : test) {
                System.out.println(t);
            }
            session.setAttribute("products", test);

            List<Category> categories = productService.getCategoryList();
            session.setAttribute("categories", categories);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } else {
            if (userInSession.getUserType() == 1) {
                request.getRequestDispatcher("sellerhistory").forward(request, response);
            } else if (userInSession.getUserType() == 0) {
                System.out.println("In buyer:" + (User) session.getAttribute("user"));
                ObjectFactory objectFactory = new ObjectFactory();
                ProductService productService = objectFactory.createProductServiceImplObj();
                List<ProductForAuction> test = productService.getBidProducts();
                for (ProductForAuction t : test) {
                    System.out.println(t);
                }
                session.setAttribute("products", test);

                List<Category> categories = productService.getCategoryList();
                session.setAttribute("categories", categories);

                request.getRequestDispatcher("/index.jsp").forward(request, response);
            } else {
                System.out.println("something error from loginservlet");
            }
        }

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        HttpSession session = request.getSession();
        User userInSession = (User) session.getAttribute("user");
        if (userInSession == null)
            request.getRequestDispatcher("/accounts/login.jsp").forward(request, response);
        else {

            int bidderId = userInSession.getUserid();
            int bidProductId = Integer.parseInt(request.getParameter("productId"));
            double bidValue = Double.parseDouble(request.getParameter("bidValue"));
            int status = Integer.parseInt(request.getParameter("status"));
            ObjectFactory objectFactory = new ObjectFactory();
            ProductService productService = objectFactory.createProductServiceImplObj();
            Bid bid = new Bid();
            bid.setBidProductID(bidProductId);
            bid.setBidderID(bidderId);
            bid.setBidValue(bidValue);
            productService.placeBid(bid);
            response.sendRedirect("home");

        }
    }

}
