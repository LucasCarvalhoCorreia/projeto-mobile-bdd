package br.com.rsinet.hub_bdd.screenObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
	
	private MobileElement encontraPorduto(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		MobileElement encontraPorduto = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.RelativeLayout[@content-desc=\"Search\"]/android.widget.LinearLayout/android.widget.GridView/android.widget.RelativeLayout/android.widget.ImageView")));
		return encontraPorduto;
	}
	
	public void clicaProduto() {
		encontraPorduto(driver).click();
	}
	
	public MobileElement encontraNomePorduto(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		MobileElement encontraNomePorduto = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.id("com.Advantage.aShopping:id/textViewProductName")));
		return encontraNomePorduto;
	}
	
	public MobileElement encontraResultadoPesquisa(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		MobileElement encontraResultadoPesquisa = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.id("com.Advantage.aShopping:id/textViewNoProductsToShow")));
		return encontraResultadoPesquisa;
	}
	
	private MobileElement encontraProdutoCategoria(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 50);
		MobileElement encontraPordutoCategoria = (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//android.widget.RelativeLayout[@content-desc=\"Speakers\"]/android.widget.LinearLayout/android.widget.GridView/android.widget.RelativeLayout[3]/android.widget.ImageView")));
		return encontraPordutoCategoria;
	}
	
	public void escolheProduto() {
		encontraProdutoCategoria(driver).click();
	}
	
	private MobileElement encontraQuantidadeProduto() {
		MobileElement encontraQuantidadeProduto = (MobileElement) driver.findElement(By.id("com.Advantage.aShopping:id/textViewProductQuantity"));
		return encontraQuantidadeProduto;
	}
	
	public void clicaQuantidadeProduto() {
		encontraQuantidadeProduto().click();
	}
	
	private MobileElement encontraQuantidaDeCompra() {
		MobileElement encontraQuantidaDeCompra = (MobileElement) driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout[2]/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.EditText"));
		return encontraQuantidaDeCompra;
	}
	
	public void preencheQuantidadeCompra() {
		encontraQuantidaDeCompra().click();
		encontraQuantidaDeCompra().clear();
		encontraQuantidaDeCompra().sendKeys("11");
	}
	
	private MobileElement encontraAplicaQuantidade() {
		MobileElement encontraAplicaQuantidade = (MobileElement) driver.findElement(By.id("com.Advantage.aShopping:id/textViewApply"));
		return encontraAplicaQuantidade;
	}
	
	public void clicaAplicaQuantidade() {
		encontraAplicaQuantidade().click();
	}
	
	private MobileElement encontraAdicionarAoCarrinho() {
		MobileElement encontraAdicionarAoCarrinho = (MobileElement) driver.findElement(By.id("com.Advantage.aShopping:id/buttonProductAddToCart"));
		return encontraAdicionarAoCarrinho;
	}
	
	public void clicaAdicionarAoCarrinho() {
		encontraAdicionarAoCarrinho().click();
	}
	
	private MobileElement encontraCarrinhoDeCompras() {
		MobileElement encontraCarrinhoDeCompras = (MobileElement) driver.findElement(By.id("com.Advantage.aShopping:id/imageViewCart"));
		return encontraCarrinhoDeCompras;
	}
	
	public void clicaCarrinhoDeCompras() {
		encontraCarrinhoDeCompras().click();
	}
	
	public MobileElement encontraQuantidadeComprada() {
		MobileElement encontraQuantidadeDeCompra = (MobileElement) driver.findElement(By.id("com.Advantage.aShopping:id/textViewCartQuantity"));
		return encontraQuantidadeDeCompra;
	}
	
}
