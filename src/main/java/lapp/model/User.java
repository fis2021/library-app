package lapp.model;

import javafx.scene.control.CheckBox;
import org.dizitart.no2.objects.Id;

import java.util.ArrayList;

public class User{
    @Id
    private String fullName;
    private String email;
    private String phone;
    private String username; //this also defines the role
    private String password;
    private ArrayList<Book> order;
    private CheckBox select;

    public User(String fullName, String email, String phone, String username, String password) {
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.username = username;
        this.password = password;
        this.select= new CheckBox();
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {}

    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) { this.email = email; }

    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) { this.fullName = phone; }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Book> getOrder() { return order; }

    public CheckBox getSelect(){ return select; }
    public void setSelect(CheckBox select){ this.select=select;}

    /*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (!Objects.equals(username, user.username)) return false;
        if (!Objects.equals(password, user.password)) return false;
        return Objects.equals(username, user.username);
    }*/

    public void addToOrder(Book book){
        order.add(book);
    }

    public boolean isInOrder(Book orderedBook){   //already exists in order
        for(Book book : order){
            if(book.getNameOfBook().equals(orderedBook.getNameOfBook())){
                return true;
            }
        }
        return false;
    }

    public void removeFromOrder(Book orderedBook){
        for(Book book : order){
            if(book.getNameOfBook().equals(orderedBook.getNameOfBook())){     //default show.equals not working!
                order.remove(book);
                break;
            }
        }
    }

    @Override
    public int hashCode() {
        int result = username != null ? username.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        //result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }
}
