package com.example.formulaisland;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.formulaisland.adapters.ProductAdapter;
import com.example.formulaisland.dataaccess.Cart;
import com.example.formulaisland.dataaccess.Product;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

public class Dashboard extends AppCompatActivity {

    private FloatingActionButton btnCart;
    private ImageButton btnSearch;
    private EditText edSearch;
    private ListView lvProducts;
    private List<Product> products;
    public static final String PRODUCT = "Product";
    private SharedPreferences pref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        Log.d("CheckPoint", "Before setContentView");
        setContentView(R.layout.activity_dashboard);
        Log.d("CheckPoint", "After setContentView");
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        defineViews();
        getData();
        addProductsList();
        searchAction();
    }

    private void searchAction() {
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String search = edSearch.getText().toString();
                if (search.isBlank())
                    return;
                List<Product> result = new ArrayList<>();
                for (int i = 0; i < products.size(); i++) {
                    Product product = products.get(i);
                    if (product.getDescription().contains(search) || product.getColor().contains(search)
                            || product.getProductName().contains(search) || product.getTeam().contains(search))
                        result.add(product);
                }

                Intent intent = new Intent(Dashboard.this, Search.class);
                Gson gson = new Gson();
                String searchItems = gson.toJson(result);
                intent.putExtra(Search.SEARCH, searchItems);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onStop() {
        super.onStop();
        Gson gson = new Gson();
        String products_json = gson.toJson(products);
        String cart_json = gson.toJson(Cart.cart);
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(Product.DATA, products_json);
        editor.putString(Cart.CART, cart_json);
        editor.apply();
    }

    private void addProductsList() {
        ProductAdapter adapter = new ProductAdapter(this, products);
        lvProducts.setAdapter(adapter);
        lvProducts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Product product = products.get(position);
                Intent intent = new Intent(Dashboard.this, SelectedProduct.class);
                Gson gson = new Gson();
                String product_json = gson.toJson(product);
                intent.putExtra(PRODUCT, product_json);
                startActivity(intent);
            }
        });
    }

    private void getData() {
        Gson gson = new Gson();
        pref = PreferenceManager.getDefaultSharedPreferences(this);
        String productsString = pref.getString(Product.DATA, "");
        String cartString = pref.getString(Cart.CART, "");
        if (!productsString.isBlank())
            this.products = gson.fromJson(productsString, new TypeToken<List<Product>>() {
            }.getType());
        else
            this.products = new ArrayList<>();
        if (!cartString.isBlank())
            Cart.cart = gson.fromJson(cartString, new TypeToken<List<Product>>() {
            }.getType());
    }

    private void defineViews() {
        this.btnCart = findViewById(R.id.btnCart);
        this.btnSearch = findViewById(R.id.btnSearch);
        this.edSearch = findViewById(R.id.edSearch);
        this.lvProducts = findViewById(R.id.lvProducts);
    }
}