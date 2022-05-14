package com.example.myapplication;

public class model {
    String price,productName,shopkeeper,purl;

    public model() {
    }

    public model(String price, String productName, String shopkeeper, String purl) {
        this.price = price;
        this.productName = productName;
        this.shopkeeper = shopkeeper;
        this.purl = purl;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getShopkeeper() {
        return shopkeeper;
    }

    public void setShopkeeper(String shopkeeper) {
        this.shopkeeper = shopkeeper;
    }

    public String getPurl() {
        return purl;
    }

    public void setPurl(String purl) {
        this.purl = purl;
    }
}



