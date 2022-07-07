package com.milesacq.onlinemonopoly;
public class Player {
    private int position;
    private String username;
    private static final int MAX_INDEX = 39;

    public Player(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
    }

    public void setPostion(int position) {
        this.position = position;
    }

    private void incrementPosition(int num) {
        if (this.position + num > MAX_INDEX) {
            this.position = this.position + num - MAX_INDEX;
        } else {
            this.position += num;
        }
        HelloApplication.getClientHandler().broadcastMessage("!move! " + SingletonBoard.getNum(username) + " " + this.position);
    }
    public void roll() {
        incrementPosition((int)(Math.random()*(11)+2));
    }
}