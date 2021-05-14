package lapp.services;

import lapp.model.Book;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;

import static lapp.services.FileSystemService.getPathToFile;

public class BookstoreService {

    private static ObjectRepository<Book> bookRepository;

    public static void initDatabase() {
        Nitrite database = Nitrite.builder()
                .compressed()
                .filePath(getPathToFile("books.db").toFile())
                .openOrCreate("test", "test");

        bookRepository = database.getRepository(Book.class);
    }

    public static void addBook(String title, String author, String pHouse, String description) {
        bookRepository.insert(new Book(title, author, pHouse, description));
    }
}