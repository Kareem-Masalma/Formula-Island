package com.example.formulaisland.dataaccess;

import androidx.annotation.NonNull;

public class Product {
    private String team;
    private String productName;
    private String color;
    private int imageCode;
    public static int quantity;
    private String description;
    public static final String DATA = "Products";

    public Product() {

    }

    public Product(String team, String productName, String color, String description, int image_code, int quantity) {
        this.team = team;
        this.productName = productName;
        this.color = color;
        this.imageCode = image_code;
        Product.quantity = quantity;
        this.description = description;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getImageCode() {
        return imageCode;
    }

    public void setImageCode(int imageCode) {
        this.imageCode = imageCode;
    }

    public static int getQuantity() {
        return quantity;
    }

    public static void setQuantity(int quantity) {
        Product.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @NonNull
    @Override
    public String toString() {
        return "Product{" +
                "team='" + team + '\'' +
                ", productName='" + productName + '\'' +
                ", color='" + color + '\'' +
                ", imageCode=" + imageCode +
                ", description='" + description + '\'' +
                '}';
    }
}
