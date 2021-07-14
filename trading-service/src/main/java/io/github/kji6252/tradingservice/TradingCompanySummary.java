package io.github.kji6252.tradingservice;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TradingCompanySummary {

    private final TradingCompany tradingCompany;
    private final Quote latestQuote;
}
