package blog.cybertricks.portfolio.balancesheet;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("balance-sheets")
@AllArgsConstructor
public class BalanceSheetController {
    private final BalanceSheetService balanceSheetService;

    @GetMapping
    public ResponseEntity<List<BalanceSheet>> getAllBalanceSheets() {
        List<BalanceSheet> balanceSheets = balanceSheetService.findAll();
        System.out.println(balanceSheets.get(0).getTicker().getSymbol());
        return new ResponseEntity<>(balanceSheets, HttpStatus.OK);
    }
}
