package com.example.formulaisland;

import static com.example.formulaisland.Dashboard.PRODUCT;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.formulaisland.adapters.ProductAdapter;
import com.example.formulaisland.dataaccess.Product;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class Search extends AppCompatActivity {

    private ListView lvSearch;
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
        addProductsList();
    }

    private void addProductsList() {
        Intent intent = getIntent();
        String searchItem = intent.getStringExtra(SEARCH);
        Gson gson = new Gson();
        List<Product> items = gson.fromJson(searchItem, new TypeToken<List<Product>>() {
        }.getType());
        ProductAdapter adapter = new ProductAdapter(this, items);
        lvSearch.setAdapter(adapter);
        lvSearch.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Product product = items.get(position);
                Intent intent = new Intent(Search.this, SelectedProduct.class);
                Gson gson = new Gson();
                String product_json = gson.toJson(product);
                intent.putExtra(PRODUCT, product_json);
                startActivity(intent);
            }
        });
    }
}