package br.com.rsinet.hub_bdd.stepDefinitions;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import br.com.rsinet.hub_bdd.pageObject.HomePage;
import br.com.rsinet.hub_bdd.pageObject.PesquisaPage;
import br.com.rsinet.hub_tdd.utils.Constantes;
import br.com.rsinet.hub_tdd.utils.DriverFactory;
import br.com.rsinet.hub_tdd.utils.ExcelUtils;
import br.com.rsinet.hub_tdd.utils.PegaMassa;
import cucumber.api.java.After;
import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Entao;
import cucumber.api.java.pt.Quando;
import io.appium.java_client.android.AndroidDriver;

public class BuscaLupa {
	
	private AndroidDriver<WebElement> driver;
	private HomePage homePage;
	private PegaMassa pegaMassa;
	private PesquisaPage pesquisaPage;
	
	@Dado("^que o usuario tenha entrado no app e digitado o nome do produto desejado na barra de pesquisa$")
	public void que_o_usuario_tenha_entrado_no_app_e_digitado_o_nome_do_produto_desejado_na_barra_de_pesquisa() throws Throwable {
		ExcelUtils.setExcelFile(Constantes.Path_TestData + Constantes.File_TestData, "PesquisaBarra");
		pesquisaPage = PageFactory.initElements(driver, PesquisaPage.class);
		homePage = PageFactory.initElements(driver, HomePage.class);
		pegaMassa = new PegaMassa();
		
		homePage.preencheBarraPesquisa(pegaMassa.PesquisaNaBarra());
	}

	@Quando("^clicar em pesquisar$")
	public void clicar_em_pesquisar() throws Throwable {
		homePage.clicaLupa();
	}

	@Quando("^ele selecionar o produto desejado$")
	public void ele_selecionar_o_produto_desejado() throws Throwable {
		pesquisaPage.clicaProduto();
	}

	@Entao("^checar se o produto selecionado foi encontrado$")
	public void checar_se_o_produto_selecionado_foi_encontrado() throws Throwable {
		String condicao = pegaMassa.CondicaoAssertBarra();
		String mensagem = pegaMassa.MenssagemAssertBarra();
		
		String pass = pesquisaPage.encontraNomePorduto(driver).getText();
		Assert.assertTrue(pass.equals(condicao), mensagem);
	}

	@Dado("^que o usuario tenha entrado no app e digitado o nome do produto inexistente no banco na barra de pesquisa$")
	public void que_o_usuario_tenha_entrado_no_app_e_digitado_o_nome_do_produto_inexistente_no_banco_na_barra_de_pesquisa() throws Throwable {
		homePage.preencheBarraPesquisa(pegaMassa.PesquisaNaBarraErro());
	}
	
	@Quando("^pesquisar o produto inexistente$")
	public void pesquisar_o_produto_inexistente() throws Throwable {
		homePage.clicaLupa();
	}

	@Entao("^checar no banco de dados e informar que nao foi encontrado nenhum resultado para o produto desejado$")
	public void checar_no_banco_de_dados_e_informar_que_nao_foi_encontrado_nenhum_resultado_para_o_produto_desejado() throws Throwable {
		String elemento = pegaMassa.PesquisaNaBarraErro();
		String resposta = pesquisaPage.encontraResultadoPesquisa(driver).getText();
		Assert.assertTrue(resposta.equals("- No results for " + "\"" + elemento + "\" -"),
				"Nenhum resultado encontrado para " + elemento + "!");
	}
	
	@After
	public void finalizaTeste() throws Exception {
		DriverFactory.fechaApp();
	}


}
