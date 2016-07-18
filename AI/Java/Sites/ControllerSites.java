package sample.Sites;

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
public class ControllerSites {

        private Stage editDialogStage;
        private Parent fxmlEdit;
        private Stage mainStage;

        private EditDialogSites editDialogSites;
        private CollectionSiteBook collectionSiteBook = new CollectionSiteBook();
        private FXMLLoader fxmlLoader = new FXMLLoader();


        @FXML
        private Button btnAddSite;

        @FXML
        private Button btnUpdateSite;

        @FXML
        private Button btsDeleteSite;

        @FXML
        private TableColumn<Sites, String> colSite;

        @FXML
        private TableView tableSiteBook;

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
                case "btnAddSite":
                    System.out.println("Here 1");
                    editDialogSites.setSites(new Sites());
                    showDialog();
                    collectionSiteBook.add(editDialogSites.getSite());
                    break;

                case "btnUpdateSite":
                    System.out.println("Here 2");
                    editDialogSites.setSites((Sites)tableSiteBook.getSelectionModel().getSelectedItem());
                    showDialog();
                    break;

                case "btsDeleteSite":
                    System.out.println("Here 3");
                    collectionSiteBook.delete((Sites)tableSiteBook.getSelectionModel().getSelectedItem());
                    break;
            }

        }

    @FXML
    private void initialize() {
        colSite.setCellValueFactory(new PropertyValueFactory<Sites, String>("site"));
        initListeners();
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

                fxmlLoader.setLocation(getClass().getResource("editSites.fxml"));
                fxmlEdit = fxmlLoader.load();
                editDialogSites = fxmlLoader.getController();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void fillData() {
            collectionSiteBook.fillTestSiteData();
            tableSiteBook.setItems(collectionSiteBook.getSiteList());
        }

        private void initListeners() {
            tableSiteBook.setOnMouseClicked(new EventHandler<MouseEvent>() {
                                                  public void handle(MouseEvent event) {
                                                      if (event.getClickCount() == 2) {
                                                          editDialogSites.setSites((Sites) tableSiteBook.getSelectionModel().getSelectedItem());
                                                          showDialog();
                                                      }
                                                  }
                                              }

            );
        }

    }


