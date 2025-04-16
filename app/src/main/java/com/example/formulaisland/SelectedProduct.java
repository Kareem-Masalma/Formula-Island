package com.example.formulaisland;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.formulaisland.dataaccess.Cart;
import com.example.formulaisland.dataaccess.Product;
import com.google.gson.Gson;

public class SelectedProduct extends AppCompatActivity {

    private ImageView image;
    private TextView tvDescription;
    private TextView tvPrice;
    private TextView tvQuantity;
    private Button btnCart;
    private boolean flag = false;
    private Product product;

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
                    Cart.price -= product.getPrice();
                } else {
                    Cart.cart.add(product);
                    btnCart.setText("Remove from Cart");
                    Cart.price += product.getPrice();
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
        tvQuantity.setText("Quantity: " + product.getQuantity());
        if (Cart.cart.contains(product)) {
            btnCart.setText("Remove from Cart");
            flag = true;
        } else {
            btnCart.setText("Add to Cart");
            flag = false;
        }
    }

    private void defineViews() {
        image = findViewById(R.id.ivProduct);
        tvDescription = findViewById(R.id.tvDescription);
        tvPrice = findViewById(R.id.tvPrice);
        btnCart = findViewById(R.id.btnCart);
        tvQuantity = findViewById(R.id.tvQuantity);
    }

}