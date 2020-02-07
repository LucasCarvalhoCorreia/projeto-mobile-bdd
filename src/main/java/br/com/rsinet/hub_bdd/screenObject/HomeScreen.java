package br.com.rsinet.hub_bdd.screenObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;

public class HomeScreen {
	
	private WebDriver driver;
	
	public HomeScreen(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}
	
	private MobileElement encontraMenu(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		MobileElement encontraMenu = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.id("com.Advantage.aShopping:id/imageViewMenu")));
		return encontraMenu;
	}
	
	public void clicaMenu() {
		encontraMenu(driver).click();
	}
	
	public void clicaLogin() {
		driver.findElement(By.id("com.Advantage.aShopping:id/textViewMenuUser")).click();
	}
	
	public void clicaCriarNovaConta() {
		driver.findElement(By.id("com.Advantage.aShopping:id/textViewDontHaveAnAccount")).click();
	}
	
	public MobileElement pegaLogon() {
		MobileElement pegaLogon = (MobileElement) driver.findElement(By.id("com.Advantage.aShopping:id/textViewMenuUser"));
		return pegaLogon;
	}
	
	private MobileElement encontraBarraPesquisa() {
		MobileElement encontraBarraPesquisa = (MobileElement) driver.findElement(By.id("com.Advantage.aShopping:id/editTextSearch"));
		return encontraBarraPesquisa;
	}
	
	public void preencheBarraPesquisa(String et_BarraPesquisa) {
		encontraBarraPesquisa().click();
		encontraBarraPesquisa().sendKeys(et_BarraPesquisa);
	}
	
	private MobileElement encontraLupa() {
		MobileElement encontraLupa = (MobileElement) driver.findElement(By.id("com.Advantage.aShopping:id/imageViewSearch"));
		return encontraLupa;
	}
	
	public void clicaLupa() {
		encontraLupa().click();
	}
	
	private MobileElement encontraSpeakers() {
		MobileElement encontraSpeakers = (MobileElement) driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[4]/android.widget.ImageView"));
		return encontraSpeakers;
	}
	
	public void clicaCategoriaSpeakers() {
		encontraSpeakers().click();
	}
	
	private MobileElement encontraUserLogin() {
		MobileElement encontraUserLogin = (MobileElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout[3]/android.widget.EditText"));
		return encontraUserLogin;
	}
	
	public void preencheUserLogin(String et_UserLogin) {
		encontraUserLogin().click();
		encontraUserLogin().sendKeys(et_UserLogin);
	}
	
	private MobileElement encontraPasswordLogin() {
		MobileElement encontraUserLogin = (MobileElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout[4]/android.widget.EditText"));
		return encontraUserLogin;
	}
	
	public void preenchePasswordLogin(String et_PasswordLogin) {
		encontraPasswordLogin().click();
		encontraPasswordLogin().sendKeys(et_PasswordLogin);
	}
	
	private MobileElement encontraBtLogin() {
		MobileElement encontraBtLogin = (MobileElement) driver.findElement(By.id("com.Advantage.aShopping:id/buttonLogin"));
		return encontraBtLogin;
	}
	
	public void clicaBtLogin() {
		encontraBtLogin().click();
	}
	
	private MobileElement encontraNoBt(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		MobileElement encontraNoBt = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button[1]")));
		return encontraNoBt;
	}
	
	public void clicaNoBt() throws InterruptedException {
		encontraNoBt(driver).click();
	}
	
	
}