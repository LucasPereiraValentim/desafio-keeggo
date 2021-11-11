package br.com.keeggo.projectkeeggo.logic;

import org.openqa.selenium.WebDriver;

import br.com.keeggo.projectkeeggo.config.ConfigEvidencia;
import br.com.keeggo.projectkeeggo.config.ConsoleColors;
import br.com.keeggo.projectkeeggo.logic.webdriver.WebDriverConfig;
import br.com.keeggo.projectkeeggo.page.CadastroPage;
import br.com.keeggo.projectkeeggo.page.LoginPage;

public class LoginLogic extends WebDriverConfig{
	
	private LoginPage loginPage;
	
	private ConfigEvidencia configEvidencia;
	
	public LoginLogic(WebDriver browser) {
		super(browser);
		this.loginPage = new LoginPage();
		this.configEvidencia = new ConfigEvidencia();
	}
	
	//Seleciona uma categoria e retorna o WebDriver em execução
	public ProdutoLogic selecionarCategoria() {
		final String msg = ConsoleColors.YELLOW + "\t\t\t\tLogs: ---- Clico em um categoria de produto ----";
		System.out.println(msg);
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.configEvidencia.gerarScreenshot(super.browser);
		super.browser.findElement(this.loginPage.getByCategoria()).click();
		return new ProdutoLogic(super.browser); 
	}
	
	// Verifica se encontra os elementos para validar
	public boolean validarLogin() {
		final String msg = "\t\t\tLogs: ---- Valido Login ----" + ConsoleColors.RESET;
		System.out.println(msg);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.configEvidencia.gerarScreenshot(super.browser);
		this.configEvidencia.fecharPdf();
		return super.browser.getCurrentUrl().equals(CadastroPage.URL_HOME) && 
				super.browser.findElement(this.loginPage.getByNomeUsuario()).getText().equals(CadastroPage.NOME_USUARIO);
	}
	
	
	// Clica no Icone de carrinho para adicionar um produto e retorna o WebDriver em execução
	public CarrinhoLogic clicarIconeCarrinho() { 
		final String msg = "\t\t\tLogs: ---- Clico no ícone de carrinho ----";
		System.out.println(msg);
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.configEvidencia.gerarScreenshot(super.browser);
		super.browser.findElement(this.loginPage.getByIconeCarrinho()).click();
		return new CarrinhoLogic(super.browser);
	}
}
