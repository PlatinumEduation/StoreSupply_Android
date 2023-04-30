package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    //This one for showing the products list view
    private Context context;
    private ArrayList productsID;
    private ArrayList productsName;
    private ArrayList productsColor;
    private ArrayList productsStock;
    private ArrayList productsSize;
    private ArrayList productsBrand;
    private ArrayList productsPrice;

    public CustomAdapter(
            Context context,
            ArrayList productsId,
            ArrayList productsName,
            ArrayList productsColor,
            ArrayList productsStock,
            ArrayList productsSize,
            ArrayList productsBrand,
            ArrayList productsPrice) {
        this.context = context;
        this.productsID = productsId;
        this.productsName = productsName;
        this.productsColor = productsColor;
        this.productsStock = productsStock;
        this.productsSize = productsSize;
        this.productsBrand = productsBrand;
        this.productsPrice = productsPrice;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.products_list,parent,false); //passing here the layout
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        // Set the values of the views for this item
        // to set all the products in the productsListView -> if that deletes the products list won't exists
        holder.product_stock_text.setText(String.valueOf(productsStock.get(position)));
        holder.product_name_text.setText(String.valueOf(productsName.get(position)));
        holder.product_brand_text.setText(String.valueOf(productsBrand.get(position)));
        holder.product_price_text.setText(String.valueOf(productsPrice.get(position)));

        // Set the click listener for the edit button
        holder.editProduct_btn.setOnClickListener(v -> {
            int productId = (int) productsID.get(holder.getAdapterPosition());
            String productColor = (String) productsColor.get(holder.getAdapterPosition());
            String productsSize = (String) productsColor.get(holder.getAdapterPosition());

            Intent intent = new Intent(context, UpdateProductActivity.class);
            //transferring the data list product of the selected product to the UpdateProductActivity
            intent.putExtra("product_id", productId);
            intent.putExtra("name", String.valueOf(productsName.get(position)));
            intent.putExtra("brand", String.valueOf(productsStock.get(position)));
            intent.putExtra("price", String.valueOf(productsPrice.get(position)));
            intent.putExtra("stock", String.valueOf(productsStock.get(position)));
            intent.putExtra("color", productColor);
            intent.putExtra("size", productsSize);

            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return productsName.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder{

        //text view objects
        TextView product_stock_text,product_name_text, product_brand_text,product_price_text;
        LinearLayout updateProductLayout;
        Button editProduct_btn;

        MyViewHolder(@NonNull View itemView) {
            super(itemView);
            editProduct_btn = itemView.findViewById(R.id.editProduct_btn);
            // those are the fields in the show products list where i am getting the id of them
            product_stock_text = itemView.findViewById(R.id.product_stock_text);
            product_name_text = itemView.findViewById(R.id.product_name_text);
            product_brand_text = itemView.findViewById(R.id.product_brand_text);
            product_price_text = itemView.findViewById(R.id.product_price_text);
            updateProductLayout = itemView.findViewById(R.id.updateProductLayout);
        }
    }
}
