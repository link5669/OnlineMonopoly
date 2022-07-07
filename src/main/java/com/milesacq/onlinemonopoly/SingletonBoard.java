package com.milesacq.onlinemonopoly;

import java.util.ArrayList;
import java.util.HashMap;

public class SingletonBoard {

    static ClientHandler handler;
    private static ArrayList<Player> players = new ArrayList<>();
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
    private static Property[] corners = new Property[4];
    private static Property[] odds = new Property[6];
    private static Property[] taxes = new Property[2];
    private static HashMap<Integer, Coordinate> propertyLocations = new HashMap<>();
    private static HashMap<Integer, String> propertyNames = new HashMap<>();
    private static HashMap<Integer, Integer> propertyValues = new HashMap<>();
    private static int currTurn = 0;
    public static boolean addClient(String username) {
        if (players.size() < 5) {
            Player player = new Player(username);
            players.add(player);
            return true;
        }
        return false;
    }
    public static boolean canAddClient() {
        if (players.size() < 4) {
            return true;
        }
        return false;
    }

    public static Player getPlayer(String username) {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getUsername().equals(username)) {
                return players.get(i);
            }
        }
        return null;
    }

    public static int getNum(String username) {
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getUsername().equals(username)) {
                return i + 1;
            }
        }
        return 0;
    }

    public static Coordinate getCoordinate(int position) {
        return propertyLocations.get(position);
    }
    public SingletonBoard() {
        corners[0] = populate(Type.CORNER, "Go", 0, 0, new Coordinate(1224, 861));
        brownProperties[0] = populate(Type.BROWN, "Mediterranean Avenue", 60, 1, new Coordinate(1110, 867));
        odds[0] = populate(Type.ODDS, "Community Chest (bottom)", 0, 2, new Coordinate(1048, 867));
        brownProperties[1] = populate(Type.BROWN, "Baltic Avenue", 60, 3, new Coordinate(979, 867));
        taxes[0] = populate(Type.TAX, "Income Tax", 0, 4, new Coordinate(907, 867));
        railroads[0] = populate(Type.RAILROAD, "Reading Railroad", 200, 5, new Coordinate(842, 867));
        lightBlueProperties[0] = populate(Type.LIGHT_BLUE, "Oriental Avenue", 100, 6, new Coordinate(767, 867));
        odds[1] = populate(Type.ODDS, "Chance (bottom)", 0, 7, new Coordinate(703, 867));
        lightBlueProperties[1] = populate(Type.LIGHT_BLUE, "Vermont Avenue", 100, 8, new Coordinate(635, 867));
        lightBlueProperties[2] = populate(Type.LIGHT_BLUE, "Connecticut Avenue", 120, 9, new Coordinate(568, 867));
        corners[1] = populate(Type.CORNER, "Jail", 0, 10, new Coordinate(453, 875));
        pinkProperties[0] = populate(Type.PINK, "St. Charles Place", 140, 11, new Coordinate(453, 759));
        utilities[0] = populate(Type.UTILITY, "Electric Company", 150, 12, new Coordinate(453, 681));
        pinkProperties[1] = populate(Type.PINK, "States Avenue", 140, 13, new Coordinate(453, 615));
        pinkProperties[2] = populate(Type.PINK, "Virginia Avenue", 160, 14, new Coordinate(453, 547));
        railroads[1] = populate(Type.RAILROAD, "Pennsylvania Railroad", 200, 15, new Coordinate(453, 480));
        orangeProperties[0] = populate(Type.ORANGE, "St. James Place", 180, 16,new Coordinate(453, 409));
        odds[2] = populate(Type.ODDS, "Community Chest (left)", 0, 17, new Coordinate(453, 340));
        orangeProperties[1] = populate(Type.ORANGE, "Tennessee Avenue", 180, 18, new Coordinate(453, 268));
        orangeProperties[2] = populate(Type.ORANGE, "New York Avenue", 200, 19, new Coordinate(453, 198));
        corners[2] = populate(Type.CORNER, "Free Parking", 0, 20, new Coordinate(453, 86));
        redProperties[0] = populate(Type.RED, "Kentucky Avenue", 220, 21, new Coordinate(568, 86));
        odds[3] = populate(Type.ODDS, "Chance (top)", 0, 22, new Coordinate(635, 86));
        redProperties[1] = populate(Type.RED, "Indiana Avenue", 220, 23, new Coordinate(703, 86));
        redProperties[2] = populate(Type.RED, "Illinois Avenue", 240, 24, new Coordinate(767, 86));
        railroads[2] = populate(Type.RAILROAD, "B. & O. Railroad", 200, 25, new Coordinate(846, 86));
        yellowProperties[0] = populate(Type.YELLOW, "Atlantic Avenue", 260, 26, new Coordinate(907, 86));
        yellowProperties[1] = populate(Type.YELLOW, "Ventnor Avenue", 260, 27, new Coordinate(979, 86));
        utilities[1] = populate(Type.UTILITY, "Water Works", 150, 28, new Coordinate(1048, 86));
        yellowProperties[2] = populate(Type.YELLOW, "Marvin Gardens", 280, 29, new Coordinate(1110, 86));
        corners[3] = populate(Type.CORNER, "Go to Jail", 0, 30, new Coordinate(1217, 86));
        greenProperties[0] = populate(Type.GREEN, "Pacific Avenue", 300, 31, new Coordinate(1217, 200));
        greenProperties[1] = populate(Type.GREEN, "North Carolina Avenue", 300, 32, new Coordinate(1217, 268));
        odds[4] = populate(Type.ODDS, "Community Chest (right)", 0, 33, new Coordinate(1217, 338));
        greenProperties[2] = populate(Type.GREEN, "Pennsylvania Avenue", 320, 34, new Coordinate(1217, 407));
        railroads[3] = populate(Type.RAILROAD, "Short Line", 200, 35, new Coordinate(1217, 477));
        odds[5] = populate(Type.ODDS, "Chance (right)", 0, 36, new Coordinate(1217, 544));
        darkBlueProperties[0] = populate(Type.DARK_BLUE, "Park Place", 350, 37, new Coordinate(1217, 616));
        taxes[1] = populate(Type.TAX, "Luxury Tax", 0, 38, new Coordinate(1217, 680));
        darkBlueProperties[1] = populate(Type.DARK_BLUE, "Boardwalk", 400, 39, new Coordinate(1217, 755));
    }

    private Property populate(Type type, String name, int price, int position, Coordinate coordinate) {
        propertyLocations.put(position, coordinate);
        propertyNames.put(position, name);
        propertyValues.put(position, price);
        return new Property(type, name, price, position, coordinate);
    }

    public String getPropertyName(int position) {
        return propertyNames.get(position);
    }

    public int getPropertyValue(int position) {
        return propertyValues.get(position);
    }

    private static void incrementTurn() {
        if (currTurn + 1 < players.size()) {
            currTurn++;
        } else {
            currTurn = 1;
        }
    }

    public static void nextTurn() {
        incrementTurn();
        HelloApplication.getClientHandler().broadcastMessage("!turn! " + currTurn);
    }
}
