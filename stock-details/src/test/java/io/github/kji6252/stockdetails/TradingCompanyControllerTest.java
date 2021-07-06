package io.github.kji6252.stockdetails;

import static org.mockito.BDDMockito.given;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@WebFluxTest(TradingCompanyController.class)
class TradingCompanyControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @MockBean
    private TradingCompanyRepository tradingCompanyRepository;

    @Test
    void findByTicker() {
        // given
        TradingCompany soo = new TradingCompany("1", "The Sooshi Company", "SOO");
        given(tradingCompanyRepository.findByTicker("SOO")).willReturn(Mono.just(soo));
        // when
        // then
        webTestClient.get().uri("/details/SOO").accept(MediaType.APPLICATION_JSON)
                     .exchange()
                     .expectBody(TradingCompany.class)
                     .isEqualTo(soo);
    }

    @Test
    void findAll() {
        // given
        TradingCompany soo = new TradingCompany("1", "The Sooshi Company", "SOO");
        TradingCompany pizza = new TradingCompany("2", "Pizza & friends", "PIZZA");

        given(tradingCompanyRepository.findAll()).willReturn(Flux.just(soo, pizza));

        // when
        // then
        webTestClient.get().uri("/details").accept(MediaType.APPLICATION_JSON)
                     .exchange()
                     .expectBodyList(TradingCompany.class)
                     .hasSize(2)
                     .contains(soo, pizza);
    }
}