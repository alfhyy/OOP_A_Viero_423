//import scanner class for input

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //declare "input" as scanner variable
        Scanner input = new Scanner(System.in);

        //DECLARE ADMIN USER AND PASSWORD
        String AdminName = "Admin423";
        String AdminPassword = "Password423";

        //DECLARE STUDENT NAME AND ID
        String StudentName = "Viero Alfiandhy Havist";
        String StudentID = "202410370110423";

        //prompting output for user
        System.out.println("Select login type: ");
        System.out.println("1. Admin");
        System.out.println("2. Student");

        //make user input choice with integer data type using nextInt()
        System.out.print("Enter your choice: ");
        int loginType = input.nextInt();
        //consuming any left newline so that the next input won't be interrupted
        input.nextLine();

        //condition if user chose 1
        if (loginType == 1) {
            //prompting input for admin name with string using nextLine()
            System.out.print("Enter Admin Username: ");
            String AdminInputName = input.nextLine();

            //prompting input for admin password with string using nextLine()
            System.out.print("Enter Admin Password: ");
            String AdminInputPassword = input.nextLine();

            //condition to compare admin input with declared previous variables' (AdminName, AdminPassword) value using 'equals'
            if (AdminInputName.equals(AdminName) && AdminInputPassword.equals(AdminPassword)) {
                //print this if both name and password are match
                System.out.print("Admin login successful!");
            } else {
                //print this if either one or both of name and password aren't match
                System.out.print("Login failed! username or password is incorrect!");
            }
        //condition if user chose 2
        } else if (loginType == 2) {
            //prompting input for student name with string using nextLine()
            System.out.print("Enter Student Username: ");
            String StudentInputName = input.nextLine();

            //prompting input for student password with string using nextLine()
            System.out.print("Enter Student Password: ");
            String StudentInputPassword = input.nextLine();

            //condition to compare student input with declared previous variables' (StudentName, StudentID) value using 'equals'
            if (StudentInputName.equals(StudentName) && StudentInputPassword.equals(StudentID)) {
                //output prompts if the credentials match
                System.out.println("Student login successful!");
                System.out.println("Name: " + StudentInputName);
                System.out.println("Student ID: " + StudentInputPassword);
            } else {
                //output prompt if the credentials are wrong
                System.out.print("Login failed! username or password is incorrect!");
            }
        //condition if user decided to choose another number between 1 or 2
        } else {
            //prompting output
            System.out.println("Invalid Input, please try again!");
        }
    }
}
