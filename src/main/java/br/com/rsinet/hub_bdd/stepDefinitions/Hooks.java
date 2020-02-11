package br.com.rsinet.hub_bdd.stepDefinitions;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import com.cucumber.listener.Reporter;

import br.com.rsinet.hub_bdd.extendReport.Prints;
import br.com.rsinet.hub_bdd.manager.TestContext;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	
	private WebDriver driver;
	private TestContext testContext;
	
	public Hooks(TestContext context) {
		this.testContext = context;
	}
	
	@Before
	public void iniciaApp() throws Exception {
		driver = testContext.getDriverFactory().iniciaApp();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@After(order = 0)
	public void finalizaApp() {
		testContext.getDriverFactory().fechaApp();
	}
	
	@After(order = 1)
	public void ExtendReport(Scenario scenario) throws Exception {
		String caminho = Prints.tirarPrints(testContext.getDriverFactory().iniciaApp(), scenario.getName());
		Reporter.addScreenCaptureFromPath(caminho);
	}
	
	public static String timestamp() {
		return new SimpleDateFormat(" yyyy-MM-dd HH-mm-ss").format(new Date());
	}

}
