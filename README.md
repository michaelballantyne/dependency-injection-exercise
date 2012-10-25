Stock Trader Dependency Injection Exercise
=
Java exercise to practice application of the dependency injection design pattern and the unit testing that it allows. PDF presentation notes on dependency injection also included. Problem and solution are eclipse projects.


Exercise Instructions
-
Here we have the framework of a basic stock trading app. There's a command line interface in TradingApp, business logic in Trader, and an interface to Yahoo's stock price API in YahooPriceService.

Your task is to find an effective way to test the business logic in Trader. You will likely want to use the ideas and tools we discussed in class today, including:
- Manual dependency injection
- Interface abstraction
- Test mocks with mockito (the mockito library is included in the eclipse project, and documentation is at http://docs.mockito.googlecode.com/hg/latest/org/mockito/Mockito.html)

Trader has a bug, so you should be able to come up with a failing JUnit test for it.


Solution Notes
-

Students should extract an interface from YahooStockService, and call it something like StockService.

Then, apply dependency injection to Trader so that a YahooStockService is created by TradingApp and
injected into Trader (which expects a StockService in its constructor). 

Now, create a JUnit test of
Trader that:
- creates a mockito mock of StockService.class and passes it to a Trader
- stubs the getPrice method for a given symbol or any symbol
- executes Trader.buy() for a bid above, equal to and below the price provided by the stub above, verifying
both the return value and that StockService.buy() is or is not called appropriately (via mockito's verify())

Students should be able to find and produce failing tests for the two obvious bugs in Trader.java: that
the condition in the if is > instead of >=, and that stockService.buy(symbol); is misplaced - it should
be inside the if. Fixing those bugs should make their tests pass, and their tests should still fail if
only one is fixed.


License
-
public domain, though if you use this material I'd love to hear any feedback you have.
