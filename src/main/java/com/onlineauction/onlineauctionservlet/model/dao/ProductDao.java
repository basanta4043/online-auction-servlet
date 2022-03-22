package com.onlineauction.onlineauctionservlet.model.dao;

import java.util.List;

import com.onlineauction.onlineauctionservlet.model.beans.Bid;
import com.onlineauction.onlineauctionservlet.model.beans.Category;
import com.onlineauction.onlineauctionservlet.model.beans.Product;
import com.onlineauction.onlineauctionservlet.model.beans.ProductForAuction;

public interface ProductDao {

    List<ProductForAuction> getBidProducts();

    List<ProductForAuction> getProductHistory(int user_id);

    int placeBid(Bid bid);

    List<ProductForAuction> getSellerProducts(int user_id);

    int addProducts(Product product);

    List<Category> getCategoryList();

    void scheduleTask();

}
