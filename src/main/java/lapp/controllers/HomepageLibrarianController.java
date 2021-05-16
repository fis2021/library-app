package lapp.controllers;

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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import lapp.model.User;
import lapp.services.DatabaseService;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomepageLibrarianController implements Initializable{
    @FXML
    private Button x;

    @FXML
    private TextField filterField;

    @FXML
    private TableView<User> tableview;

    @FXML
    private TableColumn<User, String> clientName;

    @FXML
    private TableColumn<User, String> booksOrderedByClient;

    @FXML
    private TableColumn<User, String> approveOrReject;

    private final ObservableList<User> dataList = FXCollections.observableArrayList();

    @Override
    public void initialize (URL url, ResourceBundle rb) {

        tableview.getColumns().addAll(clientName,booksOrderedByClient,approveOrReject);

        for (User user: DatabaseService.getUserRepository().find()) {
            if(!user.getOrder().isEmpty())
                dataList.add(user);
        }


        clientName.setCellValueFactory(
                new PropertyValueFactory<>("Client Name")
        );
        booksOrderedByClient.setCellValueFactory(
                new PropertyValueFactory<>("Books Ordered")
        );
        approveOrReject.setCellValueFactory(
                new PropertyValueFactory<>("Approve/Reject")
        );

        tableview.setItems(dataList);


        //Wrap the ObservableList in a FilteredList (initially display all dataList).
        FilteredList<User> filteredData = new FilteredList<>(dataList, b -> true);

        // 2. Set the filter Predicate whenever the filter changes.
        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(users -> {

               if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                 // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                // Does not match.
                return users.getFullName().toLowerCase().indexOf(lowerCaseFilter) != -1; // Filter matches first name.
            });
        });

        // 3. Wrap the FilteredList in a SortedList.
        SortedList<User> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        // 	  Otherwise, sorting the TableView would have no effect.
        sortedData.comparatorProperty().bind(tableview.comparatorProperty());

        // 5. Add sorted (and filtered) dataList to the table.
        tableview.setItems(sortedData);
    }

   /* @FXML
    public void deleteSelectedRows(ActionEvent event) {
        for(User user : dataList){
            if(user.getSelect().isSelected()){
                dataList.remove(user);
            }
        }
        tableview.setItems(dataList);
    }*/

    @FXML
    public void goToAddBooks(ActionEvent event) throws IOException { // go to AddBooks
        Parent addBookParent = FXMLLoader.load(getClass().getClassLoader().getResource("AddBooks.fxml"));
        Scene addBookScene = new Scene(addBookParent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        window.setScene(addBookScene);
        window.show();
    }


    @FXML
    private void close_window(ActionEvent event){
        System.exit(0);
    }
}