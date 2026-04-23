package library.service;

import library.model.Book;
import java.util.ArrayList;
import java.util.List;

/**
 * Handles all Book-related operations.
 */
public class BookService {

    private List<Book> books = new ArrayList<>();
    private int nextId = 1;

    // Constructor: add some sample books
    public BookService() {
        addBook("The Great Gatsby",         "F. Scott Fitzgerald", "Classic");
        addBook("To Kill a Mockingbird",    "Harper Lee",          "Fiction");
        addBook("1984",                     "George Orwell",       "Dystopian");
        addBook("Clean Code",               "Robert C. Martin",    "Technology");
        addBook("Java: The Complete Reference", "Herbert Schildt", "Technology");
    }

    public void addBook(String title, String author, String genre) {
        books.add(new Book(nextId++, title, author, genre));
        System.out.println("  ✔  Book added: " + title);
    }

    public Book findById(int id) {
        return books.stream()
                    .filter(b -> b.getId() == id)
                    .findFirst()
                    .orElse(null);
    }

    public List<Book> searchByTitle(String keyword) {
        List<Book> result = new ArrayList<>();
        for (Book b : books) {
            if (b.getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(b);
            }
        }
        return result;
    }

    public List<Book> searchByAuthor(String keyword) {
        List<Book> result = new ArrayList<>();
        for (Book b : books) {
            if (b.getAuthor().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(b);
            }
        }
        return result;
    }

    public List<Book> getAllBooks() { return books; }

    public void displayAllBooks() {
        System.out.println("\n" + "=".repeat(95));
        System.out.println("                              ALL BOOKS IN LIBRARY");
        System.out.println("=".repeat(95));
        System.out.printf("| %-4s | %-30s | %-20s | %-15s | %-9s |%n",
                "ID", "Title", "Author", "Genre", "Status");
        System.out.println("-".repeat(95));
        if (books.isEmpty()) {
            System.out.println("  No books found.");
        } else {
            books.forEach(System.out::println);
        }
        System.out.println("=".repeat(95));
    }
}
