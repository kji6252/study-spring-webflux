package io.github.kji6252.tradingservice;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class TradingCompanyClient {

    private final WebClient webClient;

    public TradingCompanyClient(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("http://127.0.0.1:8082").build();
    }

    public Flux<TradingCompany> findAllCompanies() {
        return webClient.get()
                        .uri("/details")
                        .accept(MediaType.APPLICATION_JSON)
                        .retrieve()
                        .bodyToFlux(TradingCompany.class);
    }

    public Mono<TradingCompany> getTradingCompany(String ticker) {
        return webClient.get()
                        .uri("/details/{ticker}", ticker)
                        .accept(MediaType.APPLICATION_JSON)
                        .retrieve()
                        .bodyToMono(TradingCompany.class)
                        .switchIfEmpty(
                            Mono.error(new TickerNotFoundException("Unknown Ticker: " + ticker)));
    }

}
