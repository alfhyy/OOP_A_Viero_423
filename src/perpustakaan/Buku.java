package perpustakaan;

public abstract class Buku {
    protected String title;
    protected String author;

    public Buku(String author, String title) {
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
