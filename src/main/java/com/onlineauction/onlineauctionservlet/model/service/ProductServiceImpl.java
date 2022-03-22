package com.onlineauction.onlineauctionservlet.model.service;

import com.onlineauction.onlineauctionservlet.model.beans.Bid;
import com.onlineauction.onlineauctionservlet.model.beans.Category;
import com.onlineauction.onlineauctionservlet.model.beans.Product;
import com.onlineauction.onlineauctionservlet.model.beans.ProductForAuction;
import com.onlineauction.onlineauctionservlet.model.dao.ProductDao;
import com.onlineauction.onlineauctionservlet.utility.ObjectFactory;

import java.util.List;

public class ProductServiceImpl implements ProductService {
    ObjectFactory objectFactory = new ObjectFactory();
    ProductDao productDao = objectFactory.createProductDaoImplObj();

    @Override
    public List<ProductForAuction> getBidProducts() {
        return productDao.getBidProducts();
    }

    @Override
    public List<ProductForAuction> getProductHistory(int user_id) {
        return productDao.getProductHistory(user_id);
    }

    @Override
    public void placeBid(Bid bid) {
        productDao.placeBid(bid);
    }

    public List<ProductForAuction> getSellerProducts(int user_id) {

        return productDao.getSellerProducts(user_id);
    }

    public int addProducts(Product product) {
        return productDao.addProducts(product);
    }

    @Override
    public List<Category> getCategoryList() {
        return productDao.getCategoryList();
    }

    public void scheduleTask() {
        productDao.scheduleTask();
    }
}
