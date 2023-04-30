package com.example.myapplication.Database.Entities;

public class Laminate extends Floor{
    private boolean waterResistant;
    public Laminate(String category, String color, String size, String brand, String type, double price, boolean waterResistant) {
        super(category, color, size, brand, type, price);
        this.waterResistant = waterResistant;
    }
    public boolean isWaterResistant() {
        return waterResistant;
    }

    public void setWaterResistant(boolean waterResistant) {
        this.waterResistant = waterResistant;
    }
}
