package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.Keys.ControllerKeywords;

import java.io.IOException;

public class Controller {



    private Stage editDialogStage;
    private Parent fxmlEdit;
    private Stage mainStage;

    private EditDialogController editDialogController;
    private CollectionPersonBook personBookImpl = new CollectionPersonBook();
    private FXMLLoader fxmlLoader = new FXMLLoader();
    private String line;

    public void setLine(String line) {
        this.line = line;
    }

    @FXML
    private Button btnEditData;

    @FXML
    private Button btnUpdateData;

    @FXML
    private Button btnDeleteData;

    @FXML
    private TableColumn<Person, String> colFio;

    @FXML
    private TableView tablePersonBook;



    public void setMainStage(Stage mainStage) {
        this.mainStage = mainStage;
    }

    public void actionClose(ActionEvent actionEvent) {
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    public void commonLinkButton(ActionEvent event) throws IOException {
        actionClose(event);
        Stage stage = new Stage();
        fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("CommonStat\\common.fxml"));
        Parent fxmlMain = fxmlLoader.load();
//        Parent root = FXMLLoader.load(getClass().getResource("C:\\Users\\Aleksandr\\IdeaProjects\\My_Tests\\GB_Desktop_App\\src\\sample\\keywords.fxml"));
        stage.setTitle("Общая статистика");
        stage.setMinHeight(400);
        stage.setMinWidth(700);
        stage.setScene(new Scene(fxmlMain));
        //stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(((Node) event.getSource()).getScene().getWindow());
        stage.show();
//        System.out.println("Ключевые слова!");
        //main.primaryStage.close();


    }

    public void dayLinkButton(ActionEvent event) throws IOException {
        actionClose(event);
        Stage stage = new Stage();
        fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("DailyStat\\daily.fxml"));
        Parent fxmlMain = fxmlLoader.load();
//        Parent root = FXMLLoader.load(getClass().getResource("C:\\Users\\Aleksandr\\IdeaProjects\\My_Tests\\GB_Desktop_App\\src\\sample\\keywords.fxml"));
        stage.setTitle("Ежедневная статистика");
        stage.setMinHeight(400);
        stage.setMinWidth(700);
        stage.setScene(new Scene(fxmlMain));
        //stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(((Node) event.getSource()).getScene().getWindow());
        stage.show();
//        System.out.println("Ключевые слова!");
        //main.primaryStage.close();


    }

    public void keywordsLinkButton(ActionEvent event) throws IOException {
        actionClose(event);
        Stage stage = new Stage();
        fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("Keys\\keywords.fxml"));
        Parent fxmlMain = fxmlLoader.load();
//        Parent root = FXMLLoader.load(getClass().getResource("C:\\Users\\Aleksandr\\IdeaProjects\\My_Tests\\GB_Desktop_App\\src\\sample\\keywords.fxml"));
        stage.setTitle("Ключевые слова");
        stage.setMinHeight(400);
        stage.setMinWidth(700);
        stage.setScene(new Scene(fxmlMain));
        //stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(((Node) event.getSource()).getScene().getWindow());
        stage.show();
        System.out.println("Ключевые слова!");
        //main.primaryStage.close();


    }

    public void sitesLinkButton(ActionEvent event) throws IOException {
        actionClose(event);
        Stage stage = new Stage();
        fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("Sites\\sites.fxml"));
        Parent fxmlMain = fxmlLoader.load();
//        Parent root = FXMLLoader.load(getClass().getResource("C:\\Users\\Aleksandr\\IdeaProjects\\My_Tests\\GB_Desktop_App\\src\\sample\\keywords.fxml"));
        stage.setTitle("Справочник Сайты");
        stage.setMinHeight(400);
        stage.setMinWidth(700);
        stage.setScene(new Scene(fxmlMain));
        //stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(((Node) event.getSource()).getScene().getWindow());
        stage.show();
        System.out.println("Справочник Сайты!");
        //main.primaryStage.close();

    }

    public void actionButtonPressed(ActionEvent actionEvent) {

        Object source = actionEvent.getSource();

        // если нажата не кнопка - выходим из метода
        if (!(source instanceof Button)) {
            return;
        }

        Button clickedButton = (Button) source;
//        System.out.println(clickedButton.getId());
        switch (clickedButton.getId()) {
            case "btnEditData":
                System.out.println("Here 1");
                editDialogController.setPerson(new Person());
                showDialog();
                personBookImpl.add(editDialogController.getPerson());
                break;

            case "btnUpdateData":
                //System.out.println("Here 2");
                editDialogController.setPerson((Person)tablePersonBook.getSelectionModel().getSelectedItem());
               showDialog();
                break;

            case "btnDeleteData":
                System.out.println("Here 3");
                personBookImpl.delete((Person)tablePersonBook.getSelectionModel().getSelectedItem());
                break;
        }

    }

    private void showDialog() {

        if (editDialogStage==null) {
            editDialogStage = new Stage();
            editDialogStage.setTitle("Редактирование записи");
            editDialogStage.setMinHeight(150);
            editDialogStage.setMinWidth(300);
            editDialogStage.setResizable(false);
            editDialogStage.setScene(new Scene(fxmlEdit));
            editDialogStage.initModality(Modality.WINDOW_MODAL);
            editDialogStage.initOwner(mainStage);
        }

        editDialogStage.showAndWait(); // для ожидания закрытия окна

    }
//    private void initLoaderKeywords() {
//        try {
//
//            fxmlLoader.setLocation(getClass().getResource("keywords.fxml"));
//            fxmlEdit = fxmlLoader.load();
//            controllerKeywords = fxmlLoader.getController();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }

    private void initLoader() {
        try {

            fxmlLoader.setLocation(getClass().getResource("edit.fxml"));
            fxmlEdit = fxmlLoader.load();
            editDialogController = fxmlLoader.getController();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void initialize() {
        colFio.setCellValueFactory(new PropertyValueFactory<Person, String>("fio"));
        initListeners();
        fillData();
        initLoader();
      //  initLoaderKeywords();
    }

    private void fillData() {
        personBookImpl.fillTestData();
        tablePersonBook.setItems(personBookImpl.getPersonList());
    }

    private void initListeners() {
        tablePersonBook.setOnMouseClicked(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent event) {
                if (event.getClickCount() == 2) {
                    editDialogController.setPerson((Person) tablePersonBook.getSelectionModel().getSelectedItem());
                    showDialog();
                }
            }
        }

        );
    }

}
