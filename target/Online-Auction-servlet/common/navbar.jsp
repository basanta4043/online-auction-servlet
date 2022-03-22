<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@page import="com.onlineauction.onlineauctionservlet.model.beans.User" %>

<%

    /* 		System.out.println("IN NAVBAR isUserAuthenticated:"+session.getAttribute("isUserAuthenticated"));
     */
    boolean isUserAuthenticated = session.getAttribute("isUserAuthenticated") != null ? true : false;
    int userType = 1;
    if (session.getAttribute("userType") != null) {
        userType = (int) session.getAttribute("userType");
    }

    User u = (User) session.getAttribute("user");
    if (u != null) {
        session.setAttribute("name", u.getName());
    }
%>

<div id="bottomHeader">
    <div id="mySidebar" class="sidebar">
        <% if (isUserAuthenticated && userType == 0) { %>
        <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
        <h3>Hello <%=session.getAttribute("name")%>
        </h3>
        <a href="home">Home</a>
        <a href="profile">My Profile</a>
        <a href="buyerhistory">Purchased Products</a>
        <a href="logout">Log Out</a>

        <%} else if (isUserAuthenticated && userType == 1) { %>
        <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
        <h3>Hello <%=session.getAttribute("name")%>
        </h3>
        <a href="home">Home</a>
        <a href="profile">My Profile</a>
        <a href="addproduct">Add Product</a>
        <a href="scheduleauction">Schedule Auction</a>
        <a href="sellerhistory">Product History</a>
        <a href="logout">Log Out</a>
        <%} %>
    </div>

    <%
        if (isUserAuthenticated) {
    %>
    <div id="main">
        <img src="./resources/img/logo.jpg" style="width:50px;height: 50px;margin-left:16px">
        <button class="openbtn" onclick="openNav()">&#9776;</button>
    </div>
    <%
    } else {
    %>
    <div id="main">
        <img src="../resources/img/logo.jpg" alt="logo" style="width:50px;height: 50px;margin-left:16px ">
        <div style="float:right">
            <a href="login" class="navbar-button">Login</a>
            <a href="register" class="navbar-button">Sign Up</a>
        </div>
    </div>
    <%
        }
    %>


</div>