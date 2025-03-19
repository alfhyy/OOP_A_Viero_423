public class Student extends User {

    public Student(String name, String studentID) {
        super(name, studentID);
    }

    String studentId = getStudentID();
    String name = getName();

    @Override
    public void Login () {

        if (name.equals("UIAUOIUOIOII") && studentId.equals("Test")) {
            System.out.println("Student login successful!");
        } else {
            System.out.println("Login failed! username or password is incorrect!");
        }
    }

    @Override
    public void displayInfo () {
        System.out.println();
        System.out.println("Student Details :");
        System.out.println("Student Name: " + name);
        System.out.println("Student ID: " + studentId);
    }
}
