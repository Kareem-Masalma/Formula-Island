package com.example.formulaisland;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.formulaisland.dataaccess.Order;
import com.google.gson.Gson;

public class Checkout extends AppCompatActivity {

    private TextView tvOrder;
    private TextView tvFerrari;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_checkout);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        defineViews();
        addAnimation();
        addOrderDetails();
    }

    public void addOrderDetails() {
        Gson gson = new Gson();
        Intent intent = getIntent();
        String orderString = intent.getStringExtra(CartScene.ORDER);
        Order order = gson.fromJson(orderString, Order.class);
        String res = "Order:\n" +
                "Id: " + order.getId() + "\n" +
                "Price: " + order.getPrice() + "\n" +
                "Address: " + order.getAddress() + "\n";
        tvOrder.setText(res);
    }

    private void addAnimation() {
        Animation pulse = AnimationUtils.loadAnimation(this, R.anim.fade_pulse);
        tvFerrari.startAnimation(pulse);
    }

    private void defineViews() {
        tvOrder = findViewById(R.id.tvOrder);
        tvFerrari = findViewById(R.id.tvFerrari);
    }
}