package lapp.controllers;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class Carti {
    private  final SimpleStringProperty Titlu;
    private  final SimpleStringProperty Autor;
    private  final SimpleStringProperty Editura;
    private CheckBox select;
    private Button button;
    private CheckBox checkbox;

    public Carti(String titlu, String autor, String editura)
    {
        this.Titlu = new SimpleStringProperty(titlu);
        this.Autor = new SimpleStringProperty(autor);
        this.Editura =  new SimpleStringProperty(editura);
        this.select=new CheckBox();
        this.button=new Button();
        this.checkbox=new CheckBox();
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


}
