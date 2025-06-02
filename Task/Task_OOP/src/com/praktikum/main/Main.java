package com.praktikum.main;//import scanner class for input

import com.praktikum.exceptions.InvalidCredentialsException;
import com.praktikum.models.Item;
import com.praktikum.models.ItemStatus;
import com.praktikum.users.Admin;
import com.praktikum.users.Student;
import com.praktikum.users.User;
import com.praktikum.storage.GlobalData;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //declare "input" as scanner variable
        Scanner input = new Scanner(System.in);
        User user = null;

        GlobalData.userList.add(new Admin("Viero Alfiandhy Havist", "202410370110423", "Admin423", "Password423"));
        GlobalData.userList.add(new Student("Sakuragi Hanamichi", "202410370110023"));
        GlobalData.reportedItem.add(new Item("Book", "Dictionary", "Library", ItemStatus.reported));

        //prompting output for user
        while (true) {

            System.out.println("Select login type: ");
            System.out.println("1. Admin");
            System.out.println("2. Student");

            //make user input choice with integer data type using nextInt()
            System.out.print("Enter your choice: ");

            try {
                if (!input.hasNextInt()) {
                    throw new InputMismatchException("Invalid input type! Please enter a number (e.g., 1 or 2).");
                }
                int loginType = input.nextInt();
                //consuming any left newline so that the next input won't be interrupted
                input.nextLine();

                if (loginType == 1) {
                    for (User u : GlobalData.userList) {
                        if (u instanceof Admin) {
                            try {
                                u.login();
                                u.displayAppMenu();
                                break;
                            } catch (InvalidCredentialsException e) {
                                System.out.println(e.getMessage());
                            }
                        }
                    }
                    //condition if user chose 2
                } else if (loginType == 2) {
                    for (User u : GlobalData.userList) {
                        if (u instanceof Student) {
                            try {
                                u.login();
                                u.displayAppMenu();
                                break;
                            } catch (InvalidCredentialsException e) {
                                System.out.println(e.getMessage());
                            }
                        }
                    }
                } else if (loginType == 420) {
                    System.out.println("⡆⣐⢕⢕⢕⢕⢕⢕⢕⢕⠅⢗⢕⢕⢕⢕⢕⢕⢕⠕⠕⢕⢕⢕⢕⢕⢕⢕⢕⢕\n" +
                            "⢐⢕⢕⢕⢕⢕⣕⢕⢕⠕⠁⢕⢕⢕⢕⢕⢕⢕⢕⠅⡄⢕⢕⢕⢕⢕⢕⢕⢕⢕\n" +
                            "⢕⢕⢕⢕⢕⠅⢗⢕⠕⣠⠄⣗⢕⢕⠕⢕⢕⢕⠕⢠⣿⠐⢕⢕⢕⠑⢕⢕⠵⢕\n" +
                            "⢕⢕⢕⢕⠁⢜⠕⢁⣴⣿⡇⢓⢕⢵⢐⢕⢕⠕⢁⣾⢿⣧⠑⢕⢕⠄⢑⢕⠅⢕\n" +
                            "⢕⢕⠵⢁⠔⢁⣤⣤⣶⣶⣶⡐⣕⢽⠐⢕⠕⣡⣾⣶⣶⣶⣤⡁⢓⢕⠄⢑⢅⢑\n" +
                            "⠍⣧⠄⣶⣾⣿⣿⣿⣿⣿⣿⣷⣔⢕⢄⢡⣾⣿⣿⣿⣿⣿⣿⣿⣦⡑⢕⢤⠱⢐\n" +
                            "⢠⢕⠅⣾⣿⠋⢿⣿⣿⣿⠉⣿⣿⣷⣦⣶⣽⣿⣿⠈⣿⣿⣿⣿⠏⢹⣷⣷⡅⢐\n" +
                            "⣔⢕⢥⢻⣿⡀⠈⠛⠛⠁⢠⣿⣿⣿⣿⣿⣿⣿⣿⡀⠈⠛⠛⠁⠄⣼⣿⣿⡇⢔\n" +
                            "⢕⢕⢽⢸⢟⢟⢖⢖⢤⣶⡟⢻⣿⡿⠻⣿⣿⡟⢀⣿⣦⢤⢤⢔⢞⢿⢿⣿⠁⢕\n" +
                            "⢕⢕⠅⣐⢕⢕⢕⢕⢕⣿⣿⡄⠛⢀⣦⠈⠛⢁⣼⣿⢗⢕⢕⢕⢕⢕⢕⡏⣘⢕\n" +
                            "⢕⢕⠅⢓⣕⣕⣕⣕⣵⣿⣿⣿⣾⣿⣿⣿⣿⣿⣿⣿⣷⣕⢕⢕⢕⢕⡵⢀⢕⢕\n" +
                            "⢑⢕⠃⡈⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⢃⢕⢕⢕\n" +
                            "⣆⢕⠄⢱⣄⠛⢿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⣿⠿⢁⢕⢕⠕⢁\n" +
                            "⣿⣦⡀⣿⣿⣷⣶⣬⣍⣛⣛⣛⡛⠿⠿⠿⠛⠛⢛⣛⣉⣭⣤⣂⢜⠕⢑⣡⣴⣿");
                } else {
                    System.out.println("Invalid Input, please try again!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

    }
}
