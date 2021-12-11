package blog.cybertricks.portfolio.financials;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("financials")
@AllArgsConstructor
public class FinancialsController {
    private FinancialsService financialsService;

    @GetMapping("{tickerId}")
    public ResponseEntity<List<Financials>> getFinancialDataForTicker(@PathVariable Long tickerId) {
        List<Financials> financials = financialsService.getFinancialDataForTicker(tickerId);
        return new ResponseEntity<>(financials, HttpStatus.OK);
    }
}
