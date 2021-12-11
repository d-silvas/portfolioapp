package blog.cybertricks.portfolio.financials;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
class FinancialsDerivedData {
    private Double dividendsPaid;
    private Double averagePrice;
    private Double minPrice;
    private Double maxPrice;
}
