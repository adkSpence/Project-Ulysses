package ulysses.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import ulysses.Main;

import java.io.IOException;

public class LoginController {

    @FXML
    private BorderPane main_window;

    @FXML
    private TextField txt_username;

    @FXML
    private PasswordField txt_password;

    Main main = new Main();

    @FXML
    private void validateLogin() throws IOException {
        if(txt_username.getText().equals("Spencer") && txt_password.getText().equals("1234")) {
            main.displayDashboard();
            Stage window = (Stage) main_window.getScene().getWindow();
            window.close();
        }
    }

}
