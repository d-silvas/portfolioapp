package blog.cybertricks.portfolio.ticker;

public class TickerViews {
    public interface Public extends Ticker.Views.Symbol, Ticker.Views.Exchange, Ticker.Views.Name {
    }

    public interface Full extends Ticker.Views.Id, Public {
    }
}
