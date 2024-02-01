package lk.ijse;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import lk.ijse.controller.Server;

import java.util.Objects;

public class Launcher extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/login_form.fxml")));
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle("ZenChat");
        stage.show();
        stage.setResizable(false);
        Server.start();
    }
}
