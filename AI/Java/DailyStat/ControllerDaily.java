package sample.DailyStat;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import sample.Keys.CollectionKeyBook;
import sample.Keys.EditDialogKeywords;
import sample.Keys.Keys;

import java.io.IOException;

/**
 * Created by Aleksandr on 23.06.2016.
 */
public class ControllerDaily {

        private Stage editDialogStage;
        private Parent fxmlEdit;
        private Stage mainStage;

        private CollectionDayBook collectionDayBook = new CollectionDayBook();
        private FXMLLoader fxmlLoader = new FXMLLoader();



    @FXML
    private TableColumn<Days, String> colDate;

    @FXML
    private TableColumn<Days, String> colNumber;

    @FXML
    private TableView tabledailyBook;

    public void actionClose(ActionEvent actionEvent) {
        Node source = (Node) actionEvent.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    public void commonLinkButton(ActionEvent event) throws IOException {
        actionClose(event);
        Stage stage = new Stage();
        fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("..\\CommonStat\\common.fxml"));
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
        colDate.setCellValueFactory(new PropertyValueFactory<Days, String>("day"));
        colNumber.setCellValueFactory(new PropertyValueFactory<Days, String>("number"));
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
            collectionDayBook.fillTestDaysData();
            tabledailyBook.setItems(collectionDayBook.getDayList());
        }

    }


