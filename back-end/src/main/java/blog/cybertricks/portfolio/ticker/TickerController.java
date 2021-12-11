package blog.cybertricks.portfolio.ticker;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("tickers")
@AllArgsConstructor
public class TickerController {
    private final TickerService tickerService;

    @GetMapping
    @JsonView(TickerViews.Public.class)
    public ResponseEntity<List<Ticker>> getAllTickers() {
        List<Ticker> tickers = tickerService.findAll();
        return new ResponseEntity<>(tickers, HttpStatus.OK);
    }
}
