public class InsufficientFundsException extends Exception {
    private double deficit;

    public InsufficientFundsException(double deficit) {
        super("Insufficient funds. You are short by UGX " + deficit);
        this.deficit = deficit;
    }

    public double getDeficit() {
        return deficit;
    }
}
