package br.com.keeggo.projectkeeggo.logic;

import br.com.keeggo.projectkeeggo.config.ConfigEvidencia;
import br.com.keeggo.projectkeeggo.logic.webdriver.WebDriverConfig;
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
		final String msg = "\t\t\tLogs: ---- Clico no ícone de usuário ----";
		System.out.println(msg);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.configEvidencia.gerarScreenshot(super.browser);
		super.browser.findElement(homePage.getByRedirecionaLogin()).click();
	}

	public CadastroLogic clickBtnRedirecionarParaCadastro() {
		final String msg = "\t\t\tLogs: ---- Clico no botão \"CREATE NEW ACCOUNT\"----";
		System.out.println(msg);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.configEvidencia.gerarScreenshot(super.browser);
		super.browser.findElement(this.loginPage.getByBtnCriarNovoUsuario()).click();
		return new CadastroLogic(super.browser);
	}
}
