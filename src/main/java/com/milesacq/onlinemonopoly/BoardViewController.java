package com.milesacq.onlinemonopoly;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

public class BoardViewController {
    @FXML
    private Rectangle one;
    @FXML
    private Rectangle two;
    @FXML
    private Rectangle three;
    @FXML
    private Rectangle four;
    @FXML
    private Rectangle five;
    @FXML
    private Rectangle six;
    @FXML
    private Rectangle seven;
    @FXML
    private Rectangle eight;
    @FXML
    private Rectangle nine;
    @FXML
    private Rectangle ten;
    @FXML
    private Rectangle eleven;
    @FXML
    private Rectangle twelve;
    @FXML
    private Rectangle thirteen;
    @FXML
    private Rectangle fourteen;
    @FXML
    private Rectangle fifteen;
    @FXML
    private Rectangle sixteen;
    @FXML
    private Rectangle seventeen;
    @FXML
    private Rectangle eighteen;
    @FXML
    private Rectangle nineteen;
    @FXML
    private Rectangle twenty;
    @FXML
    private Rectangle twentyOne;
    @FXML
    private Rectangle twentyTwo;
    @FXML
    private Rectangle twentyThree;
    @FXML
    private Rectangle twentyFour;
    @FXML
    private Rectangle twentyFive;
    @FXML
    private Rectangle twentySix;
    @FXML
    private Rectangle twentySeven;
    @FXML
    private Rectangle twentyEight;
    @FXML
    private Rectangle twentyNine;
    @FXML
    private Rectangle thirty;
    @FXML
    private Rectangle thirtyOne;
    @FXML
    private Rectangle thirtyTwo;
    @FXML
    private Rectangle thirtyThree;
    @FXML
    private Rectangle thirtyFour;
    @FXML
    private Rectangle thirtyFive;
    @FXML
    private Rectangle thirtySix;
    @FXML
    private Rectangle thirtySeven;
    @FXML
    private Rectangle thirtyEight;
    @FXML
    private Rectangle thirtyNine;

    @FXML
    private Circle pOne;
    @FXML
    private Circle pTwo;
    @FXML
    private Circle pThree;
    @FXML
    private Circle pFour;
    @FXML
    private VBox boardBox;
    @FXML
    private Button rollButton;
    @FXML
    private Button create;
    @FXML
    private TextArea outputField;
    @FXML
    private TextField username;
    @FXML
    private Button startGame;
    @FXML
    private Button endTurnButton;

    private Client client;
    private SingletonBoard board;
    private HashMap<Integer, Rectangle> pieces;

    public void initialize() throws IOException {
        board = MonopolyApplication.getBoard();
        onRollButtonPress();
        onCreateButtonPress();
        MonopolyApplication.setController(this);
        onRequestInfo();
        onStartButtonPress();
        onEndButtonPress();
        populateHashMap();
    }

    private void populateHashMap() {
        pieces = new HashMap<>();
        pieces.put(1,one);
        pieces.put(2,two);
        pieces.put(3,three);
        pieces.put(4,four);
        pieces.put(5,five);
        pieces.put(6,six);
        pieces.put(7,seven);
        pieces.put(8,eight);
        pieces.put(9,nine);
        pieces.put(10,ten);
        pieces.put(11,eleven);
        pieces.put(12,twelve);
        pieces.put(13,thirteen);
        pieces.put(14,fourteen);
        pieces.put(15,fifteen);
        pieces.put(16,sixteen);
        pieces.put(17,seventeen);
        pieces.put(18,eighteen);
        pieces.put(19,nineteen);
        pieces.put(20,twenty);
        pieces.put(21,twentyOne);
        pieces.put(22,twentyTwo);
        pieces.put(23,twentyThree);
        pieces.put(24,twentyFour);
        pieces.put(25,twentyFive);
        pieces.put(26,twentySix);
        pieces.put(27,twentySeven);
        pieces.put(28,twentyEight);
        pieces.put(29,twentyNine);
        pieces.put(30,thirty);
        pieces.put(31,thirtyOne);
        pieces.put(32,thirtyTwo);
        pieces.put(33,thirtyThree);
        pieces.put(34,thirtyFour);
        pieces.put(35,thirtyFive);
        pieces.put(36,thirtySix);
        pieces.put(37,thirtySeven);
        pieces.put(38,thirtyEight);
        pieces.put(39,thirtyNine);
    }

    public Client getClient() {
        return client;
    }

