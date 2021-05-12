package lapp;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class homePage {

    ObservableList<String> autoriList= FXCollections.observableArrayList("Ion Creanga","Mihai Eminescu","George Bacovia","Marin Preda","I. L. Caragiale");
    ObservableList<String> edituriList= FXCollections.observableArrayList("Teora","Paralela 45");

    private Image imagini;
    @FXML
    private CheckBox chb1;
    @FXML
    private CheckBox chb2;
    @FXML
    private CheckBox chb3;
    @FXML
    private CheckBox chb4;
    @FXML
    private CheckBox chb5;
    @FXML
    private CheckBox chb6;
    @FXML
    private CheckBox chb7;
    @FXML
    private CheckBox chb8;
    @FXML
    private Label lbllist;
    @FXML
    private Label lblcount;
    @FXML
    private ChoiceBox autoriBox;
    @FXML
    private ChoiceBox edituriBox;
    @FXML
    private ImageView pic1;
    @FXML
    private ImageView pic2;
    @FXML
    private ImageView pic3;
    @FXML
    private ImageView pic4;
    @FXML
    private ImageView pic5;
    @FXML
    private ImageView pic6;
    @FXML
    private ImageView pic7;
    @FXML
    private ImageView pic8;


    @FXML
    private void initialize(){
        imagini=new Image("/imagini/amintiri.jpg");
        pic1.setImage(imagini);
        imagini=new Image("/imagini/harapalb.jpg");
        pic2.setImage(imagini);
        imagini=new Image("/imagini/epoezii.jpg");
        pic3.setImage(imagini);
        imagini=new Image("/imagini/luceafarul.jpg");
        pic4.setImage(imagini);
        imagini=new Image("/imagini/bpoezii.jpg");
        pic5.setImage(imagini);
        imagini=new Image("/imagini/plumb.jpg");
        pic6.setImage(imagini);
        imagini=new Image("/imagini/morometii.jpg");
        pic7.setImage(imagini);
        imagini=new Image("/imagini/nuvele.jpg");
        pic8.setImage(imagini);

        autoriBox.setValue("Ion Creanga");
        autoriBox.setItems(autoriList);

        edituriBox.setValue("Teora");
        edituriBox.setItems(edituriList);

    }


    public void CheckEvent(javafx.event.ActionEvent actionEvent) {
        int count = 0;
        String message = "";
            if (chb1.isSelected()) {
                count++;
                message += chb1.getText() + "\n";
            }
            if (chb2.isSelected()) {
                count++;
                message += chb2.getText() + "\n";
            }
            if (chb3.isSelected()) {
                count++;
                message += chb3.getText() + "\n";
            }
            if (chb4.isSelected()) {
                count++;
                message += chb4.getText() + "\n";
            }
            if (chb5.isSelected()) {
                count++;
                message += chb5.getText() + "\n";
            }
            if (chb6.isSelected()) {
                count++;
                message += chb6.getText() + "\n";
            }
            if (chb7.isSelected()) {
                count++;
                message += chb7.getText() + "\n";
            }
            if (chb8.isSelected()) {
                count++;
                message += chb8.getText() + "\n";
            }
            lblcount.setText("Numaru de carti: " + count);
            lbllist.setText(message);
//            if(count>5)
//            {
//
//            }
    }

}