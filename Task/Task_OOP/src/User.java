public class User {
    private String name;
    private String studentID;

    public User(String name, String studentID) {
        this.name = name;
        this.studentID = studentID;
    }

    public void setName(String name) {
        this.name = "Viero Alfiandhy Havist";
    }

    public String getName() {
        return name;
    }

    public void setStudentID(String studentID) {
        this.studentID = "202410370110423";
    }

    public String getStudentID() {
        return studentID;
    }

    public void login(String a, String b) {
        //override later in subclasses
    }

    public void displayInfo() {
        System.out.println("User Details :");
        System.out.println("Name: " + name);
        System.out.println("Student ID: " + studentID);
    }
}
