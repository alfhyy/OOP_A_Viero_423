package app;
import perpustakaan.*;

public class Main {
    public static void main(String[] args) {
        Member viero = new Member("Viero Alfiandhy", "A-423");
        Member opan = new Member("Ovan Gosling", "A-506");

        Book vagabond = new Fiction("Takehiko Inoue", "Vagabond");
        Book homo = new NonFiction("Yuval Noah Harari", "Sapiens: A Brief History of Humankind");

        viero.displayInfo();
        opan.displayInfo();
        System.out.println();

        vagabond.displayInfo();
        homo.displayInfo();
        System.out.println();

        viero.borrowBook(vagabond.getTitle());
        opan.borrowBook(homo.getTitle(), 5);
        System.out.println();

        viero.returnBook(vagabond);
        opan.returnBook(homo);
    }
}
