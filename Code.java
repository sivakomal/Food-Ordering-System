import java.io.*;
import java.util.*;

public class FoodOrderingSystem {
    private static final String MENU_FILE = "/Users/vedadhulipalla/Desktop/food_app/menu.txt";
    private static final String ORDERS_FILE = "/Users/vedadhulipalla/Desktop/food_app/orders.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<FoodItem> menu = loadMenuFromFile(MENU_FILE);

        System.out.println("Welcome to the Food Ordering System!");

        while (true) {
            displayMenu(menu);
            System.out.println("Enter the item number to order (or 'exit' to quit):");
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("exit")) {
                break;
            }

            int itemNumber;
            try {
                itemNumber = Integer.parseInt(choice);
            } catch (NumberFormatException e) {
                System.out.println("Invalid item number. Please try again.");
                continue;
            }

            if (itemNumber < 1 || itemNumber > menu.size()) {
                System.out.println("Invalid item number. Please try again.");
                continue;
            }

            FoodItem selectedFood = menu.get(itemNumber - 1);

            System.out.println("Enter the quantity:");
            int quantity = scanner.nextInt();
            scanner.nextLine(); // Consume the remaining newline character

            double orderTotal = selectedFood.getPrice() * quantity;

            System.out.println("Order details:");
            System.out.println("Food Item: " + selectedFood.getName());
            System.out.println("Quantity: " + quantity);
            System.out.println("Total Bill: $" + orderTotal);

            // Write the order to the file
            writeOrderToFile(ORDERS_FILE, selectedFood, quantity);

            System.out.println("Order placed successfully!");
            System.out.println("-------------------------");
        }

        System.out.println("Thank you for using the Food Ordering System!");
    }

    private static List<FoodItem> loadMenuFromFile(String fileName) {
        List<FoodItem> menu = new ArrayList<>();

        try (Scanner fileScanner = new Scanner(new File(fileName))) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");
                String name = parts[0];
                double price = Double.parseDouble(parts[1]);
                menu.add(new FoodItem(name, price));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Menu file not found.");
        }

        return menu;
    }

    private static void displayMenu(List<FoodItem> menu) {
        System.out.println("Menu:");
        for (int i = 0; i < menu.size(); i++) {
            FoodItem foodItem = menu.get(i);
            System.out.println((i + 1) + ". " + foodItem.getName() + " - $" + foodItem.getPrice());
        }
    }

    private static void writeOrderToFile(String fileName, FoodItem foodItem, int quantity) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            writer.write(foodItem.getName() + "," + quantity + "," + foodItem.getPrice());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("An error occurred while writing the order to the file.");
        }
    }
}

class FoodItem {
    private String name;
    private double price;

    public FoodItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }
}
