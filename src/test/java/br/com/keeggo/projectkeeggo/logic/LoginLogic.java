package br.com.keeggo.projectkeeggo.logic;

import br.com.keeggo.projectkeeggo.config.ConsoleColors;
import br.com.keeggo.projectkeeggo.page.CadastroPage;
import br.com.keeggo.projectkeeggo.page.LoginPage;
import br.com.keeggo.projectkeeggo.utils.ConfigEvidencia;
import br.com.keeggo.projectkeeggo.utils.UsuarioRandom;
import br.com.keeggo.projectkeeggo.utils.WebDriverConfig;

public class LoginLogic {
	
	private LoginPage loginPage;
	
	private ConfigEvidencia configEvidencia;
	
	public LoginLogic() {
		this.loginPage = new LoginPage();
		this.configEvidencia = new ConfigEvidencia();
	}
	
	//Seleciona uma categoria e retorna o WebDriver em execução
	public void selecionarCategoria() {
		final String msg = ConsoleColors.YELLOW + "\t\t\t\tLogs: ---- Clico em um categoria de produto ----";
		System.out.println(msg);
		WebDriverConfig.waitElementToBeClickable(this.loginPage.getByCategoria(), 50);
		this.configEvidencia.gerarScreenshot(WebDriverConfig.browser);
		WebDriverConfig.browser.findElement(this.loginPage.getByCategoria()).click(); 
	}
	
	// Verifica se encontra os elementos para validar
	public boolean validarLogin() {
		final String msg = "\t\t\tLogs: ---- Valido Login ----" + ConsoleColors.RESET;
		System.out.println(msg);
		WebDriverConfig.waitElementToVisibility(this.loginPage.getByNomeUsuario(), 50);
		this.configEvidencia.gerarScreenshot(WebDriverConfig.browser);
		this.configEvidencia.fecharPdf();
		return WebDriverConfig.browser.getCurrentUrl().equals(CadastroPage.URL_HOME) && 
		WebDriverConfig.browser.findElement(this.loginPage.getByNomeUsuario()).getText().equals(UsuarioRandom.nomeUsuario);
	}
	
	
	// Clica no Icone de carrinho para adicionar um produto e retorna o WebDriver em execução
	public void clicarIconeCarrinho() { 
		final String msg = "\t\t\tLogs: ---- Clico no ícone de carrinho ----";
		System.out.println(msg);
		WebDriverConfig.waitElementToBeClickable(this.loginPage.getByIconeCarrinho(), 50);
		this.configEvidencia.gerarScreenshot(WebDriverConfig.browser);
		WebDriverConfig.browser.findElement(this.loginPage.getByIconeCarrinho()).click();
	}
}
