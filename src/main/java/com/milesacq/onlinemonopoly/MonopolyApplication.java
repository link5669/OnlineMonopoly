package com.milesacq.onlinemonopoly;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class MonopolyApplication extends Application {
    static ClientHandler clientHandler;
    public static ArrayList<Client> clients = new ArrayList<>();
    public static BoardViewController boardViewController;
    public static InfoViewController infoViewController;
    public static SingletonBoard board;

    @Override
    public void start(Stage stage) throws IOException {
        board = new SingletonBoard();
        FXMLLoader fxmlLoader = new FXMLLoader(MonopolyApplication.class.getResource("hello-view.fxml"));
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

    public static BoardViewController getController() {
        return boardViewController;
    }

    public static InfoViewController getInfoViewController() {
        return infoViewController;
    }

    public static void setInfoViewController(InfoViewController controller) {
        MonopolyApplication.infoViewController = controller;
    }

    public static void setController(BoardViewController controller) {
        MonopolyApplication.boardViewController = controller;
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