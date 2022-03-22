
package com.onlineauction.onlineauctionservlet.model.beans;


public class Product {

    private int ProductId;
    private String ProductName;
    private String ProductCategory;
    private String ProductDesc;
    private double ActualPrice;
    private int Quantity;
    private String Image;
    private int SellerId;


    public int getProductId() {
        return ProductId;
    }

    public void setProductId(int productId) {
        this.ProductId = productId;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        this.ProductName = productName;
    }

    public String getProductCategory() {
        return ProductCategory;
    }

    public void setProductCategory(String productCategory) {
        this.ProductCategory = productCategory;
    }

    public String getProductDescription() {
        return ProductDesc;
    }

    public void setProductDescription(String productDescription) {
        this.ProductDesc = productDescription;
    }

    public double getProductPrice() {
        return ActualPrice;
    }

    public void setProductPrice(double productPrice) {
        this.ActualPrice = productPrice;
    }

    public int getProductQuantity() {
        return Quantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.Quantity = productQuantity;
    }

    public String getProductImage() {
        return Image;
    }

    public void setProductImage(String productImage) {
        this.Image = productImage;
    }

    public int getProductSellerId() {
        return SellerId;
    }

    public void setProductSellerId(int productSellerId) {
        this.SellerId = productSellerId;
    }

    public Product() {
        super();
    }

    public Product(int productId, String productName) {
        super();
        ProductId = productId;
        ProductName = productName;
    }

    public Product(int productId, String productName, String productCategory, String productDescription,
                   double productPrice, int productQuantity, String productImage, int productSellerId) {
        super();
        this.ProductId = productId;
        this.ProductName = productName;
        this.ProductCategory = productCategory;
        this.ProductDesc = productDescription;
        this.ActualPrice = productPrice;
        this.Quantity = productQuantity;
        this.Image = productImage;
        this.SellerId = productSellerId;
    }


    public Product(int productId, String productName, String productCategory, String productDesc, double actualPrice,
                   int quantity, String image) {
        super();
        this.ProductId = productId;
        this.ProductName = productName;
        this.ProductCategory = productCategory;
        this.ProductDesc = productDesc;
        this.ActualPrice = actualPrice;
        this.Quantity = quantity;
        this.Image = image;
    }

    public Product(String productName, String image) {
        super();
        this.Image = image;
        this.ProductName = productName;
    }


    public Product(String productName, String productCategory, String productDesc, double actualPrice, int quantity,
                   String image, int sellerId) {
        super();
        ProductName = productName;
        ProductCategory = productCategory;
        ProductDesc = productDesc;
        ActualPrice = actualPrice;
        Quantity = quantity;
        Image = image;
        SellerId = sellerId;
    }

    @Override
    public String toString() {
        return "Product [productId=" + ProductId + ", productName=" + ProductName + ", productCategory="
                + ProductCategory + ", productDescription=" + ProductDesc + ", productPrice=" + ActualPrice
                + ", productQuantity=" + Quantity + ", productImage=" + Image + ", productSellerId="
                + SellerId + "]";
    }


}
