package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginFormController {
    @FXML
    private TextField txtUsername;

    public static String username;
    @FXML
    void btnLoginOnAction(ActionEvent event) throws IOException {
        username = txtUsername.getText();
        Stage stage = new Stage();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("/View/client_form.fxml"))));
        stage.setTitle(txtUsername.getText() + "'s Chat");
        stage.show();
        txtUsername.clear();
    }
}
