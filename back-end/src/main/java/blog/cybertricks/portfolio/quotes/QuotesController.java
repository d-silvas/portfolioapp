package blog.cybertricks.portfolio.quotes;

import com.crazzyghost.alphavantage.timeseries.response.TimeSeriesResponse;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("quotes")
@AllArgsConstructor
public class QuotesController {
    private final QuotesService quotesService;

    @GetMapping
    public ResponseEntity<TimeSeriesResponse> getAllQuotes() {
        TimeSeriesResponse quotes = quotesService.test();
        return new ResponseEntity<>(quotes, HttpStatus.OK);
    }
}
