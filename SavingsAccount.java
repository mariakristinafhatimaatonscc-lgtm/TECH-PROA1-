public class SavingsAccount extends BankAccount {
    private double interestRate;

    // Constructor
    public SavingsAccount(String username, int pin) {
        super(username, pin);
        this.interestRate = 0.02; // 2% interest rate example
    }

    // Example of subclass-specific method
    public void addInterest() {
        int newBalance = (int)(getBalance() + getBalance() * interestRate);
        setBalance(newBalance);
    }
}
