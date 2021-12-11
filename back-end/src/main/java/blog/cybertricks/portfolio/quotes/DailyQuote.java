package blog.cybertricks.portfolio.quotes;

import blog.cybertricks.portfolio.ticker.Ticker;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "daily_quote", uniqueConstraints = {@UniqueConstraint(columnNames = {"ticker_id", "date"})})
public class DailyQuote {
    @Id
    @SequenceGenerator(name = "daily_quote_id_sequence", sequenceName = "daily_quote_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "daily_quote_id_sequence")
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ticker_id", nullable = false, insertable = true, updatable = false, referencedColumnName = "id")
    private Ticker ticker;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "open")
    private Double open;

    @Column(name = "high")
    private Double high;

    @Column(name = "low")
    private Double low;

    @Column(name = "close")
    private Double close;

    @Column(name = "adjusted_close")
    private Double adjustedClose;

    @Column(name = "volume")
    private Long volume;

    @Column(name = "dividend_amount")
    private Double dividendAmount;

    @Column(name = "split_coefficient")
    private Double splitCoefficient;

    DailyQuote(
            Ticker ticker,
            LocalDate date,
            Double open,
            Double high,
            Double low,
            Double close,
            Double adjustedClose,
            Long volume,
            Double dividendAmount,
            Double splitCoefficient
    ) {
        this.ticker = ticker;
        this.date = date;
        this.open = open;
        this.high = high;
        this.low = low;
        this.close = close;
        this.adjustedClose = adjustedClose;
        this.volume = volume;
        this.dividendAmount = dividendAmount;
        this.splitCoefficient = splitCoefficient;
    }

}
