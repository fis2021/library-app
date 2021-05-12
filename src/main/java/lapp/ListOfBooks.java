package lapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.util.ResourceBundle;

public class ListOfBooks implements Initializable {
    @FXML
    private Label label;
    @FXML private TextField filterField;
    @FXML private TableView<Carti> tableview;
    @FXML private TableColumn<Carti, String> EmpTitlu;
    @FXML private TableColumn<Carti, String> empAutor;
    @FXML private TableColumn<Carti, String> empEditura;

    //observalble list to store data
    private final ObservableList<Carti> dataList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        EmpTitlu.setCellValueFactory(new PropertyValueFactory<>("Titlu"));
        empAutor.setCellValueFactory(new PropertyValueFactory<>("Autor"));
        empEditura.setCellValueFactory(new PropertyValueFactory<>("Editura"));

        Carti c1=new Carti("Amintiri din copilarie","Ion Creanga","Teora");
        Carti c2=new Carti("Harap Alb","Ion Creanga","Paralela 45");
        Carti c3=new Carti("Luceafarul","Mihai Eminescu","Teora");
        Carti c4=new Carti("Plumb","George Bacovia","Paralela 45");

        dataList.addAll(c1,c2,c3,c4);

        // Wrap the ObservableList in a FilteredList (initially display all data).
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
}
