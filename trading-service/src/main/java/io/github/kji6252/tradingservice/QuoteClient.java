package io.github.kji6252.tradingservice;

import java.time.Duration;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class QuoteClient {

    private final WebClient webClient;

    public QuoteClient(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("http://127.0.0.1:8081").build();
    }

    public Flux<Quote> quotesFeed() {
        return webClient.get()
                        .uri("/quotes")
                        .accept(MediaType.APPLICATION_NDJSON)
                        .retrieve()
                        .bodyToFlux(Quote.class);
    }

    public Mono<Quote> getLatestQuote(String ticker) {
        return quotesFeed().filter(q -> q.getTicker().equalsIgnoreCase(ticker))
                           .next()
                           .timeout(Duration.ofSeconds(2), Mono.just(new Quote(ticker)));
    }
}
