package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Created by Aleksandr on 23.06.2016.
 */
public class EditDialogController {

    private Person person;

    @FXML
    private TextField txtFIO;
    @FXML
    private Button btnOk;

    @FXML
    private Button btnCancel;


    public void setPerson(Person person) {
        if (person == null){
            return;
        }
        this.person = person;
        txtFIO.setText(person.getFio());
    }

    public Person getPerson() {
        return person;
    }

    public void actionSave(ActionEvent actionEvent) {
        person.setFio(txtFIO.getText());
        actionClose(actionEvent);
    }

    public void actionClose(ActionEvent actionEvent) {
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.hide();
    }
}
