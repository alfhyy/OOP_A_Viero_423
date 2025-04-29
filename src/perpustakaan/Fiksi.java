package perpustakaan;

public class Fiksi extends Buku {

    public Fiksi(String author, String title) {
        super(author, title);
    }

    @Override
    public void displayInfo() {
        System.out.println("Fiction: \"" + title + "\" written by " + author);
    }
}
