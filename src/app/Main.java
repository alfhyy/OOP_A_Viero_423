package app;

import perpustakaan.*;

public class Main {
    public static void main(String[] args) {
        Anggota viero = new Anggota("Viero Alfiandhy", "A-423");
        Anggota opan = new Anggota("Ovan Keyva", "A-506");

        Buku madilog = new Fiksi("Takehiko Inoue", "Vagabond");
        Buku homoSapiens = new NonFiksi("Yuval Noah Harari", "Sapiens: A Brief History of Humankind");

        viero.displayInfo();
        opan.displayInfo();
        System.out.println();

        madilog.displayInfo();
        homoSapiens.displayInfo();
        System.out.println();

        viero.borrowBook(madilog.getTitle());
        opan.borrowBook(homoSapiens.getTitle(), 7);
        System.out.println();

        viero.returnBook(madilog.getTitle());
        opan.returnBook(homoSapiens.getTitle());
    }
}
