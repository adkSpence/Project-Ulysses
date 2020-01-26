package ulysses.controllers;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardController {

    @FXML
    private JFXButton btn_asset;

    @FXML
    void displayEntriesView() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../views/EntryView.fxml"));
        loader.load();
        Stage entry_stage = (Stage) btn_asset.getScene().getWindow();
        Scene entry_scene = new Scene(loader.getRoot());
        entry_stage.setScene(entry_scene);
        entry_stage.setTitle("UNFPA Asset Tracker");
    }

}
