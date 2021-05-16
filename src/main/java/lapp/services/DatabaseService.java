package lapp.services;

import lapp.model.Book;
import lapp.model.User;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;

import static lapp.services.FileSystemService.getPathToFile;

public class DatabaseService {
    public static Nitrite database;

    public static ObjectRepository<User> userRepository;
    public static ObjectRepository<Book> bookRepository;

    public static void initDatabase() {
        FileSystemService.initDirectory();
        database = Nitrite.builder()
                .compressed()
                .filePath(getPathToFile("library-app.db").toFile())
                .openOrCreate("admin", "password");
        bookRepository = database.getRepository(Book.class);
        userRepository = database.getRepository(User.class);

        UserService.initUserRepo(userRepository);
        BookstoreService.initBookRepo(bookRepository);
    }

    public static ObjectRepository<User> getUserRepository() {
        return userRepository;
    }

    public static ObjectRepository<Book> getBookRepository() {
        return bookRepository;
    }

    public static Nitrite getDatabase() {
        return database;
    }

    public static void closeDatabase() {
        database.close();
    }
}