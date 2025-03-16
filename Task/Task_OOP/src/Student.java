import java.util.Scanner;

public class Student {
    String studentName = "Viero Alfiandhy Havist";
    String studentID = "202410370110423";

    public void login (String name, String password) {
        if (name.equals(studentName) && password.equals(studentID)) {
            System.out.println("Student login successful!");
        } else {
            System.out.println("Login failed! username or password is incorrect!");
        }
    }

    public void displayInfo () {
        System.out.println();
        System.out.println("Student Details :");
        System.out.println("Student Name: " + studentName);
        System.out.println("Student ID: " + studentID);
    }
}
