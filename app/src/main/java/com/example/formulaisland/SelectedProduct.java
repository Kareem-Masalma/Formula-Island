package com.example.formulaisland;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.formulaisland.dataaccess.Cart;
import com.example.formulaisland.dataaccess.Product;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class SelectedProduct extends AppCompatActivity {

    private ImageView image;
    private TextView tvDescription;
    private TextView tvPrice;
    private TextView tvQuantity;
    private Button btnCart;
    private boolean flag = false;
    private Product product;
    private Spinner spQuantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_selected_product);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        defineViews();
        createScene();
        addActions();
    }

    @SuppressLint("SetTextI18n")
    private void addActions() {
        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag) {
                    Cart.cart.remove(product);
                    btnCart.setText("Add to Cart");
                    int quantity = (int) spQuantity.getSelectedItem();
                    Cart.price -= product.getPrice() * quantity;
                    product.setCartQuan(0);
                } else {
                    Cart.cart.add(product);
                    btnCart.setText("Remove from Cart");
                    int quantity = (int) spQuantity.getSelectedItem();
                    Cart.price += product.getPrice() * quantity;
                    product.setCartQuan(quantity);
                }
                flag = !flag;
            }
        });
    }

    @SuppressLint("SetTextI18n")
    private void createScene() {
        Intent intent = getIntent();
        int productPos = intent.getIntExtra(Dashboard.PRODUCT, 0);
        product = Dashboard.products.get(productPos);
        image.setImageResource(product.getImageCode());
        tvDescription.setText(product.getDescription() + ".\n");
        tvPrice.setText("Price: " + product.getPrice() + "$");
        tvPrice.setTextColor(getColor(android.R.color.black));

        if (product.getQuantity() == 0) {
            tvQuantity.setText("Currently out of stock. This product will be available soon.");
            tvQuantity.setTextColor(getColor(android.R.color.holo_red_dark));
            spQuantity.setEnabled(false);
            btnCart.setEnabled(false);
        } else {
            tvQuantity.setText("Quantity: " + product.getQuantity());
            tvQuantity.setTextColor(getColor(android.R.color.black));
            spQuantity.setEnabled(true);
            btnCart.setEnabled(true);
        }

        if (Cart.cart.contains(product)) {
            btnCart.setText("Remove from Cart");
            spQuantity.setEnabled(false);
            flag = true;
        } else {
            btnCart.setText("Add to Cart");
            btnCart.setEnabled(true);
            flag = false;
        }

        int maxQty = product.getQuantity();

        List<Integer> quantities = new ArrayList<>();
        for (int i = 1; i <= 5 && i <= maxQty; i++) {
            quantities.add(i);
        }

        ArrayAdapter<Integer> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, quantities);
        spQuantity.setAdapter(adapter);
    }

    private void defineViews() {
        image = findViewById(R.id.ivProduct);
        tvDescription = findViewById(R.id.tvDescription);
        tvPrice = findViewById(R.id.tvPrice);
        btnCart = findViewById(R.id.btnCart);
        tvQuantity = findViewById(R.id.tvQuantity);
        spQuantity = findViewById(R.id.spQuantity);
    }

}