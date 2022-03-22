package com.onlineauction.onlineauctionservlet.model.beans;

public class Category {

    private int categoryId;
    private String categoryName;
    private String categoryDescription;

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }


    public String getCategoryDescription() {
        return categoryDescription;
    }


    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }


    public Category() {
        super();
    }


    public Category(int categoryId, String categoryName, String categoryDescription) {
        super();
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
    }


    public Category(int categoryId, String categoryName) {
        super();
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "ProductCategory [categoryId=" + categoryId + ", categoryName=" + categoryName + ", categoryDescription="
                + categoryDescription + "]";
    }


}