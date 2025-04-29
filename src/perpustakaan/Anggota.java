package perpustakaan;

public class Anggota implements Peminjaman {
    private String name;
    private String memberID;

    public Anggota(String name, String memberID) {
        this.name = name;
        this.memberID = memberID;
    }

    public void displayInfo() {
        System.out.println("Name: " + name + " (ID: " + memberID + ")");
    }

    // Overloaded methods
    public void borrowBook(String title) {
        System.out.println(name + " just borrowed : " + title);
    }

    public void borrowBook(String title, int duration) {
        System.out.println(name + " just borrowed \"" + title + "\" for " + duration + " days.");
    }

    @Override
    public void borrowBook() {
    }

    @Override
    public void returnBook() {
    }

    public void returnBook(String title) {
        System.out.println(name + " just returned : " + title + " book");
    }
}
