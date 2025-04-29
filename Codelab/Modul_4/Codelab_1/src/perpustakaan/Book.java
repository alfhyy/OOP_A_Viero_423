package perpustakaan;

public abstract class Book {
    protected String title;
    protected String author;

    public Book(String author, String title) {
        this.author = author;
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public abstract void displayInfo(); // Abstract method!

}
