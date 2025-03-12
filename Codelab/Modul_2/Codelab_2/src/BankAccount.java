public class BankAccount {
    String accountNumber;
    String ownerName;
    double balance;

    public BankAccount(String accountName, String ownerName, double balance) {
        this.accountNumber = accountName;
        this.ownerName = ownerName;
        this.balance = balance;
    }

    public void displayInfo() {
        System.out.println("Account Number :" + accountNumber);
        System.out.println("Account Name :" + ownerName);
        System.out.println("Balance :" + balance);
        System.out.println();
    }

    public void depositMoney(double amount) {
        balance += amount;
        System.out.println(ownerName + " just deposit :" + amount + " your balance :" + balance);
    }

    public void withdrawMoney(double amount) {
        if (amount > balance) {
            System.out.println(ownerName + " just withdraw :" + amount + " Insufficient balance, please try again!");
            return;
        }

        balance -= amount;
        System.out.println(ownerName + " just withdraw :" + amount + " your balance :" + balance);
        System.out.println();
    }


}
