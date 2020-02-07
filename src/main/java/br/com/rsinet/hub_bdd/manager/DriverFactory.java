package br.com.rsinet.hub_bdd.manager;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class DriverFactory {

	public static WebDriver driver;
	
	public static WebDriver getDriver() throws Exception {
		return (driver == null) ? iniciaApp() : driver; 
	}

	@SuppressWarnings({ "rawtypes" })
	public static WebDriver iniciaApp() throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Celular");
		capabilities.setCapability("appPackage", "com.Advantage.aShopping");
		capabilities.setCapability("appActivity", ".SplashActivity");

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
	}

	/* Método responsavel por fechar o browser. */
	public static void fechaApp() {
		if (driver != null) {	
			driver.quit();
			driver = null;
		}
	}
}
