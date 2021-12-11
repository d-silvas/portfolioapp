package blog.cybertricks.portfolio.ticker;

import com.fasterxml.jackson.annotation.JsonView;
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
@Table(name = "ticker", uniqueConstraints = {@UniqueConstraint(columnNames = {"symbol", "exchange"})})
public class Ticker {
    @Id
    @SequenceGenerator(name = "ticker_id_sequence", sequenceName = "ticker_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "ticker_id_sequence")
    @Column(name = "id")
    @JsonView(Views.Id.class)
    private Long id;

    @Column(name = "symbol")
    @JsonView(Views.Symbol.class)
    private String symbol;

    @Column(name = "exchange")
    @JsonView(Views.Exchange.class)
    private String exchange;

    @Column(name = "name")
    @JsonView(Views.Name.class)
    private String name;

    public interface Views {
        interface Id {
        }

        interface Symbol {
        }

        interface Exchange {
        }

        interface Name {
        }
    }
}
