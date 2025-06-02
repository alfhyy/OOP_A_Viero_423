package com.praktikum.users;

import com.praktikum.exceptions.InvalidCredentialsException;
import com.praktikum.actions.AdminActions;
import com.praktikum.models.ItemStatus;
import com.praktikum.storage.GlobalData;
import com.praktikum.models.Item;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Admin extends User implements AdminActions {
    public String username;
    public String password;

    Scanner input = new Scanner(System.in);

    public Admin(String name, String studentID, String username, String password) {
        super(name, studentID);
        this.username = username;
        this.password = password;
    }

    @Override
    public void login() throws InvalidCredentialsException {
        System.out.print("Enter Admin Username: ");
        String AdminInputName = input.nextLine();

        System.out.print("Enter Admin Password: ");
        String AdminInputPassword = input.nextLine();

        boolean found = false;

        for (User u : GlobalData.userList) {
            if (u instanceof Admin) {
                Admin admin = (Admin) u;
                if (AdminInputName.equals(username) && AdminInputPassword.equals(password)) {
                    System.out.println("Admin login successful!");

                    this.username = admin.username;
                    this.password = admin.password;
                    this.setName(admin.getName());
                    this.setStudentID(admin.getStudentID());

                    this.loggedIn = true;

                    displayInfo();
                    found = true;
                    break;
                }
            }
        }
        if (!found) {
            this.loggedIn = false;
            throw new InvalidCredentialsException("Login Failed! username or password is incorrect!");
        }
    }

    @Override
    public void displayInfo() {
        System.out.println();
        System.out.println("Admin Details:");
        System.out.println("Username: " + username);
        System.out.println("Status: Successfully logged in as Admin.");
        System.out.println();
    }

    @Override
    public void displayAppMenu() {
        int inputChoice = -1;
        do {
            System.out.println("Admin Menu :");
            System.out.println("1. Manage Item Reports");
            System.out.println("2. Manage Student Data");
            System.out.println("0. Logout");

            System.out.print("Enter your choice: ");
            try {
                if (!input.hasNextInt()) {
                    throw new InputMismatchException("Invalid input type! Please enter a number (e.g., 1 or 2).");
                }
                inputChoice = input.nextInt();
                input.nextLine();

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
            } catch (InputMismatchException e) {
                System.out.println("Error: " + e.getMessage());
                input.nextLine();
            }
        } while (inputChoice != 0);
    }

    @Override
    public void manageItems() {
        System.out.println("Manage Item Reports:");
        System.out.println("1. View all reports");
        System.out.println("2. Mark as Reported");

        System.out.print("Enter your choice: ");
        try {
            if (!input.hasNextInt()) {
                throw new InputMismatchException("Invalid input type! Please enter a number (e.g., 1 or 2).");
            }

            int inputChoice = input.nextInt();

            if (inputChoice == 1) {
                if (GlobalData.reportedItem.isEmpty()) {
                    System.out.println("There are no reports yet!");
                    System.out.println();
                    return;
                }

                System.out.println("All Reports: ");
                int index = 1;
                for (Item i : GlobalData.reportedItem) {
                    System.out.println("--------------------");
                    System.out.println(index + ". " + i.getName());
                    System.out.println(i.getStatus());
                    System.out.println("--------------------");
                    index++;
                }
            } else if (inputChoice == 2) {
                if (GlobalData.reportedItem.isEmpty()) {
                    System.out.println("No reported items found!");
                    System.out.println();
                    return;
                }

                System.out.println("Mark as Reported: ");
                int index = 1;
                for (Item i : GlobalData.reportedItem) {
                    System.out.println("--------------------");
                    System.out.println(index + ". " + i.getName());
                    System.out.println(i.getStatus());
                    System.out.println("--------------------");
                    index++;

                    System.out.print("Select item to Mark as Reported: ");

                    try {

                        if (!input.hasNextInt()) {
                            throw new InputMismatchException("Invalid input type! Please enter a number!");
                        }

                        int reportInput = input.nextInt();
                        input.nextLine();

                        if (reportInput < 1 || reportInput > GlobalData.reportedItem.size()) {
                            throw new IndexOutOfBoundsException("Invalid selection, please try again!");
                        }

                        System.out.println("Choose new status: ");
                        System.out.println("1. Found");
                        System.out.println("2. Claimed");
                        System.out.print("Enter your choice: ");
                        inputChoice = input.nextInt();

                        Item selectedItem = GlobalData.reportedItem.get(reportInput - 1);
                        switch (inputChoice) {
                            case 1:
                                selectedItem.setStatus(ItemStatus.found);
                                System.out.println("Status: Marked as Found");
                                break;
                            case 2:
                                selectedItem.setStatus(ItemStatus.claimed);
                                System.out.println("Status: Claimed");
                                break;
                            default:
                                System.out.println("Invalid choice! Try again.");
                        }
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println(e.getMessage());
                    } catch (InputMismatchException e) {
                        System.out.println(e.getMessage());
                        input.nextLine();
                    } catch (Exception e) {
                        System.out.println("Invalid input. Please try again!");
                        input.nextLine();
                    }
                }
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: " + e.getMessage());
            input.nextLine();
        }
    }

    @Override
    public void manageUsers() {
        System.out.println("Manage User:");
        System.out.println("1. Add new student");
        System.out.println("2. Delete student");
        System.out.print("Enter your choice: ");
        int inputChoice = input.nextInt();

        if (inputChoice == 1) {
            System.out.println("Add new student:");
            input.nextLine();

            System.out.print("Enter student Name: ");
            String studentName = input.nextLine();

            System.out.print("Enter student ID: ");
            String studentID = input.nextLine();

            User user = new Student(studentName, studentID);
            GlobalData.userList.add(user);

            System.out.println("New student just added successfully!");
            System.out.println();
        } else if (inputChoice == 2) {
            boolean hasStudents = false;

            for (User u : GlobalData.userList) {
                if (u instanceof Student) {
                    hasStudents = true;
                    break;
                }
            }

            if (!hasStudents) {
                System.out.println("Student does not exist!");
                System.out.println();
                return;
            }

            System.out.println("Delete student:");
            input.nextLine();

            for (User u : GlobalData.userList) {
                if (u instanceof Student) {
                    int index = 1;
                    System.out.println("-------------------------");
                    System.out.println("Name: " + u.getName());
                    System.out.println("NIM: " + u.getStudentID());
                    System.out.println("-------------------------");
                    index++;
                }
            }

            System.out.print("Enter student ID: ");
            String studentID = input.nextLine();

            User userToDelete = null;
            for (User user : GlobalData.userList) {
                if (user instanceof Student && studentID.equals(user.getStudentID())) {
                    userToDelete = user;
                    break;
                }
            }

            if (userToDelete != null) {
                GlobalData.userList.remove(userToDelete);
                System.out.println("Successfully deleted student with ID " + studentID);
            } else {
                System.out.println("Student with ID " + studentID + " does not exist!");
            }

        }
    }


}
