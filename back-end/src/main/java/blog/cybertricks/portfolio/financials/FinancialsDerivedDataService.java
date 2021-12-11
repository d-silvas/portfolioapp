package blog.cybertricks.portfolio.financials;

import blog.cybertricks.portfolio.balancesheet.BalanceSheetEntry;
import blog.cybertricks.portfolio.quotes.DailyQuote;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinancialsDerivedDataService {
    FinancialsDerivedData getFinancialsDerivedData(
            List<BalanceSheetEntry> balanceSheetEntries,
            List<DailyQuote> dailyQuotes
    ) {
        FinancialsDerivedData financialsDerivedData = new FinancialsDerivedData();

        double dividendsPaid = 0D;
        double closingPricesSum = 0D;
        int totalDays = 0;
        double minPrice = dailyQuotes.get(0).getAdjustedClose();
        double maxPrice = 0D;

        for (DailyQuote dailyQuote : dailyQuotes) {
            totalDays += 1;
            double closingPrice = dailyQuote.getAdjustedClose();
            closingPricesSum = closingPricesSum + closingPrice;
            dividendsPaid = dividendsPaid + dailyQuote.getDividendAmount();
            minPrice = Math.min(minPrice, closingPrice);
            maxPrice = Math.max(maxPrice, closingPrice);
        }

        financialsDerivedData.setDividendsPaid(dividendsPaid);
        financialsDerivedData.setMaxPrice(maxPrice);
        financialsDerivedData.setMinPrice(minPrice);
        financialsDerivedData.setAveragePrice(closingPricesSum / totalDays);

        return financialsDerivedData;
    }
}
