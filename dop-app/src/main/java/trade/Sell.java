package trade;

public record Sell(String ticker, int quantity) implements Trade {
    @Override
    public void perform() {
        System.out.printf("Performing sell of ticker %s quantity %d%n", ticker, quantity);
    }
}
