package com.milesacq.onlinemonopoly;
public class Player {
    private int position;
    private String username;
    private static final int MAX_INDEX = 39;
    private int money;

    public Player(String username) {
        this.username = username;
        money = 1500;
    }

    public String getUsername() {
        return this.username;
    }
    public int getMoney() {
        return this.money;
    }

    public void subtractMoney(int money) {
        this.money -= money;
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
        MonopolyApplication.getClientHandler().broadcastMessage("!move! " + SingletonBoard.getNum(username) + " " + this.position);
    }
    public int roll() {
        incrementPosition((int)(Math.random()*(11)+2));
        return this.position;
    }
}