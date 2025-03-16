//import scanner class for input

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //declare "input" as scanner variable
        Scanner input = new Scanner(System.in);

        //prompting output for user
        System.out.println("Select login type: ");
        System.out.println("1. Admin");
        System.out.println("2. Student");

        //make user input choice with integer data type using nextInt()
        System.out.print("Enter your choice: ");
        int loginType = input.nextInt();
        //consuming any left newline so that the next input won't be interrupted
        input.nextLine();

        Admin admin = new Admin();
        Student student = new Student();

        if (loginType == 1) {

            System.out.print("Enter Admin Username: ");
            String AdminInputName = input.nextLine();

            System.out.print("Enter Admin Password: ");
            String AdminInputPassword = input.nextLine();

            admin.login(AdminInputName, AdminInputPassword);

        //condition if user chose 2
        } else if (loginType == 2) {
            System.out.print("Enter Student Username: ");
            String StudentInputName = input.nextLine();

            System.out.print("Enter Student Password: ");
            String StudentInputPassword = input.nextLine();

            student.login(StudentInputName, StudentInputPassword);
            student.displayInfo();

        //condition if user decided to choose another number between 1 or 2
        } else {
            //prompting output
            System.out.println("Invalid Input, please try again!");
        }
    }
}
