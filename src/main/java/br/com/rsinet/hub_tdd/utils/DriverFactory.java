package br.com.rsinet.hub_tdd.utils;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class DriverFactory {

	public static AndroidDriver<WebElement> driver;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static AndroidDriver<WebElement> iniciaApp() throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "ASUS_X018D");
		capabilities.setCapability("appPackage", "com.Advantage.aShopping");
		capabilities.setCapability("appActivity", ".SplashActivity");

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
	}

	/* Método responsavel por fechar o browzer. */
	public static AndroidDriver<WebElement> fechaApp() {
			driver.quit();

			return driver;
	}
}
