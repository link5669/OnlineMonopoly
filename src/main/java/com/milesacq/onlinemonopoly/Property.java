package com.milesacq.onlinemonopoly;

public class Property extends BoardPiece {
    private int owner;
    public Property(Type type, String name, int price, int position, Coordinate coords) {
        super(type, name, price, position, coords);
        owner = 5;
    }

    public boolean isOwned() {
        return owner != 5;
    }

    public void setOwner(int owner) {
        this.owner = owner;
        System.out.println(this.name + " bought by " + owner);
    }
}
