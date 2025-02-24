import java.util.Scanner;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        Scanner inputUser = new Scanner(System.in);
        LocalDate calcAge = LocalDate.now();

        System.out.print("Enter name : ");
        String name = inputUser.nextLine();

        char gender;
        do {
            System.out.print("Enter gender(M/F) : ");
            gender = inputUser.next().toLowerCase().charAt(0);
        } while (gender != 'm' && gender != 'f');

        System.out.print("Enter year of birth : ");
        int year = inputUser.nextInt();
        int todayYear = calcAge.getYear();
        int age = todayYear - year;


        System.out.println("Personal Data :");
        System.out.println("Name: " + name);
        switch (gender) {
            case 'm':
                System.out.println("Gender: Male");
                break;
            case 'f':
                System.out.println("Gender: Female");
                break;
            default:
                System.out.println("Gender: Error occured, please select the available gender");
        }
        System.out.println("Age: " + age);
    }
}