package com.onlineauction.onlineauctionservlet.model.beans;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;


public class ProductForAuction extends Product {

    public enum status {
        NEW(0), OPEN(1), UNSOLD(2), SOLD(3);

        private final int statusCode;
        private static final Map<Object, Object> map = new HashMap<>();

        status(int statusCode) {
            this.statusCode = statusCode;
        }

        static {
            for (status bidStatus : status.values()) {
                map.put(bidStatus.statusCode, bidStatus);
            }
        }

        public static status valueOf(int bidStatus) {
            return (status) map.get(bidStatus);
        }

        public int getValue() {
            return statusCode;
        }
    }

    private int bidProductID;
    private double minBidValue;
    private LocalDate bidStartDate;
    private LocalDate bidEndDate;
    private int userID;
    private double soldPrice;
    private status bidStatus;
    private Bid bid;

    public ProductForAuction() {
        super();

    }

    public ProductForAuction(int bidProductID, double minBidValue, LocalDate bidStartDate, LocalDate bidEndDate, int userID, double soldPrice, status bidStatus, Bid bid) {
        super();
        this.bidProductID = bidProductID;
        this.minBidValue = minBidValue;
        this.bidStartDate = bidStartDate;
        this.bidEndDate = bidEndDate;
        this.userID = userID;
        this.soldPrice = soldPrice;
        this.bidStatus = bidStatus;
        this.bid = bid;
    }

    public ProductForAuction(int productId, String productName, String productCategory, String productDescription, double productPrice, int productQuantity, String productImage, int productSellerId, int bidProductID, double minBidValue, LocalDate bidStartDate, LocalDate bidEndDate, int userID, double soldPrice, status bidStatus, Bid bid) {
        super(productId, productName, productCategory, productDescription, productPrice, productQuantity, productImage, productSellerId);
        this.bidProductID = bidProductID;
        this.minBidValue = minBidValue;
        this.bidStartDate = bidStartDate;
        this.bidEndDate = bidEndDate;
        this.userID = userID;
        this.soldPrice = soldPrice;
        this.bidStatus = bidStatus;
        this.bid = bid;
    }

    public ProductForAuction(int productId, String productName, String productCategory, String productDesc, double actualPrice, int quantity, String image, double minBidValue, LocalDate bidStartDate, LocalDate bidEndDate, double soldPrice, status bidStatus) {
        super(productId, productName, productCategory, productDesc, actualPrice, quantity, image);
        this.minBidValue = minBidValue;
        this.bidStartDate = bidStartDate;
        this.bidEndDate = bidEndDate;
        this.soldPrice = soldPrice;
        this.bidStatus = bidStatus;
    }


    public ProductForAuction(String pName, String img, double sPrice, LocalDate sDate, LocalDate eDate, status cond) {
        super(pName, img);
        this.bidStartDate = sDate;
        this.bidEndDate = eDate;
        this.soldPrice = sPrice;
        this.bidStatus = cond;
    }

    public int getBidProductID() {
        return bidProductID;
    }

    public void setBidProductID(int bidProductID) {
        this.bidProductID = bidProductID;
    }

    public double getMinBidValue() {
        return minBidValue;
    }


    public void setMinBidValue(double minBidValue) {
        this.minBidValue = minBidValue;
    }

    public LocalDate getBidStartDate() {
        return bidStartDate;
    }

    public void setBidStartDate(LocalDate bidStartDate) {
        this.bidStartDate = bidStartDate;
    }

    public LocalDate getBidEndDate() {
        return bidEndDate;
    }

    public void setBidEndDate(LocalDate bidEndDate) {
        this.bidEndDate = bidEndDate;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public double getSoldPrice() {
        return soldPrice;
    }

    public void setSoldPrice(double soldPrice) {
        this.soldPrice = soldPrice;
    }

    public int getBidStatus() {
        return bidStatus.statusCode;
    }

    public void setBidStatus(int i) {
        this.bidStatus = status.valueOf(i);
    }


    public Bid getBid() {
        return bid;
    }

    public void setBid(Bid bid) {
        this.bid = bid;
    }

    @Override
    public String toString() {
        return "ProductForAuction [bidProductID=" + bidProductID + ", minBidValue=" + minBidValue + ", bidStartDate=" + bidStartDate + ", bidEndDate=" + bidEndDate + ", userID=" + userID + ", soldPrice=" + soldPrice + ", bidStatus=" + bidStatus + ", bid=" + bid + ", getProductId()=" + getProductId() + ", getProductName()=" + getProductName() + ", getProductCategory()=" + getProductCategory() + ", getProductDescription()=" + getProductDescription() + ", getProductPrice()=" + getProductPrice() + ", getProductQuantity()=" + getProductQuantity() + ", getProductImage()=" + getProductImage() + ", getProductSellerId()=" + getProductSellerId() + ", toString()=" + super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
    }


}