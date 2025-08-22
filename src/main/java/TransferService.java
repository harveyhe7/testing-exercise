public class TransferService {

    public void transfer(Account from, Account to, double amount) {
        if (from == null || to == null) {
            throw new IllegalArgumentException("Accounts cannot be null");
        }
        if (amount < 0) {
            throw new IllegalArgumentException("Transfer amount must be positive");
        }

        from.withdraw(amount);
        to.deposit(amount);
    }
}
