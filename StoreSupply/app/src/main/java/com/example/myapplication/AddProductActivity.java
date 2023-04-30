package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.Database.DatabaseHelper;

public class AddProductActivity extends AppCompatActivity {
    EditText
            productName_input,
            productColor_input,
            productStock_input,
            productSize_input,
            productBrand_input,
            productPrice_input;

    Button addProduct_Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        // Initialize the views
        productName_input = findViewById(R.id.productName_input);
        productColor_input = findViewById(R.id.productColor_input);
        productStock_input = findViewById(R.id.productStock_input);
        productSize_input = findViewById(R.id.productSize_input);
        productBrand_input = findViewById(R.id.productBrand_input);
        productPrice_input = findViewById(R.id.productPrice_input);
        addProduct_Button = findViewById(R.id.addProduct_Button);

        // Set up the click listener for the add product button
        addProduct_Button.setOnClickListener(v -> {
            DatabaseHelper db = new DatabaseHelper(AddProductActivity.this);
            // Get the values from the input fields
            String name = productName_input.getText().toString();
            String color = productColor_input.getText().toString();
            int stock = Integer.parseInt(productStock_input.getText().toString().trim());
            int size = Integer.parseInt(productSize_input.getText().toString().trim());
            String brand = productBrand_input.getText().toString();
            double price = Double.parseDouble(productPrice_input.getText().toString());
            db.createProduct(name,stock,color,size,brand,price);
            // Return to the "List Products" activity
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }

}