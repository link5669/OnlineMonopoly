package com.milesacq.onlinemonopoly;

public class Property {
    private Type type;
    private String name;
    private int price;
    private Client owner;
    private int position;

    public Property(Type type, String name, int price, int position) {
        this.type = type;
        this.name = name;
        this.price = price;
        this.position = position;
    }
}
