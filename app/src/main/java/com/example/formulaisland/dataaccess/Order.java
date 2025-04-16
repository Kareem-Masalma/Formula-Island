package com.example.formulaisland.dataaccess;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Product> products;
    private double price;

    public Order() {
        this.products = new ArrayList<>();
        this.price = 0.0;
    }

    public Order(List<Product> products, double price) {
        this.products = products;
        this.price = price;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @NonNull
    @Override
    public String toString() {
        return "Order{" +
                "products=" + products +
                ", price=" + price +
                '}';
    }
}
