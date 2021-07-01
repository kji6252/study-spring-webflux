package io.github.kji6252.stockquotes;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
public class QuoteController {

    private final QuoteGenerator quoteGenerator;

    @GetMapping(path = "/quotes", produces = MediaType.APPLICATION_NDJSON_VALUE)
    public Flux<Quote> streamQuotes() {
        return quoteGenerator.fetchQuoteStream();
    }

}
