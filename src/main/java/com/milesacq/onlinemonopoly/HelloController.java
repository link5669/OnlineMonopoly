package com.milesacq.onlinemonopoly;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

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

    public void initialize() {
        setPlayer();
    }

    @FXML
    public void onRollButtonPress() {
        rollButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                SingletonBoard.getCurrPlayer().roll();
            }
        });
    }

    public void setPlayer() {
        pOne.setLayoutX(boardBox.getLayoutX() + boardBox.getPrefWidth() - 40);
        pOne.setLayoutY(boardBox.getLayoutY() + boardBox.getPrefHeight() - 70);
    }
}