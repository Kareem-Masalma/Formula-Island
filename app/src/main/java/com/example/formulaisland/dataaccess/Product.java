package com.example.formulaisland.dataaccess;

import androidx.annotation.NonNull;

public class Product {
    private String team;
    private String productName;
    private String color;
    private int imageCode;
    private int quantity;
    private String description;
    private double price;
    public static final String DATA = "Products";

    public Product() {

    }

    public Product(String team, String productName, String color, String description, int image_code, int quantity, double price) {
        this.team = team;
        this.productName = productName;
        this.color = color;
        this.imageCode = image_code;
        this.quantity = quantity;
        this.description = description;
        this.price = price;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
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
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o instanceof Product)
            return this.imageCode == ((Product) o).getImageCode();
        return false;
    }

}
