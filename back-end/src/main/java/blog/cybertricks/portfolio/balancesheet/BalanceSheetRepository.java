package blog.cybertricks.portfolio.balancesheet;

import blog.cybertricks.portfolio.ticker.Ticker;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BalanceSheetRepository extends JpaRepository<BalanceSheet, Long> {
    Optional<List<BalanceSheet>> findAllByTicker(Ticker ticker);
}
