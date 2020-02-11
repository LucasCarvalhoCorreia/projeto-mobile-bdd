package br.com.rsinet.hub_bdd.stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import br.com.rsinet.hub_bdd.excel.Constantes;
import br.com.rsinet.hub_bdd.excel.ExcelUtils;
import br.com.rsinet.hub_bdd.excel.PegaMassa;
import br.com.rsinet.hub_bdd.manager.ScreenObjectManager;
import br.com.rsinet.hub_bdd.manager.TestContext;
import br.com.rsinet.hub_bdd.screenObject.HomeScreen;
import br.com.rsinet.hub_bdd.screenObject.PesquisaScreen;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;

public class ConsultaPorBarraDePesquisa {
	
	private WebDriver driver;
	private HomeScreen homeScreen;
	private PegaMassa pegaMassa;
	private PesquisaScreen pesquisaScreen;
	private TestContext testContext;
	
	public ConsultaPorBarraDePesquisa(TestContext context) throws Exception {
		testContext = context;
		driver = testContext.getDriverFactory().iniciaApp();
	}
	
	
	@Dado("^que o usuario tenha entrado no app e digitado o nome do produto desejado na barra de pesquisa$")
	public void que_o_usuario_tenha_entrado_no_app_e_digitado_o_nome_do_produto_desejado_na_barra_de_pesquisa() throws Throwable {
		PageFactory.initElements(driver, this);
		ScreenObjectManager manager = new ScreenObjectManager(driver);
		homeScreen = manager.getHomeScreen();
		pegaMassa = manager.getPegaMassa();
		pesquisaScreen = manager.getPesquisaScreen();
		
		ExcelUtils.setExcelFile(Constantes.Path_TestData + Constantes.File_TestData, "PesquisaBarra");
		
		homeScreen.preencheBarraPesquisa(pegaMassa.PesquisaNaBarra());
	}

	@Quando("^clicar em pesquisar$")
	public void clicar_em_pesquisar() throws Throwable {
		homeScreen.clicaLupa();
	}

	@Quando("^ele selecionar o produto desejado$")
	public void ele_selecionar_o_produto_desejado() throws Throwable {
		pesquisaScreen.clicaProduto();
	}

	@Entao("^checar se o produto selecionado foi encontrado$")
	public void checar_se_o_produto_selecionado_foi_encontrado() throws Throwable {
		String condicao = pegaMassa.CondicaoAssertBarra();
		String mensagem = pegaMassa.MenssagemAssertBarra();
		
		String pass = pesquisaScreen.encontraNomePorduto(driver).getText();
		Assert.assertTrue(pass.equals(condicao), mensagem);
	}

	@Dado("^que o usuario tenha entrado no app e digitado o nome do produto inexistente no banco na barra de pesquisa$")
	public void que_o_usuario_tenha_entrado_no_app_e_digitado_o_nome_do_produto_inexistente_no_banco_na_barra_de_pesquisa() throws Throwable {
		ExcelUtils.setExcelFile(Constantes.Path_TestData + Constantes.File_TestData, "PesquisaBarra");
		PageFactory.initElements(driver, this);
		ScreenObjectManager manager = new ScreenObjectManager(driver);
		homeScreen = manager.getHomeScreen();
		pesquisaScreen = manager.getPesquisaScreen();
		pegaMassa = manager.getPegaMassa();
		
		homeScreen.preencheBarraPesquisa(pegaMassa.PesquisaNaBarraErro());
	}
	
	@Quando("^pesquisar o produto inexistente$")
	public void pesquisar_o_produto_inexistente() throws Throwable {
		homeScreen.clicaLupa();
	}

	@Entao("^checar no banco de dados e informar que nao foi encontrado nenhum resultado para o produto desejado$")
	public void checar_no_banco_de_dados_e_informar_que_nao_foi_encontrado_nenhum_resultado_para_o_produto_desejado() throws Throwable {
		String elemento = pegaMassa.PesquisaNaBarraErro();
		String resposta = pesquisaScreen.encontraResultadoPesquisa(driver).getText();
		Assert.assertTrue(resposta.equals("- No results for " + "\"" + elemento + "\" -"),
				"Nenhum resultado encontrado para " + elemento + "!");
	}
	
}
