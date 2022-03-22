package com.onlineauction.onlineauctionservlet.utility;


import com.onlineauction.onlineauctionservlet.model.dao.*;
import com.onlineauction.onlineauctionservlet.model.service.*;

public class ObjectFactory {

    public ProductSchedulerDao createProductSchedulerDaoImplObj() {
        return new ProductSchedulerDaoImpl();
    }

    public ProductDao createProductDaoImplObj() {
        return new ProductDaoImpl();
    }

    public UserDao createUserDaoImplObj() {
        return new UserDaoImpl();
    }

    public ProductSchedulerService createProductSchedulerServiceImplObj() {
        return new ProductSchedulerServiceImpl();
    }

    public ProductService createProductServiceImplObj() {
        return new ProductServiceImpl();
    }

    public UserService createUserServiceImplObj() {
        return new UserServiceImpl();
    }

}
