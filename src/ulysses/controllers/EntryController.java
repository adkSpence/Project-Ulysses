package ulysses.controllers;

import com.jfoenix.controls.*;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TreeItem;
import org.controlsfx.control.textfield.TextFields;
import ulysses.models.Assets;
import ulysses.models.SQLStatements;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;

@SuppressWarnings("ALL")
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

    @FXML
    private JFXTreeTableView<Assets> tree_assets;

    SQLStatements sqlStatements = new SQLStatements();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cb_workstation.setItems(workstation_types);
        TextFields.bindAutoCompletion(txt_user, names);

        String table_query = "CREATE TABLE IF NOT EXISTS Assets (\n" +
                " Workstation_Type String(100) NOT NULL, \n" +
                " Model_Description String(100), \n" +
                " Serial_Number String(100) primary key NOT NULL, \n" +
                " Location String(50), \n" +
                " Acquisition_Date Text NOT NULL, \n" +
                " End_User String(100), \n" +
                " Comments String(400));";

        // Executing table command
        try{
            PreparedStatement preparedStatement = sqlStatements.getConnection().prepareStatement(table_query);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }

        // Code for generating table
        JFXTreeTableColumn<Assets, String> workstation = new JFXTreeTableColumn<>("Workstation Type");
        workstation.setPrefWidth(150);
        workstation.setCellValueFactory(param -> param.getValue().getValue().workstation_type);

        JFXTreeTableColumn<Assets, String> model = new JFXTreeTableColumn<>("Model Description");
        model.setPrefWidth(150);
        model.setCellValueFactory(param -> param.getValue().getValue().model);

        JFXTreeTableColumn<Assets, String> serial_number = new JFXTreeTableColumn<>("Serial Number");
        serial_number.setPrefWidth(150);
        serial_number.setCellValueFactory(param -> param.getValue().getValue().serial_number);

        JFXTreeTableColumn<Assets, String> loc = new JFXTreeTableColumn<>("Location");
        loc.setPrefWidth(150);
        loc.setCellValueFactory(param -> param.getValue().getValue().location);

        JFXTreeTableColumn<Assets, String> date = new JFXTreeTableColumn<>("Acquisition Date");
        date.setPrefWidth(150);
        date.setCellValueFactory(param -> param.getValue().getValue().acq_date);

        JFXTreeTableColumn<Assets, String> user = new JFXTreeTableColumn<>("End User");
        user.setPrefWidth(150);
        user.setCellValueFactory(param -> param.getValue().getValue().user);

        JFXTreeTableColumn<Assets, String> comments = new JFXTreeTableColumn<>("Comments");
        comments.setPrefWidth(150);
        comments.setCellValueFactory(param -> param.getValue().getValue().comments);

        //Creating an array of assets to add
        ObservableList<Assets> assets = FXCollections.observableArrayList();
        assets.add(new Assets("Laptop", "HP", "HGK3000", "304", "12/2/2020", "Spencer Apeadjei", ""));

        final TreeItem<Assets> root = new RecursiveTreeItem<>(assets, RecursiveTreeObject::getChildren);
        tree_assets.getColumns().setAll(workstation, model, serial_number, loc, date, user, comments);
        tree_assets.setRoot(root);
        tree_assets.setShowRoot(false);
    }

    @FXML
    void clearEntry() {
        txt_model.clear();
        txt_location.clear();
        txt_user.clear();
        txt_serialnumber.clear();
        cb_workstation.getEditor().clear();
        ta_comments.clear();
        dtp_acquisition.getEditor().clear();
    }

    @FXML
    void saveEntry() throws SQLException {
        String insert_query = "INSERT INTO Assets (Workstation_Type, Model_Description, Serial_Number, Location, Acquisition_Date, End_User, Comments) VALUES (?,?,?,?,?,?,?);";

        PreparedStatement preparedStatement = sqlStatements.getConnection().prepareStatement(insert_query);
        preparedStatement.setString(1, cb_workstation.getValue());
        preparedStatement.setString(2, txt_model.getText());
        preparedStatement.setString(3, txt_serialnumber.getText());
        preparedStatement.setString(4, txt_location.getText());
        preparedStatement.setString(5, dtp_acquisition.getEditor().getText());
        preparedStatement.setString(6, txt_user.getText());
        preparedStatement.setString(7, ta_comments.getText());
        preparedStatement.executeUpdate();
    }
}
