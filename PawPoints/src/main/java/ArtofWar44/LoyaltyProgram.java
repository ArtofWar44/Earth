package ArtofWar44;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LoyaltyProgram {
    private Map<String, com.ArtofWar44.Customer> customers;
    private Scanner scanner;

    public LoyaltyProgram() {
        customers = new HashMap<>();
        scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            System.out.println("Welcome to Gray Skies Cafe Paw Points!");
            System.out.println("1. Add Purchase");
            System.out.println("2. Check Loyalty Status");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addPurchase();
                    break;
                case 2:
                    checkLoyaltyStatus();
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void addPurchase() {
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();
        com.ArtofWar44.Customer customer = customers.getOrDefault(name, new com.ArtofWar44.Customer(name));
        customer.addPurchase();
        customers.put(name, customer);
        System.out.println("Purchase added for " + name);
    }

    private void checkLoyaltyStatus() {
        System.out.print("Enter customer name: ");
        String name = scanner.nextLine();
        com.ArtofWar44.Customer customer = customers.get(name);

        if (customer == null) {
            System.out.println("No records found for " + name);
        } else {
            String message = customer.getName() + " has made " + customer.getPurchases() + " purchases.";
            if (customer.isEligibleForReward()) {
                message += " Congratulations! You have earned a free select menu item for your dog!";
            }
            System.out.println(message);
        }
    }
}
