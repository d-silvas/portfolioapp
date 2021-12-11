package blog.cybertricks.portfolio.quotes;

import blog.cybertricks.portfolio.ticker.Ticker;
import blog.cybertricks.portfolio.ticker.TickerRepository;
import com.crazzyghost.alphavantage.AlphaVantage;
import com.crazzyghost.alphavantage.Config;
import com.crazzyghost.alphavantage.parameters.OutputSize;
import com.crazzyghost.alphavantage.timeseries.response.StockUnit;
import com.crazzyghost.alphavantage.timeseries.response.TimeSeriesResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Optional;

@Service
@PropertySource("classpath:/apikeys.properties")
public class QuotesService {
    private final DailyQuoteRepository dailyQuoteRepository;

    private final TickerRepository tickerRepository;

    @Autowired
    QuotesService(Environment env, DailyQuoteRepository dailyQuoteRepository, TickerRepository tickerRepository) {
        this.dailyQuoteRepository = dailyQuoteRepository;
        this.tickerRepository = tickerRepository;

        Config cfg = Config.builder().key(env.getProperty("alphavantage")).timeOut(10).build();
        AlphaVantage.api().init(cfg);
    }

    TimeSeriesResponse test() {
        // TODO: TODO
        String symbol = "INTC";
        Optional<Ticker> ticker = this.tickerRepository.findBySymbol(symbol);
        if (ticker.isEmpty()) {
            return null;
        }
        System.out.println(ticker.get());
        System.out.println(ticker.get().getSymbol());
        ZoneId zoneId = ZoneId.of("America/New_York");

        TimeSeriesResponse response = AlphaVantage.api()
                .timeSeries()
                .daily()
                .adjusted()
                .forSymbol(symbol)
                .outputSize(OutputSize.FULL)
                .fetchSync();
        for (StockUnit stockUnit : response.getStockUnits()) {
            LocalDate date = LocalDateTime.parse(stockUnit.getDate() + "T00:00:00").atZone(zoneId).toLocalDate();
            Optional<DailyQuote> dailyQuote = this.dailyQuoteRepository.findByTickerAndDate(ticker.get(), date);
            if (dailyQuote.isPresent()) {
                break;
            }
            DailyQuote newDailyQuote = new DailyQuote(
                    ticker.get(),
                    date,
                    stockUnit.getOpen(),
                    stockUnit.getHigh(),
                    stockUnit.getLow(),
                    stockUnit.getClose(),
                    stockUnit.getAdjustedClose(),
                    stockUnit.getVolume(),
                    stockUnit.getDividendAmount(),
                    stockUnit.getSplitCoefficient());
            dailyQuoteRepository.save(newDailyQuote);
        }
        return response;
    }
}
