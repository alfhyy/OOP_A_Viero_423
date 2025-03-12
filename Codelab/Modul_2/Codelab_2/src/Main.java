public class Main {
    public static void main(String[] args) {

        BankAccount bankAccount1 = new BankAccount("202410370110423", "Viero", 5000000);
        BankAccount bankAccount2 = new BankAccount("202410370110506", "Opan", 4000000);

        bankAccount1.displayInfo();
        bankAccount1.depositMoney(400000);
        bankAccount1.withdrawMoney(1000);

        bankAccount2.displayInfo();
        bankAccount2.depositMoney(300000);
        bankAccount2.withdrawMoney(300000000);
    }
}
