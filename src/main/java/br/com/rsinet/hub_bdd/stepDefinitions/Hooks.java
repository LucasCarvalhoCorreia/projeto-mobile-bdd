package br.com.rsinet.hub_bdd.stepDefinitions;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.cucumber.listener.Reporter;

import br.com.rsinet.hub_bdd.extendReport.Prints;
import br.com.rsinet.hub_bdd.manager.DriverFactory;
import cucumber.api.Scenario;
import cucumber.api.java.After;

public class Hooks {
	
//	private WebDriver driver;
//	
//	@Before
//	public void iniciaApp() throws Exception {
//		driver = DriverFactory.iniciaApp();
//	}
	
	@After(order = 0)
	public void finalizaApp() {
		DriverFactory.fechaApp();
	}
	
	@After(order = 1)
	public void ExtendReport(Scenario scenario) throws Exception {
		String caminho = Prints.tirarPrints(DriverFactory.getDriver(), scenario.getName());
		Reporter.addScreenCaptureFromPath(caminho);
	}
	
	public static String timestamp() {
		return new SimpleDateFormat(" yyyy-MM-dd HH-mm-ss").format(new Date());
	}

}
