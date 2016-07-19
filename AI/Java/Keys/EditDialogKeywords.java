package sample.Keys;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.Person;

/**
 * Created by Aleksandr on 23.06.2016.
 */
public class EditDialogKeywords {

    private Keys key;

    @FXML
    private TextField txtKey;
    @FXML
    private Button btnOk;

    @FXML
    private Button btnCancel;


    public void setKey(Keys key) {
        if (key == null){
            return;
        }
        this.key = key;
        txtKey.setText(key.getKey());
    }

    public Keys getKeys() {
        return key;
    }

    public void actionSave(ActionEvent actionEvent) {
        key.setKey(txtKey.getText());
        actionClose(actionEvent);
    }

    public void actionClose(ActionEvent actionEvent) {
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.hide();
    }
}
