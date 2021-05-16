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
import lapp.model.Book;
import lapp.services.BookstoreService;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class HomepageClientController implements Initializable {
    @FXML
    private TableView<Book> tableview;

    @FXML
    private TableColumn<Book, String> titleColumn;

    @FXML
    private TableColumn<Book, String> authorColumn;

    @FXML
    private TableColumn<Book, String> pHouseColumn;

    @FXML
    private TableColumn<Book, String> selectColumn;

    @FXML
    private TextField filterField;

    @FXML
    private Button buttonOrderBooks;

    @FXML
    private Button buttonPastOrders;

    @FXML
    private Button x;

    private final ObservableList<Book> dataList = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb){

        tableview.getColumns().addAll(titleColumn,authorColumn,pHouseColumn,selectColumn);

        if(BookstoreService.getBookRepository()!=null)
        for (Book book : BookstoreService.getBookRepository().find()) {
                dataList.add(book);
        }


        titleColumn.setCellValueFactory(
                new PropertyValueFactory<>("Title")
        );
        authorColumn.setCellValueFactory(
                new PropertyValueFactory<>("author")
        );
        pHouseColumn.setCellValueFactory(
                new PropertyValueFactory<>("Publishing House")
        );

        selectColumn.setCellValueFactory(
                new PropertyValueFactory<>("Select")
        );

        tableview.setItems(dataList);

        //Wrap the ObservableList in a FilteredList (initially display all dataList).
        FilteredList<Book> filteredData = new FilteredList<>(dataList, b -> true);

        // 2. Set the filter Predicate whenever the filter changes.
        filterField.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(books -> {
                // If filter text is empty, display all persons.

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (books.getNameOfBook().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
                    return true; // Filter matches first name.
                } else if (books.getAuthor().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches last name.
                } else if (books.getpHouse().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches last name.
                } else if (String.valueOf(books.getpHouse()).indexOf(lowerCaseFilter)!=-1)
                    return true;
                else
                    return false; // Does not match.
            });
        });

        // 3. Wrap the FilteredList in a SortedList.
        SortedList<Book> sortedData = new SortedList<>(filteredData);

        // 4. Bind the SortedList comparator to the TableView comparator.
        // 	  Otherwise, sorting the TableView would have no effect.
        sortedData.comparatorProperty().bind(tableview.comparatorProperty());

        // 5. Add sorted (and filtered) dataList to the table.
        tableview.setItems(sortedData);
    }

    @FXML
    public void open_seePastOrders(ActionEvent actionEvent) throws IOException {
        Parent registerParent = FXMLLoader.load(getClass().getClassLoader().getResource("seePastOrders.fxml"));
        Scene registerScene = new Scene(registerParent);

        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        window.setScene(registerScene);
        window.show();

    }

    @FXML
    public void orderBooks(ActionEvent actionEvent) throws IOException {
        Parent registerParent = FXMLLoader.load(getClass().getClassLoader().getResource("OrderedBooks.fxml"));
        Scene registerScene = new Scene(registerParent);

        Stage window = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();

        window.setScene(registerScene);
        window.show();

        for (Book book : dataList) {
            if(book.getSelect().isSelected()){
                SignInController.getCurrentUser().addToOrder(book);
                dataList.remove(book);
            }
        }
    }

    @FXML
    private void close_window(ActionEvent event){
        System.exit(0);
    }
}