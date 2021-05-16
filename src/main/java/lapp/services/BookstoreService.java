package lapp.services;

import lapp.model.Book;
import org.dizitart.no2.objects.ObjectRepository;

public class BookstoreService {
    private static ObjectRepository<Book> bookRepository;

    public static void initBookRepo(ObjectRepository<Book> bookRepository){
        BookstoreService.bookRepository = bookRepository;
    }

    public static void addBook(String title, String author, String pHouse, String description) {
        DatabaseService.getBookRepository().insert(new Book(title, author, pHouse, description));
    }

    public static ObjectRepository<Book> getBookRepository(){
        return DatabaseService.getBookRepository();
    }

}