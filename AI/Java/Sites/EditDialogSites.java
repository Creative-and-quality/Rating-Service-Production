package sample.Sites;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Keys.Keys;

/**
 * Created by Aleksandr on 23.06.2016.
 */
public class EditDialogSites {

    private Sites site;

    @FXML
    private TextField txtSite;

    @FXML
    private Button btnOk;

    @FXML
    private Button btnCancel;


    public void setSites(Sites site) {
        if (site == null){
            return;
        }
        this.site = site;
        txtSite.setText(site.getSite());
    }

    public Sites getSite() {
        return site;
    }

    public void actionSave(ActionEvent actionEvent) {
        site.setSite(txtSite.getText());
        actionClose(actionEvent);
    }

    public void actionClose(ActionEvent actionEvent) {
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.hide();
    }
}
