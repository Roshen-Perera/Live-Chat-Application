package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientFormController {

    @FXML
    private Label lblUser;

    @FXML
    private TextField txtChatField;

    Socket socket;
    BufferedReader in;
    PrintWriter out;

    public void initialize() throws IOException {
        lblUser.setText(LoginFormController.username);
        socket = new Socket("localhost", 3002);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(socket.getOutputStream(), true);
    }
    @FXML
    void btnAttachOnAction(ActionEvent event) {

    }

    @FXML
    void btnEmojiOnAction(ActionEvent event) {

    }

    @FXML
    void btnMinimizeOnAction(ActionEvent event) {

    }

    @FXML
    void btnSendOnAction(ActionEvent event) {
        String message = txtChatField.getText();
        System.out.println("["+lblUser.getText()+"]"+" : "+message);
        txtChatField.clear();
    }
}
