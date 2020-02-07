package br.com.rsinet.hub_bdd.screenObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import br.com.rsinet.hub_bdd.manager.DriverFactory;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class CadastroScreen {
	
	private WebDriver driver;
	
	public CadastroScreen(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	private MobileElement encontraUserName() {
		MobileElement userName = (MobileElement) driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.EditText"));
		return userName;
	}
	
	public void preencheUserName(String et_UserName) {
		encontraUserName().click();
		encontraUserName().sendKeys(et_UserName);
	}
	
	
	private MobileElement encontraEmail() {
		MobileElement email = (MobileElement) driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.EditText"));
		return email;
	}
	
	public void preencheEmail(String et_Email) {
		encontraEmail().click();		
		encontraEmail().sendKeys(et_Email);
	}
	
	private MobileElement encontraPassword() {
		MobileElement password = (MobileElement) driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.RelativeLayout/android.widget.EditText"));
		return password;
	}
	
	public void preenchePassword(String et_Password) {
		encontraPassword().click();		
		encontraPassword().sendKeys(et_Password);
	}
	
	private MobileElement encontraConfirmPassword() {
		MobileElement confirmPassword = (MobileElement) driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.RelativeLayout/android.widget.EditText"));
		return confirmPassword;
	}
	
	public void preencheConfirmPassword(String et_ConfirmPassword) {
		encontraConfirmPassword().click();		
		encontraConfirmPassword().sendKeys(et_ConfirmPassword);
	}
	
	private MobileElement encontraFirstName() {
		MobileElement firstName = (MobileElement) driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.EditText"));
		return firstName;
	}
	
	public void preencheFirstName(String et_FirstName) {
		encontraFirstName().click();		
		encontraFirstName().sendKeys(et_FirstName);
	}
	
	private MobileElement encontraLastName() {
		MobileElement lastName = (MobileElement) driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.EditText"));
		return lastName;
	}
	
	public void preencheLastName(String et_LastName) {
		encontraLastName().click();		
		encontraLastName().sendKeys(et_LastName);
	}
	
	private MobileElement encontraPhoneNumber() {
		MobileElement phoneNumber = (MobileElement) driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.EditText"));
		return phoneNumber;
	}
	
	public void preenchePhoneNumber(String et_PhoneNumber) {
		encontraPhoneNumber().click();		
		encontraPhoneNumber().sendKeys(et_PhoneNumber);
	}
	
	private MobileElement encontraCountry() {
		MobileElement country = (MobileElement) driver.findElement(By.id("com.Advantage.aShopping:id/linearLayoutCountry"));
		return country;
	}
	
	public void clicaCountry() {
		encontraCountry().click();
	}
	
	public void clicaBrazil(@SuppressWarnings("rawtypes") AndroidDriver driver, String visibleText) {
		driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"" + visibleText + "\")"))
		.click();	
	}
	
	private MobileElement encontraState() {
		MobileElement state = (MobileElement) driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.EditText"));
		return state;
	}
	
	public void preencheState(String et_State) {
		encontraState().click();	
		encontraState().sendKeys(et_State);	
	}
	
	private MobileElement encontraAddress() {
		MobileElement address = (MobileElement) driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.EditText"));
		return address;
	}
	
	public void preencheAddress(String et_Address) {
		encontraAddress().click();	
		encontraAddress().sendKeys(et_Address);
	}
	
	private MobileElement encontraCity() {
		MobileElement city = (MobileElement) driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.EditText"));
		return city;
	}
	
	public void preencheCity(String et_City) {
		encontraCity().click();	
		encontraCity().sendKeys(et_City);
	}
	
	private MobileElement encontraPostalCode() {
		MobileElement postalCode = (MobileElement) driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout[2]/android.widget.EditText"));
		return postalCode;
	}
	
	public void preenchePostalCode(String et_Postalode) {
		encontraPostalCode().click();	
		encontraPostalCode().sendKeys(et_Postalode);
	}
	
	private MobileElement encontraCheckOffers() {
		MobileElement checkOffers = (MobileElement) driver.findElement(By.id("com.Advantage.aShopping:id/checkBoxRecieveOffers"));
		return checkOffers;
	}
	
	public void clicaCheckOffers() {
		encontraCheckOffers().click();
	}
	
	private MobileElement encontraRegister() {
		MobileElement btRegister = (MobileElement) driver.findElement(By.id("com.Advantage.aShopping:id/buttonRegister"));
		return btRegister;
	}
	
	public MobileElement encontraMsgPassword() {
		MobileElement tvPassword = (MobileElement) driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.RelativeLayout/android.widget.TextView"));
		return tvPassword;
	}

	public void clicaRegister() {
		encontraRegister().click();	
	}
	
	@SuppressWarnings("rawtypes")
	public void scroll(double inicio, double fim) throws Exception {
		Dimension size = DriverFactory.getDriver().manage().window().getSize();

		int x = size.width / 2;
		int start_y = (int) (size.height * inicio);
		int end_y = (int) (size.height * fim);
		new TouchAction((PerformsTouchActions) DriverFactory.getDriver()).press(PointOption.point(x, start_y))
				.waitAction((WaitOptions.waitOptions(Duration.ofMillis(500))))//
				.moveTo(PointOption.point(x, end_y))//
				.release().perform();

	}
	
	public void scrollCountry(@SuppressWarnings("rawtypes") AndroidDriver driver, String visibleText) {
		driver.findElementByAndroidUIAutomator(
				"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
						+ visibleText + "\").instance(0))");
	}
	
}
