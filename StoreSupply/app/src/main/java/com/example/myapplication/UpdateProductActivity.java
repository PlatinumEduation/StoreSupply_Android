package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.example.myapplication.Database.DatabaseHelper;
import com.example.myapplication.R;

public class UpdateProductActivity extends AppCompatActivity {

    EditText
            productName_input_update,
            productColor_input_update,
            productStock_input_update,
            productSize_input_update,
            productBrand_input_update,
            productPrice_input_update;
    String productName,productColor,productStock,productSize,productBrand,productPrice;
    Button updateProduct_Button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_product);

        // Initialize the views
        productName_input_update = findViewById(R.id.productName_input_update);
        productColor_input_update = findViewById(R.id.productColor_input_update);
        productStock_input_update = findViewById(R.id.productStock_input_update);
        productSize_input_update = findViewById(R.id.productSize_input_update);
        productBrand_input_update = findViewById(R.id.productBrand_input_update);
        productPrice_input_update = findViewById(R.id.productPrice_input_update);
        updateProduct_Button = findViewById(R.id.updateProduct_Button);

        // Set up the click listener for the "Update" button
        updateProduct_Button.setOnClickListener(v -> {
            String name = productName_input_update.getText().toString().trim();
            String color = productColor_input_update.getText().toString().trim();
            int stock = Integer.parseInt(productStock_input_update.getText().toString().trim());
            int size = Integer.parseInt(productSize_input_update.getText().toString().trim());
            String brand = productBrand_input_update.getText().toString().trim();
            double price = Double.parseDouble(productPrice_input_update.getText().toString().trim());
            int id = getIntent().getIntExtra("product_id", 0);

            DatabaseHelper db = new DatabaseHelper(UpdateProductActivity.this);
            db.updateProduct(id,name, stock, color, size, brand, price);

            // Go back to the product list activity
            Intent intent = new Intent(UpdateProductActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });

        getAndSetIntentData_SelectedProduct();
    }



    void getAndSetIntentData_SelectedProduct(){
        if(getIntent().hasExtra("stock") &&
                getIntent().hasExtra("name") &&
                getIntent().hasExtra("brand") &&
                getIntent().hasExtra("price")
        ){
            // Get the Intent data
            productName = getIntent().getStringExtra("name");
            productColor = getIntent().getStringExtra("color");
            productStock = getIntent().getStringExtra("stock");
            productSize = getIntent().getStringExtra("size");
            productBrand = getIntent().getStringExtra("brand");
            productPrice = getIntent().getStringExtra("price");

            // Set the EditText values
            productName_input_update.setText(productName);
            productColor_input_update.setText(productColor);
            productStock_input_update.setText(productStock);
            productSize_input_update.setText(productSize);
            productBrand_input_update.setText(productBrand);
            productPrice_input_update.setText(productPrice);
        }

    }

}