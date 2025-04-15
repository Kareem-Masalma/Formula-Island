package com.example.formulaisland;

import static com.example.formulaisland.Dashboard.PRODUCT;

import android.content.Intent;
import android.os.Bundle;
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
import com.example.formulaisland.dataaccess.Product;
import com.example.formulaisland.dataaccess.Cart;
import com.google.gson.Gson;

import java.util.List;

public class CartScene extends AppCompatActivity {

    private ListView lvCart;
    private Spinner spAddress;
    private Button btnCheck;
    private TextView tvMessage;
    private List<Product> cart;

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
        getAddresses();
        getList();
    }

    private void getAddresses() {
        String[] addresses = Address.getData();
        ArrayAdapter<String> spAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, addresses);

        spAddress.setAdapter(spAdapter);
    }

    private void getList() {
        cart = Cart.cart;
        if (cart.isEmpty()) {
            tvMessage.setVisibility(View.VISIBLE);
            lvCart.setVisibility(View.GONE);
            return;
        } else {
            tvMessage.setVisibility(View.GONE);
            lvCart.setVisibility(View.VISIBLE);
        }

        ProductAdapter adapter = new ProductAdapter(this, cart);
        lvCart.setAdapter(adapter);

        lvCart.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Product product = cart.get(position);
                Intent intent = new Intent(CartScene.this, SelectedProduct.class);
                Gson gson = new Gson();
                String product_json = gson.toJson(product);
                intent.putExtra(PRODUCT, product_json);
                startActivity(intent);
            }
        });
    }

    private void defineViews() {
        lvCart = findViewById(R.id.lvCart);
        spAddress = findViewById(R.id.spAddress);
        btnCheck = findViewById(R.id.btnCheck);
        tvMessage = findViewById(R.id.tvMessage);
    }

}