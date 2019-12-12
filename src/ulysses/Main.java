package ulysses;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    private Stage main_stage;

    public static void main(String [] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        main_stage = primaryStage;
        displayLoginScreen();
        main_stage.setWidth(1050);
        main_stage.setHeight(750);
        main_stage.setResizable(false);
    }

    /*
        Displays for different Screens
     */
    private void displayLoginScreen() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("views/LoginView.fxml"));
        BorderPane login_layout = loader.load();
        Scene login_scene = new Scene(login_layout);
        main_stage.setScene(login_scene);
        main_stage.show();
    }

    public void displayDashboard() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(Main.class.getResource("views/Dashboard.fxml"));
        BorderPane dashboard_layout = loader.load();
        Scene dashboard_scene = new Scene(dashboard_layout);
        Stage dashboard_stage = new Stage();
        dashboard_stage.setScene(dashboard_scene);
        dashboard_stage.setResizable(false);
        dashboard_stage.show();
    }
}
