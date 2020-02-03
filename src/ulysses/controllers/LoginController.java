package ulysses.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import ulysses.Main;
import ulysses.models.SQLStatements;
import java.io.IOException;

public class LoginController {

    @FXML
    private BorderPane main_window;

    @FXML
    private TextField txt_username;

    @FXML
    private PasswordField txt_password;

    Main main = new Main();
    SQLStatements sqlStatements = new SQLStatements();

    @FXML
    private void validateLogin() throws IOException {
        if(sqlStatements.loginDetails(txt_username.getText(), txt_password.getText())) {
            main.displayDashboard();
            Stage window = (Stage) main_window.getScene().getWindow();
            window.close();
        }
    }

    @FXML
    private void displaySignUp() throws IOException {
        main.displaySignUpScreen();
        Stage window = (Stage) main_window.getScene().getWindow();
        window.close();
    }
}
