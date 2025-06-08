package payments;

import orders.PaymentMethod;

public class CreditCard implements PaymentMethod {
    private void charge(int amount) {
        System.out.println("Charging " + amount + " credit card");
    }
    @Override
    public void pay(int amountInCents) {
        charge(amountInCents);
    }
}
