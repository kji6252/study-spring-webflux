package io.github.kji6252.stockquotes;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class StockQuotesApplicationTests {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void fetchQuotes() {
        List<Quote> result = webTestClient
            .get().uri("/quotes")
            .accept(MediaType.APPLICATION_NDJSON)
            .exchange()
            .expectStatus().isOk()
            .expectHeader().contentType(MediaType.APPLICATION_NDJSON_VALUE)
            .returnResult(Quote.class)
            .getResponseBody()
            .take(20)
            .collectList()
            .block();

        assertThat(result).allSatisfy(quote -> assertThat(quote.getPrice()).isPositive());
    }

}
