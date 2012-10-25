import java.math.BigDecimal;

public interface StockService {

	/** Get stock price from yahoo and return as a BigDecimal with two decimal places. */
	public abstract BigDecimal getPrice(String symbol);

	/** Buys a share of the given stock at the current price. */
	public abstract boolean buy(String symbol);

}