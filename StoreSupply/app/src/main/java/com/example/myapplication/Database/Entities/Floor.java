package com.example.myapplication.Database.Entities;

public class Floor {
    private String category;
    private String color;
    private String size;
    private String brand;
    private String type;
    private double price;

    public Floor(String category, String color, String size, String brand, String type, double price) {
        this.category = category;
        this.color = color;
        this.size = size;
        this.brand = brand;
        this.type = type;
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
