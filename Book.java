package library.model;

/**
 * Represents a Book in the Library.
 */
public class Book {

    private int id;
    private String title;
    private String author;
    private String genre;
    private boolean isAvailable;

    public Book(int id, String title, String author, String genre) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isAvailable = true;
    }

    // Getters
    public int getId()          { return id; }
    public String getTitle()    { return title; }
    public String getAuthor()   { return author; }
    public String getGenre()    { return genre; }
    public boolean isAvailable(){ return isAvailable; }

    // Setters
    public void setAvailable(boolean available) { this.isAvailable = available; }

    @Override
    public String toString() {
        return String.format("| %-4d | %-30s | %-20s | %-15s | %-9s |",
                id, title, author, genre, isAvailable ? "Available" : "Issued");
    }
}
