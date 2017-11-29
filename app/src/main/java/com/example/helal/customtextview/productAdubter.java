package com.example.helal.customtextview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

import static android.media.CamcorderProfile.get;

/**
 * Created by Helal on 11/15/2017.
 */

public class productAdubter extends ArrayAdapter<Product> {

    private final Context context;
    private ArrayList<Product> values;
    Product p ;

    public productAdubter(Context context, ArrayList<Product> list) {
        super(context, R.layout.custon_textview_layout , list);
        this.context = context;
        this.values = list;
    }

    @NonNull
    @Override
    public View getView(int position,View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View custon_textview_layout = inflater.inflate(R.layout.custon_textview_layout,parent ,false);

        TextView tvProductName = (TextView) custon_textview_layout.findViewById(R.id.tvProductName);
        TextView tvProductPrice= (TextView) custon_textview_layout.findViewById(R.id.tvProductPrice);
        TextView tvProductDescription = (TextView) custon_textview_layout.findViewById(R.id.tvProductDescription);
        ImageView ivProduct = (ImageView) custon_textview_layout.findViewById(R.id.ivProduct);
        ImageView ivProductSale = (ImageView) custon_textview_layout.findViewById(R.id.ivProductSale);

        tvProductName.setText(values.get(position).getTitle());
        tvProductPrice.setText("EGP " +values.get(position).getPrice());
        tvProductDescription.setText(values.get(position).getDescription());
        if (values.get(position).getSale()){
            ivProductSale.setImageResource(R.mipmap.on_sale_big);
        }else {ivProductSale.setImageResource(R.mipmap.best_price); }

        if(values.get(position).getType().equals("Laptop")){
            ivProduct.setImageResource(R.mipmap.laptop);
        }
        else if(values.get(position).getType().equals("Memory")){
            ivProduct.setImageResource(R.mipmap.memory);
        }
        else {
            ivProduct.setImageResource(R.mipmap.hdd);
        }

        return custon_textview_layout;

    }
}
