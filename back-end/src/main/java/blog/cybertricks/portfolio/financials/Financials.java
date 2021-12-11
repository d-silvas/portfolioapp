package blog.cybertricks.portfolio.financials;

import blog.cybertricks.portfolio.balancesheet.BalanceSheetEntry;
import blog.cybertricks.portfolio.financialstatement.FinancialStatementPeriod;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class Financials {
    private FinancialStatementPeriod period;
    private LocalDate fiscalDateEnding;
    private List<BalanceSheetEntry> balanceSheetEntries;
    private FinancialsDerivedData financialsDerivedData;
}
