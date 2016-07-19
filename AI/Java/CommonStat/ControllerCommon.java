package sample.CommonStat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.DailyStat.CollectionDayBook;
import sample.DailyStat.Days;

import java.io.IOException;

/**
 * Created by Aleksandr on 23.06.2016.
 */
public class ControllerCommon {

        private Stage editDialogStage;
        private Parent fxmlEdit;
        private Stage mainStage;

        private CollectionCommonBook collectionCommonBook = new CollectionCommonBook();
        private FXMLLoader fxmlLoader = new FXMLLoader();


    @FXML
    private TableView tableCommonBook;

    @FXML
    private TableColumn<Common, String> colName;

    @FXML
    private TableColumn<Common, String> colNumber;

    public ControllerCommon() {
    }

    public void actionClose(ActionEvent actionEvent) {
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    public void dayLinkButton(ActionEvent event) throws IOException {
        actionClose(event);
        Stage stage = new Stage();
        fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("..\\DailyStat\\daily.fxml"));
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



    public void sitesLinkButton(ActionEvent event) throws IOException {
        actionClose(event);
        Stage stage = new Stage();
        fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("..\\Sites\\sites.fxml"));
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

    public void keywordsLinkButton(ActionEvent event) throws IOException {
        actionClose(event);
        Stage stage = new Stage();
        fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("..\\Keys\\keywords.fxml"));
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

    public void personLinkButton(ActionEvent event) throws IOException {
        actionClose(event);
        Stage stage = new Stage();
        fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("..\\personality.fxml"));
        Parent fxmlMain = fxmlLoader.load();
//        Parent root = FXMLLoader.load(getClass().getResource("C:\\Users\\Aleksandr\\IdeaProjects\\My_Tests\\GB_Desktop_App\\src\\sample\\keywords.fxml"));
        stage.setTitle("Справочник Личности");
        stage.setMinHeight(400);
        stage.setMinWidth(700);
        stage.setScene(new Scene(fxmlMain));
        //stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(((Node) event.getSource()).getScene().getWindow());
        stage.show();
        System.out.println("Справочник Личности!");
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
                case "btnShow":

                    break;

            }

        }

    @FXML
    private void initialize() {
        colName.setCellValueFactory(new PropertyValueFactory<Common, String>("name"));
        colNumber.setCellValueFactory(new PropertyValueFactory<Common, String>("number"));
        fillData();
//        initLoader();
    }

//        private void initLoader() {
//            try {
//
//                fxmlLoader.setLocation(getClass().getResource("editKeywords.fxml"));
//                fxmlEdit = fxmlLoader.load();
//                editDialogKeywords = fxmlLoader.getController();
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

        private void fillData() {
            collectionCommonBook.fillTestCommonData();
            tableCommonBook.setItems(collectionCommonBook.getCommonList());
        }

    }


