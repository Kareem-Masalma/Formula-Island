package com.example.formulaisland.dataaccess;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    public static List<Product> cart = new ArrayList<>();
    public static double price = 0.0;
    /** Parameter CART is used as the key for the cart list stored in the SharedPreference */
    public static final String CART = "Cart";
}
