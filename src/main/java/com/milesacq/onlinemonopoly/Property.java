package com.milesacq.onlinemonopoly;

import javafx.scene.layout.CornerRadii;

public class Property {
    private Type type;
    private String name;
    private int price;
    private Client owner;
    private int position;
    private Coordinate coords;

    public Property(Type type, String name, int price, int position, Coordinate coords) {
        this.type = type;
        this.name = name;
        this.price = price;
        this.position = position;
        this.coords = coords;
    }
}
