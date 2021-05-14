package lapp.controllers;

//WORKS

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomepageClientController implements Initializable {
    @FXML
    private Label label;

    @FXML
    TableView tableview;

    ObservableList<Carti> data;


    @FXML private TextField filterField;
    @FXML private TableView<Carti> tableView;
    @FXML private TableColumn<Carti, String> EmpTitlu;
    @FXML private TableColumn<Carti, String> empAutor;
    @FXML private TableColumn<Carti, String> empEditura;

    @FXML
    private Button button;

    @FXML
    private Button x;

    @FXML
    private Button buttonPastOrders;

    private final ObservableList<Carti> dataList = FXCollections.observableArrayList();


    @Override
    public void initialize(URL url, ResourceBundle rb) {

        TableColumn EmpTitlu=new TableColumn("Titlu");
        TableColumn empAutor=new TableColumn("Nume autor");
        TableColumn empEditura=new TableColumn("Editura");
        TableColumn selectCol = new TableColumn("Select book");

        button=new Button("Order");
        buttonPastOrders=new Button("See past orders");

        tableview.getColumns().addAll(EmpTitlu,empAutor,empEditura,selectCol);



        Carti c1=new Carti("Amintiri din copilarie","Ion Creanga","Teora");
        Carti c2=new Carti("Harap Alb","Ion Creanga","Paralela 45");
        Carti c3=new Carti("Luceafarul","Mihai Eminescu","Teora");
        Carti c4=new Carti("Plumb","George Bacovia","Paralela 45");
        Carti c5=new Carti("Morometii","Marin Preda","Paralela 45");

        dataList.addAll(c1,c2,c3,c4,c5);


        EmpTitlu.setCellValueFactory(
                new PropertyValueFactory<Carti,String>("titlu")
        );
        empAutor.setCellValueFactory(
                new PropertyValueFactory<Carti,String>("autor")
        );
        empEditura.setCellValueFactory(
                new PropertyValueFactory<Carti,String>("editura")
        );

        selectCol.setCellValueFactory(
                new PropertyValueFactory<Carti,String>("select")
        );

        tableview.setItems(data);




        //Wrap the ObservableList in a FilteredList (initially display all data).
        FilteredList<Carti> filteredData = new FilteredList<>(dataList, b -> true);

        // 2. Set the filter Predicate whenever the filter changes.
        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(carti -> {
                // If filter text is empty, display all persons.

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (carti.getTitlu().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
                    return true; // Filter matches first name.
                } else if (carti.getAutor().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches last name.
                } else if (carti.getEditura().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches last name.
                }
                else if (String.valueOf(carti.getEditura()).indexOf(lowerCaseFilter)!=-1)
                    return true;
                else
                    return false; // Does not match.
            });
        });

        // 3. Wrap the FilteredList in a SortedList.
        SortedList<Carti> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        // 	  Otherwise, sorting the TableView would have no effect.
        sortedData.comparatorProperty().bind(tableview.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        tableview.setItems(sortedData);
    }

    @FXML
    public void open_pastOrders(ActionEvent actionEvent) throws IOException {
        Parent registerParent = FXMLLoader.load(getClass().getClassLoader().getResource("seePastOrders.fxml"));
        Scene registerScene = new Scene(registerParent);

        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        window.setScene(registerScene);
        window.show();

    }

    @FXML
    public void open_orderedBooks(ActionEvent actionEvent) throws IOException {
        Parent registerParent = FXMLLoader.load(getClass().getClassLoader().getResource("seePastOrders.fxml"));
        Scene registerScene = new Scene(registerParent);

        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        window.setScene(registerScene);
        window.show();
    }

    @FXML
    private void close_window(ActionEvent event){
        System.exit(0);
    }
}
