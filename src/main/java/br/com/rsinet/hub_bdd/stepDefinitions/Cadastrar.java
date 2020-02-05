package br.com.rsinet.hub_bdd.stepDefinitions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import br.com.rsinet.hub_bdd.pageObject.CadastroPage;
import br.com.rsinet.hub_bdd.pageObject.HomePage;
import br.com.rsinet.hub_bdd.pageObject.PesquisaPage;
import br.com.rsinet.hub_tdd.utils.Constantes;
import br.com.rsinet.hub_tdd.utils.DriverFactory;
import br.com.rsinet.hub_tdd.utils.ExcelUtils;
import br.com.rsinet.hub_tdd.utils.PegaMassa;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class Cadastrar {
	
	private AndroidDriver<WebElement> driver;
	private CadastroPage cadastroPage;
	private HomePage homePage;
	private PegaMassa pegaMassa;
	private PesquisaPage pesquisaPage;
	
	@Before
	public void iniciaTeste() throws Exception {
		driver = DriverFactory.iniciaApp();
	}

	@Dado("^que o usuario tenha entrado no app e clicado na opcao de menu$")
	public void que_o_usuario_tenha_entrado_no_app_e_clicado_na_opcao_de_menu() throws Throwable {
		ExcelUtils.setExcelFile(Constantes.Path_TestData + Constantes.File_TestData, "Cadastro");
		homePage.clicaMenu();
	}
	
	@Quando("^ele clicar no link de login$")
	public void ele_clicar_no_link_de_login() throws Throwable {
		homePage.clicaLogin();
	}

	@Quando("^clicar no link de criar uma nova conta$")
	public void clicar_no_link_de_criar_uma_nova_conta() throws Throwable {
		homePage.clicaCriarNovaConta();
	}

	@SuppressWarnings("rawtypes")
	@Quando("^o usuario preencher o formulario de cadastro$")
	public void o_usuario_preencher_o_formulario_de_cadastro() throws Throwable {
		cadastroPage.preencheUserName(pegaMassa.UserName());
		
		new TouchAction(driver).tap(PointOption.point(976, 1934)).perform();

		cadastroPage.preencheEmail(pegaMassa.Email());
		
		new TouchAction(driver).tap(PointOption.point(976, 1934)).perform();
		
		cadastroPage.preenchePassword(pegaMassa.Password());
		
		new TouchAction(driver).tap(PointOption.point(976, 1934)).perform();
		
		cadastroPage.preencheConfirmPassword(pegaMassa.ConfirmPassword());

		new TouchAction(driver).tap(PointOption.point(976, 1934)).perform();
		
		cadastroPage.preencheFirstName(pegaMassa.FirstName());
		
		cadastroPage.preencheLastName(pegaMassa.LastName());
		
		new TouchAction(driver).tap(PointOption.point(976, 1934)).perform();
		
		cadastroPage.preenchePhoneNumber(pegaMassa.Telefone());
		
		new TouchAction(driver).tap(PointOption.point(976, 1934)).perform();
		
		cadastroPage.clicaCountry();	
		
		new TouchAction(driver).press(PointOption.point(1019, 1962)).moveTo(PointOption.point(1014, 132)).perform();
		new TouchAction(driver).press(PointOption.point(1019, 1962)).moveTo(PointOption.point(1014, 132)).perform();
		
		cadastroPage.clicaBrazil();
		
		cadastroPage.preencheState(pegaMassa.Estado());
		
		new TouchAction(driver).tap(PointOption.point(976, 1934)).perform();
		
		cadastroPage.preencheAddress(pegaMassa.Endereco());
		
		new TouchAction(driver).tap(PointOption.point(976, 1934)).perform();
		
		cadastroPage.preencheCity(pegaMassa.Cidade());

		cadastroPage.preenchePostalCode(pegaMassa.Cep());
		
		new TouchAction(driver).tap(PointOption.point(976, 1934)).perform();
		
		new TouchAction(driver).press(PointOption.point(1019, 1962)).moveTo(PointOption.point(1014, 132)).perform();
	}

	@Quando("^clicar na caixa de receber ofertas$")
	public void clicar_na_caixa_de_receber_ofertas() throws Throwable {
		cadastroPage.clicaCheckOffers();
	}

	@Quando("^ele clicar no botao de registrar$")
	public void ele_clicar_no_botao_de_registrar() throws Throwable {
		cadastroPage.clicaRegister();
	}

	@Entao("^verifica se o usuario esta logado$")
	public void verifica_se_o_usuario_esta_logado() throws Throwable {
		homePage.clicaMenu();
		
		String mensagem = pegaMassa.MenssagemAssertCadastroSucesso();
		String condicao = pegaMassa.UserName();
		
		String pass = homePage.pegaLogon().getText();
		
		Assert.assertTrue(pass.equals(condicao), mensagem);
	}

	@SuppressWarnings("rawtypes")
	@Quando("^o usuario preencher o formulario de cadastro com a confirmacao de senha diferente da senha$")
	public void o_usuario_preencher_o_formulario_de_cadastro_com_a_confirmacao_de_senha_diferente_da_senha() throws Throwable {
		cadastroPage.preencheUserName(pegaMassa.UserName());
		
		new TouchAction(driver).tap(PointOption.point(976, 1934)).perform();

		cadastroPage.preencheEmail(pegaMassa.Email());
		
		new TouchAction(driver).tap(PointOption.point(976, 1934)).perform();
		
		cadastroPage.preenchePassword(pegaMassa.Password());
	
		new TouchAction(driver).tap(PointOption.point(976, 1934)).perform();
		
		cadastroPage.preencheConfirmPassword(pegaMassa.ConfirmPasswordErrado());
	
		new TouchAction(driver).tap(PointOption.point(976, 1934)).perform();
	}

	@Entao("^o usuario nao pode efetuar o registro$")
	public void o_usuario_nao_pode_efetuar_o_registro() throws Throwable {
		String condicao = pegaMassa.CondicaoAssertCadastroErro();
		String mensagem = pegaMassa.MenssagemAssertCadastroErro();
		String pass = cadastroPage.encontraMsgPassword().getText();
		
		Assert.assertTrue(pass.equals(condicao), mensagem);
	}
	
	@After
	public void finalizaTeste() throws Exception {
		DriverFactory.fechaApp();
	}
	
}
