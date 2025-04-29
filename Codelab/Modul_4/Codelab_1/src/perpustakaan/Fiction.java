package perpustakaan;

public class Fiction extends Book {

    public Fiction(String author, String title) {
        super(author, title);
    }

    @Override
    public void displayInfo() {
        System.out.println("Fiction: \"" + title + "\" written by " + author);
    }
}
