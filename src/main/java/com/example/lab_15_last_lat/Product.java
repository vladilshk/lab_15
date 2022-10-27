package com.example.lab_15_last_lat;

public class Product {
    private String name;
    private String author;
    private String description;
    private int price;
    private int id;

    public Product(String name, String author, String description, int price, int id) {
        this.name = name;
        this.author = author;
        this.description = description;
        this.price = price;
        this.id = id;
    }

    public Product(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
