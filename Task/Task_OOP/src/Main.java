import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        //DECLARE ADMIN USER AND PASSWORD
        String AdminName = "Admin423";
        String AdminPassword = "Password423";

        //DECLARE STUDENT NAME AND ID
        String StudentName = "Viero Alfiandhy Havist";
        String StudentID = "202410370110423";

        System.out.println("Select login type: ");
        System.out.println("1. Admin");
        System.out.println("2. Student");

        System.out.print("Enter your choice: ");
        int loginType = input.nextInt();
        input.nextLine();

        if (loginType == 1) {
            System.out.print("Enter Admin Username: ");
            String AdminInputName = input.nextLine();

            System.out.print("Enter Admin Password: ");
            String AdminInputPassword = input.nextLine();

            if (AdminInputName.equals(AdminName) && AdminInputPassword.equals(AdminPassword)) {
                System.out.print("Admin login successful!");
            } else {
                System.out.print("Login failed! username or password is incorrect!");
            }
        } else if (loginType == 2) {
            System.out.print("Enter Student Username: ");
            String StudentInputName = input.nextLine();

            System.out.print("Enter Student Password: ");
            String StudentInputPassword = input.nextLine();

            if (StudentInputName.equals(StudentName) && StudentInputPassword.equals(StudentID)) {
                System.out.println("Student login successful!");
                System.out.println("Name: " + StudentInputName);
                System.out.println("Student ID: " + StudentInputPassword);
            } else {
                System.out.print("Login failed! username or password is incorrect!");
            }
        } else {
            System.out.println("Invalid Input, please try again!");
        }
    }
}
