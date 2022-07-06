package com.milesacq.onlinemonopoly;

import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class InfoViewController {
    @FXML
    private Text title;
    @FXML
    private Text cost;

    public void initialize() {
        HelloApplication.setInfoViewController(this);
    }
    public void setInfo(String name, int cost) {
        this.title.setText(name);
        this.cost.setText(String.valueOf(cost));
    }

    public InfoViewController getInstance() {
        return this;
    }
}
