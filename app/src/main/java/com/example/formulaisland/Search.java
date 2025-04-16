package com.example.formulaisland;

import static com.example.formulaisland.Dashboard.products;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.formulaisland.adapters.ProductAdapter;
import com.example.formulaisland.dataaccess.Product;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

/**
 * This Activity is to present the list of products are relatable to the user's search.
 * */

public class Search extends AppCompatActivity {

    private ListView lvSearch;
    private TextView tvNoResults;
    /** Parameter SEARCH is used as the key for the result product list for the user's search */
    public static final String SEARCH = "Search";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_search);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        lvSearch = findViewById(R.id.lvSearch);
        tvNoResults = findViewById(R.id.tvNoResults);

        addProductsList();
    }

    private void addProductsList() {
        Intent intent = getIntent();
        String searchItem = intent.getStringExtra(SEARCH);
        Gson gson = new Gson();
        List<Integer> positions = gson.fromJson(searchItem, new TypeToken<List<Integer>>() {
        }.getType());

        List<Product> items = new ArrayList<>();
        if (positions != null) {
            for (int i = 0; i < positions.size(); i++) {
                items.add(products.get(positions.get(i)));
            }
        }

        if (items.isEmpty()) {
            tvNoResults.setVisibility(View.VISIBLE);
            lvSearch.setVisibility(View.GONE);
        } else {
            tvNoResults.setVisibility(View.GONE);
            lvSearch.setVisibility(View.VISIBLE);

            ProductAdapter adapter = new ProductAdapter(this, items);
            lvSearch.setAdapter(adapter);

            lvSearch.setOnItemClickListener((parent, view, position, id) -> {
                Intent productIntent = new Intent(Search.this, SelectedProduct.class);
                productIntent.putExtra(Dashboard.PRODUCT, Dashboard.products.indexOf(items.get(position)));
                startActivity(productIntent);
            });
        }
    }
}
