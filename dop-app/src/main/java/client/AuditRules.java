package client;

import trade.Buy;
import trade.Sell;
import trade.Trade;

public class AuditRules {
    public static void audit(Trade trade) {
        //trade-package is provided by third parties, we cannot modify its classes
        var message = switch (trade){
            case Buy buy when buy.quantity() > 5000 -> "audit the buy...";
            //case Buy(_, var quantity) when quantity > 5000 -> "audit the buy..."; //This is for Java 22+
            case Buy buy -> "";

            case Sell sell when sell.quantity() > 10000 -> "audit the sell...";
            //case Sell(_, var quantity) when quantity > 10000 -> "audit the buy..."; //This is for Java 22+
            case Sell  sell -> "";
            //default -> "Invalid trade type"; //Recommendation: skip default here
        };
        System.out.println(message);
    }
}
