package br.com.keeggo.projectkeeggo.logic;

import br.com.keeggo.projectkeeggo.logic.webdriver.WebDriverConfig;
import br.com.keeggo.projectkeeggo.page.HomePage;
import br.com.keeggo.projectkeeggo.page.LoginPage;

public class HomeLogic extends WebDriverConfig {

	private HomePage homePage;

	private LoginPage loginPage;

	public HomeLogic() {
		super(null);
		this.homePage = new HomePage();
		this.loginPage = new LoginPage();
	}

	public void clickBtnRedirecionarLogin() {
		final String msg = "Log: ---- Clico no ícone de usuário ----";
		System.err.println(msg);
		super.waitElement(homePage.getByRedirecionaLogin(), 6L);
		super.browser.findElement(homePage.getByRedirecionaLogin()).click();
	}

	public CadastroLogic clickBtnRedirecionarParaCadastro() {
		final String msg = "Log: ---- Clico no botão \"CREATE NEW ACCOUNT\"----";
		System.err.println(msg);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		super.browser.findElement(this.loginPage.getByBtnCriarNovoUsuario()).click();
		return new CadastroLogic(super.browser);
	}
}
