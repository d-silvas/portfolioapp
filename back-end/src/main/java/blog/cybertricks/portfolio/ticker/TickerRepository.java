package blog.cybertricks.portfolio.ticker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface TickerRepository extends JpaRepository<Ticker, Long> {
    @Query("SELECT t from Ticker t WHERE t.symbol = ?1")
    Optional<Ticker> findBySymbol(String symbol);
}
