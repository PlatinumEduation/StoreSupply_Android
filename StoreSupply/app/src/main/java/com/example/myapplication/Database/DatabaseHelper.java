package com.example.myapplication.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;


public class DatabaseHelper extends SQLiteOpenHelper {
    private Context context;

    private static final String DATABASE_NAME = "Store_Supply.DB";
    private static final int DATABASE_VERSION = 1;
    // Table names
    private static final String USER_TABLE = "users";
    private static final String CATEGORY_TABLE = "categories";
    private static final String SPECIES_TABLE = "species";
    private static final String PRODUCT_TABLE = "products";

    // Product Table
    private static final String PRODUCT_COL_ID = "prod_id";
    private static final String PRODUCT_COL_NAME = "prod_name";
    private static final String PRODUCT_COL_COLOR = "prod_color";
    private static final String PRODUCT_COL_STOCK = "prod_stock";
    private static final String PRODUCT_COL_SIZE = "prod_size";
    private static final String PRODUCT_COL_BRAND = "prod_brand";
    private static final String PRODUCT_COL_PRICE = "prod_price";




    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create user table
        String CREATE_USER_TABLE = "CREATE TABLE users(username TEXT, password TEXT)";
        db.execSQL(CREATE_USER_TABLE);

        // Category table create statement
        String CREATE_CATEGORY_TABLE = "CREATE TABLE categories (id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT)";
        db.execSQL(CREATE_CATEGORY_TABLE);

        // Product table create statement
        String CREATE_PRODUCT_TABLE = "CREATE TABLE products (" +
                PRODUCT_COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                PRODUCT_COL_NAME + " TEXT," +
                PRODUCT_COL_COLOR + " TEXT," +
                PRODUCT_COL_STOCK + " INTEGER," +
                PRODUCT_COL_SIZE + " INTEGER," +
                PRODUCT_COL_BRAND + " TEXT," +
                PRODUCT_COL_PRICE + " REAL" +
                ")";
        db.execSQL(CREATE_PRODUCT_TABLE);

        // Species table create statement
        String CREATE_SPECIES_TABLE = "CREATE TABLE species (id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT)";
        db.execSQL(CREATE_SPECIES_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older tables if existed
        db.execSQL("DROP TABLE IF EXISTS " + USER_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + PRODUCT_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + CATEGORY_TABLE);
        db.execSQL("DROP TABLE IF EXISTS " + SPECIES_TABLE);
        // Create tables again
        onCreate(db);
    }
    public boolean register(String username, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(username,username);
        values.put(password, password);
        long result = db.insert(USER_TABLE, null, values);
        db.close();
        return result != -1;
    }
    public int login(String username, String password){
        int result =0;
        String str [] = new String[2];
        str[0]= username;
        str[1]= password;
        SQLiteDatabase db = getReadableDatabase();
        Cursor c = db.rawQuery("select * from users where username =? and password =?",str);
        if(c.moveToFirst()){
            result = 1;
        }
        return result;
    }

    public Cursor getAllProducts(){ // will be called inside the main activity
        String query = "SELECT * FROM " + PRODUCT_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if (db!=null)     //so we have data here
            cursor = db.rawQuery(query,null);
        return cursor;
    }
    public void createProduct(String name, int stock, String color, int size, String brand, double price) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(PRODUCT_COL_NAME, name);
        values.put(PRODUCT_COL_STOCK, stock);
        values.put(PRODUCT_COL_COLOR, color);
        values.put(PRODUCT_COL_SIZE, size);
        values.put(PRODUCT_COL_BRAND, brand);
        values.put(PRODUCT_COL_PRICE, price);
        long result = db.insert("products", null, values);
        db.close();
        if(result == -1)
            Toast.makeText(context,"Failed to create a product!",Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(context,"Added product successfully!",Toast.LENGTH_SHORT).show();
    }

    public void updateProduct(int id,String name, int stock, String color, int size, String brand, double price) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(PRODUCT_COL_NAME, name);
        values.put(PRODUCT_COL_STOCK, stock);
        values.put(PRODUCT_COL_COLOR, color);
        values.put(PRODUCT_COL_SIZE, size);
        values.put(PRODUCT_COL_BRAND, brand);
        values.put(PRODUCT_COL_PRICE, price);
        db.update(PRODUCT_TABLE, values, PRODUCT_COL_ID + "=?", new String[]{String.valueOf(id)});
        db.close();
    }

    public void deleteProduct(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(PRODUCT_TABLE, PRODUCT_COL_ID + "=?", new String[]{String.valueOf(id)});
        db.close();
    }

    public Cursor getProductByName(String name) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "SELECT * FROM " + PRODUCT_TABLE + " WHERE " + PRODUCT_COL_NAME + "=?";
        String[] selectionArgs = { name };
        Cursor cursor = db.rawQuery(query, selectionArgs);
        return cursor;
    }}