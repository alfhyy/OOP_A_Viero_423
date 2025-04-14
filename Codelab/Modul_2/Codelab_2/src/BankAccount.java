public class BankAccount {
    //declare necessary variables
    private String accountNumber;
    private String ownerName;
    private double balance;
    private double minimumBalance = 100.0;

    //initialized constructor
    public BankAccount(String accountNumber, String ownerName, double balance) {
        //scope for defining where a certain variable or method is accessible in a program.
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    //make displayInfo() function to display user' information
    public void displayInfo() {
        System.out.println("Account Number :" + accountNumber);
        System.out.println("Account Name :" + ownerName);
        System.out.println("Balance :" + balance);
        System.out.println();
    }

    //make depositMoney() function to allows user make a deposit
    public void depositMoney(double amount) {
        //put more into amount depending on how much the balance
        balance += amount;
        System.out.println(ownerName + " just deposit :" + amount + " your balance :" + balance);
    }

    //make withdrawMoney() function to allows user make a withdraw
    public void withdrawMoney(double amount) {
        //condition if user' balance is less than the amount of withdraw
        if (balance - amount < minimumBalance) {
            System.out.println("Withdrawal denied. Minimum balance of " + minimumBalance + " must be maintained.");
            return;
        }
        balance -= amount;
        System.out.println(ownerName + " just withdrew: " + amount + ". New balance: " + balance);
        System.out.println();
    }
}



