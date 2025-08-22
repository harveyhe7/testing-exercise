public class Account {
    private final String id;
    private double balance;

    public Account(String id, double balance) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Account id cannot be null or empty");
        }
        if (balance < 0) {
            throw new IllegalArgumentException("Initial balance cannot be negative");
        }
        this.id = id;
        this.balance = balance;
    }

    public String getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Deposit amount must be positive");
        }
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Withdraw amount must be positive");
        }
        if (balance < amount) {
            throw new IllegalStateException("Insufficient balance");
        }
        balance -= amount;
    }
}
