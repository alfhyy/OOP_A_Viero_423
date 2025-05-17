package com.praktikum.users;

public abstract class User {
    private String name;
    private String studentID;

    public User(String name, String studentID) {
        this.name = name;
        this.studentID = studentID;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public String getStudentID() {
        return studentID;
    }

    public abstract void login();

    public boolean loggedIn = false;

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public abstract void displayAppMenu();

    public void displayInfo() {
//        System.out.println("User Details :");
//        System.out.println("Name: " + name);
//        System.out.println("Student ID: " + studentID);
    }
}
