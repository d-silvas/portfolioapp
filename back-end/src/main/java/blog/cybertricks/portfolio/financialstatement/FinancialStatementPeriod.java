package blog.cybertricks.portfolio.financialstatement;

public enum FinancialStatementPeriod {
    FULL("full"), Q1("q1"), Q2("q2"), Q3("q3"), Q4("q4");

    private final String period;

    FinancialStatementPeriod(String period) {
        this.period = period;
    }

    public String getPeriod() {
        return period;
    }
}