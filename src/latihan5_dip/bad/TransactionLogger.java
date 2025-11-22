package latihan5_dip.bad;

public class TransactionLogger {
    public void log(String transactionId, double amount) {
        System.out.println("  [DB] Saved transaction");
    }
}
