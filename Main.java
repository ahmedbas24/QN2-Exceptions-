import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    // ===== Q2(a): mystery() method =====
    static int mystery() {
        try {
            System.out.println("A");
            return 1;
        } catch (Exception e) {
            System.out.println("B");
            return 2;
        } finally {
            System.out.println("C");
            return 3;
        }
    }

    // ===== Q2(b): risky() method =====
    static int risky(int x) {
        try {
            if (x == 0) throw new ArithmeticException();
            return 10 / x;
        } catch (ArithmeticException e) {
            System.out.println("caught");
            return -1;
        } finally {
            System.out.println("done");
        }
    }

    // ===== Q2(d): Try-with-resources demo =====
    static void readFileSafe() {
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            String line = br.readLine();
            System.out.println(line);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("===== QN2: Exceptions =====\n");

        // Part (a)
        System.out.println("--- Part (a): mystery() ---");
        int result = mystery();
        System.out.println("Returned value: " + result);

        // Part (b)
        System.out.println("\n--- Part (b): risky(0) ---");
        int r1 = risky(0);
        System.out.println("Returned: " + r1);

        System.out.println("\n--- Part (b): risky(2) ---");
        int r2 = risky(2);
        System.out.println("Returned: " + r2);

        // Part (c)
        System.out.println("\n--- Part (c): InsufficientFundsException ---");
        PaymentService ps = new PaymentService(50000);
        try {
            ps.withdraw(20000);
            ps.withdraw(40000); // this should throw
        } catch (InsufficientFundsException e) {
            System.out.println("Exception caught: " + e.getMessage());
            System.out.println("Deficit: UGX " + e.getDeficit());
        }

        // Part (d)
        System.out.println("\n--- Part (d): Try-with-resources ---");
        readFileSafe();
    }
}
