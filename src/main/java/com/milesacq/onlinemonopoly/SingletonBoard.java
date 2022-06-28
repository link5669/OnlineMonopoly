package com.milesacq.onlinemonopoly;

import java.util.ArrayList;

public class SingletonBoard {

    private static ArrayList<Client> players = new ArrayList<>();
    private static Property[] brownProperties = new Property[2];
    private static Property[] lightBlueProperties = new Property[3];
    private static Property[] pinkProperties = new Property[3];
    private static Property[] orangeProperties = new Property[3];
    private static Property[] redProperties = new Property[3];
    private static Property[] yellowProperties = new Property[3];
    private static Property[] greenProperties = new Property[3];
    private static Property[] darkBlueProperties = new Property[2];
    private static Property[] railroads = new Property[4];
    private static Property[] utilities = new Property[2];
    private static Client currPlayer;
    public SingletonBoard() {
//        for (int i = 0; i < players.size(); i++) {
//            players.get(i).setPostion(0);
//        }
        brownProperties[0] = new Property(Type.BROWN, "Mediterranean Avenue", 60, 1);
        brownProperties[1] = new Property(Type.BROWN, "Baltic Avenue", 60,3);
        lightBlueProperties[0] = new Property(Type.LIGHT_BLUE, "Oriental Avenue", 100, 6);
        lightBlueProperties[1] = new Property(Type.LIGHT_BLUE, "Vermont Avenue", 100, 8);
        lightBlueProperties[2] = new Property(Type.LIGHT_BLUE, "Connecticut Avenue", 120, 9);
        pinkProperties[0] = new Property(Type.PINK, "St. Charles Place", 140, 11);
        pinkProperties[1] = new Property(Type.PINK, "States Avenue", 140, 13);
        pinkProperties[2] = new Property(Type.PINK, "Virginia Avenue", 160, 14);
        orangeProperties[0] = new Property(Type.ORANGE, "St. James Place", 180, 16);
        orangeProperties[1] = new Property(Type.ORANGE, "Tennessee Avenue", 180, 18);
        orangeProperties[2] = new Property(Type.ORANGE, "New York Avenue", 200, 19);
        redProperties[0] = new Property(Type.RED, "Kentucky Avenue", 220, 21);
        redProperties[1] = new Property(Type.RED, "Indiana Avenue", 220, 23);
        redProperties[2] = new Property(Type.RED, "Illinois Avenue", 240, 24);
        yellowProperties[0] = new Property(Type.YELLOW, "Atlantic Avenue", 260, 26);
        yellowProperties[1] = new Property(Type.YELLOW, "Ventnor Avenue", 260, 27);
        yellowProperties[2] = new Property(Type.YELLOW, "Marvin Gardens", 280, 29);
        greenProperties[0] = new Property(Type.GREEN, "Pacific Avenue", 300, 31);
        greenProperties[1] = new Property(Type.GREEN, "North Carolina Avenue", 300, 32);
        greenProperties[2] = new Property(Type.GREEN, "Pennsylvania Avenue", 320, 34);
        darkBlueProperties[0] = new Property(Type.DARK_BLUE, "Park Place", 350, 37);
        darkBlueProperties[1] = new Property(Type.DARK_BLUE, "Boardwalk", 400, 39);
        railroads[0] = new Property(Type.RAILROAD, "Reading Railroad", 200, 5);
        railroads[1] = new Property(Type.RAILROAD, "Pennsylvania Railroad", 200, 15);
        railroads[2] = new Property(Type.RAILROAD, "B. & O. Railroad", 200, 25);
        railroads[3] = new Property(Type.RAILROAD, "Short Line", 200, 35);
        utilities[0] = new Property(Type.UTILITY, "Electric Company", 150, 12);
        utilities[1] = new Property(Type.UTILITY, "Water Works", 150, 28);
    }

    public static Client getCurrPlayer() {
        return currPlayer;
    }
}
