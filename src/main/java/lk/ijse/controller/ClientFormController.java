package lk.ijse.controller;

import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Popup;

import java.io.*;
import java.net.Socket;
import java.nio.file.Files;

public class ClientFormController{

/*    @FXML
    private HBox hboxreciever;

    @FXML
    private HBox hboxsender;*/

    @FXML
    private JFXButton emoji;

    @FXML
    private Label lblUser;
/*
    @FXML
    private Label lblreceiver;

    @FXML
    private Label lblsender;*/

    @FXML
    private TextField txtChatField;

    @FXML
    private VBox vBox;

    Socket socket;

    DataInputStream reader;
    DataOutputStream writer;

    String condition = "";

    public void initialize() {
        lblUser.setText(LoginFormController.username);
        new Thread(()->{
            try {
                Socket socket = new Socket("localhost", 3002);
                reader = new DataInputStream(socket.getInputStream());
                writer = new DataOutputStream(socket.getOutputStream());

                while (true){
                    String message = reader.readUTF();
                    System.out.println(message);
                    Platform.runLater(()->{
                        if(condition.equals("this")){
                            HBox hBox = new HBox();
                            hBox.setStyle("-fx-alignment: top-right;-fx-fill-height: true;-fx-min-height: 50;-fx-pref-width: 520;-fx-max-width: 520;-fx-padding: 10");
                            Label messageLbl = new Label(message);
                            messageLbl.setStyle("-fx-background-color:  #27ae60;-fx-background-radius:15;-fx-font-size: 14;-fx-font-weight: normal;-fx-text-fill: white;-fx-wrap-text: true;-fx-alignment: center-left;-fx-content-display: left;-fx-padding: 10;-fx-max-width: 350;");
                            hBox.getChildren().add(messageLbl);
                            vBox.getChildren().add(hBox);
                            condition = "";
                        } else {
                            HBox hBox = new HBox();
                            hBox.setStyle("-fx-alignment: top-left;-fx-fill-height: true;-fx-min-height: 50;-fx-pref-width: 520;-fx-max-width: 520;-fx-padding: 10");
                            Label messageLbl = new Label(message);
                            messageLbl.setStyle("-fx-background-color:  #9b2b2b;-fx-background-radius:15;-fx-font-size: 14;-fx-font-weight: normal;-fx-text-fill: white;-fx-wrap-text: true;-fx-alignment: center-left;-fx-content-display: left;-fx-padding: 10;-fx-max-width: 350;");
                            hBox.getChildren().add(messageLbl);
                            vBox.getChildren().add(hBox);
                        }
                    });
                }
            }catch (IOException e){
                throw new RuntimeException(e);
            }
        }).start();
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
    void btnSendOnAction(ActionEvent event) throws IOException {
        String message = txtChatField.getText().trim(); // Trim to remove leading/trailing spaces
        String sender = lblUser.getText();
        writer.writeUTF(sender+": "+message);
        writer.flush(); // Ensure the message is sent immediately

        // Clear the text field after sending the message
        txtChatField.clear();
        condition = "this";
    }
}
