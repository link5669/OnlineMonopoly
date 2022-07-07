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
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;

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

    public void initialize() throws IOException {
        board = HelloApplication.getBoard();
        onRollButtonPress();
        onCreateButtonPress();
        HelloApplication.setController(this);
        onRequestInfo();
        onStartButtonPress();
        onEndButtonPress();
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
        one.setOnMouseClicked(mouseEvent -> newWindow(1));
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
                        setPlayer(SingletonBoard.getNum(username.getText()), board.getCoordinate(0).getX(), board.getCoordinate(0).getY());
                    }
                }).start();
            }
        });
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
            root = FXMLLoader.load(HelloApplication.class.getResource("info-view.fxml"));
            Scene secondScene = new Scene(root, 230, 350);
            Stage newWindow = new Stage();
            newWindow.setTitle("Info");

            newWindow.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
        HelloApplication.getInfoViewController().setInfo(board.getPropertyName(index), board.getPropertyValue(index));
    }

    public void enableRoll(boolean bool) {
        rollButton.setDisable(!bool);
    }

    public void enableEnd(boolean bool) {
        endTurnButton.setDisable(!bool);
    }
}