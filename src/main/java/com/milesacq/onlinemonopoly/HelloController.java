package com.milesacq.onlinemonopoly;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.io.IOException;
import java.security.interfaces.EdECKey;

public class HelloController {
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
    private VBox boardBox;
    @FXML
    private Button rollButton;
    @FXML
    private Button create;
    @FXML
    private TextArea outputField;

    private Client client;


    public void initialize() throws IOException {
        SingletonBoard board = HelloApplication.getBoard();
        setPlayer(board.getCoordinate(0).getX(), board.getCoordinate(0).getY());
        onRollButtonPress();
        onCreateButtonPress();
        HelloApplication.setController(this);
    }

    private void onCreateButtonPress() {
        create.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            client = Client.main("test");
                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }).start();
            }
        });
    }

    private void onRollButtonPress() {
        rollButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                client.sendMessage("!roll!");
            }
        });
    }
    public void addText(String text) {
        outputField.appendText("\n" + text);
    }

    //default X boardBox.getLayoutX() + boardBox.getPrefWidth() - 40
    //default Y boardBox.getLayoutY() + boardBox.getPrefHeight() - 70
    public void setPlayer(int x, int y) {
        pOne.setLayoutX(x);
        pOne.setLayoutY(y);
    }
}