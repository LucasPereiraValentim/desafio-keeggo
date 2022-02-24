package br.com.keeggo.projectkeeggo.logic;

import java.time.Duration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.keeggo.projectkeeggo.page.LoginPage;
import br.com.keeggo.projectkeeggo.utils.ConfigEvidencia;
import br.com.keeggo.projectkeeggo.utils.UsuarioRandom;
import br.com.keeggo.projectkeeggo.utils.WebDriverConfig;

public class LoginLogic {
	
	private static final Logger LOG = LoggerFactory.getLogger(HomeLogic.class);
	
	private LoginPage loginPage;
	
	private ConfigEvidencia configEvidencia;
	
	public LoginLogic() {
		this.loginPage = new LoginPage();
		this.configEvidencia = new ConfigEvidencia();
	}
	
	//Seleciona uma categoria e retorna o WebDriver em execução
	public void selecionarCategoria() {
		String msg = "Clico em uma categoria de produto";
		LOG.info(msg);;
		WebDriverConfig.waitElementToBeClickable(this.loginPage.getByCategoria(), Duration.ofSeconds(50));
		this.configEvidencia.gerarScreenshot(WebDriverConfig.browser);
		WebDriverConfig.browser.findElement(this.loginPage.getByCategoria()).click(); 
	}
	
	// Verifica se encontra os elementos para validar
	public boolean validarLogin() {
		String msg = "Válido Login";
		LOG.info(msg);
		WebDriverConfig.waitElementToVisibility(this.loginPage.getByNomeUsuario(), Duration.ofSeconds(80));
		this.configEvidencia.gerarScreenshot(WebDriverConfig.browser);
		this.configEvidencia.fecharPdf();
		return WebDriverConfig.browser.getCurrentUrl().equals(WebDriverConfig.URL_HOME) && 
		WebDriverConfig.browser.findElement(this.loginPage.getByNomeUsuario()).getText().equals(UsuarioRandom.nomeUsuario);
	}
	
	
	// Clica no Icone de carrinho para adicionar um produto e retorna o WebDriver em execução
	public void clicarIconeCarrinho() { 
		String msg = "Clico no ícone de carrinho";
		LOG.info(msg);
		WebDriverConfig.waitElementToBeClickable(this.loginPage.getByIconeCarrinho(), Duration.ofSeconds(50));
		this.configEvidencia.gerarScreenshot(WebDriverConfig.browser);
		WebDriverConfig.browser.findElement(this.loginPage.getByIconeCarrinho()).click();
	}
}
