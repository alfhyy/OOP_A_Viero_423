package com.perpustakaan.users;

public class Student extends User {
    public Student(String name, String studentID) {
        super(name, studentID);
    }

    @Override
    public void login (String inputName, String inputStudentID) {

        if (inputName.equals(getName()) && inputStudentID.equals(getStudentID())) {
            System.out.println("com.perpustakaan.users.Student login successful!");
            return;
        } else {
            System.out.println("Login failed! username or password is incorrect!");
        }
    }

    @Override
    public void displayInfo () {
        System.out.println();
        System.out.println("com.perpustakaan.users.Student Details :");
        System.out.println("com.perpustakaan.users.Student Name: " + getName());
        System.out.println("com.perpustakaan.users.Student ID: " + getStudentID());
        System.out.println("Successfully logged in as com.perpustakaan.users.Student. ");
    }
}
