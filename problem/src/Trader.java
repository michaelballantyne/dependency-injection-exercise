import java.math.BigDecimal;

/** Business logic for stock trading  
 *  @author Michael Ballantyne and Zachary Morin */
public class Trader {
	YahooStockService stockService = new YahooStockService();

	/** Checks the price of a stock, and buys it if the price is not greater than the bid amount.
	 * 	@return The amount paid, or null if the price was greater than the bid. */
	public BigDecimal buy(String symbol, BigDecimal bid) {
		BigDecimal price = stockService.getPrice(symbol);
		
		BigDecimal result;
		if (price.compareTo(bid) < 0) {
			result = price;
		}
		else {
			result = null;
		}
		stockService.buy(symbol);
		
		return result;
	}
}