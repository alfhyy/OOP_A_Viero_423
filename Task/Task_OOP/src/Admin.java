import java.util.Scanner;

public class Admin {
    String AdminName = "Admin423";
    String AdminPassword = "Password423";

    public void login (String name, String password) {

        if (name.equals(AdminName) && password.equals(AdminPassword)) {
            System.out.println("Admin login successful!");
        } else {
            System.out.println("Login failed! username or password is incorrect!");
        }
    }
}
