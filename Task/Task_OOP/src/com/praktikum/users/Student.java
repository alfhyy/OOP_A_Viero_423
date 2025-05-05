package com.praktikum.users;

import com.praktikum.actions.MahasiswaActions;

import java.util.Scanner;
import java.util.ArrayList;

public class Student extends User implements MahasiswaActions {
    public Student(String name, String studentID) {
        super(name, studentID);
    }

    Scanner input = new Scanner(System.in);

    @Override
    public void login() {
        System.out.print("Enter Student Username: ");
        String StudentInputName = input.nextLine();

        System.out.print("Enter Student Password: ");
        String StudentInputPassword = input.nextLine();

        if (StudentInputName.equals(getName()) && StudentInputPassword.equals(getStudentID())) {
            System.out.println("Student login successful!");
            displayInfo();
            loggedIn = true;
        } else {
            System.out.println("Login failed! username or password is incorrect!");
            loggedIn = false;
        }
    }

    @Override
    public void displayInfo() {
        System.out.println();
        System.out.println("Student Details :");
        System.out.println("Student Name: " + getName());
        System.out.println("Student ID: " + getStudentID());
        System.out.println("Successfully logged in as Student. ");
    }

    @Override
    public void displayAppMenu() {
        int inputChoice;
        do {
            System.out.println("Choose one of the following options:");
            System.out.println("1. Report Lost and Found Items");
            System.out.println("2. View Report List");
            System.out.println("0. Logout");

            System.out.print("Enter your choice: ");
            inputChoice = input.nextInt();

            switch (inputChoice) {
                case 1:
                    reportItem();
                    break;
                case 2:
                    viewReportedItems();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    break;
                default:
            }
        } while (inputChoice != 0);
    }

    @Override
    public void reportItem() {
        input.nextLine();
        System.out.println("Reported Items :");

        System.out.print("Item Name: ");
        String inputName = input.nextLine();

        System.out.print("Item Description: ");
        String inputDescription = input.nextLine();

        System.out.print("Item last location/found: ");
        String inputLastLocation = input.nextLine();
    }

    @Override
    public void viewReportedItems() {
        System.out.println(">> View Reported Items Feature Not Available <<");
    }
}
