package br.com.keeggo.projectkeeggo.logic;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;

import br.com.keeggo.projectkeeggo.config.ConsoleColors;
import br.com.keeggo.projectkeeggo.page.CadastroPage;
import br.com.keeggo.projectkeeggo.page.HomePage;
import br.com.keeggo.projectkeeggo.page.LoginPage;
import br.com.keeggo.projectkeeggo.utils.ConfigEvidencia;
import br.com.keeggo.projectkeeggo.utils.UsuarioRandom;
import br.com.keeggo.projectkeeggo.utils.WebDriverConfig;


public class HomeLogic {

	private HomePage homePage;

	private LoginPage loginPage;
	
	private ConfigEvidencia configEvidencia;
	
	public HomeLogic() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
		WebDriverConfig.browser = new ChromeDriver();
		WebDriverConfig.browser.navigate().to(CadastroPage.URL_HOME);
		this.homePage = new HomePage();
		this.loginPage = new LoginPage();
		this.configEvidencia = new ConfigEvidencia();
		this.configEvidencia.configuracoesEvidences();
	}
	
	//Clica no botão para abrir pop up de login
	public void clickIconeAbrirPopUpLogin() {
		final String msg = ConsoleColors.YELLOW + "\t\t\t\tLogs: ---- Clico no ícone de usuário ----";
		System.out.println(msg);
		WebDriverConfig.waitElementToBeClickable(this.homePage.getByRedirecionaLogin(), Duration.ofSeconds(50));
		this.configEvidencia.gerarScreenshot(WebDriverConfig.browser);
		WebDriverConfig.browser.findElement(homePage.getByRedirecionaLogin()).click();
	}

	// Clica no botão para redirecionar para tela de cadastro e retorna o WebDriver em execução
	public void clickBtnRedirecionarParaCadastro() {
		final String msg = "\t\t\tLogs: ---- Clico no botão \"CREATE NEW ACCOUNT\"----";
		System.out.println(msg);
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebDriverConfig.waitElementToBeClickable(this.loginPage.getByBtnCriarNovousuario(), Duration.ofSeconds(50));
		this.configEvidencia.gerarScreenshot(WebDriverConfig.browser);
		WebDriverConfig.browser.findElement(this.loginPage.getByBtnCriarNovousuario()).click();
	}
	
	// Campo Usuario
	public void preencherCampoUsuario() {
		final String msg = "\t\t\tLogs: ---- Preencho o campo \"Usermame\"----";
		System.out.println(msg);
		UsuarioRandom.lerFileTxt();
		this.configEvidencia.gerarScreenshot(WebDriverConfig.browser);
		WebDriverConfig.waitElementToBeClickable(this.loginPage.getByInputUserName(), Duration.ofSeconds(50));
		WebDriverConfig.browser.findElement(this.loginPage.getByInputUserName()).sendKeys(UsuarioRandom.nomeUsuario);
		
	}
	
	//Campo Senha
	public void preencherCampoSenha() {
		final String msg = "\t\t\tLogs: ---- Preencho o campo \"Password\"----";
		System.out.println(msg);
		this.configEvidencia.gerarScreenshot(WebDriverConfig.browser);
		WebDriverConfig.waitElementToBeClickable(this.loginPage.getByInputPassWord(), Duration.ofSeconds(50));
		WebDriverConfig.browser.findElement(this.loginPage.getByInputPassWord()).sendKeys(CadastroPage.senha);
	}
	
	// Clica no botão de realizar login
	public void clickBtnRealizarLogin() {
		final String msg = "\t\t\tLogs: ---- Clico no botão \"SIGN IN\"----";
		System.out.println(msg);
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		WebDriverConfig.waitElementToBeClickable(this.loginPage.getByBtnSignIn(), Duration.ofSeconds(50));
		this.configEvidencia.gerarScreenshot(WebDriverConfig.browser);
		WebDriverConfig.browser.findElement(this.loginPage.getByBtnSignIn()).click();	
	}
	
	
	
}
