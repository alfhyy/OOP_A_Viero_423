public class Main {
    public static void main(String[] args) {

        //importing another class named BankAccount and split into two variables named
        BankAccount bankAccount1 = new BankAccount("202410370110423", "Viero", 5000000);
        BankAccount bankAccount2 = new BankAccount("202410370110506", "Opan", 4000000);

        //calling the methods to display, deposit and withdraw for 1st person
        bankAccount1.displayInfo();
        bankAccount1.depositMoney(400000);
        bankAccount1.withdrawMoney(1000);

        //calling the methods to display, deposit and withdraw for 2nd person
        bankAccount2.displayInfo();
        bankAccount2.depositMoney(300000);
        bankAccount2.withdrawMoney(300000000);
    }
}
