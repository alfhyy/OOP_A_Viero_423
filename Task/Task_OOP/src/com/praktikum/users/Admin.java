package com.praktikum.users;

import com.praktikum.actions.AdminActions;

import java.util.Scanner;

public class Admin extends User implements AdminActions {
    String username;
    String password;

    Scanner input = new Scanner(System.in);

    public Admin(String name, String studentID, String username, String password) {
        super(name, studentID);
        this.username = username;
        this.password = password;
    }

    @Override
    public void login() {
        System.out.print("Enter Admin Username: ");
        String AdminInputName = input.nextLine();

        System.out.print("Enter Admin Password: ");
        String AdminInputPassword = input.nextLine();

        if (AdminInputName.equals(username) && AdminInputPassword.equals(password)) {
            System.out.println("Admin login successful!");
            displayInfo();
            loggedIn = true;
        } else {
            System.out.println("Login failed! Username or password is incorrect.");
            loggedIn = false;
        }
    }

    @Override
    public void displayInfo() {
        System.out.println();
        System.out.println("Admin Details:");
        System.out.println("Username: " + username);
        System.out.println("Status: Successfully logged in as Admin.");
    }

    @Override
    public void displayAppMenu() {
        int inputChoice;
        do {
        System.out.println("Admin Menu :");
        System.out.println("1. Manage Item Reports");
        System.out.println("2. Manage Student Data");
        System.out.println("0. Logout");

            System.out.print("Enter your choice: ");
            inputChoice = input.nextInt();

            switch (inputChoice) {
                case 1:
                    manageItems();
                    break;
                case 2:
                    manageUsers();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (inputChoice!=0);
    }

    @Override
    public void manageItems() {
        System.out.println(">> Manage Items Feature Not Available <<");
    }

    @Override
    public void manageUsers() {
        System.out.println(">> Manage Users Feature Not Available <<");
    }
}
