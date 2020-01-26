package ulysses.models;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Assets extends RecursiveTreeObject<Assets> {

    public StringProperty workstation_type, model, serial_number, location, acq_date, user, comments;

    // Parameters in Assets constructor given contracted names for brevity
    public Assets(String workstation, String mod, String serial_num, String loc, String acquisition, String end_user, String comments) {
        this.workstation_type = new SimpleStringProperty(workstation);
        this.model = new SimpleStringProperty(mod);
        this.serial_number = new SimpleStringProperty(serial_num);
        this.location = new SimpleStringProperty(loc);
        this.acq_date = new SimpleStringProperty(acquisition);
        this.user = new SimpleStringProperty(end_user);
        this.comments = new SimpleStringProperty(comments);
    }
}
