package lapp.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class SeePastOrdersController implements Initializable{
    @FXML
    private Label label;

    @FXML
    TableView tableview;

    ObservableList<Carti> data;


    @FXML private TextField filterField;
    @FXML private TableView<Carti> tableView;
    @FXML private TableColumn<Carti, String> EmpTitlu;
    @FXML private TableColumn<Carti, String> empStatus;
    @FXML private TableColumn<Carti, String> empDdl;

    //observalble list to store data
    private final ObservableList<Carti> dataList = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle rb){

        TableColumn EmpTitlu=new TableColumn("Titlu");
        TableColumn empStatus=new TableColumn("Statusul cartii");
        TableColumn empDdl=new TableColumn("Deadline");



        //tableview.getColumns().addAll(EmpTitlu,empAutor,empEditura,selectCol);



        Carti c1=new Carti("Amintiri din copilarie","Ion Creanga","Teora");
        Carti c2=new Carti("Harap Alb","Ion Creanga","Paralela 45");
        Carti c3=new Carti("Luceafarul","Mihai Eminescu","Teora");
        Carti c4=new Carti("Plumb","George Bacovia","Paralela 45");
        Carti c5=new Carti("Morometii","Marin Preda","Paralela 45");

        dataList.addAll(c1,c2,c3,c4,c5);


//        EmpTitlu.setCellValueFactory(
//                new PropertyValueFactory<Carti,String>("titlu")
//        );
//        empAutor.setCellValueFactory(
//                new PropertyValueFactory<Carti,String>("autor")
//        );
//        empEditura.setCellValueFactory(
//                new PropertyValueFactory<Carti,String>("editura")
//        );
//
//        selectCol.setCellValueFactory(
//                new PropertyValueFactory<Carti,String>("select")
//        );
//
//        tableview.setItems(data);




    }
}
