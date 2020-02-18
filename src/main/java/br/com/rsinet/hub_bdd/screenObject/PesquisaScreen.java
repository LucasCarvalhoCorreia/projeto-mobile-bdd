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

public class PesquisaScreen {

	private WebDriver driver;

	public PesquisaScreen(WebDriver driver) {
		PageFactory.initElements(driver, this);
		this.driver = driver;
	}

	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/textViewProductQuantity")
	private WebElement txt_QuantidadeProduto;

	@FindBy(how = How.XPATH, using = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText")
	private WebElement txt_QuantidadeCompra;

	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/textViewApply")
	private WebElement bt_Aplica;

	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/buttonProductAddToCart")
	private WebElement txt_AddCarrinho;

	@FindBy(how = How.ID, using = "com.Advantage.aShopping:id/imageViewCart")
	private WebElement txt_CarrinhoDeCompras;

	private MobileElement encontraPorduto(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		MobileElement encontraPorduto = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//android.widget.RelativeLayout[@content-desc=\"Search\"]/android.widget.LinearLayout/android.widget.GridView/android.widget.RelativeLayout/android.widget.ImageView")));
		return encontraPorduto;
	}

	public MobileElement encontraNomePorduto(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		MobileElement encontraNomePorduto = (MobileElement) wait.until(
				ExpectedConditions.elementToBeClickable(By.id("com.Advantage.aShopping:id/textViewProductName")));
		return encontraNomePorduto;
	}

	public MobileElement encontraResultadoPesquisa(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		MobileElement encontraResultadoPesquisa = (MobileElement) wait.until(
				ExpectedConditions.elementToBeClickable(By.id("com.Advantage.aShopping:id/textViewNoProductsToShow")));
		return encontraResultadoPesquisa;
	}

	private MobileElement encontraProdutoCategoria(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		MobileElement encontraPordutoCategoria = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By
				.xpath("//android.widget.RelativeLayout[@content-desc=\"Speakers\"]/android.widget.LinearLayout/android.widget.GridView/android.widget.RelativeLayout[3]/android.widget.ImageView")));
		return encontraPordutoCategoria;
	}

	public MobileElement encontraQuantidadeComprada() {
		MobileElement encontraQuantidadeDeCompra = (MobileElement) driver
				.findElement(By.id("com.Advantage.aShopping:id/textViewCartQuantity"));
		return encontraQuantidadeDeCompra;
	}

	public void clicaProduto() {
		encontraPorduto(driver).click();
	}

	public void escolheProduto() {
		encontraProdutoCategoria(driver).click();
	}

	public void clicaQuantidadeProduto() {
		txt_QuantidadeProduto.click();
	}

	public void preencheQuantidadeCompra() {
		txt_QuantidadeCompra.click();
		txt_QuantidadeCompra.clear();
		txt_QuantidadeCompra.sendKeys("11");
	}

	public void clicaAplicaQuantidade() {
		bt_Aplica.click();
	}

	public void clicaAdicionarAoCarrinho() {
		txt_AddCarrinho.click();
	}

	public void clicaCarrinhoDeCompras() {
		txt_CarrinhoDeCompras.click();
	}
}
