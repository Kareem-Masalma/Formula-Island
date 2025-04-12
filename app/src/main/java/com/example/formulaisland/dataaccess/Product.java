package com.example.formulaisland.dataaccess;

import androidx.annotation.NonNull;

public class Product {
    private String team;
    private String productName;
    private String color;
    private int image_code;
    public static int quantity;
    private String description;

    public Product() {

    }

    public Product(String team, String productName, String color, String description, int image_code, int quantity) {
        this.team = team;
        this.productName = productName;
        this.color = color;
        this.image_code = image_code;
        Product.quantity = quantity;
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

    public int getImage_code() {
        return image_code;
    }

    public void setImage_code(int image_code) {
        this.image_code = image_code;
    }

    public static int getQuantity() {
        return quantity;
    }

    public static void setQuantity(int quantity) {
        Product.quantity = quantity;
    }

    @NonNull
    @Override
    public String toString() {
        return "Product{" +
                "team='" + team + '\'' +
                ", productName='" + productName + '\'' +
                ", color='" + color + '\'' +
                ", image_code=" + image_code +
                '}';
    }
}
