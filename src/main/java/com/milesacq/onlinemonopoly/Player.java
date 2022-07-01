package com.milesacq.onlinemonopoly;

public class Player {
    private int position;
    private String username;

    public Player(String username) {
        this.username = username;
    }

    public void setPostion(int position) {
        this.position = position;
    }

    private void movePiece(int num) {
        this.position += num;
        System.out.println(this.position);

        HelloApplication.getClientHandler().broadcastMessage("!move! " + username + " " + this.position);
    }
    public void roll() {
        movePiece((int)(Math.random()*(11)+2));
    }
}
