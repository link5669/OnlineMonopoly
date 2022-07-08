package com.milesacq.onlinemonopoly;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class InfoViewController {
    @FXML
    private Text title;
    @FXML
    private Text cost;
    @FXML
    private Button okButton;

    public void initialize() {
        MonopolyApplication.setInfoViewController(this);
        onButtonPress();
    }
    public void setInfo(String name, int cost) {
        this.title.setText(name);
        this.cost.setText(String.valueOf(cost));
    }

    private void onButtonPress() {
        okButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ((Stage) (okButton.getScene().getWindow())).close();
            }
        });
    }

    public InfoViewController getInstance() {
        return this;
    }
}
