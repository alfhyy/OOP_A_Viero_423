//import necessaries class or api
import java.util.Scanner;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        //declare classes as inputUser and calcAge
        Scanner inputUser = new Scanner(System.in);
        LocalDate calcAge = LocalDate.now();

        //prompting for username input using nextLine()
        System.out.print("Enter name : ");
        String name = inputUser.nextLine();

        //declare "gender" variable since we only need a single alphabet from user
        char gender;
        //a do while condition for looping the gender input process as long as user chooses anything between "m" or "f"
        do {
            //prompting for user gender input using next, convert the input to lowercase for fixing any case-sensitive, and using the charAt(0) to acquire the first character of a string
            System.out.print("Enter gender(M/F) : ");
            gender = inputUser.next().toLowerCase().charAt(0);
        } while (gender != 'm' && gender != 'f');

        //prompting user year of birth using nextInt() for integer data type
        System.out.print("Enter year of birth : ");
        int year = inputUser.nextInt();
        //use the localdate to acquire current year value as integer(2025)
        int todayYear = calcAge.getYear();
        //calculate user age by subtracting "todayYear" variable with "year"
        int age = todayYear - year;

        //prompting user data output
        System.out.println("Personal Data :");
        System.out.println("Name: " + name);
        //switch condition based on user gender input
        switch (gender) {
            //if user chose 'm' then print male
            case 'm':
                System.out.println("Gender: Male");
                break;
            case 'f':
            //if user chose 'f' the print female
                System.out.println("Gender: Female");
                break;
            //if user input are neither of them, then output error
            default:
                System.out.println("Gender: Error occured, please select the available gender");
        }
        //output for user age
        System.out.println("Age: " + age);
    }
}