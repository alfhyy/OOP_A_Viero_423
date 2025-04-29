package perpustakaan;

public class NonFiksi extends Buku {

    public NonFiksi(String author, String title) {
        super(author, title);
    }

    @Override
    public void displayInfo() {
        System.out.println("Non-Fiction: \"" + title + "\" written by " + author);
    }
}
