package perpustakaan;

public class NonFiction extends Book {
    public NonFiction(String author, String title, String genre) {
        super(author, title, genre);
    }

    @Override
    public void displayInfo() {
        System.out.println("Fiction: \"" + title + "\" written by " + author + "Genre: " + genre);
    }
}
