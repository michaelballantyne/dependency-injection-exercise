
import static org.junit.Assert.*;
import java.math.BigDecimal;
import junit.framework.Assert;
import org.junit.Test;
import static org.mockito.Mockito.*;

/** Test for Trader. 
 * @author Zachary Morin */
public class TraderTest {

	private BigDecimal stockprice;
	private BigDecimal askPriceHigh;
	private BigDecimal askPriceLow;
	private BigDecimal askPriceEqual;
	private String stockSymbol;
	private Trader t;
	private StockService s;
	
	public void setup(){
		s = mock(StockService.class);		
		t = new Trader(s);
		
		stockprice = new BigDecimal("10.00");
		askPriceHigh = new BigDecimal("15.00");
		askPriceLow = new BigDecimal("5.00");
		askPriceEqual = new BigDecimal("10.00");
		
		stockSymbol = "FakeStock";
		when(s.getPrice(stockSymbol)).thenReturn(stockprice);
	}
	@Test
	public void testHigh() {
		//Setup Mocks
		setup();
		
		//Run Test
		assertEquals(stockprice, t.buy(stockSymbol, askPriceHigh));
		
		//Verify
		verify(s, times(1)).buy(stockSymbol);
	}

	@Test
	public void testLow() {
		//Setup Mocks
		setup();
		
		//Run Test
		assertEquals(null, t.buy(stockSymbol, askPriceLow));
		
		//Verify
		verify(s, times(0)).buy(stockSymbol);
	}
	
	@Test
	public void testEqual() {
		//Setup Mocks
		setup();
		
		//Run Test
		assertEquals(stockprice, t.buy(stockSymbol, askPriceEqual));
		
		//Verify
		verify(s, times(1)).buy(stockSymbol);
	}

}
