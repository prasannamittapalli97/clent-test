package com.vending.steps;


//Item
public enum Item{
    COKE("COKE", 25), PEPSI("PEPSI", 35), SODA("SODA", 45);
    private String name;
    private int price;
    private Item(String name, int price){
        this.name = name; this.price = price;
    }
    public String getName(){
        return name;
    }
    public int getPrice(){
        return price;
    }
}