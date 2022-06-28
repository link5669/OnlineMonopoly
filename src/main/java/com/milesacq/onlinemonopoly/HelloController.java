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