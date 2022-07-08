package com.milesacq.onlinemonopoly;

import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private Socket socket;
    private static BufferedReader bufferedReader;
    private static BufferedWriter bufferedWriter;
    private String username;
    private BoardViewController controller = MonopolyApplication.getController();
    private int num;

    public Client(Socket socket, String username) {
        try {
            this.socket = socket;
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.username = username;
        } catch (IOException e) {
            closeEverything(socket, bufferedReader, bufferedWriter);
        }
    }

    public void sendMessage(String message) {
        try {
            if (socket.isConnected()) {
                bufferedWriter.write(message);
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            closeEverything(socket, bufferedReader, bufferedWriter);
        }
    }

    public void listenForMessage() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String msgFromGroup;
                while (socket.isConnected()) {
                    try {
                        BoardViewController controller = MonopolyApplication.getController();
                        msgFromGroup = bufferedReader.readLine();
                        String[] msgArr = msgFromGroup.split(" ");
                        if (msgArr[0].equals("!move!")) {
                            controller.setPlayer(Integer.parseInt(msgArr[1]), SingletonBoard.getCoordinate(Integer.parseInt(msgArr[2])).getX(), SingletonBoard.getCoordinate(Integer.parseInt(msgArr[2])).getY());
                            controller.enableRoll(false);
                        } else if (msgArr[0].equals("!turn!")) {
                            if (num == Integer.parseInt(msgArr[1])) {
                                controller.enableRoll(true);
                                controller.enableEnd(true);
                            }
                        } else if (msgArr[0].equals("!num!") && msgArr[1].equals(username)) {
                            num = Integer.parseInt(msgArr[2]);
                        } else if (msgArr[0].equals("!canbuy!") && msgArr[1].equals(username)) {
                            Runnable runnable = () -> {
                                MonopolyApplication.newWindow(Integer.parseInt(msgArr[2]), username);
                            };
                            Platform.runLater(runnable);
                        }
                        controller.addText(msgFromGroup);
                    } catch (IOException e) {
                        closeEverything(socket, bufferedReader, bufferedWriter);
                    }
                }
            }
        }).start();
    }



    public void closeEverything(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter)   {
        try {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (bufferedWriter != null) {
                bufferedWriter.close();
            }
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Client main(String username) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Socket socket = new Socket("localhost", 1234);
        Client client = new Client(socket, username);
        client.listenForMessage();
        client.sendMessage("!a! " + username);
        client.sendMessage("!a! " + username);
        return client;
    }
}
