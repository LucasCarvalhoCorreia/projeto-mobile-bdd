package br.com.rsinet.hub_tdd.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtendReport {

	public static WebDriver driver;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentTest test;
	public static ExtentReports extent;

	public static String pegaHora() {
		return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}

	public static void setExtent() {
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/target/Reports "+pegaHora()+".html");

		htmlReporter.config().setDocumentTitle("Automatização de Teste");// Titulo do documento
		htmlReporter.config().setReportName("Reporte TDD");// Nome do reporte
		htmlReporter.config().setTheme(Theme.DARK);

		extent = new ExtentReports();

		extent.attachReporter(htmlReporter);

		extent.setSystemInfo("Hostname", "LocalHost");
		extent.setSystemInfo("OS", "Windows10");
		extent.setSystemInfo("Tester Name", "Lucas");
		extent.setSystemInfo("Browser", "Chrome");
	}

	public static void endReport() {
		extent.flush();
	}

	public static ExtentTest createTest(String testName) {
		return extent.createTest(testName);
	}

	public static void tearDown(ITestResult result, ExtentTest test, WebDriver driver) throws Exception {
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
}