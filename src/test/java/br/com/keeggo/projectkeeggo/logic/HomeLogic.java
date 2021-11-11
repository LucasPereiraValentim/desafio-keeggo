package br.com.keeggo.projectkeeggo.logic;

import br.com.keeggo.projectkeeggo.config.ConfigEvidencia;
import br.com.keeggo.projectkeeggo.config.ConsoleColors;
import br.com.keeggo.projectkeeggo.logic.webdriver.WebDriverConfig;
import br.com.keeggo.projectkeeggo.page.CadastroPage;
import br.com.keeggo.projectkeeggo.page.HomePage;
import br.com.keeggo.projectkeeggo.page.LoginPage;

public class HomeLogic extends WebDriverConfig {

	private HomePage homePage;

	private LoginPage loginPage;
	
	private ConfigEvidencia configEvidencia;
	
	public HomeLogic() {
		super(null);
		this.homePage = new HomePage();
		this.loginPage = new LoginPage();
		this.configEvidencia = new ConfigEvidencia();
		this.configEvidencia.configuracoesEvidences();
	}
	
	//Clica no botão para abrir pop up de login
	public void clickIconeAbrirPopUpLogin() {
		final String msg = ConsoleColors.YELLOW + "\t\t\t\tLogs: ---- Clico no ícone de usuário ----";
		System.out.println(msg);
		super.waitElementToBeClickable(this.homePage.getByRedirecionaLogin(), 30);
		this.configEvidencia.gerarScreenshot(super.browser);
		super.browser.findElement(homePage.getByRedirecionaLogin()).click();
	}

	// Clica no botão para redirecionar para tela de cadastro e retorna o WebDriver em execução
	public CadastroLogic clickBtnRedirecionarParaCadastro() {
		final String msg = "\t\t\tLogs: ---- Clico no botão \"CREATE NEW ACCOUNT\"----";
		System.out.println(msg);
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		super.waitElementToBeClickable(this.loginPage.getByBtnCriarNovousuario(), 40);
		this.configEvidencia.gerarScreenshot(super.browser);
		super.browser.findElement(this.loginPage.getByBtnCriarNovousuario()).click();
		return new CadastroLogic(super.browser);
	}
	
	// Campo Usuario
	public void preencherCampoUsuario() {
		final String msg = "\t\t\tLogs: ---- Preencho o campo \"Usermame\"----";
		System.out.println(msg);
		this.configEvidencia.gerarScreenshot(super.browser);
		super.waitElementToBeClickable(this.loginPage.getByInputUserName(), 40);
		super.browser.findElement(this.loginPage.getByInputUserName()).sendKeys(CadastroPage.NOME_USUARIO);
		
	}
	
	//Campo Senha
	public void preencherCampoSenha() {
		final String msg = "\t\t\tLogs: ---- Preencho o campo \"Password\"----";
		System.out.println(msg);
		this.configEvidencia.gerarScreenshot(super.browser);
		super.waitElementToBeClickable(this.loginPage.getByInputPassWord(), 40);
		super.browser.findElement(this.loginPage.getByInputPassWord()).sendKeys(CadastroPage.SENHA);
	}
	
	// Clica no botão de realizar login
	public LoginLogic clickBtnRealizarLogin() {
		final String msg = "\t\t\tLogs: ---- Clico no botão \"SIGN IN\"----";
		System.out.println(msg);
		super.waitElementToBeClickable(this.loginPage.getByBtnSignIn(), 40);
		this.configEvidencia.gerarScreenshot(super.browser);
		super.browser.findElement(this.loginPage.getByBtnSignIn()).click();	
		return new LoginLogic(super.browser);
	}
	
	
	
}
