package io.github.kji6252.stockdetails;

import java.time.Duration;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class TradingCompanyRunner implements ApplicationRunner {

    private final TradingCompanyRepository tradingCompanyRepository;

    @Override
    public void run(ApplicationArguments args) {
        List<TradingCompany> companies = List.of(
            new TradingCompany("Pivotal Software", "PVTL"),
            new TradingCompany("Dell Technologies", "DELL"),
            new TradingCompany("Google", "GOOG"),
            new TradingCompany("Microsoft", "MSFT"),
            new TradingCompany("Oracle", "ORCL"),
            new TradingCompany("Red Hat", "RHT"),
            new TradingCompany("Vmware", "VMW")
        );
        tradingCompanyRepository.insert(companies).blockLast(Duration.ofSeconds(30));
    }
}
