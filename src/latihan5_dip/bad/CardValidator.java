package latihan5_dip.bad;

public class CardValidator {
    public boolean validate(String cardNumber) {
        return cardNumber != null && cardNumber.length() == 19;
    }
}
