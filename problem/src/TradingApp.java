import java.math.BigDecimal;
import java.util.Scanner;

/** Provides a command line interface for stock trading 
 *  @author Michael Ballantyne and Zachary Morin */
public class TradingApp {
	public static void main(String[] args) {
		Trader trader = new Trader();
	
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Enter a stock symbol: ");
		String symbol = keyboard.nextLine();
		System.out.println("Enter the maximum price you are willing to pay: ");
		BigDecimal price = keyboard.nextBigDecimal();
		
		BigDecimal purchasePrice = null;
		try {
			purchasePrice = trader.buy(symbol, price);
		} catch (Exception e) {
			System.out.println("There was an error while attempting to buy the stock: " + e.getMessage());
		}
		
		if (purchasePrice != null) {
			System.out.println("Purchased at $" + purchasePrice);
		}
		else {
			System.out.println("Couldn't buy the stock at that price.");
		}
	}
}