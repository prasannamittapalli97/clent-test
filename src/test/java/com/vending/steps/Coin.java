package com.vending.steps;

//Coin
public enum Coin {
    PENNY("PENNY",1), NICKEL("NICKEL",5), DIME("DIME",10), QUARTER("QUARTER",25);
    private int denom;
    private String name;
    private Coin(String name, int denom){
        this.name = name; this.denom = denom;
    }
    public int getDenom(){
        return denom;
    }
    public String getName(){
        return name;
    }
}