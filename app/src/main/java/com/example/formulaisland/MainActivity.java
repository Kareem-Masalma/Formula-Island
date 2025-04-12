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
        products.add(new Product("Aston Martin", "AM24 Lego", "Dark Green", "Aston Martin Aramco F1® LEGO® AMR4 Race Car", R.drawable.aston_martin_am24_lego));
        products.add(new Product("Aston Martin", "AMR24 Lego", "Green", "Aston Martin Aramco F1® LEGO® AMR24 Race Car",R.drawable.aston_martin_amr24_lego));
        products.add(new Product("Aston Martin", "Cap", "Black", "Aston Martin Aramco Cognizant F1 2025 Team Cap",R.drawable.aston_martin_am24_lego));
        products.add(new Product("Aston Martin", "AM24 Lego", "Dark Green", "Aston Martin Aramco F1® LEGO® AMR4 Race Car", R.drawable.aston_martin_am24_lego));
        products.add(new Product("Aston Martin", "AMR24 Lego", "Green", "Aston Martin Aramco F1® LEGO® AMR24 Race Car",R.drawable.aston_martin_amr24_lego));
        products.add(new Product("Aston Martin", "Cap", "Black", "Aston Martin Aramco Cognizant F1 2025 Team Cap",R.drawable.aston_martin_am24_lego));
        products.add(new Product("Aston Martin", "AM24 Lego", "Dark Green", "Aston Martin Aramco F1® LEGO® AMR4 Race Car", R.drawable.aston_martin_am24_lego));
        products.add(new Product("Aston Martin", "AMR24 Lego", "Green", "Aston Martin Aramco F1® LEGO® AMR24 Race Car",R.drawable.aston_martin_amr24_lego));
        products.add(new Product("Aston Martin", "Cap", "Black", "Aston Martin Aramco Cognizant F1 2025 Team Cap",R.drawable.aston_martin_am24_lego));
        products.add(new Product("Aston Martin", "AM24 Lego", "Dark Green", "Aston Martin Aramco F1® LEGO® AMR4 Race Car", R.drawable.aston_martin_am24_lego));
        products.add(new Product("Aston Martin", "AMR24 Lego", "Green", "Aston Martin Aramco F1® LEGO® AMR24 Race Car",R.drawable.aston_martin_amr24_lego));
        products.add(new Product("Aston Martin", "Cap", "Black", "Aston Martin Aramco Cognizant F1 2025 Team Cap",R.drawable.aston_martin_am24_lego));
        products.add(new Product("Aston Martin", "AM24 Lego", "Dark Green", "Aston Martin Aramco F1® LEGO® AMR4 Race Car", R.drawable.aston_martin_am24_lego));
        products.add(new Product("Aston Martin", "AMR24 Lego", "Green", "Aston Martin Aramco F1® LEGO® AMR24 Race Car",R.drawable.aston_martin_amr24_lego));

    }
}