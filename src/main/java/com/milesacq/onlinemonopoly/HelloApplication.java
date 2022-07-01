package com.milesacq.onlinemonopoly;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    static ClientHandler clientHandler;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Rectangle2D r = Screen.getPrimary().getBounds();
        Scene scene = new Scene(fxmlLoader.load(), r.getWidth(), r.getHeight());
        stage.setTitle("Monopoly");
        stage.setScene(scene);
        stage.show();
    }

    public static ClientHandler getClientHandler() {
        return clientHandler;
    }
    public static void setClientHandler(ClientHandler clientHandler1) {
        clientHandler = clientHandler1;
    }

    public static void main(String[] args) {
        launch();
    }
}