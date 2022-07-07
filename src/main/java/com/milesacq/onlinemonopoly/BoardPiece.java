package com.milesacq.onlinemonopoly;

public class BoardPiece {
    protected Type type;
    protected String name;
    protected int price;
    protected int position;
    protected Coordinate coords;

    public BoardPiece(Type type, String name, int price, int position, Coordinate coords) {
        this.type = type;
        this.name = name;
        this.price = price;
        this.position = position;
        this.coords = coords;
    }
}
