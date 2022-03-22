package com.onlineauction.onlineauctionservlet.model.service;

import java.util.List;

import com.onlineauction.onlineauctionservlet.model.beans.Product;
import com.onlineauction.onlineauctionservlet.model.beans.ProductForAuction;

public interface ProductSchedulerService {
	int scheduleAuction(ProductForAuction productAuction);
	List<Product> getProductList(int sellerId);
}
