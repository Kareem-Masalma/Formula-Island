package com.example.formulaisland;

import static com.example.formulaisland.Dashboard.PRODUCT;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.formulaisland.adapters.ProductAdapter;
import com.example.formulaisland.dataaccess.Address;
import com.example.formulaisland.dataaccess.Order;
import com.example.formulaisland.dataaccess.Product;
import com.example.formulaisland.dataaccess.Cart;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class CartScene extends AppCompatActivity {

    private ListView lvCart;
    private Spinner spAddress;
    private Button btnCheck;
    private TextView tvMessage;
    private List<Product> cart;
    private TextView tvTotal;
    public static final String ORDER = "Order";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cart);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        defineViews();
    }

    @Override
    protected void onResume() {
        super.onResume();
        getAddresses();
        getList();
        checkOut();
    }

    private void checkOut() {
        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Order order = new Order(cart, Cart.price);
                Gson gson = new Gson();
                SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(CartScene.this);
                String ordersString = pref.getString(ORDER, "");
                List<Order> ordersHistory;
                if (!ordersString.isBlank())
                    ordersHistory = gson.fromJson(ordersString, new TypeToken<List<Order>>() {
                    }.getType());
                else
                    ordersHistory = new ArrayList<>();

                ordersHistory.add(order);

                for (int i = 0; i < cart.size(); i++) {
                    Product product = cart.get(i);
                    product.setQuantity(product.getQuantity() - product.getCartQuan());
                    product.setCartQuan(0);
                }
                Cart.cart.clear();

                SharedPreferences.Editor editor = pref.edit();
                String orders_json = gson.toJson(ordersHistory);
                editor.putString(ORDER, orders_json);
                editor.commit();
            }
        });
    }

    private void getAddresses() {
        String[] addresses = Address.getData();
        ArrayAdapter<String> spAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, addresses);

        spAddress.setAdapter(spAdapter);
    }

    @SuppressLint("SetTextI18n")
    private void getList() {
        cart = Cart.cart;
        if (cart.isEmpty()) {
            tvMessage.setVisibility(View.VISIBLE);
            lvCart.setVisibility(View.GONE);
            tvTotal.setText("Total: $0.00");
            btnCheck.setEnabled(false);
            return;
        } else {
            tvMessage.setVisibility(View.GONE);
            lvCart.setVisibility(View.VISIBLE);
            tvTotal.setText("Total: $" + Cart.price);
            btnCheck.setEnabled(true);
        }

        ProductAdapter adapter = new ProductAdapter(this, cart);
        lvCart.setAdapter(adapter);

        lvCart.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(CartScene.this, SelectedProduct.class);
                intent.putExtra(PRODUCT, Dashboard.products.indexOf(Cart.cart.get(position)));
                startActivity(intent);
            }
        });
    }

    private void defineViews() {
        lvCart = findViewById(R.id.lvCart);
        spAddress = findViewById(R.id.spAddress);
        btnCheck = findViewById(R.id.btnCheck);
        tvMessage = findViewById(R.id.tvMessage);
        tvTotal = findViewById(R.id.tvTotal);
    }

}