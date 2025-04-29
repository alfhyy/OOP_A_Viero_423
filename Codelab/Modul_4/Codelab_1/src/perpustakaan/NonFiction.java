package perpustakaan;

public class NonFiction extends Book {
    public NonFiction(String author, String title) {
        super(author, title);
    }

    @Override
    public void displayInfo() {
        System.out.println("Fiction: \"" + title + "\" written by " + author);
    }
}
