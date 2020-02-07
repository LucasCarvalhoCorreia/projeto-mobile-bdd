package br.com.rsinet.hub_bdd.manager;

import org.openqa.selenium.WebDriver;

import br.com.rsinet.hub_bdd.excel.PegaMassa;
import br.com.rsinet.hub_bdd.screenObject.CadastroScreen;
import br.com.rsinet.hub_bdd.screenObject.HomeScreen;
import br.com.rsinet.hub_bdd.screenObject.PesquisaScreen;

public class ScreenObjectManager {
	
	private WebDriver driver;
	
	private HomeScreen homeScreen;
	private CadastroScreen cadastroScreen;
	private PesquisaScreen pesquisaScreen;
	private PegaMassa pegaMassa;
	
	
	public ScreenObjectManager(WebDriver driver) {
		this.driver = driver;
	}
	
	public HomeScreen getHomeScreen() {
		return (homeScreen == null) ? homeScreen = new HomeScreen(driver) : homeScreen;
	}
	
	public CadastroScreen getCadastroScreen() {
		return (cadastroScreen == null) ? cadastroScreen = new CadastroScreen(driver) : cadastroScreen;
	}
	
	public PesquisaScreen getPesquisaScreen() {
		return (pesquisaScreen == null) ? pesquisaScreen = new PesquisaScreen(driver) : pesquisaScreen;
	}
	
	public PegaMassa getPegaMassa() {
		return (pegaMassa == null) ? pegaMassa = new PegaMassa(driver) : pegaMassa;
	}

}
