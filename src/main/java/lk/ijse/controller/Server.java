package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server {

    public static ArrayList<ClientHandler> clientList = new ArrayList<>();

    private static LoginFormController login = new LoginFormController();
    public static void start() throws IOException {
        new Thread(()->{
            try {
                String username = login.username;
                ServerSocket serverSocket = new ServerSocket(3002);
                Socket socket;
                while (true) {
                    System.out.println("[SERVER] : Waiting for Clients...");
                    //socket is referred to as a client.
                    socket = serverSocket.accept();
                    System.out.println("[SERVER] : Client " + username + " Accepted");
                    ClientHandler clients = new ClientHandler(socket, clientList);
                    clientList.add(clients);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}