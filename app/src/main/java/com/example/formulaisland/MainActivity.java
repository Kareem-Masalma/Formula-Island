package com.example.formulaisland;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.formulaisland.dataaccess.Product;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        List<Product> products = new ArrayList<>();
        products.add(new Product("Aston Martin", "Lego", "Dark Green", "Aston Martin Aramco F1® LEGO® AMR4 Race Car", R.drawable.aston_martin_am24_lego, 20, 25));
        products.add(new Product("Aston Martin", "Lego", "Green", "Aston Martin Aramco F1® LEGO® AMR24 Race Car", R.drawable.aston_martin_amr24_lego, 20, 90));
        products.add(new Product("Aston Martin", "Cap", "Black", "Aston Martin Aramco Cognizant F1 2025 Team Cap", R.drawable.aston_martin_black_cap, 20, 32));
        products.add(new Product("Aston Martin", "Sweatshirt", "Black", "Aston Martin Aramco F1 Stealth Crew Sweat", R.drawable.aston_martin_black_sweat, 20, 85));
        products.add(new Product("Aston Martin", "Cap", "Green", "Aston Martin Aramco F1 2024 Team Cap", R.drawable.aston_martin_green_cap, 20, 22));
        products.add(new Product("Aston Martin", "Bag", "Green", "Aston Martin Aramco F1 Pullbag", R.drawable.aston_martin_green_pullbag, 20, 22));
        products.add(new Product("Aston Martin", "Sweatshirt", "Dark Green", "Aston Martin Cognizant F1 Official Kimoa Fernando Alonso Embroidery Sweatshirt", R.drawable.aston_martin_green_sweat, 20, 85));
        products.add(new Product("Aston Martin", "Hoodie", "Green", "Aston Martin Aramco F1 2024 Team Driver Hoodie", R.drawable.aston_martin_hoodies, 20, 57));
        products.add(new Product("Aston Martin", "Polo", "Green", "Aston Martin Aramco Cognizant F1 2025 Team Polo", R.drawable.aston_martin_polo, 20, 57));
        products.add(new Product("Aston Martin", "Cap", "Red and White", "Aston Martin Aramco Cognizant F1 2023 Fernando Alonso Special Edition USA GP Cap", R.drawable.aston_martin_red_cap, 20, 12));
        products.add(new Product("Aston Martin", "T-Shirt", "Green", "Aston Martin Aramco Cognizant F1 2025 Fernando Alonso Team Driver T-Shirt", R.drawable.aston_martin_tshirt, 20, 50));
        products.add(new Product("Aston Martin", "Mug/Watter Bottle", "Blue", "Aston Martin Aramco F1 Water bottle", R.drawable.aston_martin_waterbottle, 20, 21));
        products.add(new Product("Aston Martin", "Cap", "White", "Aston Martin Aramco Cognizant F1 2025 Team Cap", R.drawable.aston_martin_white_cap, 20, 32));
        products.add(new Product("Aston Martin", "Cap", "Yellow", "Aston Martin Aramco F1 2024 Fernando Alonso Team Cap", R.drawable.aston_martin_yellow_cap, 20, 18));

        products.add(new Product("Ferrari", "Cap", "Black", "Scuderia Ferrari Puma Classic Cap", R.drawable.ferrari_black_cap, 20, 28));
        products.add(new Product("Ferrari", "Jacket", "Black", "Scuderia Ferrari Puma Softshell Jacket", R.drawable.ferrari_black_jacket, 20, 133));
        products.add(new Product("Ferrari", "Pants", "Black", "Scuderia Ferrari Race Premium Trousers by Puma", R.drawable.ferrari_black_pants, 20, 90));
        products.add(new Product("Ferrari", "Polo", "Black", "Scuderia Ferrari Puma Classic Polo", R.drawable.ferrari_black_polo, 20, 52));
        products.add(new Product("Ferrari", "T-Shirt", "Black", "Scuderia Ferrari Puma Large Shield T-Shirt ", R.drawable.ferrari_black_tshirt, 20, 28));
        products.add(new Product("Ferrari", "Sunglasses", "Black", "Scuderia Ferrari Adrenaline Performance Sunglasses", R.drawable.ferrari_black_sunglasses, 20, 104));
        products.add(new Product("Ferrari", "T-Shirt", "Blue", "Scuderia Ferrari Race MT7 T-Shirt by Puma", R.drawable.ferrari_blue_tshirt, 20, 45));
        products.add(new Product("Ferrari", "Sunglasses", "Grey", "Scuderia Ferrari Aerodynamic Sunglasses", R.drawable.ferrari_grey_sunglasses, 20, 104));
        products.add(new Product("Ferrari", "Cap", "Red", "Scuderia Ferrari 2025 Team Lewis Hamilton Cap", R.drawable.ferrari_hamilton_cap, 20, 36));
        products.add(new Product("Ferrari", "Helmet", "Yellow", "Scuderia Ferrari Lewis Hamilton Fiorano Test 2025 1:5 LookSmart Model Helmet", R.drawable.ferrari_hamilton_helmet, 20, 60));
        products.add(new Product("Ferrari", "Hoodie", "Red and White", "Scuderia Ferrari Race Premium Hoodie by Puma - Red - Hamilton 44", R.drawable.ferrari_hamilton_red_and_white_hoodies, 20, 118));
        products.add(new Product("Ferrari", "Cap", "Red", "Scuderia Ferrari 2025 Team Charles Leclerc Cap", R.drawable.ferrari_leclerc_cap, 20, 36));
        products.add(new Product("Ferrari", "Mug/Watter Bottle", "Red", "Scuderia Ferrari Matte Thermal Mug", R.drawable.ferrari_mug, 20,22.50));
        products.add(new Product("Ferrari", "Bag", "Red", "Scuderia Ferrari 2025 Race Backpack", R.drawable.ferrari_red_backpack, 20, 71));
        products.add(new Product("Ferrari", "Bag", "Red", "Scuderia Ferrari Race Waist Bag by Puma", R.drawable.ferrari_red_bag, 20, 32));
        products.add(new Product("Ferrari", "Cap", "Red", "Scuderia Ferrari Puma Classic Cap", R.drawable.ferrari_red_cap, 20, 28));
        products.add(new Product("Ferrari", "Gilet", "Red", "Scuderia Ferrari 2025 Puma Lightly Padded Gilet", R.drawable.ferrari_red_gilet, 20, 95));
        products.add(new Product("Ferrari", "Jacket", "Red", "Scuderia Ferrari 2024 Team Softshell Jacket", R.drawable.ferrari_red_jacket, 20, 162));
        products.add(new Product("Ferrari", "T-Shirt", "Red", "Scuderia Ferrari 2025 Drivers Oversized T-Shirt", R.drawable.ferrari_red_oversize_tshirt, 20, 81));
        products.add(new Product("Ferrari", "Polo", "Red", "Scuderia Ferrari 2025 Team Polo", R.drawable.ferrari_red_polo, 20, 77));
        products.add(new Product("Ferrari", "Shorts", "Red", "Scuderia Ferrari Race Woven Shorts by Puma", R.drawable.ferrari_red_shorts, 20, 63));
        products.add(new Product("Ferrari", "T-Shirt", "Red", "Scuderia Ferrari 2025 Team T-Shirt", R.drawable.ferrari_red_tshirt, 20,63));
        products.add(new Product("Ferrari", "Figure", "Red", "Scuderia Ferrari SF23 No.55 Bahrain GP 4th Place - Carlos Sainz 1:18 LookSmart Model", R.drawable.ferrari_sf23, 20, 150));
        products.add(new Product("Ferrari", "Lego", "Red", "Ferrari SF-24 F1® LEGO® Race Car", R.drawable.ferrari_sf24_lego, 20, 230));
        products.add(new Product("Ferrari", "Figure", "Red", "Scuderia Ferrari F1-75 No.16 Winner Austria GP Charles LeClerc 1:18 LookSmart Model", R.drawable.ferrari_sf75, 20, 150));
        products.add(new Product("Ferrari", "Mug/Water Bottle", "Red", "Scuderia Ferrari Race Water bottle", R.drawable.ferrari_waterbttle, 20, 22.50));
        products.add(new Product("Ferrari", "Sunglasses", "White", "Scuderia Ferrari Aerodynamic Sunglasses", R.drawable.ferrari_white_sunglasses, 20, 104));
        products.add(new Product("Ferrari", "T-Shirt", "White", "Scuderia Ferrari Race Chrome Large Shield T-Shirt by Puma", R.drawable.ferrari_white_tshirt, 20, 40.50));
        products.add(new Product("Ferrari", "T-Shirt", "Yellow", "Scuderia Ferrari Team Reflective T-Shirt", R.drawable.ferrari_yellow_tshirt, 20, 52));

        products.add(new Product("McLaren", "Cap", "Orange", "McLaren New Era Lando Norris 9SEVENTY Pre Curved Cap", R.drawable.mclearn_lando_cap, 20, 41));
        products.add(new Product("McLaren", "Cap", "Orange", "McLaren New Era Essential 9FORTY Cap - Papaya", R.drawable.mclearn_orange_cap, 20, 28));
        products.add(new Product("McLaren", "Cap", "White", "McLaren New Era 9SEVENTY Special Edition Miami GP Cap", R.drawable.mclearn_white_cap, 20, 40));
        products.add(new Product("McLaren", "Cap", "Pink", "McLaren New Era Seasonal 9TWENTY Cap", R.drawable.mclearn_pink_cap, 20, 29));
        products.add(new Product("McLaren", "Cap", "Black and White", "McLaren New Era 9SEVENTY Special Edition Japan GP Cap", R.drawable.mclearn_black_cap, 20, 40));
        products.add(new Product("McLaren", "Figure", "Green", "McLaren Mighty Jaxx 2023 Lando Norris Collectable Figurine", R.drawable.mclearn_lando_figure, 20, 100));
        products.add(new Product("McLaren", "Figure", "Red", "McLaren Mighty Jaxx 2023 Oscar Piastri Collectable Figurine", R.drawable.mclearn_oscar_figure, 20, 100));
        products.add(new Product("McLaren", "Figure", "White", "Ayrton Senna Funko", R.drawable.senna_funko, 20, 20));
        products.add(new Product("McLaren", "Lego", "Orange", "McLaren F1® Team LEGO® MCL38 Race Car", R.drawable.mclearn_mcl38_lego, 20, 200));
        products.add(new Product("McLaren", "Lego", "White", "LEGO® Icons McLaren MP4/4 & Ayrton Senna Set 10330", R.drawable.senna_mp4_lego, 20, 80));
        products.add(new Product("McLaren", "T-Shirt", "Black", "McLaren Essentials T-Shirt", R.drawable.mclearn_black_tshirt, 20, 35));
        products.add(new Product("McLaren", "T-Shirt", "Black and Orange", "McLaren Essentials T-Shirt - Black", R.drawable.mclearn_black_and_orange_tshirt, 20, 65));
        products.add(new Product("McLaren", "T-Shirt", "Green", "McLaren Essentials T-Shirt", R.drawable.mclearn_green_tshirt, 20, 35));
        products.add(new Product("McLaren", "T-Shirt", "White", "McLaren Essential Logo T-Shirt", R.drawable.mclearn_white_tshirt, 20, 30));
        products.add(new Product("McLaren", "Gilet", "Black", "McLaren 2025 Team Hybrid Gilet", R.drawable.mclearn_black_and_orange_gilet, 20, 105));
        products.add(new Product("McLaren", "Jacket", "Black", "McLaren x Mitchell & Ness Las Vegas GP Track Jacket", R.drawable.mclearn_black_and_white_track, 20, 140));
        products.add(new Product("McLaren", "Hoodie", "Orange", "McLaren 2025 Team Hooded Sweat", R.drawable.mclearn_orange_hoodies, 20, 110));
        products.add(new Product("McLaren", "Hoodie", "Pink", "McLaren Essential Logo Hoodie", R.drawable.mclearn_pink_hoodies, 20, 68));
        products.add(new Product("McLaren", "Hoodie", "Green", "McLaren Essential Logo Hoodie", R.drawable.mclearn_green_hoodies, 20, 68));
        products.add(new Product("McLaren", "Polo", "Orange", "McLaren 2025 Team Polo", R.drawable.mclearn_orange_polo, 20, 78));

        products.add(new Product("Mercedes", "Cap", "Black", "Mercedes AMG Petronas adidas F1 2025 Team Cap", R.drawable.mercedes_black_cap, 20, 52));
        products.add(new Product("Mercedes", "Cap", "White", "Mercedes AMG Petronas adidas F1 2025 Team Cap", R.drawable.mercedes_white_cap, 20, 52));
        products.add(new Product("Mercedes", "T-Shirt", "Black", "Mercedes AMG Petronas adidas F1 2025 Team Driver T-Shirt ", R.drawable.mercedes_black_tshirt, 20, 60));
        products.add(new Product("Mercedes", "Sweatshirt", "White", "Mercedes AMG Petronas F1 Crew Sweat", R.drawable.mercedes_white_sweat, 20, 48));
        products.add(new Product("Mercedes", "Sweatshirt", "Black", "Mercedes AMG Petronas F1 Crew Sweat", R.drawable.mercedes_black_sweat, 20, 48));
        products.add(new Product("Mercedes", "Bag", "Black", "Mercedes AMG Petronas F1 Backpack", R.drawable.mercedes_black_backpack, 20, 20));
        products.add(new Product("Mercedes", "Figure", "White", "Mercedes Mighty Jaxx 2023 Lewis Hamilton Collectable Figurine", R.drawable.mercedes_hamilton_funko, 20, 20));
        products.add(new Product("Mercedes", "Helmet", "Green", "Mercedes AMG Petronas Lewis Hamilton 2024 1:5 Spark Model Helmet", R.drawable.mercedes_hamilton_helmet, 20, 60));
        products.add(new Product("Mercedes", "Helmet", "Blue", "Mercedes AMG Petronas George Russell 2024 1:5 Spark Model Helmet", R.drawable.mercedes_russell_helmet, 20, 60));
        products.add(new Product("Mercedes", "Figure", "White", "Mercedes AMG Petronas F1 No.44 W13 E Performance 4th Bahrain GP - George Russell 1:18 Model", R.drawable.mercedes_w13, 20, 14));
        products.add(new Product("Mercedes", "Figure", "Black", "Mercedes AMG Petronas F1 No.44 W14 E Performance Australian GP 2nd Place - Lewis Hamilton 1:18 Model", R.drawable.mercedes_w14, 20, 57));
        products.add(new Product("Mercedes", "Lego", "Black", "Mercedes-AMG F1® LEGO® W15 Race Car", R.drawable.mercedes_w14_lego, 20, 220));
        products.add(new Product("Mercedes", "Hoodie", "Green", "Mercedes AMG Petronas F1 Tie Dye Hoodie", R.drawable.mercedes_green_hoodies, 20, 94));
        products.add(new Product("Mercedes", "Jacket", "Black", "Mercedes AMG Petronas Padded Jacket", R.drawable.mercedes_black_coat, 20, 170));


        products.add(new Product("Red bull", "T_Shirt", "Dutch", "Oracle Red Bull Racing Max Verstappen Driver T-Shirt", R.drawable.redbull_dutch_tshirt, 20, 18));
        products.add(new Product("Red bull", "T_Shirt", "White", "Oracle Red Bull Racing Large Logo T-shirt", R.drawable.redbull_white_tshirt, 20, 33));
        products.add(new Product("Red bull", "T_Shirt", "Navy", "Red Bull Racing 2025 Team Set Up T-Shirt", R.drawable.redbull_tshirt, 20, 68));
        products.add(new Product("Red bull", "T_Shirt", "Orange", "Oracle Red Bull Racing Max Verstappen Driver T-Shirt - Orange", R.drawable.redbull_orange_tshirt, 20, 31));
        products.add(new Product("Red bull", "Hoodie", "Black", "Red Bull Racing 2025 Team Hoodie", R.drawable.redbull_hoodies, 20, 70));
        products.add(new Product("Red bull", "Helmet", "Navy", "VCARB Yuki Tsunoda 2024 1:5 Spark Model Helmet", R.drawable.redbull_yuki_helmet, 20, 60));
        products.add(new Product("Red bull", "Cap", "Navy", "Red Bull Racing New Era Max Verstappen 9SEVENTY Piped Cap - Navy", R.drawable.redbull_verstappen_cap, 20, 55));
        products.add(new Product("Red bull", "Cap", "Green", "Red Bull Racing New Era Contrast E-Frame Trucker", R.drawable.redbull_green_cap, 20, 54));
        products.add(new Product("Red bull", "Cap", "Purple", "Oracle Red Bull Racing New Era Seasonal 9FIFTY Pre Curved Cap", R.drawable.redbull_purble_cap, 20, 12));
        products.add(new Product("Red bull", "Lego", "Navy Blue", "Oracle Red Bull Racing RB20 F1® LEGO® Race Car", R.drawable.redbull_rb20_lego, 20, 220));
        products.add(new Product("Red bull", "Lego", "Navy", "Oracle Red Bull Racing RB18 No.1 Winner Miami GP - Max Verstappen - 1:18 Model", R.drawable.redbull_rb18, 20,58));


        Gson gson = new Gson();
        String products_json = gson.toJson(products);
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(Product.DATA, products_json);
        editor.apply();


        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, Background.class);
                startActivity(intent);
                finish();
            }
        }, 3 * 1000);
    }
}