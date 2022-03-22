package com.onlineauction.onlineauctionservlet.model.service;

import java.util.List;

import com.onlineauction.onlineauctionservlet.model.beans.Bid;
import com.onlineauction.onlineauctionservlet.model.beans.Category;
import com.onlineauction.onlineauctionservlet.model.beans.Product;
import com.onlineauction.onlineauctionservlet.model.beans.ProductForAuction;

public interface ProductService {
    List<ProductForAuction> getBidProducts();

    List<ProductForAuction> getProductHistory(int userId);

    List<ProductForAuction> getSellerProducts(int userId);

    void placeBid(Bid bid);

    int addProducts(Product product);

    List<Category> getCategoryList();

    void scheduleTask();
}
