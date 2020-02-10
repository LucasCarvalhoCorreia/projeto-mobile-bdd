package br.com.rsinet.hub_bdd.manager;

public class TestContext {
	
	private DriverFactory driverFactory;
	
	public TestContext() {
		driverFactory = new DriverFactory();
	}
	
	public DriverFactory getDriverFactory() {
		return driverFactory;
	}

}
