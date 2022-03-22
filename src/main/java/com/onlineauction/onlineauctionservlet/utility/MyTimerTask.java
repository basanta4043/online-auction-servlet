package com.onlineauction.onlineauctionservlet.utility;

import java.util.Timer;
import java.util.TimerTask;

import com.onlineauction.onlineauctionservlet.model.service.ProductService;
import com.onlineauction.onlineauctionservlet.model.service.ProductServiceImpl;

public class MyTimerTask extends TimerTask {
    ProductService productService = new ProductServiceImpl();

    public void run() {
        productService.scheduleTask();
    }

    public static void scheduleAcution() {
        System.out.println("in doSchedule");
        MyTimerTask myTask = new MyTimerTask();
        Timer myTimer = new Timer();
        myTimer.schedule(myTask, 0, 60000);
    }
}
