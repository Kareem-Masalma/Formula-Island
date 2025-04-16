package com.example.formulaisland;

import static com.example.formulaisland.Dashboard.PRODUCT;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
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
    private CheckBox chkRemember;
    public static final String ORDER = "History";
    public static final String ADDRESS = "Address";
    public static boolean remember = false;
    public static String REMEMBER = "Remember Address";

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
        cart = Cart.cart;
        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Order order = getOrder();
                Gson gson = new Gson();

                for (int i = 0; i < Cart.cart.size(); i++)
                    Log.d("Cart: ", Cart.cart.get(i).toString());

                SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(CartScene.this);
                String ordersString = pref.getString(ORDER, "");
                Log.d("Checkout", ordersString);

                List<Order> ordersHistory;
                if (!ordersString.isBlank()) {
                    ordersHistory = gson.fromJson(ordersString, new TypeToken<List<Order>>() {
                    }.getType());
                } else {
                    ordersHistory = new ArrayList<>();
                }

                ordersHistory.add(order);

                for (int i = 0; i < cart.size(); i++) {
                    Product product = cart.get(i);
                    product.setQuantity(product.getQuantity() - product.getCartQuan());
                    product.setCartQuan(0);
                }
                Cart.cart.clear();
                Cart.price = 0.0;

                SharedPreferences.Editor editor = pref.edit();
                String orders_json = gson.toJson(ordersHistory);
                editor.putString(ORDER, orders_json);
                if (chkRemember.isChecked()) {
                    editor.putString(ADDRESS, spAddress.getSelectedItem().toString());
                    remember = true;
                    editor.putBoolean(REMEMBER, remember);
                } else {
                    remember = false;
                    editor.putBoolean(REMEMBER, remember);
                }
                editor.apply();
                Intent intent = new Intent(CartScene.this, Checkout.class);
                intent.putExtra(ORDER, gson.toJson(order));
                startActivity(intent);
            }
        });
    }

    @NonNull
    private Order getOrder() {
        List<Product> copiedCart = new ArrayList<>();
        for (Product p : cart) {
            Product copy = new Product(
                    p.getTeam(),
                    p.getProductName(),
                    p.getColor(),
                    p.getDescription(),
                    p.getImageCode(),
                    p.getQuantity(),
                    p.getPrice()
            );
            copy.setCartQuan(p.getCartQuan());
            copiedCart.add(copy);
        }

        return new Order(copiedCart, Cart.price, spAddress.getSelectedItem().toString());
    }


    private void getAddresses() {
        String[] addresses = Address.getData();
        ArrayAdapter<String> spAdapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, addresses);

        spAddress.setAdapter(spAdapter);
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        String address = pref.getString(ADDRESS, "");
        remember = pref.getBoolean(REMEMBER, false);
        int pos = -1;
        for (int i = 0; i < addresses.length; i++) {
            if (addresses[i].equals(address))
                pos = i;
        }
        if (remember && pos >= 0) {
            spAddress.setSelection(pos);
            chkRemember.setChecked(true);
        } else {
            spAddress.setSelection(0);
            chkRemember.setChecked(false);
        }

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
        chkRemember = findViewById(R.id.chkRemember);
    }

}