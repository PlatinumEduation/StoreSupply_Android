package com.example.myapplication.Database.Entities;

public class Stone extends Floor{
    private String material;

    public Stone(String category, String color, String size, String brand, String type, double price, String material) {
        super(category, color, size, brand, type, price);
        this.material = material;
    }

    // getter and setter for material

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
}
