package latihan5_dip;

public class DIPPractice {
    public static void main(String[] args) {
        /*
         * MAIN yang aman: tidak mengimpor kedua package secara langsung untuk menghindari
         * ambiguitas nama. Kita gunakan fully-qualified names.
         */

        // ===== PART 1: BAD PRACTICE - Melanggar DIP =====
        System.out.println("=== BAD PRACTICE: Melanggar DIP ===\n");

        latihan5_dip.bad.PaymentService badService = new latihan5_dip.bad.PaymentService();
        badService.processPayment("4532-1234-5678-9010", 150000.0, "user@example.com");

        System.out.println("\n--- Analisis Masalah ---");
        System.out.println("PaymentService TIGHTLY COUPLED dengan concrete classes:");
        System.out.println("1. new CardValidator() - depend on concrete class");
        System.out.println("2. new FraudDetector() - depend on concrete class");
        System.out.println("3. new PaymentGateway() - depend on concrete class");
        System.out.println("4. new TransactionLogger() - depend on concrete class");
        System.out.println("5. new NotificationSender() - depend on concrete class");
        System.out.println("\nMasalah:");
        System.out.println("✗ Hard to test (tidak bisa mock)");
        System.out.println("✗ Hard to extend (ganti gateway harus ubah PaymentService)");
        System.out.println("✗ Hard to reuse (terikat implementasi tertentu)");
        System.out.println("✗ Tight coupling");
        System.out.println("✗ Tidak bisa swap Stripe → PayPal tanpa ubah code");

        System.out.println("\n" + "=".repeat(70));

        // ===== PART 2: GOOD PRACTICE - Mengikuti DIP =====
        System.out.println("\n=== GOOD PRACTICE: Mengikuti DIP ===\n");

        // Setup 1: Stripe
        System.out.println("--- Setup 1: Stripe Payment Gateway ---");

        // create abstractions' implementations (fully-qualified to avoid ambiguity)
        latihan5_dip.good.CardValidator cardValidator = new latihan5_dip.good.LuhnCardValidator();
        latihan5_dip.good.FraudDetector fraudDetector = new latihan5_dip.good.RuleBasedFraudDetector();
        latihan5_dip.good.PaymentGateway stripeGateway = new latihan5_dip.good.StripePaymentGateway();
        latihan5_dip.good.TransactionLogger transactionLogger = new latihan5_dip.good.DatabaseTransactionLogger();
        latihan5_dip.good.NotificationSender notificationSender = new latihan5_dip.good.EmailNotificationSender();

        // inject dependencies into the good PaymentService
        latihan5_dip.good.PaymentService stripePaymentService = new latihan5_dip.good.PaymentService(
                cardValidator,
                fraudDetector,
                stripeGateway,
                transactionLogger,
                notificationSender
        );

        stripePaymentService.processPayment("4532-1234-5678-9010", 150000.0, "user@example.com");

        System.out.println("\n" + "=".repeat(70));
        System.out.println("\n--- Keuntungan Setelah Refactoring ---");
        System.out.println("✓ Loose coupling");
        System.out.println("✓ Easy to test");
        System.out.println("✓ Flexible");
        System.out.println("✓ Reusable");
        System.out.println("✓ Follow DIP");
        System.out.println("✓ Open for extension");
    }
}
