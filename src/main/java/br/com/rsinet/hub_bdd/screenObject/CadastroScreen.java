package br.com.rsinet.hub_bdd.screenObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
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
	
	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.RelativeLayout/android.widget.EditText")
	private WebElement txt_UserName;

	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.EditText")
	private WebElement txt_Email;

	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[3]/android.widget.RelativeLayout/android.widget.EditText")
	private WebElement txt_Password;

	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.RelativeLayout/android.widget.EditText")
	private WebElement txt_ConfirmPassword;

	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[1]/android.widget.EditText")
	private WebElement txt_FirstName;

	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.RelativeLayout[2]/android.widget.EditText")
	private WebElement txt_LastName;

	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.EditText")
	private WebElement txt_PhoneNumber;

	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/linearLayoutCountry")
	private WebElement combo_Country;

	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout[2]/android.widget.RelativeLayout/android.widget.EditText")
	private WebElement txt_State;

	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.RelativeLayout/android.widget.EditText")
	private WebElement txt_Address;

	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout[1]/android.widget.EditText")
	private WebElement txt_Cidade;

	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout[2]/android.widget.EditText")
	private WebElement txt_CEP;

	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/checkBoxRecieveOffers")
	private WebElement check_Offers;
	
	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/buttonRegister")
	private WebElement bt_Register;
	
	public void preencheUserName(String et_UserName) {
		txt_UserName.click();
		txt_UserName.sendKeys(et_UserName);
	}
	
	public void preencheEmail(String et_Email) {
		txt_Email.click();		
		txt_Email.sendKeys(et_Email);
	}
	
	public void preenchePassword(String et_Password) {
		txt_Password.click();		
		txt_Password.sendKeys(et_Password);
	}
	
	public void preencheConfirmPassword(String et_ConfirmPassword) {
		txt_ConfirmPassword.click();		
		txt_ConfirmPassword.sendKeys(et_ConfirmPassword);
	}
	
	public void preencheFirstName(String et_FirstName) {
		txt_FirstName.click();		
		txt_FirstName.sendKeys(et_FirstName);
	}
	
	public void preencheLastName(String et_LastName) {
		txt_LastName.click();		
		txt_LastName.sendKeys(et_LastName);
	}
	
	public void preenchePhoneNumber(String et_PhoneNumber) {
		txt_PhoneNumber.click();		
		txt_PhoneNumber.sendKeys(et_PhoneNumber);
	}
	
	public void clicaCountry() {
		combo_Country.click();
	}
	
	public void clicaBrazil(@SuppressWarnings("rawtypes") AndroidDriver driver, String visibleText) {
		driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().textContains(\"" + visibleText + "\")"))
		.click();	
	}
	
	public void preencheState(String et_State) {
		txt_State.click();	
		txt_State.sendKeys(et_State);	
	}
	
	public void preencheAddress(String et_Address) {
		txt_Address.click();	
		txt_Address.sendKeys(et_Address);
	}
	
	public void preencheCity(String et_City) {
		txt_Cidade.click();	
		txt_Cidade.sendKeys(et_City);
	}
	
	public void preenchePostalCode(String et_Postalode) {
		txt_CEP.click();	
		txt_CEP.sendKeys(et_Postalode);
	}
	
	public void clicaCheckOffers() {
		check_Offers.click();
	}
	
	public MobileElement encontraMsgPassword() {
		MobileElement tvPassword = (MobileElement) driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout/android.widget.ScrollView/android.widget.LinearLayout/android.widget.LinearLayout[1]/android.widget.LinearLayout/android.widget.LinearLayout[4]/android.widget.RelativeLayout/android.widget.TextView"));
		return tvPassword;
	}

	public void clicaRegister() {
		bt_Register.click();	
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
