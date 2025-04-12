package com.example.formulaisland;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.formulaisland.dataaccess.Product;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        List<Product> products = new ArrayList<>();
        products.add(new Product("Aston Martin", "AM24 Lego", "Dark Green", "Aston Martin Aramco F1® LEGO® AMR4 Race Car", R.drawable.aston_martin_am24_lego, 20));
        products.add(new Product("Aston Martin", "AMR24 Lego", "Green", "Aston Martin Aramco F1® LEGO® AMR24 Race Car",R.drawable.aston_martin_amr24_lego, 20));
        products.add(new Product("Aston Martin", "Cap", "Black", "Aston Martin Aramco Cognizant F1 2025 Team Cap",R.drawable.aston_martin_black_cap, 20));
        products.add(new Product("Aston Martin", "Sweatshirt", "Black", "Aston Martin Aramco F1 Stealth Crew Sweat", R.drawable.aston_martin_black_sweat, 20));
        products.add(new Product("Aston Martin", "Cap", "Green", "Aston Martin Aramco F1 2024 Team Cap",R.drawable.aston_martin_green_cap, 20));
        products.add(new Product("Aston Martin", "Bag", "Green", "Aston Martin Aramco F1 Pullbag",R.drawable.aston_martin_green_pullbag, 20));
        products.add(new Product("Aston Martin", "Sweatshirt", "Dark Green", "Aston Martin Cognizant F1 Official Kimoa Fernando Alonso Embroidery Sweatshirt", R.drawable.aston_martin_green_sweat, 20));
        products.add(new Product("Aston Martin", "Hoodie", "Green", "Aston Martin Aramco F1 2024 Team Driver Hoodie",R.drawable.aston_martin_hoodies, 20));
        products.add(new Product("Aston Martin", "Polo", "Green", "Aston Martin Aramco Cognizant F1 2025 Team Polo",R.drawable.aston_martin_polo, 20));
        products.add(new Product("Aston Martin", "Cap", "Red and White", "Aston Martin Aramco Cognizant F1 2023 Fernando Alonso Special Edition USA GP Cap", R.drawable.aston_martin_red_cap, 20));
        products.add(new Product("Aston Martin", "T-Shirt", "Green", "Aston Martin Aramco Cognizant F1 2025 Fernando Alonso Team Driver T-Shirt",R.drawable.aston_martin_tshirt, 20));
        products.add(new Product("Aston Martin", "Watter Bottle", "Blue", "Aston Martin Aramco F1 Water bottle",R.drawable.aston_martin_waterbottle, 20));
        products.add(new Product("Aston Martin", "Cap", "White", "Aston Martin Aramco Cognizant F1 2025 Team Cap", R.drawable.aston_martin_white_cap, 20));
        products.add(new Product("Aston Martin", "Cap", "Yellow", "Aston Martin Aramco F1 2024 Fernando Alonso Team Cap",R.drawable.aston_martin_yellow_cap, 20));

    }
}