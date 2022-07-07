package com.milesacq.onlinemonopoly;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler implements Runnable {

    public static ArrayList<ClientHandler> clientHandlers = new ArrayList<>();
    private Socket socket;
    private BufferedReader bufferedReader;
    private BufferedWriter bufferedWriter;
    private String clientUsername;

    public ClientHandler(Socket socket) {
        try {
            this.socket = socket;
            this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String[] msgArr = bufferedReader.readLine().split(" ");
            this.clientUsername = msgArr[1];
            clientHandlers.add(this);
            broadcastMessage("SERVER: " + clientUsername + " has entered the game!");
        } catch (Exception e) {
            closeEverything(socket, bufferedReader, bufferedWriter);
        }
    }

    private void closeEverything(Socket socket, BufferedReader bufferedReader, BufferedWriter bufferedWriter) {
        removeClientHandler();
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

    public void broadcastMessage(String s) {
        for (ClientHandler clientHandler : clientHandlers) {
            try {
//                if (!clientHandler.clientUsername.equals(clientUsername)) {
                    clientHandler.bufferedWriter.write(s);
                    clientHandler.bufferedWriter.newLine();
                    clientHandler.bufferedWriter.flush();
//                }
            } catch (IOException e) {
                closeEverything(socket, bufferedReader, bufferedWriter);
            }
        }
    }

    public void removeClientHandler() {
        clientHandlers.remove(this);
        broadcastMessage("SERVER: " + clientUsername + " has left the game");
    }

    @Override
    public void run() {
        String message;
        while (socket.isConnected()) {
            try {
                message = bufferedReader.readLine();
                if (message == null) {
                    continue;
                }
                String[] msgArr = message.split(" ");
                if (msgArr[0].equals("!a!")) {
                    if (SingletonBoard.canAddClient()) {
                        SingletonBoard.addClient(msgArr[1]);
                        broadcastMessage("!num! " + clientUsername + " " + SingletonBoard.getNum(clientUsername));
                        continue;
                    } else {
                        broadcastMessage("Game is full, new player cannot join");
                        continue;
                    }
                } else if (msgArr[0].equals("!roll!")) {
                    SingletonBoard.getPlayer(msgArr[1]).roll();
                } else if (msgArr[0].equals("!increment!")) {
                    SingletonBoard.nextTurn();
                } else if (msgArr[0].equals("!end!")) {
                    SingletonBoard.nextTurn();
                }
                broadcastMessage(message);
            } catch (IOException e) {
                closeEverything(socket, bufferedReader, bufferedWriter);
                break;
            }
        }
    }
}
