import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Item {

    private String name;
    private int stock;

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_MAGENTA = "\u001B[35m";

    public Item(String name, int stock) {
        this.name = name;
        this.stock = stock;
    }

    public Item() {

    }

    ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String toString() {
        return "Item Name: " + name + ", Stock: " + stock;
    }

    public static Item addItem(Scanner input) {
        System.out.print("Enter new item: ");
        input.nextLine();
        String name = input.nextLine();

        System.out.print("Enter new stock: ");
        int stock = input.nextInt();

        System.out.println("Item " + ANSI_MAGENTA + name + ANSI_RESET + " added to stock ");
        System.out.println();
        return new Item(name, stock);
    }

    public static void reduceItem(Scanner input, ArrayList<Item> itemsList) {
        if (itemsList.isEmpty()) {
            System.out.println("Items list is empty");
            return;
        }

        System.out.print("---- Available Items ----");
        System.out.println();
        int index = 1;
        for (Item item : itemsList) {
            System.out.println(index + ". " + item);
            index++;
        }


        try {
            System.out.print("Select an item to reduce: ");
            int itemIndex = input.nextInt() - 1;

            if (itemIndex < 0 || itemIndex >= itemsList.size()) {
                throw new IndexOutOfBoundsException("Invalid index");
            }

            Item selectedItem = itemsList.get(itemIndex);

            System.out.print("Enter amount to reduce: ");
            int reduceAmount = input.nextInt();

            if (reduceAmount <= 0) {
                System.out.println("Invalid amount");
                return;
            }
            if (reduceAmount > selectedItem.getStock()) {
                throw new InsufficientStockException("Stock only available for: " + selectedItem.getName() + ", cannot reduce for: " + reduceAmount);
            }
            int newStock = selectedItem.getStock() - reduceAmount;

            if (newStock <= 0) {
                itemsList.remove(itemIndex);
                System.out.println("Stock reduced to 0. Item " + ANSI_MAGENTA + selectedItem.getName() + ANSI_RESET + " removed from stock ");
            } else {
                selectedItem.setStock(newStock);
                System.out.println("Stock updated. New stock for: " + selectedItem.getName() + "': " + newStock);
            }

        } catch (InputMismatchException e) {
            System.out.println("Invalid input, please enter the correct number: ");
            System.out.println();
            input.nextLine();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println();
        } catch (InsufficientStockException e) {
            System.out.println("Error: " + e.getMessage());
            System.out.println();
        }

    }
}
