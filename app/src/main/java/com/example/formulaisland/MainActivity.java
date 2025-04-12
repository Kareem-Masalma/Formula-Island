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
        products.add(new Product("Aston Martin", "Lego", "Dark Green", "Aston Martin Aramco F1® LEGO® AMR4 Race Car", R.drawable.aston_martin_am24_lego, 20));
        products.add(new Product("Aston Martin", "Lego", "Green", "Aston Martin Aramco F1® LEGO® AMR24 Race Car",R.drawable.aston_martin_amr24_lego, 20));
        products.add(new Product("Aston Martin", "Cap", "Black", "Aston Martin Aramco Cognizant F1 2025 Team Cap",R.drawable.aston_martin_black_cap, 20));
        products.add(new Product("Aston Martin", "Sweatshirt", "Black", "Aston Martin Aramco F1 Stealth Crew Sweat", R.drawable.aston_martin_black_sweat, 20));
        products.add(new Product("Aston Martin", "Cap", "Green", "Aston Martin Aramco F1 2024 Team Cap",R.drawable.aston_martin_green_cap, 20));
        products.add(new Product("Aston Martin", "Bag", "Green", "Aston Martin Aramco F1 Pullbag",R.drawable.aston_martin_green_pullbag, 20));
        products.add(new Product("Aston Martin", "Sweatshirt", "Dark Green", "Aston Martin Cognizant F1 Official Kimoa Fernando Alonso Embroidery Sweatshirt", R.drawable.aston_martin_green_sweat, 20));
        products.add(new Product("Aston Martin", "Hoodie", "Green", "Aston Martin Aramco F1 2024 Team Driver Hoodie",R.drawable.aston_martin_hoodies, 20));
        products.add(new Product("Aston Martin", "Polo", "Green", "Aston Martin Aramco Cognizant F1 2025 Team Polo",R.drawable.aston_martin_polo, 20));
        products.add(new Product("Aston Martin", "Cap", "Red and White", "Aston Martin Aramco Cognizant F1 2023 Fernando Alonso Special Edition USA GP Cap", R.drawable.aston_martin_red_cap, 20));
        products.add(new Product("Aston Martin", "T-Shirt", "Green", "Aston Martin Aramco Cognizant F1 2025 Fernando Alonso Team Driver T-Shirt",R.drawable.aston_martin_tshirt, 20));
        products.add(new Product("Aston Martin", "Mug/Watter Bottle", "Blue", "Aston Martin Aramco F1 Water bottle",R.drawable.aston_martin_waterbottle, 20));
        products.add(new Product("Aston Martin", "Cap", "White", "Aston Martin Aramco Cognizant F1 2025 Team Cap", R.drawable.aston_martin_white_cap, 20));
        products.add(new Product("Aston Martin", "Cap", "Yellow", "Aston Martin Aramco F1 2024 Fernando Alonso Team Cap",R.drawable.aston_martin_yellow_cap, 20));

        products.add(new Product("Ferrari", "Cap", "Black", "Scuderia Ferrari Puma Classic Cap",R.drawable.ferrari_black_cap, 20));
        products.add(new Product("Ferrari", "Jacket", "Black", "Scuderia Ferrari Puma Softshell Jacket",R.drawable.ferrari_black_jacket, 20));
        products.add(new Product("Ferrari", "Pants", "Black", "Scuderia Ferrari Race Premium Trousers by Puma",R.drawable.ferrari_black_pants, 20));
        products.add(new Product("Ferrari", "Polo", "Black", "Scuderia Ferrari Puma Classic Polo",R.drawable.ferrari_black_polo, 20));
        products.add(new Product("Ferrari", "T-Shirt", "Black", "Scuderia Ferrari Puma Large Shield T-Shirt ",R.drawable.ferrari_black_tshirt, 20));
        products.add(new Product("Ferrari", "Sunglasses", "Black", "Scuderia Ferrari Adrenaline Performance Sunglasses",R.drawable.ferrari_black_sunglasses, 20));
        products.add(new Product("Ferrari", "T-Shirt", "Blue", "Scuderia Ferrari Race MT7 T-Shirt by Puma",R.drawable.ferrari_blue_tshirt, 20));
        products.add(new Product("Ferrari", "Sunglasses", "Grey", "Scuderia Ferrari Aerodynamic Sunglasses",R.drawable.ferrari_grey_sunglasses, 20));
        products.add(new Product("Ferrari", "Cap", "Red", "Scuderia Ferrari 2025 Team Lewis Hamilton Cap",R.drawable.ferrari_hamilton_cap, 20));
        products.add(new Product("Ferrari", "Helmet", "Yellow", "Scuderia Ferrari Lewis Hamilton Fiorano Test 2025 1:5 LookSmart Model Helmet",R.drawable.ferrari_hamilton_helmet, 20));
        products.add(new Product("Ferrari", "Hoodie", "Red and White", "Scuderia Ferrari Race Premium Hoodie by Puma - Red - Hamilton 44",R.drawable.ferrari_hamilton_red_and_white_hoodies, 20));
        products.add(new Product("Ferrari", "Cap", "Red", "Scuderia Ferrari 2025 Team Charles Leclerc Cap",R.drawable.ferrari_leclerc_cap, 20));
        products.add(new Product("Ferrari", "Mug/Watter Bottle", "Red", "Scuderia Ferrari Matte Thermal Mug",R.drawable.ferrari_mug, 20));
        products.add(new Product("Ferrari", "Bag", "Red", "Scuderia Ferrari 2025 Race Backpack",R.drawable.ferrari_red_backpack, 20));
        products.add(new Product("Ferrari", "Bag", "Red", "Scuderia Ferrari Race Waist Bag by Puma",R.drawable.ferrari_red_bag, 20));
        products.add(new Product("Ferrari", "Cap", "Red", "Scuderia Ferrari Puma Classic Cap",R.drawable.ferrari_red_cap, 20));
        products.add(new Product("Ferrari", "Gilet", "Red", "Scuderia Ferrari 2025 Puma Lightly Padded Gilet",R.drawable.ferrari_red_gilet, 20));
        products.add(new Product("Ferrari", "Jacket", "Red", "Scuderia Ferrari 2024 Team Softshell Jacket",R.drawable.ferrari_red_jacket, 20));
        products.add(new Product("Ferrari", "T-Shirt", "Red", "Scuderia Ferrari 2025 Drivers Oversized T-Shirt",R.drawable.ferrari_red_oversize_tshirt, 20));
        products.add(new Product("Ferrari", "Polo", "Red", "Scuderia Ferrari 2025 Team Polo",R.drawable.ferrari_red_polo, 20));
        products.add(new Product("Ferrari", "Shorts", "Red", "Scuderia Ferrari Race Woven Shorts by Puma",R.drawable.ferrari_red_shorts, 20));
        products.add(new Product("Ferrari", "T-Shirt", "Red", "Scuderia Ferrari 2025 Team T-Shirt",R.drawable.ferrari_red_tshirt, 20));
        products.add(new Product("Ferrari", "Figure", "Red", "Scuderia Ferrari SF23 No.55 Bahrain GP 4th Place - Carlos Sainz 1:18 LookSmart Model",R.drawable.ferrari_sf23, 20));
        products.add(new Product("Ferrari", "Lego", "Red", "Ferrari SF-24 F1® LEGO® Race Car",R.drawable.ferrari_sf24_lego, 20));
        products.add(new Product("Ferrari", "Figure", "Red", "Scuderia Ferrari F1-75 No.16 Winner Austria GP Charles LeClerc 1:18 LookSmart Model",R.drawable.ferrari_sf75, 20));
        products.add(new Product("Ferrari", "Mug/Water Bottle", "Red", "Scuderia Ferrari Race Water bottle",R.drawable.ferrari_waterbttle, 20));
        products.add(new Product("Ferrari", "Sunglasses", "White", "Scuderia Ferrari Aerodynamic Sunglasses",R.drawable.ferrari_white_sunglasses, 20));
        products.add(new Product("Ferrari", "T-Shirt", "White", "Scuderia Ferrari Race Chrome Large Shield T-Shirt by Puma",R.drawable.ferrari_white_tshirt, 20));
        products.add(new Product("Ferrari", "T-Shirt", "Yellow", "Scuderia Ferrari Team Reflective T-Shirt",R.drawable.ferrari_yellow_tshirt, 20));

    }
}