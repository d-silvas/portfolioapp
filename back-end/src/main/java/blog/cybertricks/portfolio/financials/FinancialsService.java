package blog.cybertricks.portfolio.financials;

import blog.cybertricks.portfolio.balancesheet.BalanceSheet;
import blog.cybertricks.portfolio.balancesheet.BalanceSheetRepository;
import blog.cybertricks.portfolio.quotes.DailyQuoteRepository;
import blog.cybertricks.portfolio.ticker.Ticker;
import blog.cybertricks.portfolio.ticker.TickerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class FinancialsService {
    private TickerRepository tickerRepository;
    private BalanceSheetRepository balanceSheetRepository;
    private DailyQuoteRepository dailyQuoteRepository;
    private FinancialsDerivedDataService financialsDerivedDataService;

    List<Financials> getFinancialDataForTicker(Long tickerId) {
        Ticker ticker = tickerRepository.findById(tickerId).orElse(null);
        List<BalanceSheet> balanceSheetList = balanceSheetRepository.findAllByTicker(ticker).orElse(new ArrayList<>());
        List<Financials> financialsList = new ArrayList<>();
        // Leaning on Balance Sheet list to calculate the rest
        for (BalanceSheet balanceSheet : balanceSheetList) {
            LocalDate fiscalDateEnding = balanceSheet.getFiscalDateEnding();
            financialsList.add(new Financials(
                    balanceSheet.getPeriod(),
                    fiscalDateEnding,
                    balanceSheet.getEntries(),
                    financialsDerivedDataService.getFinancialsDerivedData(
                            balanceSheet.getEntries(),
                            dailyQuoteRepository.findAllByTickerAndDateBetween(
                                    ticker,
                                    // ASSUMING 1 YEAR !!!!
                                    fiscalDateEnding.minusYears(1),
                                    fiscalDateEnding
                            ).orElse(new ArrayList<>())
                    )
            ));
        }
        return financialsList;
    }
}
