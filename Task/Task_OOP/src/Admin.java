public class Admin extends User {
    private final String username;
    private final String password;

    public Admin(String name, String studentID, String username, String password) {
        super(name, studentID);
        this.username = username;
        this.password = password;
    }

    @Override
    public void Login() {
        if (this.username.equals("Test") && this.password.equals("Testpw")) {
            System.out.println("Admin login successful!");
            return;
        } else {
            System.out.println("Login failed! Username or password is incorrect.");
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("Admin Details:");
        System.out.println("Username: " + username);
        System.out.println("Status: Successfully logged in as Admin.");
    }
}
