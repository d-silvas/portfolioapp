package blog.cybertricks.portfolio.financialstatement;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class FinancialStatementPeriodConverter implements AttributeConverter<FinancialStatementPeriod, String> {
    @Override
    public String convertToDatabaseColumn(FinancialStatementPeriod financialStatementPeriod) {
        if (financialStatementPeriod == null) {
            return null;
        }
        return financialStatementPeriod.getPeriod();
    }

    @Override
    public FinancialStatementPeriod convertToEntityAttribute(String period) {
        if (period == null) {
            return null;
        }
        return Stream.of(FinancialStatementPeriod.values())
                .filter(a -> a.getPeriod().equals(period))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
