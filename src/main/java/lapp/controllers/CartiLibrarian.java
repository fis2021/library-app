package lapp.controllers;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class CartiLibrarian {
    private  final SimpleStringProperty Titlu;
    private  final SimpleStringProperty Autor;
    private  final SimpleStringProperty Editura;
    private CheckBox select;
    private Button button;
    private CheckBox checkbox;
    private ComboBox approveOrReject;
    private TextField reasons;

    public CartiLibrarian(String titlu, String autor, String editura, ObservableList dataList,String reason)
    {
        this.Titlu = new SimpleStringProperty(titlu);
        this.Autor = new SimpleStringProperty(autor);
        this.Editura =  new SimpleStringProperty(editura);
        this.select=new CheckBox();
        this.button=new Button();
        this.checkbox=new CheckBox();
        this.approveOrReject=new ComboBox(dataList);
        this.reasons=new TextField(reason);
    }

    public String getTitlu(){
        return Titlu.get();
    }
    public void setTitlu(String titlu){
        Titlu.set(titlu);
    }

    public String getAutor(){
        return Autor.get();
    }
    public void setAutor(String autor){
        Autor.set(autor);
    }

    public String getEditura(){
        return Editura.get();
    }
    public void setEditura(String editura){
        Editura.set(editura);
    }
    public CheckBox getSelect(){
        return select;
    }
    public void setSelect(CheckBox select){
        this.select=select;
    }

    public Button getButton(){
        return button;
    }
    public void setButton(Button button){
        this.button=button;
    }

    public CheckBox getCheckbox(){
        return checkbox;
    }
    public void setCheckbox(CheckBox checkbox){
        this.checkbox=checkbox;
    }

    public ComboBox getApproveOrReject(){
        return approveOrReject;
    }
    public void setApproveOrReject(ComboBox approveOrReject){
        this.approveOrReject=approveOrReject;
    }

    public TextField getReasons(){
        return reasons;
    }
    public void setReasons(TextField reasons){
        this.reasons=reasons;
    }

}
