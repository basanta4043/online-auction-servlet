package com.onlineauction.onlineauctionservlet.model.service;

import java.util.List;

import com.onlineauction.onlineauctionservlet.model.beans.Product;
import com.onlineauction.onlineauctionservlet.model.beans.ProductForAuction;
import com.onlineauction.onlineauctionservlet.model.dao.ProductSchedulerDao;
import com.onlineauction.onlineauctionservlet.model.dao.ProductSchedulerDaoImpl;

public class ProductSchedulerServiceImpl implements ProductSchedulerService {

    ProductSchedulerDao productSchedulerDao = new ProductSchedulerDaoImpl();

    @Override
    public int scheduleAuction(ProductForAuction productAuction) {

        return productSchedulerDao.scheduleAuction(productAuction);
    }

    @Override
    public List<Product> getProductList(int sellerId) {

        return productSchedulerDao.getProductList(sellerId);
    }

}
