package com.example.myapplication.Database.Entities;

public class Tile extends Floor{
    private String material;

    public Tile(String category, String color, String size, String brand, String type, double price, String material) {
        super(category, color, size, brand, type, price);
        this.material = material;
    }
    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}
