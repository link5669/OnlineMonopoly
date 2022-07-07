package com.milesacq.onlinemonopoly;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private static ServerSocket serverSocket;
    private static SingletonBoard board;

    public Server(ServerSocket serverSocket) throws IOException {
        Server.serverSocket = serverSocket;
        Server.board = new SingletonBoard();
    }

    public static void startServer() {
        try {
            while(!serverSocket.isClosed()) {
                Socket socket = serverSocket.accept();
                System.out.println("A new client has connected");
                ClientHandler clientHandler = new ClientHandler(socket);
                if (MonopolyApplication.getClientHandler() == null) {
                    MonopolyApplication.setClientHandler(clientHandler);
                }
                Thread thread = new Thread(clientHandler);
                thread.start();
            }
        } catch (IOException e) {
            closeServerSocket();
        }
    }

    public static void closeServerSocket() {
        try {
            if (serverSocket != null) {
                serverSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(1234);
        Server server = new Server(serverSocket);
        startServer();
    }
}
