package blog.cybertricks.portfolio.balancesheet;

import blog.cybertricks.portfolio.financialstatement.FinancialStatementEntry;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "balance_sheet_entry")
public class BalanceSheetEntry implements FinancialStatementEntry {
    @Id
    @SequenceGenerator(name = "balance_sheet_entry_sequence", sequenceName = "balance_sheet_entry_seq", allocationSize
            = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "balance_sheet_entry_sequence")
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "balance_sheet_id", referencedColumnName = "id", nullable = false)
    @JsonIgnoreProperties("entries")
    private BalanceSheet balanceSheet;

    @Column(name = "attribute")
    private BalanceSheetEntryAttribute attribute;

    @Column(name = "value")
    private Double value;

    @Column(name = "notes")
    private String notes;
}
