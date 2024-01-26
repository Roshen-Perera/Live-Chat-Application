package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ClientFormController {

    @FXML
    private Label user;

    @FXML
    private TextField chatfield;

    public void initialize(){
        user.setText(LoginFormController.username);
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

    }
/*    @FXML
    private TextArea chatArea;

    @FXML
    private TextField chatField;
    @FXML
    private AnchorPane rootNode;
    String message = "";
    DataOutputStream dataOutputStream;
    DataInputStream dataInputStream;

    public void initialize(){
        chatArea.setEditable(false);
        new Thread(() -> {
            try {
                // Open a socket and specify server address and port
                Socket socket = new Socket("localhost", 3000);

                // Output stream used for writing data to the server
                dataOutputStream = new DataOutputStream(socket.getOutputStream());
                dataInputStream = new DataInputStream(socket.getInputStream());

                while (!message.startsWith("end")) {
                    // Receive and print the server's response
                    message = dataInputStream.readUTF();
                    chatArea.appendText("\nServer: "+message);
                }

                //Close streams and socket
                dataOutputStream.close();
                dataInputStream.close();
                socket.close();

            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }).start();
    }

    @FXML
    void btnSendOnAction(ActionEvent event) throws IOException {
        // Send the user input to the server
        dataOutputStream.writeUTF(chatField.getText());
        dataOutputStream.flush();
    }*/
}
