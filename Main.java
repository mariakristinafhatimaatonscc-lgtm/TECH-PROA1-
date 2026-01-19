import java.util.HashMap;
import java.util.Scanner;

public class Main {
    private static HashMap<String, SavingsAccount> users = new HashMap<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("==========================");
        System.out.println("     Alia and Carla System");
        System.out.println("==========================");

        if (!registration()) {
            System.out.println("Registration failed. Exiting app...");
            return;
        }

        login();
    }

    // Registration method
    private static boolean registration() {
        System.out.print("Do you have an account? (yes/no): ");
        String ans = sc.nextLine().trim().toLowerCase();

        if (ans.equals("yes")) {
            if (users.isEmpty()) {
                System.out.println("No accounts exist yet. Please register first.\n");
                return doRegistration();
            }
            return true;
        }
        else if (ans.equals("no")) {
            return doRegistration();
        }

        System.out.println("Invalid input.");
        return false;
    }

    private static boolean doRegistration() {
        System.out.println("==== Registration ====");
        System.out.print("Enter Username: ");
        String username = sc.nextLine();

        System.out.print("Enter PIN (4 digits): ");
        String pinStr = sc.nextLine();

        if (!pinStr.matches("\\d{4}")) {
            System.out.println("PIN must be exactly 4 digits.");
            return false;
        }

        int pin = Integer.parseInt(pinStr);

        if (users.containsKey(username)) {
            System.out.println("Username already exists! Try again.");
            return false;
        }

        // Create SavingsAccount object
        users.put(username, new SavingsAccount(username, pin));
        System.out.println("Registration successful! Please login.");
        return true;
    }

    // Login method
    private static void login() {
        while (true) {
            System.out.println("==== Login ====");
            System.out.print("Username: ");
            String username = sc.nextLine();

            System.out.print("PIN: ");
            String pinStr = sc.nextLine();

            if (!pinStr.matches("\\d{4}")) {
                System.out.println("PIN must be exactly 4 digits.\n");
                continue;
            }

            int pin = Integer.parseInt(pinStr);

            if (users.containsKey(username)) {
                SavingsAccount acc = users.get(username);

                if (acc.checkPIN(pin)) {
                    System.out.println("Login successful! Welcome to Alia and Carla System.");
                    mainMenu(acc);
                    return;
                }
            }

            System.out.println("Incorrect username or PIN. Please try again.\n");
        }
    }

    // Main menu
    private static void mainMenu(SavingsAccount acc) {
        while (true) {
            System.out.println("\n===== MAIN MENU =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Add Interest");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            String choiceStr = sc.nextLine();
            if (!choiceStr.matches("\\d")) {
                System.out.println("Invalid input. Enter a number.");
                continue;
            }

            int choice = Integer.parseInt(choiceStr);

            switch (choice) {
                case 1:
                    System.out.println("Your balance is: PHP " + acc.getBalance());
                    break;
                case 2:
                    System.out.print("Enter amount to deposit: ");
                    int dep = Integer.parseInt(sc.nextLine());
                    acc.deposit(dep);
                    System.out.println("Deposit successful.");
                    break;
                case 3:
                    System.out.print("Enter amount to withdraw: ");
                    int wit = Integer.parseInt(sc.nextLine());
                    if (acc.withdraw(wit)) {
                        System.out.println("Withdrawal successful.");
                    } else {
                        System.out.println("Insufficient balance!");
                    }
                    break;
                case 4:
                    acc.addInterest();
                    System.out.println("Interest added! New balance: PHP " + acc.getBalance());
                    break;
                case 5:
                    System.out.println("Thank you for using Alia and Carla System.");
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
