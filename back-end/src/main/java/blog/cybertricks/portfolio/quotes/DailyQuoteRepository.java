package blog.cybertricks.portfolio.quotes;

import blog.cybertricks.portfolio.ticker.Ticker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface DailyQuoteRepository extends JpaRepository<DailyQuote, Long> {
    @Query("SELECT q from DailyQuote q WHERE q.ticker = ?1 AND q.date = ?2")
    Optional<DailyQuote> findByTickerAndDate(Ticker ticker, LocalDate date);

    @Query("SELECT q from DailyQuote q WHERE q.ticker = ?1 AND q.date BETWEEN ?2 AND ?3")
    Optional<List<DailyQuote>> findAllByTickerAndDateBetween(Ticker ticker, LocalDate startDate, LocalDate endDate);

    Optional<List<DailyQuote>> findAllByTicker(Ticker ticker);
}
