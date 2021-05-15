/*package lapp.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class SeePastOrdersController implements Initializable{
    @FXML
    private Label label;

    @FXML
    TableView tableview;

    @FXML
    private Button x;

    ObservableList<Carti> data;


    @FXML private TextField filterField;
    @FXML private TableView<Carti> tableView;
    @FXML private TableColumn<Carti, String> EmpTitlu;
    @FXML private TableColumn<Carti, String> empStatus;
    @FXML private TableColumn<Carti, String> empDdl;

    //observable list to store dataList
    private final ObservableList<Carti> dataList = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle rb){

        TableColumn EmpTitlu=new TableColumn("Titlu");
        TableColumn empStatus=new TableColumn("Statusul cartii");
        TableColumn empDdl=new TableColumn("Deadline");



        //tableview.getColumns().addAll(EmpTitlu,empAutor,empEditura,selectCol);
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
//        tableview.setItems(dataList);


    }
        @FXML
        private void close_window(ActionEvent event){
            System.exit(0);
        }


}
*/