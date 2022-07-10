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
//                        broadcastMessage("!setname! " + clientUsername + " " + SingletonBoard.getNum(clientUsername));
                        continue;
                    } else {
                        broadcastMessage("Game is full, new player cannot join");
                        continue;
                    }
                } else if (msgArr[0].equals("!roll!")) {
                    int currPosition = SingletonBoard.getPlayer(msgArr[1]).roll();
                    if (SingletonBoard.getProperty(currPosition) instanceof Property) {
                        if (!((Property) SingletonBoard.getProperty(currPosition)).isOwned()) {
                            if (SingletonBoard.getPlayer(clientUsername).getMoney() > SingletonBoard.getProperty(currPosition).price) {
                                broadcastMessage("!canbuy! " + clientUsername + " " + currPosition);
                            }
                        }
                    }
                } else if (msgArr[0].equals("!increment!")) {
                    SingletonBoard.nextTurn();
                } else if (msgArr[0].equals("!end!")) {
                    SingletonBoard.nextTurn();
                } else if (msgArr[0].equals("!willbuy!")) {
                    ((Property)SingletonBoard.getProperty(Integer.parseInt(msgArr[1]))).setOwner(SingletonBoard.getNum(msgArr[2]));
                    SingletonBoard.getPlayer(clientUsername).subtractMoney(SingletonBoard.getProperty(Integer.parseInt(msgArr[1])).price);
                    broadcastMessage("!bought! " + msgArr[1] + " " + SingletonBoard.getNum(clientUsername) + " " + SingletonBoard.getProperty(Integer.parseInt(msgArr[1])).price + " " + SingletonBoard.getNum(clientUsername));
                } else if (msgArr[0].equals("!start!")) {
                    int i = 1;
                    while (SingletonBoard.getPlayer(i) != null) {
                        broadcastMessage("!setname! " + SingletonBoard.getPlayer(i).getUsername() + " " + i);
                        i++;
                    }
                }
                broadcastMessage(message);
            } catch (IOException e) {
                closeEverything(socket, bufferedReader, bufferedWriter);
                break;
            }
        }
    }
}
