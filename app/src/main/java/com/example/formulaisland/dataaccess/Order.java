package com.example.formulaisland.dataaccess;

import android.annotation.SuppressLint;

import androidx.annotation.NonNull;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Random;
import java.util.Date;

public class Order {
    private int id;
    private List<Product> products;
    private double price;
    private final String date;
    private String address;

    @SuppressLint("SimpleDateFormat")
    public Order(List<Product> products, double price, String address) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        date = dateFormat.format(new Date());
        Random random = new Random();
        this.id = random.nextInt(90000) + 10000;
        this.products = products;
        this.price = price;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDate() {
        return date;
    }

    @NonNull
    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", products=" + products +
                ", price=" + price +
                ", date='" + date + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
