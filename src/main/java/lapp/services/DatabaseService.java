package lapp.services;

import lapp.model.Book;
import lapp.model.User;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;

import static lapp.services.FileSystemService.getPathToFile;

public class DatabaseService {
    private static Nitrite database;

    private static ObjectRepository<User> userRepository;
    private static ObjectRepository<Book> bookRepository;

    public static void initDatabase() {
        FileSystemService.initDirectory();
        database = Nitrite.builder()
                .compressed()
                .filePath(getPathToFile("library-app.db").toFile())
                .openOrCreate("admin", "password");
        bookRepository = database.getRepository(Book.class);
        userRepository = database.getRepository(User.class);
    }
    public static ObjectRepository<User> getUserRepository(){
        return userRepository;
    }

    public static ObjectRepository<Book> getBookRepository(){
        return bookRepository;
    }

    public static Nitrite getDatabase() {
        return database;
    }
}
