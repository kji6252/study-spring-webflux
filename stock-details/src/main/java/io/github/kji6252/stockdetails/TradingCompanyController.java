package io.github.kji6252.stockdetails;

import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class TradingCompanyController {

    private final TradingCompanyRepository tradingCompanyRepository;


    @GetMapping("/details/{ticker}")
    public Mono<TradingCompany> findByTicker(@PathVariable String ticker) {
        return tradingCompanyRepository.findByTicker(ticker);
    }

    @GetMapping("/details")
    public Flux<TradingCompany> findAll() {
        return tradingCompanyRepository.findAll();
    }
}
