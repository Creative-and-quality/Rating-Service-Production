package sample.Keys;

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
import sample.CollectionPersonBook;
import sample.EditDialogController;
import sample.Person;

import java.io.IOException;

/**
 * Created by Aleksandr on 23.06.2016.
 */
public class ControllerKeywords {

    private Stage editDialogStage;
        private Parent fxmlEdit;
        private Stage mainStage;

        private EditDialogKeywords editDialogKeywords;
        private CollectionKeyBook collectionKeyBook = new CollectionKeyBook();
        private FXMLLoader fxmlLoader = new FXMLLoader();


        @FXML
        private Button btnAddKey;

        @FXML
        private Button btnUpdateKey;

        @FXML
        private Button btsDeleteKey;

        @FXML
        private TableColumn<Keys, String> colKey;

        @FXML
        private TableView tableKeyBook;

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
                case "btnAddKey":
                    System.out.println("Here 1");
                    editDialogKeywords.setKey(new Keys());
                    showDialog();
                    collectionKeyBook.add(editDialogKeywords.getKeys());
                    break;

                case "btnUpdateKey":
                    System.out.println("Here 2");
                    editDialogKeywords.setKey((Keys) tableKeyBook.getSelectionModel().getSelectedItem());
                    showDialog();
                    break;

                case "btsDeleteKey":
                    System.out.println("Here 3");
                    collectionKeyBook.delete((Keys) tableKeyBook.getSelectionModel().getSelectedItem());
                    break;
            }

        }

    @FXML
    private void initialize() {
        colKey.setCellValueFactory(new PropertyValueFactory<Keys, String>("key"));
//        initListeners();
        fillData();
        initLoader();
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

        private void initLoader() {
            try {

                fxmlLoader.setLocation(getClass().getResource("editKeywords.fxml"));
                fxmlEdit = fxmlLoader.load();
                editDialogKeywords = fxmlLoader.getController();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void fillData() {
            collectionKeyBook.fillTestKeysData();
            tableKeyBook.setItems(collectionKeyBook.getkeysList());
        }

        private void initListeners() {
            tableKeyBook.setOnMouseClicked(new EventHandler<MouseEvent>() {
                                                  public void handle(MouseEvent event) {
                                                      if (event.getClickCount() == 2) {
                                                          editDialogKeywords.setKey((Keys) tableKeyBook.getSelectionModel().getSelectedItem());
                                                          showDialog();
                                                      }
                                                  }
                                              }

            );
        }

    }


