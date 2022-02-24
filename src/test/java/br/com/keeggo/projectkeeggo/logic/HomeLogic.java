package br.com.keeggo.projectkeeggo.logic;

import java.time.Duration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.keeggo.projectkeeggo.page.CadastroPage;
import br.com.keeggo.projectkeeggo.page.HomePage;
import br.com.keeggo.projectkeeggo.page.LoginPage;
import br.com.keeggo.projectkeeggo.utils.ConfigEvidencia;
import br.com.keeggo.projectkeeggo.utils.UsuarioRandom;
import br.com.keeggo.projectkeeggo.utils.WebDriverConfig;


public class HomeLogic {
	
	private static final Logger LOG = LoggerFactory.getLogger(HomeLogic.class);

	private HomePage homePage;

	private LoginPage loginPage;
	
	private ConfigEvidencia configEvidencia;
	
	public HomeLogic() {
		WebDriverConfig.initDriver();
		WebDriverConfig.navigateToURL();
		WebDriverConfig.maximizeBrowser();
		this.homePage = new HomePage();
		this.loginPage = new LoginPage();
		this.configEvidencia = new ConfigEvidencia();
		this.configEvidencia.configuracoesEvidences();
	}
	
	//Clica no botão para abrir pop up de login
	public void clickIconeAbrirPopUpLogin() {
		String msg = "Clico no ícone de usuário";
		LOG.info(msg);
		WebDriverConfig.waitElementToBeClickable(this.homePage.getByRedirecionaLogin(), Duration.ofMinutes(1));
		this.configEvidencia.gerarScreenshot(WebDriverConfig.browser);
		WebDriverConfig.browser.findElement(homePage.getByRedirecionaLogin()).click();
	}

	// Clica no botão para redirecionar para tela de cadastro e retorna o WebDriver em execução
	public void clickBtnRedirecionarParaCadastro() {
		String msg = "Clico no botão \"CREATE NEW ACCOUNT\"";
		LOG.info(msg);
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebDriverConfig.waitElementToBeClickable(this.loginPage.getByBtnCriarNovousuario(), Duration.ofSeconds(50));
		this.configEvidencia.gerarScreenshot(WebDriverConfig.browser);
		WebDriverConfig.browser.findElement(this.loginPage.getByBtnCriarNovousuario()).click();
	}
	
	// Campo Usuario
	public void preencherCampoUsuario() {
		String msg = "Preencho o campo \"Usermame\"";
		LOG.info(msg);
		UsuarioRandom.lerFileTxt();
		this.configEvidencia.gerarScreenshot(WebDriverConfig.browser);
		WebDriverConfig.waitElementToBeClickable(this.loginPage.getByInputUserName(), Duration.ofSeconds(50));
		WebDriverConfig.browser.findElement(this.loginPage.getByInputUserName()).sendKeys(UsuarioRandom.nomeUsuario);
		
	}
	
	//Campo Senha
	public void preencherCampoSenha() {
		String msg = "Preencho o campo \"Password\"";
		LOG.info(msg);
		this.configEvidencia.gerarScreenshot(WebDriverConfig.browser);
		WebDriverConfig.waitElementToBeClickable(this.loginPage.getByInputPassWord(), Duration.ofSeconds(50));
		WebDriverConfig.browser.findElement(this.loginPage.getByInputPassWord()).sendKeys(CadastroPage.senha);
	}
	
	// Clica no botão de realizar login
	public void clickBtnRealizarLogin() {
		String msg = "Clico no botão \"SIGN IN\"";
		LOG.info(msg);
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebDriverConfig.waitElementToBeClickable(this.loginPage.getByBtnSignIn(), Duration.ofSeconds(50));
		this.configEvidencia.gerarScreenshot(WebDriverConfig.browser);
		WebDriverConfig.browser.findElement(this.loginPage.getByBtnSignIn()).click();	
	}
	
	
	
}
