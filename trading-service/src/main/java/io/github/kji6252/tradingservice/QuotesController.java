package io.github.kji6252.tradingservice;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@RestController
public class QuotesController {

    private final TradingCompanyClient tradingCompanyClient;
    private final QuoteClient quoteClient;

    @GetMapping("/quotes/feed")
    public Flux<Quote> quotesFeed() {
        return quoteClient.quotesFeed();
    }

    @GetMapping(value = "/quotes/summary/{ticker}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<TradingCompanySummary> quotesDetails(@PathVariable String ticker) {
        return tradingCompanyClient.getTradingCompany(ticker)
                                   .zipWith(quoteClient.getLatestQuote(ticker),
                                            TradingCompanySummary::new);
    }

}
