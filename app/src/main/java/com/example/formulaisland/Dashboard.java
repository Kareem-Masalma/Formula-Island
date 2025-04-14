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

import com.example.formulaisland.dataaccess.Product;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

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
    }

    private void addProductsList() {
        Log.d("Before the Adapter", "Here");
        ProductAdapter adapter = new ProductAdapter(this, products);
        Log.d("After the Adapter", "Here");
        lvProducts.setAdapter(adapter);
        Log.d("After the list view adapter", "Here");
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
        String productsString = pref.getString(Product.DATA, "No Products");
        this.products = gson.fromJson(productsString, new TypeToken<List<Product>>() {
        }.getType());
    }

    private void defineViews() {
        this.btnCart = findViewById(R.id.btnCart);
        this.btnSearch = findViewById(R.id.btnSearch);
        this.edSearch = findViewById(R.id.edSearch);
        this.lvProducts = findViewById(R.id.lvProducts);
    }

    class ProductAdapter extends ArrayAdapter<Product> {
        private Context context;
        private List<Product> productList;

        public ProductAdapter(Context context, List<Product> products) {
            super(context, 0, products);
            this.productList = products;
            this.context = context;
        }


        @NonNull
        @Override
        public View getView(int i, View convertView, @NonNull ViewGroup parent) {

            if (convertView == null) {
                convertView = LayoutInflater.from(context).inflate(R.layout.products_list, parent, false);
            }

            Product product = productList.get(i);

            ImageView image = convertView.findViewById(R.id.pImage);
            TextView description = convertView.findViewById(R.id.pTitle);
            Log.d("CheckPoint", "Product: " + product.getDescription() + ", ImgCode: " + product.getImageCode());
            image.setImageResource(product.getImageCode());
            description.setText(product.getDescription());

            return convertView;
        }
    }

}