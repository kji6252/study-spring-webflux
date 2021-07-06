package io.github.kji6252.stockdetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document
public class TradingCompany {

    @Id
    private String id;
    private String description;
    private String ticker;

    public TradingCompany(String description, String ticker) {
        this.description = description;
        this.ticker = ticker;
    }
}
