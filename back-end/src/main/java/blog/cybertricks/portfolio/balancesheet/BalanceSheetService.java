package blog.cybertricks.portfolio.balancesheet;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BalanceSheetService {
    private final BalanceSheetRepository balanceSheetRepository;

    public List<BalanceSheet> findAll() {
        return balanceSheetRepository.findAll();
    }
}
