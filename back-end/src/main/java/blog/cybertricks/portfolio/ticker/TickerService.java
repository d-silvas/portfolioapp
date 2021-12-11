package blog.cybertricks.portfolio.ticker;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TickerService {
    private final TickerRepository tickerRepository;

    public List<Ticker> findAll() {
        return tickerRepository.findAll();
    }
}
