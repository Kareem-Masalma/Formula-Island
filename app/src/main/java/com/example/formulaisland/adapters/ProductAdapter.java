package com.example.formulaisland.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.formulaisland.R;
import com.example.formulaisland.dataaccess.Product;

import java.util.List;

/**
 * This class is a Product Adapter to add the list of products to the ListView and customize it
 * using Images and text.
 * **/

public class ProductAdapter extends ArrayAdapter<Product> {
    private final Context context;
    private final List<Product> productList;

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