package latihan5_dip.bad;

public class PaymentService {

    private CardValidator cardValidator;
    private FraudDetector fraudDetector;
    private PaymentGateway paymentGateway;
    private TransactionLogger transactionLogger;
    private NotificationSender notificationSender;

    public PaymentService() {
        this.cardValidator = new CardValidator();
        this.fraudDetector = new FraudDetector();
        this.paymentGateway = new PaymentGateway();
        this.transactionLogger = new TransactionLogger();
        this.notificationSender = new NotificationSender();
    }

    public void processPayment(String cardNumber, double amount, String email) {
        System.out.println("[CardValidator] Validating card: " + cardNumber);
        if (!cardValidator.validate(cardNumber)) {
            System.out.println("[CardValidator] Card INVALID");
            return;
        }
        System.out.println("[CardValidator] Card is valid");

        System.out.println("[FraudDetector] Checking fraud for amount: " + amount);
        if (fraudDetector.isFraud(amount)) {
            System.out.println("[FraudDetector] Fraud detected! Payment cancelled");
            return;
        }
        System.out.println("[FraudDetector] No fraud detected");

        System.out.println("[PaymentGateway] Charging " + amount + " to card: " + cardNumber);
        String txnId = paymentGateway.charge(amount, cardNumber);
        System.out.println("[PaymentGateway] Payment successful - Transaction ID: " + txnId);

        System.out.println("[TransactionLogger] Logging transaction: " + txnId + ", Amount: " + amount + ", Status: SUCCESS");
        transactionLogger.log(txnId, amount);

        System.out.println("[NotificationSender] Sending notification to: " + email);
        notificationSender.send(email, "Payment Successful");
    }
}
