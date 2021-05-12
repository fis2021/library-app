package lapp;

import javafx.beans.property.SimpleStringProperty;

public class Carti {
    private  final SimpleStringProperty Titlu;
    private  final SimpleStringProperty Autor;
    private  final SimpleStringProperty Editura;

    Carti(String titlu, String autor, String editura)
    {
        this.Titlu = new SimpleStringProperty(titlu);
        this.Autor = new SimpleStringProperty(autor);
        this.Editura =  new SimpleStringProperty(editura);
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

}
