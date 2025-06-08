package trade;

public record Buy(String ticker, int quantity) implements Trade {
    @Override
    public void perform() {
        System.out.printf("Performing buy of ticker %s quantity %d%n", ticker, quantity);
    }
}
