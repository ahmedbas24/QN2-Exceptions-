public class PaymentService {
    private double balance;

    public PaymentService(double balance) {
        this.balance = balance;
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException(amount - balance);
        }
        balance -= amount;
        System.out.println("Withdrawal successful. Remaining balance: UGX " + balance);
    }
}
