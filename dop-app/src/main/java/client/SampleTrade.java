package client;

import trade.Buy;
import trade.Sell;
import trade.Trade;

public class SampleTrade {
    public static void main(String[] args) {
        processTrade(new Buy("Product1", 200));
        processTrade(new Buy("Product2", 30000));

        processTrade(new Sell("Product1", 300));
        processTrade(new Sell("Product2", 50000));

    }

    private static void processTrade(Trade trade) {
        AuditRules.audit(trade);
        trade.perform();
    }
}
