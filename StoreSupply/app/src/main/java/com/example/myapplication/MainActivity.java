package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import com.example.myapplication.Database.DatabaseHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    DatabaseHelper db;
    CustomAdapter customAdapter;
    FloatingActionButton add_ProductButton;
    ArrayList<Integer> productsID;
    ArrayList<String> productsName;
    ArrayList<String> productsColor;
    ArrayList<Integer> productsStock;
    ArrayList<Integer> productsSize;
    ArrayList<String> productsBrand;
    ArrayList<Double> productsPrice;

    //for the search product bar view
    private SearchView searchProductsByName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        add_ProductButton = findViewById(R.id.add_ProductButton);
        add_ProductButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddProductActivity.class); //return is the addProduct Activity
            startActivity(intent);
        });
        db = new DatabaseHelper(MainActivity.this);
        productsID = new ArrayList<>();
        productsName = new ArrayList<>();
        productsColor = new ArrayList<>();
        productsStock = new ArrayList<>();
        productsSize = new ArrayList<>();
        productsBrand = new ArrayList<>();
        productsPrice = new ArrayList<>();

        getAllProducts();
        customAdapter = new CustomAdapter(MainActivity.this,productsID,productsName,productsColor,productsStock,productsSize,productsBrand,productsPrice);
        recyclerView.setAdapter(customAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this)); //show in the recycle view

        // for the search view
        searchProductsByName = findViewById(R.id.searchProductsByName);
        searchProductsByName.clearFocus();

        searchProductsByName.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                getProductsByName(newText);
                return true;
            }
        });

    }

    void getAllProducts(){
        productsID.clear();
        productsName.clear();
        productsColor.clear();
        productsStock.clear();
        productsSize.clear();
        productsBrand.clear();
        productsPrice.clear();
        // clear the list before adding data to avoid duplicates
        Cursor cursor = db.getAllProducts();
        if(cursor.getCount() == 0) {
            Toast.makeText(this,"No products exists!",Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()){
                productsID.add(Integer.valueOf(cursor.getString(0)));
                productsName.add(cursor.getString(1));
                productsColor.add(cursor.getString(2));
                productsStock.add(Integer.valueOf(cursor.getString(3)));
                productsSize.add(Integer.valueOf(cursor.getString(4)));
                productsBrand.add(cursor.getString(5));
                productsPrice.add(Double.valueOf(cursor.getString(6)));
            }
        }
    }
    void getProductsByName(String name){
        // clear the list before adding data to avoid duplicates
        Cursor cursor = db.getProductByName(name);
        if(cursor.getCount() == 0) {
            Toast.makeText(this,"No products match the search query!",Toast.LENGTH_SHORT).show();
            getAllProducts();
            customAdapter = new CustomAdapter(MainActivity.this,productsID,productsName,productsColor,productsStock,productsSize,productsBrand,productsPrice);
            recyclerView.setAdapter(customAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this)); //show in the recycle view
        } else {
            // clear the list before adding data to avoid duplicates
            productsID.clear();
            productsName.clear();
            productsColor.clear();
            productsStock.clear();
            productsSize.clear();
            productsBrand.clear();
            productsPrice.clear();
            while (cursor.moveToNext()){
                productsID.add(Integer.valueOf(cursor.getString(0)));
                productsName.add(cursor.getString(1));
                productsColor.add(cursor.getString(2));
                productsStock.add(Integer.valueOf(cursor.getString(3)));
                productsSize.add(Integer.valueOf(cursor.getString(4)));
                productsBrand.add(cursor.getString(5));
                productsPrice.add(Double.valueOf(cursor.getString(6)));
            }
        }
        customAdapter.notifyDataSetChanged(); // notify the adapter that the data set has changed
    }


}