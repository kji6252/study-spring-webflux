package io.github.kji6252.tradingservice;

public class TickerNotFoundException extends RuntimeException {

    public TickerNotFoundException(String message) {
        super(message);
    }
}
