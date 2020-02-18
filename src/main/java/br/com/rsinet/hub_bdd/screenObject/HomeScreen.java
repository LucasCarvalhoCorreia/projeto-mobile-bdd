package br.com.rsinet.hub_bdd.screenObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
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

	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/textViewMenuUser")
	private WebElement bt_LoginIcon;

	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/textViewDontHaveAnAccount")
	private WebElement bt_CriaNovaConta;

	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/editTextSearch")
	private WebElement bt_BarraPesquisa;

	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/imageViewSearch")
	private WebElement bt_Lupa;

	@FindBy(how = How.XPATH, using = "//android.view.ViewGroup[@content-desc=\"Home Page\"]/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.support.v7.widget.RecyclerView/android.widget.RelativeLayout[4]/android.widget.ImageView")
	private WebElement bt_CatSpeakers;

	@FindBy(how = How.XPATH, using = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout[3]/android.widget.EditText")
	private WebElement txt_UserLogin;

	@FindBy(how = How.XPATH, using = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.RelativeLayout[4]/android.widget.EditText")
	private WebElement txt_UserPassword;

	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/buttonLogin")
	private WebElement bt_Login;

	private MobileElement encontraMenu(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		MobileElement encontraMenu = (MobileElement) wait
				.until(ExpectedConditions.elementToBeClickable(By.id("com.Advantage.aShopping:id/imageViewMenu")));
		return encontraMenu;
	}

	public MobileElement pegaLogon() {
		MobileElement pegaLogon = (MobileElement) driver
				.findElement(By.id("com.Advantage.aShopping:id/textViewMenuUser"));
		return pegaLogon;
	}

	private MobileElement encontraNoBt(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		MobileElement encontraNoBt = (MobileElement) wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(
				"/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.LinearLayout/android.widget.Button[1]")));
		return encontraNoBt;
	}

	public void clicaMenu() {
		encontraMenu(driver).click();
	}

	public void clicaLogin() {
		bt_LoginIcon.click();
	}

	public void clicaCriarNovaConta() {
		bt_CriaNovaConta.click();
	}

	public void preencheBarraPesquisa(String et_BarraPesquisa) {
		bt_BarraPesquisa.click();
		bt_BarraPesquisa.sendKeys(et_BarraPesquisa);
	}

	public void clicaLupa() {
		bt_Lupa.click();
	}

	public void clicaCategoriaSpeakers() {
		bt_CatSpeakers.click();
	}

	public void preencheUserLogin(String et_UserLogin) {
		txt_UserLogin.click();
		txt_UserLogin.sendKeys(et_UserLogin);
	}

	public void preenchePasswordLogin(String et_PasswordLogin) {
		txt_UserPassword.click();
		txt_UserPassword.sendKeys(et_PasswordLogin);
	}

	public void clicaBtLogin() {
		bt_Login.click();
	}

	public void clicaNoBt() throws InterruptedException {
		encontraNoBt(driver).click();
	}
}