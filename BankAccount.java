public class BankAccount {
    private String username;
    private int pin;
    private int balance;

    // Constructor
    public BankAccount(String username, int pin) {
        this.username = username;
        this.pin = pin;
        this.balance = 0;
    }

    // Encapsulation: getters and setters
    public String getUsername() {
        return username;
    }

    public int getPin() {
        return pin;
    }

    public int getBalance() {
        return balance;
    }

    protected void setBalance(int balance) {
        this.balance = balance;
    }

    // Methods
    public boolean checkPIN(int enteredPin) {
        return this.pin == enteredPin;
    }

    public void deposit(int amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    public boolean withdraw(int amount) {
        if (amount > balance) {
            return false;
        }
        balance -= amount;
        return true;
    }
}
