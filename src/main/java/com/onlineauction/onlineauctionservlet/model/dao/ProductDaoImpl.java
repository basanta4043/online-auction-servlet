package com.onlineauction.onlineauctionservlet.model.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.onlineauction.onlineauctionservlet.controller.ScheduleAuctionController;
import com.onlineauction.onlineauctionservlet.model.beans.Bid;
import com.onlineauction.onlineauctionservlet.model.beans.Category;


import com.onlineauction.onlineauctionservlet.model.beans.Product;
import com.onlineauction.onlineauctionservlet.model.beans.ProductForAuction;
import com.onlineauction.onlineauctionservlet.model.beans.ProductForAuction.status;

import com.onlineauction.onlineauctionservlet.utility.DBConnection;

public class ProductDaoImpl implements ProductDao {
    static Connection conn = null;

    @Override
    public List<ProductForAuction> getBidProducts() {
        List<ProductForAuction> prodList = new ArrayList<ProductForAuction>();
        conn = DBConnection.getConnectionId();
        ResultSet rs = null;
        try {
            //Query to get the required data from the database
            String getQuery = "Select Product.ProductID,Productbid.MinBidValue,ProductBid.BidStartDate,ProductBid.BidEndDate,Product.ProductName,Product.ProductCategory,Product.ProductDesc,Product.ActualPrice,Product.Quantity,Product.Image,ProductBid.Status From ProductBid inner join Product on ProductBid.ProductID=Product.ProductID";
            PreparedStatement ps = conn.prepareStatement(getQuery);
            rs = ps.executeQuery();
            while (rs.next()) {
                int pid = rs.getInt("ProductID");
                int minBid = rs.getInt("MinBidValue");
                LocalDate sDate = rs.getTimestamp("BidStartDate").toLocalDateTime().toLocalDate();
                LocalDate eDate = rs.getTimestamp("BidEndDate").toLocalDateTime().toLocalDate();
                String pName = rs.getString("ProductName");
                String pCat = rs.getString("ProductCategory");
                String pDesc = rs.getString("ProductDesc");
                double price = rs.getDouble("ActualPrice");
                int pQuan = rs.getInt("Quantity");
                String img = rs.getString("Image");
                double sPrice = minBid;
                String DEFAULT_FILENAME = "./resources/img/logo.jpg";
                if (img.compareTo(DEFAULT_FILENAME) != 0) {
                    img = "/media/" + img;
                }
                int stat = rs.getInt("Status");
                status cond = status.valueOf(stat);

                prodList.add(new ProductForAuction(pid, pName, pCat, pDesc, price, pQuan, img, minBid, sDate, eDate,
                        sPrice, cond));
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }

        return prodList;
    }


    @Override
    public List<ProductForAuction> getProductHistory(int user_id) {
        List<ProductForAuction> prodList = new ArrayList<ProductForAuction>();
        conn = DBConnection.getConnectionId();
        ResultSet rs = null;
        try {
            //Query to get the required data from the database
            String getQuery = "select prod_bid.BidEndDate,prod.ProductName,prod.Image,prod_bid.SoldPrice, prod_bid.Status From ProductBid prod_bid inner join Product prod on prod_bid.ProductID=prod.ProductID where prod_bid.BuyerID=?";
            PreparedStatement ps = conn.prepareStatement(getQuery);
            ps.setInt(1, user_id);
            rs = ps.executeQuery();
            while (rs.next()) {
                LocalDate eDate = rs.getTimestamp("BidEndDate").toLocalDateTime().toLocalDate();
                LocalDate sDate = rs.getTimestamp("BidStartDate").toLocalDateTime().toLocalDate();
                String pName = rs.getString("ProductName");
                String img = rs.getString("Image");
                double sPrice = rs.getInt("SoldPrice");

                int stat = rs.getInt("Status");
                status cond = status.valueOf("stat");

                prodList.add(new ProductForAuction(pName, img, sPrice, sDate, eDate, cond));

            }
        } catch (SQLException e) {

            e.printStackTrace();
        }

        return prodList;
    }


    @Override
    public List<ProductForAuction> getSellerProducts(int user_id) {
        List<ProductForAuction> prodList = new ArrayList<ProductForAuction>();
        conn = DBConnection.getConnectionId();
        ResultSet rs = null;
        String getQuery = "select * From ProductBid prod_bid inner join Product prod on prod_bid.ProductID=prod.ProductID where prod_bid.BuyerID=?";
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(getQuery);
            ps.setInt(1, user_id);
            rs = ps.executeQuery();
            while (rs.next()) {
                LocalDate eDate = rs.getTimestamp("BidEndDate").toLocalDateTime().toLocalDate();
                LocalDate sDate = rs.getTimestamp("BidStartDate").toLocalDateTime().toLocalDate();
                String pName = rs.getString("ProductName");
                String img = rs.getString("Image");
                double sPrice = rs.getInt("SoldPrice");
                int stat = rs.getInt("Status");
                status cond = status.valueOf(stat);

                prodList.add(new ProductForAuction(pName, img, sPrice, sDate, eDate, cond));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return prodList;
    }

    public int addProducts(Product product) {
        Random random = new Random();
        int id = random.nextInt(200);
        String insert = "insert into Product (ProductID,ProductName,ProductCategory,ProductDesc,ActualPrice,Quantity,Image,SellerID) values(?,?,?,?,?,?,?,?)";
        int status = 0;
        conn = DBConnection.getConnectionId();
        try {
            PreparedStatement ps = conn.prepareStatement(insert);
            ps.setInt(1, id);
            ps.setString(2, product.getProductName());
            ps.setString(3, product.getProductCategory());

            System.out.println(product.getProductDescription());

            ps.setString(4, product.getProductDescription());
            ps.setDouble(5, product.getProductPrice());
            ps.setInt(6, product.getProductQuantity());
            ps.setString(7, product.getProductImage());
            ps.setInt(8, product.getProductSellerId());

            status = ps.executeUpdate();
            return status;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        return status;

    }

    @Override
    public List<Category> getCategoryList() {
        System.out.println("is here?");
        // TODO Auto-generated method stub
        List<Category> cateList = new ArrayList<Category>();
        conn = DBConnection.getConnectionId();
        ResultSet rs = null;
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement("select CategoryID,CategoryName from category");
            rs = ps.executeQuery();
            while (rs.next()) {
                int categoryID = rs.getInt(1);
                String categoryName = rs.getString(2);

                Category category = new Category(categoryID, categoryName);

                System.out.println("Id name ==" + categoryID + "," + categoryName);
                cateList.add(category);
            }

            System.out.println(cateList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cateList;
    }

    public void scheduleTask() {
        Statement stmt, stmt1 = null;
        PreparedStatement pstmt = null;
        Connection con = DBConnection.getConnectionId();
        String sql = "SELECT * FROM productbid";
        System.out.println("Timer task executed.");
        try {
            stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Timestamp bidStartDate = rs.getTimestamp("bidstartdate");
                Timestamp bidEndDate = rs.getTimestamp("bidenddate");
                int productId = rs.getInt("productid");
                int response = ScheduleAuctionController.getTime(bidStartDate);
                int endRespose = ScheduleAuctionController.getTime(bidEndDate);
                System.out.println("response::" + response);
                if (response == 1) {
                    System.out.println("productId inner::" + productId);
                    pstmt = con.prepareStatement(
                            "update productbid set status=4 where productid=? and status!=4");
                    pstmt.setInt(1, productId);
                    int i = pstmt.executeUpdate();
                    System.out.println(i > 0 ? "Bid started successfull " + i : "Error starting bid:" + i);
                } else if (endRespose == 1) {


                    System.out.println("productId inner::" + productId);
                    pstmt = con.prepareStatement("update bid set status=5 where productid=? and status=4");
                    pstmt.setInt(1, productId);
                    int i = pstmt.executeUpdate();
                    pstmt = con.prepareStatement("update productbid set status=5 where productid=? and status=4");
                    pstmt.setInt(1, productId);
                    int j = pstmt.executeUpdate();
                    System.out.println(i > 0 ? "Bid ended successful " + i : "Error ending bid:" + i);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int placeBid(Bid bid) {
        Random random = new Random();
        int id = random.nextInt(2000);
        int status = 0;
        Connection conn = DBConnection.getConnectionId();
        PreparedStatement ps;
        try {
            ps = conn.prepareStatement(
                    "insert into Bid values (?,?,?,?,?)");
            ps.setInt(1, id);
            ps.setInt(2, bid.getBidderID());
            ps.setInt(3, bid.getBidProductID());
            ps.setDouble(4, bid.getBidValue());
            ps.setInt(5, 4);
            status = ps.executeUpdate();
            System.out.println("Bid success status:" + status);
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return status;
    }

}