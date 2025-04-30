package perpustakaan;

public abstract class Book {
    protected String title;
    protected String author;
    protected String genre;

    public Book(String author, String title, String genre) {
        this.author = author;
        this.title = title;
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public abstract void displayInfo(); 

}
