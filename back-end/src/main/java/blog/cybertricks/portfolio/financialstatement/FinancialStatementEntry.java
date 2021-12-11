package blog.cybertricks.portfolio.financialstatement;

public interface FinancialStatementEntry {
    FinancialStatementEntryAttribute getAttribute();

    Double getValue();

    String getNotes();
}
