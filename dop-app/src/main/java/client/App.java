package client;

import orders.OrderProcessor;
import payments.CreditCard;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        var orderPRocessor = new OrderProcessor();
        orderPRocessor.processOrder(new CreditCard());
        System.out.println("Order has been successfully processed!");
    }
}
