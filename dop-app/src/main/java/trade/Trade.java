package trade;

public sealed interface Trade permits Buy, Sell {
    void perform();
}
