package orders;

public class OrderProcessor {
    public void processOrder(PaymentMethod method) {
        method.pay(10);
    }
}
