package br.com.rsinet.hub_bdd.stepDefinitions;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import br.com.rsinet.hub_bdd.extendReport.Prints;
import br.com.rsinet.hub_bdd.manager.DriverFactory;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {
	
private WebDriver driver;
	
	@Before
	public void iniciaApp() throws Exception {
		driver = DriverFactory.iniciaApp();
		DriverFactory.getDriver();
	}
	
	@After(order = 0)
	public void finalizaApp() {
		DriverFactory.fechaApp();
	}
	
	@After(order = 1)
	public void ExtendReport(ITestResult result, ExtentTest test, WebDriver driver) throws Exception {
		DriverFactory.getDriver();
		String caminho = Prints.tirarPrints(driver, result.getName());
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, "Caso de teste falhou " + result.getName()); // Adiciona o nome na extenção reporte
			test.log(Status.FAIL, "Caso de teste falhou " + result.getThrowable()); // Adiciona o erro/ exceção
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, "Caso de teste que pulou " + result.getName());
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, "Caso de teste passou " + result.getName());
		}
		test.addScreenCaptureFromPath(caminho);
	}
	
	public static String timestamp() {
		return new SimpleDateFormat(" yyyy-MM-dd HH-mm-ss").format(new Date());
	}

}
