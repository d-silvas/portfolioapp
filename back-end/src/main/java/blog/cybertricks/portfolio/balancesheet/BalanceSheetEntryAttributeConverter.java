package blog.cybertricks.portfolio.balancesheet;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter(autoApply = true)
public class BalanceSheetEntryAttributeConverter implements AttributeConverter<BalanceSheetEntryAttribute, String> {
    @Override
    public String convertToDatabaseColumn(BalanceSheetEntryAttribute balanceSheetEntryAttribute) {
        if (balanceSheetEntryAttribute == null) {
            return null;
        }
        return balanceSheetEntryAttribute.getAttribute();
    }

    @Override
    public BalanceSheetEntryAttribute convertToEntityAttribute(String attribute) {
        if (attribute == null) {
            return null;
        }
        return Stream.of(BalanceSheetEntryAttribute.values())
                .filter(a -> a.getAttribute().equals(attribute))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
