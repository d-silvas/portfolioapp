package blog.cybertricks.portfolio.balancesheet;

import blog.cybertricks.portfolio.financialstatement.FinancialStatementEntryAttribute;

public enum BalanceSheetEntryAttribute implements FinancialStatementEntryAttribute {
    CASH_AND_CASH_EQUIVALENTS("cash_and_cash_equivalents"),
    SHORT_TERM_INVESTMENTS("short_term_investments"),
    TRADING_ASSETS("trading_assets"),
    ACCOUNTS_RECEIVABLE("accounts_receivable"),
    INVENTORIES("inventories"),
    ASSETS_HELD_FOR_SALE("assets_held_for_sale"),
    OTHER_CURRENT_ASSETS("other_current_assets"),
    TOTAL_CURRENT_ASSETS("total_current_assets"),
    TOTAL_ASSETS("total_assets"),
    TOTAL_CURRENT_LIABILITIES("total_current_liabilities"),
    TOTAL_LIABILITIES("total_liabilities"),
    TOTAL_STOCKHOLDERS_EQUITY("total_stockholders_equity");

    private final String attribute;

    BalanceSheetEntryAttribute(String attribute) {
        this.attribute = attribute;
    }

    @Override
    public String getAttribute() {
        return attribute;
    }
}
