package ulysses.controllers;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import org.controlsfx.control.textfield.TextFields;
import java.net.URL;
import java.util.ResourceBundle;

public class EntryController implements Initializable {

    String[] names = {"Spencer Apeadjei-Duodu", "Emmanuel Adare"};

    ObservableList<String> workstation_types = FXCollections.observableArrayList("Laptop",
            "Desktop", "Mobile Phone", "Printer", "Tablet", "MiFi", "Router"
    );

    @FXML
    private JFXComboBox<String> cb_workstation;

    @FXML
    private JFXTextField txt_model;

    @FXML
    private JFXTextField txt_serialnumber;

    @FXML
    private JFXTextField txt_location;

    @FXML
    private JFXDatePicker dtp_acquisition;

    @FXML
    private JFXTextField txt_user;

    @FXML
    private JFXTextArea ta_comments;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cb_workstation.setItems(workstation_types);
        TextFields.bindAutoCompletion(txt_user, names);
    }


    @FXML
    void clearEntry() {
        txt_model.clear();
        txt_location.clear();
        txt_user.clear();
        txt_serialnumber.clear();
        cb_workstation.getItems().clear();
        ta_comments.clear();
    }

    @FXML
    void saveEntry() {

    }

}
