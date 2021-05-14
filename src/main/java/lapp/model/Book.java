package lapp.model;

import org.dizitart.no2.objects.Id;

public class Book {

    @Id
    private String name;
    private String author;
    private String description;
    private String pHouse;

    public Book(String name, String author, String description, String pHouse) {
        this.name = name;
        this.author = author;
        this.description = description;
        this.pHouse = pHouse;
    }
            
    public Book(){}

    public String getNameOfBook() {return name; }
    public void setNameOfBook(String name) { this.name = name; }

    public String getAuthor() {return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = author; }

    public String getpHouse() { return pHouse; }
    public void setpHouse(String pHouse) { this.pHouse = pHouse; }

}