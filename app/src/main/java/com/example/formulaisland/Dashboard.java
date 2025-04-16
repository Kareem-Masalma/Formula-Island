package com.example.formulaisland;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

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
    private RadioGroup rgTeams;
    public static List<Product> products;
    List<Product> filtered;
    /** Parameter PRODUCT is used as the key for the products list stored in the SharedPreference */
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
        cartAction();
        filterAction();
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

    private void filterAction() {
        rgTeams.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton selectedButton = findViewById(checkedId);
                String team = selectedButton.getText().toString();

                String ferrari = "Ferrari";
                String astonMartin = "Aston Martin";
                String redbull = "RedBull";
                String mercedes = "Mercedes";
                String mclaren = "McLaren";

                if (ferrari.toLowerCase().contains(team.toLowerCase()))
                    filtered = filterByTeam(ferrari);
                else if (astonMartin.toLowerCase().contains(team.toLowerCase().replace("\n", " ")))
                    filtered = filterByTeam(astonMartin);
                else if (redbull.toLowerCase().contains(team.toLowerCase().replace("\n", " ")))
                    filtered = filterByTeam(redbull);
                else if (mercedes.toLowerCase().contains(team.toLowerCase()))
                    filtered = filterByTeam(mercedes);
                else if (mclaren.toLowerCase().contains(team.toLowerCase().replace("\n", "")))
                    filtered = filterByTeam(mclaren);
                else
                    filtered = products;


                ProductAdapter adapter = new ProductAdapter(Dashboard.this, filtered);
                lvProducts.setAdapter(adapter);
            }
        });
    }

    private List<Product> filterByTeam(String team) {
        List<Product> result = new ArrayList<>();
        for (Product p : Dashboard.products) {
            if (p.getTeam().equalsIgnoreCase(team)) {
                result.add(p);
            }
        }
        return result;
    }

    private void cartAction() {
        btnCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Dashboard.this, CartScene.class);
                startActivity(intent);
            }
        });
    }

    private void searchAction() {
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String search = edSearch.getText().toString();
                if (search.isBlank())
                    return;
                List<Integer> result = getIntegers(search);

                Intent intent = new Intent(Dashboard.this, Search.class);
                Gson gson = new Gson();
                String searchItems = gson.toJson(result);
                intent.putExtra(Search.SEARCH, searchItems);
                startActivity(intent);
            }
        });
    }

    @NonNull
    private static List<Integer> getIntegers(String search) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < products.size(); i++) {
            Product product = products.get(i);
            if (product.getDescription().toLowerCase().contains(search.toLowerCase()) || product.getColor().toLowerCase().contains(search.toLowerCase())
                    || product.getProductName().toLowerCase().contains(search.toLowerCase()) || product.getTeam().toLowerCase().contains(search.toLowerCase()))
                result.add(i);
        }
        return result;
    }

    private void addProductsList() {
        ProductAdapter adapter = new ProductAdapter(this, products);
        lvProducts.setAdapter(adapter);
        lvProducts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(Dashboard.this, SelectedProduct.class);
                intent.putExtra(PRODUCT, products.indexOf(filtered.get(position)));
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
            products = gson.fromJson(productsString, new TypeToken<List<Product>>() {
            }.getType());
        else
            products = new ArrayList<>();
        if (!cartString.isBlank())
            Cart.cart = gson.fromJson(cartString, new TypeToken<List<Product>>() {
            }.getType());

        for (int i = 0; i < Cart.cart.size(); i++)
            Cart.price += Cart.cart.get(i).getPrice();

        filtered = products;
    }

    private void defineViews() {
        this.btnCart = findViewById(R.id.btnCart);
        this.btnSearch = findViewById(R.id.btnSearch);
        this.edSearch = findViewById(R.id.edSearch);
        this.lvProducts = findViewById(R.id.lvProducts);
        this.rgTeams = findViewById(R.id.rgTeams);
    }
}