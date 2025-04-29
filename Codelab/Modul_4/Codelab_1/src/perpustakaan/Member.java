package perpustakaan;

public class Member implements BookLoan{
    private String name;
    private String memberID;

    public Member(String name, String memberID) {
        this.name = name;
        this.memberID = memberID;
    }

    public void displayInfo() {
        System.out.println("Names: " + name + " (ID: " + memberID + ")");
    }

    public void borrowBook(String title) {
        System.out.println(name + " just borrowed : " + title);
    }

    public void borrowBook(String title, int duration) {
        System.out.println(name + " just borrowed \"" + title + "\" for " + duration + " days.");
    }

    @Override
    public void borrowBook (Book book) {
        System.out.println(name + " just borrowed : " + book.getTitle());
    }

    @Override
    public void returnBook (Book book) {
        System.out.println(name + " just returned : " + book.getTitle());
    }
}
