package com.onlineauction.onlineauctionservlet.model.dao;

import java.util.List;

import com.onlineauction.onlineauctionservlet.model.beans.Product;
import com.onlineauction.onlineauctionservlet.model.beans.ProductForAuction;

public interface ProductSchedulerDao {
	int scheduleAuction(ProductForAuction productAuction);
	List<Product> getProductList(int sellerId);
	boolean checkIfBidScheduled(int productId);
}
