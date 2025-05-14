import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Item> itemList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

//        Item item1 = new Item("Neon Genesis Evangelion (Collector Edition)", 4);
//        Item item2 = new Item("Slam Dunk (New Paper)", 30);
//
//        itemList.add(item1);
//        itemList.add(item2);

        int choice;
        do {

            System.out.println("---- STOCK MANAGEMENT MENU ----");
            System.out.println("1. Add new item");
            System.out.println("2. Display items");
            System.out.println("3. Delete item");
            System.out.println("0. Exit program");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Item newItem = Item.addItem(scanner);
                    itemList.add(newItem);
                    break;
                case 2:
                    System.out.println("---- ITEM LIST ----");
                    if (itemList.isEmpty()) {
                        System.out.println("No items available.");
                        System.out.println();
                        break;
                    }
                    int index = 1;
                    for (Item item : itemList) {
                        System.out.println(index + ". " + item);
                        index++;
                    }
                    System.out.println();
                    break;
                case 3:
                    Item.reduceItem(scanner, itemList);
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        } while (choice != 0);
        scanner.close();
    }
}
