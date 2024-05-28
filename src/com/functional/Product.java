package com.functional;

import java.util.Objects;

public class Product {

    private float price = 10;
    private String name;

    public Product() {
    }

    public Product(float price, String name) {
        this.price = price;
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(float p){
        price = p;
    }

    public void showPrice(){
        System.out.println("Price "+price);
    }

    @Override
    public String toString() {
        return "Product{" +
                "price=" + Objects.toString(price,"no value")  +
                ", name='" + Objects.toString(name,"no value") + '\'' +
                '}';
    }
}
