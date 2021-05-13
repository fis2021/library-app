package lapp.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class LApproveRejectOrderController implements Initializable {

    @FXML
    private Label label;

    @FXML
    TableView tableview;

    ObservableList<Carti> data;


    @FXML
    private TextField filterField;
    @FXML
    private TableView<CartiLibrarian> tableView;
    @FXML
    private TableColumn<CartiLibrarian, String> EmpTitlu;
    @FXML
    private TableColumn<CartiLibrarian, String> empAutor;
    @FXML
    private TableColumn<CartiLibrarian, String> empEditura;
    @FXML
    private TableColumn empApproveReject;
    @FXML
    private TableColumn reasonCol;

    @FXML
    private Button buttonL;

    //observalble list to store data
    private final ObservableList<CartiLibrarian> dataList = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle rb) {

        TableColumn EmpTitlu = new TableColumn("Titlu");
        TableColumn empAutor = new TableColumn("Nume autor");
        TableColumn empEditura = new TableColumn("Editura");
        TableColumn empApproveReject=new TableColumn("Approve/Reject");
        TableColumn reasonCol = new TableColumn("Reason for rejection");



        tableview.getColumns().addAll(EmpTitlu, empAutor, empEditura,empApproveReject,reasonCol);


        CartiLibrarian c1 = new CartiLibrarian("Amintiri din copilarie", "Ion Creanga", "Teora",FXCollections.observableArrayList("Approve","Reject"), "");
        CartiLibrarian c2 = new CartiLibrarian("Harap Alb", "Ion Creanga", "Paralela 45",FXCollections.observableArrayList("Approve","Reject"), "");
        CartiLibrarian c3 = new CartiLibrarian("Luceafarul", "Mihai Eminescu", "Teora",FXCollections.observableArrayList("Approve","Reject"), "");
        CartiLibrarian c4 = new CartiLibrarian("Plumb", "George Bacovia", "Paralela 45",FXCollections.observableArrayList("Approve","Reject"), "");
        CartiLibrarian c5 = new CartiLibrarian("Morometii", "Marin Preda", "Paralela 45",FXCollections.observableArrayList("Approve","Reject"), "");

        dataList.addAll(c1, c2, c3, c4, c5);


        EmpTitlu.setCellValueFactory(
                new PropertyValueFactory<Carti, String>("titlu")
        );
        empAutor.setCellValueFactory(
                new PropertyValueFactory<Carti, String>("autor")
        );
        empEditura.setCellValueFactory(
                new PropertyValueFactory<Carti, String>("editura")
        );
        empApproveReject.setCellValueFactory(
                new PropertyValueFactory<Carti,String>("approveOrReject")
        );
        reasonCol.setCellValueFactory(
                new PropertyValueFactory<Carti,String>("reasons")
        );

        tableview.setItems(dataList);


    }
}
