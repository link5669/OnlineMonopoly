package com.milesacq.onlinemonopoly;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class BuyViewController {
    @FXML
    private Button yes;
    @FXML
    private Button no;
    private static int index;
    private static String username;

    public void initialize() {
        onButtonPress();
    }

    public static void setIndex(int indexA, String usernameA) {
        index = indexA;
        username = usernameA;
    }
    private void onButtonPress() {
        yes.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                MonopolyApplication.getController().getClient().sendMessage("!willbuy! " + index + " " + username);
                ((Stage) (yes.getScene().getWindow())).close();
            }
        });
        no.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                MonopolyApplication.getController().getClient().sendMessage("!willnotbuy! " + index + " " + username);
                ((Stage) (no.getScene().getWindow())).close();
            }
        });
    }


}
