package com.milesacq.onlinemonopoly;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class HelloApplication extends Application {
    static ClientHandler clientHandler;
    public static ArrayList<Client> clients = new ArrayList<>();
    public static HelloController controller;
    public static SingletonBoard board;

    @Override
    public void start(Stage stage) throws IOException {
        board = new SingletonBoard();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Rectangle2D r = Screen.getPrimary().getBounds();
        Scene scene = new Scene(fxmlLoader.load(), r.getWidth(), r.getHeight());
        stage.setTitle("Monopoly");
        stage.setScene(scene);
        stage.show();
    }

    public static SingletonBoard getBoard() {
        return board;
    }

    public static ArrayList<Client> getClients() {
        return clients;
    }

    public static HelloController getController() {
        return controller;
    }

    public static void setController(HelloController controller) {
        HelloApplication.controller = controller;
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