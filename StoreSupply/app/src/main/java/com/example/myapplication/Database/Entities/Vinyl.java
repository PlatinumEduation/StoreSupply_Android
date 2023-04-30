package com.example.myapplication.Database.Entities;

public class Vinyl extends Floor{
    private boolean waterResistant;
    private boolean waterproof;
    public Vinyl(String category, String color, String size, String brand, String type, double price, boolean waterResistant, boolean waterproof) {
        super(category, color, size, brand, type, price);
        this.waterResistant = waterResistant;
        this.waterproof = waterproof;
    }
    public boolean isWaterResistant() {
        return waterResistant;
    }

    public void setWaterResistant(boolean waterResistant) {
        this.waterResistant = waterResistant;
    }

    public boolean isWaterproof() {
        return waterproof;
    }

    public void setWaterproof(boolean waterproof) {
        this.waterproof = waterproof;
    }
}
