package com.praktikum.users;

import com.praktikum.exceptions.InvalidCredentialsException;
import com.praktikum.actions.MahasiswaActions;
import com.praktikum.models.Item;
import com.praktikum.models.ItemStatus;
import com.praktikum.storage.GlobalData;

import java.util.Scanner;

public class Student extends User implements MahasiswaActions {
    public Student(String name, String studentID) {
        super(name, studentID);
    }

    public String getName() {
        return super.getName();
    }

    public String getStudentID() {
        return super.getStudentID();
    }

    Scanner input = new Scanner(System.in);

    @Override
    public void login() throws InvalidCredentialsException {
        System.out.print("Enter Student Username: ");
        String StudentInputName = input.nextLine();

        System.out.print("Enter Student Password: ");
        String StudentInputPassword = input.nextLine();

        boolean found = false;

        for (User u : GlobalData.userList) {
            if (u instanceof Student) {
                Student s = (Student) u;
                if (s.getName().equals(StudentInputName) && s.getStudentID().equals(StudentInputPassword)) {

                    this.setName(s.getName());
                    this.setStudentID(s.getStudentID());
                    this.loggedIn = true;

                    System.out.println("Student login successful!");
                    displayInfo();
                    found = true;
                    break;
                }
            }
        }
        if (!found) {
            this.loggedIn = false;
            throw new InvalidCredentialsException("Login Failed! username or student ID is incorrect!");
        }

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

        Item newItem = new Item(inputName, inputDescription, inputLastLocation, ItemStatus.reported);

        GlobalData.reportedItem.add(newItem);
        System.out.println("Successfully Put " + newItem.getName() + " Into reported Item!");
    }

    @Override
    public void viewReportedItems() {
        if (GlobalData.reportedItem.isEmpty()) {
            System.out.println("No reported items found!");
            System.out.println();
            return;
        }

        System.out.println("Reported Items :");
        for (Item i : GlobalData.reportedItem) {
            System.out.println("------------------------------");
            System.out.println("Item name: " + i.getName());
            System.out.println("Item description: " + i.getDescription());
            System.out.println("Last found: " + i.getLocation());
        }
        System.out.println("------------------------------");
    }
}
