package com.example.myapplication.Database.Entities;

public class Wood extends Floor{
    private String type;
    private String species;

    public Wood(String category, String color, String size, String brand, String type, double price, String typeOfWood, String species) {
        super(category, color, size, brand, type, price);
        this.type = typeOfWood;
        this.species = species;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }
}