    private void onStartButtonPress() {
        startGame.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                client.sendMessage("!increment!");
            }
        });
    }

    private void onEndButtonPress() {
        endTurnButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                client.sendMessage("!end!");
                endTurnButton.setDisable(true);
            }
        });
    }
    private void onRequestInfo() {
        one.setOnMouseClicked(mouseEvent -> {
            newWindow(1);
        });
        two.setOnMouseClicked(mouseEvent -> newWindow(2));
        three.setOnMouseClicked(mouseEvent -> newWindow(3));
        four.setOnMouseClicked(mouseEvent -> newWindow(4));
        five.setOnMouseClicked(mouseEvent -> newWindow(5));
        six.setOnMouseClicked(mouseEvent -> newWindow(6));
        seven.setOnMouseClicked(mouseEvent -> newWindow(7));
        eight.setOnMouseClicked(mouseEvent -> newWindow(8));
        nine.setOnMouseClicked(mouseEvent -> newWindow(9));
        ten.setOnMouseClicked(mouseEvent -> newWindow(10));
        eleven.setOnMouseClicked(mouseEvent -> newWindow(11));
        twelve.setOnMouseClicked(mouseEvent -> newWindow(12));
        thirteen.setOnMouseClicked(mouseEvent -> newWindow(13));
        fourteen.setOnMouseClicked(mouseEvent -> newWindow(14));
        fifteen.setOnMouseClicked(mouseEvent -> newWindow(15));
        sixteen.setOnMouseClicked(mouseEvent -> newWindow(16));
        seventeen.setOnMouseClicked(mouseEvent -> newWindow(17));
        eighteen.setOnMouseClicked(mouseEvent -> newWindow(18));
        nineteen.setOnMouseClicked(mouseEvent -> newWindow(19));
        twenty.setOnMouseClicked(mouseEvent -> newWindow(20));
        twentyOne.setOnMouseClicked(mouseEvent -> newWindow(21));
        twentyTwo.setOnMouseClicked(mouseEvent -> newWindow(22));
        twentyThree.setOnMouseClicked(mouseEvent -> newWindow(23));
        twentyFour.setOnMouseClicked(mouseEvent -> newWindow(24));
        twentyFive.setOnMouseClicked(mouseEvent -> newWindow(1));
        twentySix.setOnMouseClicked(mouseEvent -> newWindow(26));
        twentySeven.setOnMouseClicked(mouseEvent -> newWindow(27));
        twentyEight.setOnMouseClicked(mouseEvent -> newWindow(28));
        twentyNine.setOnMouseClicked(mouseEvent -> newWindow(29));
        thirty.setOnMouseClicked(mouseEvent -> newWindow(30));
        thirtyOne.setOnMouseClicked(mouseEvent -> newWindow(31));
        thirtyTwo.setOnMouseClicked(mouseEvent -> newWindow(32));
        thirtyThree.setOnMouseClicked(mouseEvent -> newWindow(33));
        thirtyFour.setOnMouseClicked(mouseEvent -> newWindow(34));
        thirtyFive.setOnMouseClicked(mouseEvent -> newWindow(35));
        thirtySix.setOnMouseClicked(mouseEvent -> newWindow(36));
        thirtySeven.setOnMouseClicked(mouseEvent -> newWindow(37));
        thirtyEight.setOnMouseClicked(mouseEvent -> newWindow(38));
        thirtyNine.setOnMouseClicked(mouseEvent -> newWindow(39));
    }

    private void onCreateButtonPress() {
        create.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            client = Client.main(username.getText());
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
//                        setPlayer(SingletonBoard.getNum(username.getText()), board.getCoordinate(0).getX(), board.getCoordinate(0).getY());
                    }
                }).start();
            }
        });
    }

    public void setColor(int index, int player) {
        if (player == 1) {
            pieces.get(index).setFill(Color.DODGERBLUE);
        } else if (player == 2) {
            pieces.get(index).setFill(Color.web("#1fff61"));
        } else if (player == 3) {
            pieces.get(index).setFill(Color.web("#f3ff21"));
        } else if (player == 4) {
            pieces.get(index).setFill(Color.web("#ff3921"));
        }
    }

    private void onRollButtonPress() {
        rollButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                client.sendMessage("!roll! " + username.getText());
            }
        });
    }
    public void addText(String text) {
        outputField.appendText("\n" + text);
    }

    //default X boardBox.getLayoutX() + boardBox.getPrefWidth() - 40
    //default Y boardBox.getLayoutY() + boardBox.getPrefHeight() - 70
    public void setPlayer(int playerNum, int x, int y) {
        if (playerNum == 1) {
            pOne.setLayoutX(x);
            pOne.setLayoutY(y);
        } else if (playerNum == 2){
            pTwo.setLayoutX(x);
            pTwo.setLayoutY(y);
        } else if (playerNum == 3){
            pThree.setLayoutX(x);
            pThree.setLayoutY(y);
        } else if (playerNum == 4){
            pFour.setLayoutX(x);
            pFour.setLayoutY(y);
        }
    }

    private void newWindow(int index) {
        Parent root = null;
        try {
            root = FXMLLoader.load(MonopolyApplication.class.getResource("info-view.fxml"));
            Scene secondScene = new Scene(root, 230, 350);
            Stage newWindow = new Stage();
            newWindow.setTitle("Info");
            newWindow.setScene(secondScene);
            newWindow.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        MonopolyApplication.getInfoViewController().setInfo(board.getPropertyName(index), board.getPropertyValue(index));
    }

    public void enableRoll(boolean bool) {
        rollButton.setDisable(!bool);
    }

    public void enableEnd(boolean bool) {
        endTurnButton.setDisable(!bool);
    }
}