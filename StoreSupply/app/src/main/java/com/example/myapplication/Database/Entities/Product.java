package com.example.myapplication.Database.Entities;

public class Product {
    private int id;
    private String name;
    private int categoryId;
    private int stock;
    private String species;
    private String material;
    private String color;
    private String size;
    private String brand;
    private double price;
    private boolean isWaterProof;

    public Product() {
    }

    public Product(int id, String name, int categoryId, int stock, String species, String material, String color, String size, String brand, double price, boolean isWaterProof) {
        this.id = id;
        this.name = name;
        this.categoryId = categoryId;
        this.stock = stock;
        this.species = species;
        this.material = material;
        this.color = color;
        this.size = size;
        this.brand = brand;
        this.price = price;
        this.isWaterProof = isWaterProof;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isWaterProof() {
        return isWaterProof;
    }

    public void setWaterProof(boolean waterProof) {
        isWaterProof = waterProof;
    }
}
