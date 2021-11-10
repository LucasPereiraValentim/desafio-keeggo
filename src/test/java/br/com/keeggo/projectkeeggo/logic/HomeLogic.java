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

	public void clickBtnRedirecionarLogin() {
		final String msg = ConsoleColors.YELLOW + "\t\t\t\tLogs: ---- Clico no ícone de usuário ----";
		System.out.println(msg);
		super.waitElementToBeClickable(this.homePage.getByRedirecionaLogin(), 30);
		this.configEvidencia.gerarScreenshot(super.browser);
		super.browser.findElement(homePage.getByRedirecionaLogin()).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public CadastroLogic clickBtnRedirecionarParaCadastro() {
		final String msg = "\t\t\tLogs: ---- Clico no botão \"CREATE NEW ACCOUNT\"----";
		System.out.println(msg);
		try {
			Thread.sleep(15000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.configEvidencia.gerarScreenshot(super.browser);
		super.browser.findElement(this.loginPage.getByBtnCriarNovousuario()).click();
		return new CadastroLogic(super.browser);
	}
	
	//Input Login
	public void preencherCampoUsuario() {
		final String msg = "\t\t\tLogs: ---- Preencho o campo \"Usermame\"----";
		System.out.println(msg);
		this.configEvidencia.gerarScreenshot(super.browser);
		super.waitElementToBeClickable(this.loginPage.getByInputUserName(), 10);
		super.browser.findElement(this.loginPage.getByInputUserName()).sendKeys(CadastroPage.NOME_USUARIO);
		
	}
	
	//Input senha
	public void preencherCampoSenha() {
		final String msg = "\t\t\tLogs: ---- Preencho o campo \"Password\"----";
		System.out.println(msg);
		this.configEvidencia.gerarScreenshot(super.browser);
		super.waitElementToBeClickable(this.loginPage.getByInputPassWord(), 10);
		super.browser.findElement(this.loginPage.getByInputPassWord()).sendKeys(CadastroPage.SENHA);
	}
	
	//Btn Sign in
	public LoginLogic clickBtnRealizarLogin() {
		final String msg = "\t\t\tLogs: ---- Clico no botão \"SIGN IN\"----";
		System.out.println(msg);
		super.waitElementToBeClickable(this.loginPage.getByBtnSignIn(), 20);
		this.configEvidencia.gerarScreenshot(super.browser);
		super.browser.findElement(this.loginPage.getByBtnSignIn()).click();	
		return new LoginLogic(super.browser);
	}
	
	
	
}
