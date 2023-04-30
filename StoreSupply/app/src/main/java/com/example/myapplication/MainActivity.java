package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import com.example.myapplication.Database.DatabaseHelper;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

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

//        edit_ProductButton = findViewById(R.id.add_ProductButton);
//        add_ProductButton.setOnClickListener(v -> {
//            Intent intent = new Intent(MainActivity.this, AddProductActivity.class); //return is the addProduct Activity
//            startActivity(intent);
//        });



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

    }
    void getAllProducts(){
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

}