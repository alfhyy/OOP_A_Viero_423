public class Student extends User {
    public Student(String name, String studentID) {
        super(name, studentID);
    }

    @Override
    public void login (String inputName, String inputStudentID) {

        if (inputName.equals(getName()) && inputStudentID.equals(getStudentID())) {
            System.out.println("Student login successful!");
            return;
        } else {
            System.out.println("Login failed! username or password is incorrect!");
        }
    }

    @Override
    public void displayInfo () {
        System.out.println();
        System.out.println("Student Details :");
        System.out.println("Student Name: " + getName());
        System.out.println("Student ID: " + getStudentID());
        System.out.println("Successfully logged in as Student. ");
    }
}
