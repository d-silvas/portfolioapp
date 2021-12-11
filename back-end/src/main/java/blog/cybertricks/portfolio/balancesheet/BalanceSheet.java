package blog.cybertricks.portfolio.balancesheet;

import blog.cybertricks.portfolio.financialstatement.FinancialStatementPeriod;
import blog.cybertricks.portfolio.ticker.Ticker;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "balance_sheet")
public class BalanceSheet {
    @Id
    @SequenceGenerator(name = "balance_sheet_id_sequence", sequenceName = "balance_sheet_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "balance_sheet_id_sequence")
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ticker_id", nullable = false, referencedColumnName = "id")
    @JsonIgnoreProperties("balanceSheets")
    private Ticker ticker;

    @Column(name = "period")
    private FinancialStatementPeriod period;

    @Column(name = "fiscal_date_ending")
    private LocalDate fiscalDateEnding;

    @OneToMany(mappedBy = "balanceSheet", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnoreProperties("balanceSheet")
    private List<BalanceSheetEntry> entries;
}
