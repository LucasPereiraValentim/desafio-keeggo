package br.com.keeggo.projectkeeggo.logic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import br.com.keeggo.projectkeeggo.config.ConfigEvidencia;
import br.com.keeggo.projectkeeggo.config.ConsoleColors;
import br.com.keeggo.projectkeeggo.logic.webdriver.WebDriverConfig;
import br.com.keeggo.projectkeeggo.page.CadastroPage;

public class CadastroLogic extends WebDriverConfig{
	
	private CadastroPage cadastroPage;
	
	private ConfigEvidencia configEvidencia;
	
	public CadastroLogic(WebDriver browser) {
		super(browser);
		this.cadastroPage = new CadastroPage();
		this.configEvidencia = new ConfigEvidencia();
	}

	public void preenchoUsuario() {
		final String msg = "\t\t\tLogs: ---- Preencho o campo \"Username\" ----";
		System.out.println(msg);
		super.waitElement(cadastroPage.getByInputNomeDeUsuario(), 20L);
		super.browser.findElement(this.cadastroPage.getByInputNomeDeUsuario()).sendKeys(CadastroPage.NOME_USUARIO);	
		this.configEvidencia.gerarScreenshot(super.browser);
		
	}
	public void preenchoEmail() {
		final String msg = "\t\t\tLogs: ---- Preencho o campo \"Email\" ----";
		System.out.println(msg);
		super.waitElement(cadastroPage.getByInputEmail(), 5L);
		super.browser.findElement(this.cadastroPage.getByInputEmail()).sendKeys("lucas.costa@pop.com.br");
		this.configEvidencia.gerarScreenshot(super.browser);
	}
	
	public void preenchoSenha() {
		final String msg = "\t\t\tLogs: ---- Preencho o campo \"Password\" ----";
		System.out.println(msg);
		super.waitElement(cadastroPage.getByInputSenha(), 5L);
		super.browser.findElement(this.cadastroPage.getByInputSenha()).sendKeys("#Pp82369785");
		this.configEvidencia.gerarScreenshot(super.browser);
	}
	
	public void preenchoSenhaConfirmacao() {
		final String msg = "\t\t\tLogs: ---- Preencho o campo \"Confirm password\" ----";
		System.out.println(msg);
		super.waitElement(cadastroPage.getByInputSenhaConfirmacao(), 5L);
		super.browser.findElement(this.cadastroPage.getByInputSenhaConfirmacao()).sendKeys("#Pp82369785");
		this.configEvidencia.gerarScreenshot(super.browser);
	}
	
	public void preenchoPrimeiroNome() {
		final String msg = "\t\t\tLogs: ---- Preencho o campo \"Fist Name\" ----";
		System.out.println(msg);
		super.waitElement(cadastroPage.getByInputPrimeiroNome(), 5L);
		super.browser.findElement(this.cadastroPage.getByInputPrimeiroNome()).sendKeys("Lucas");
		this.configEvidencia.gerarScreenshot(super.browser);
	}
	
	public void preenchoSegundoNome() {
		final String msg = "\t\t\tLogs: ---- Preencho o campo \"Last Name\" ----";
		System.out.println(msg);
		super.waitElement(cadastroPage.getByInputSegundoNome(), 5L);
		super.browser.findElement(this.cadastroPage.getByInputSegundoNome()).sendKeys("Valentim");
		this.configEvidencia.gerarScreenshot(super.browser);
	}
	
	public void preenchoTelefone() {
		final String msg = "\t\t\tLogs: ---- Preencho o campo \"Phone Number\" ----";
		System.out.println(msg);
		super.waitElement(cadastroPage.getByInputTelefone(), 5L);
		super.browser.findElement(this.cadastroPage.getByInputTelefone()).sendKeys("(61) 111-111");
		this.configEvidencia.gerarScreenshot(super.browser);
	}
	
	public void SelecionoBrasilSelect() {
		final String msg = "\t\t\tLogs: ---- Seleciono \"Brazil\" no campo select \"Country\" ----";
		System.out.println(msg);
		Select select = new Select(super.browser.findElement(this.cadastroPage.getSelectPais()));
		select.selectByVisibleText("Brazil");
		this.configEvidencia.gerarScreenshot(super.browser);
	}
	
	public void preenchoCidade() {
		final String msg = "\t\t\tLogs: ---- Preencho o campo \"City\" ----";
		System.out.println(msg);
		super.waitElement(cadastroPage.getByInputCidade(), 5L);
		super.browser.findElement(this.cadastroPage.getByInputCidade()).sendKeys("Planaltina");
		this.configEvidencia.gerarScreenshot(super.browser);
	}
	
	
	public void preenchoEndereco() {
		final String msg = "\t\t\tLogs: ---- Preencho o campo \"Adress\" ----";
		System.out.println(msg);
		super.waitElement(cadastroPage.getByInputEndereco(), 5L);
		super.browser.findElement(this.cadastroPage.getByInputEndereco()).sendKeys("Q. 5 Conj. F Lote 90");
		this.configEvidencia.gerarScreenshot(super.browser);
	}
	
	public void preenchoEstado() {
		final String msg = "\t\t\tLogs: ---- Preencho o campo \"State/Province/Region\" ----";
		System.out.println(msg);
		super.waitElement(cadastroPage.getByInputEstado(), 5L);
		super.browser.findElement(this.cadastroPage.getByInputEstado()).sendKeys("Brasília");
		this.configEvidencia.gerarScreenshot(super.browser);
	}
	
	
	public void preenchoCep() {
		final String msg = "\t\t\tLogs: ---- Preencho o campo \"Postal Code\" ----";
		System.out.println(msg);
		super.waitElement(cadastroPage.getByInputCep(), 5L);
		super.browser.findElement(this.cadastroPage.getByInputCep()).sendKeys("73350-410");
		this.configEvidencia.gerarScreenshot(super.browser);
	}
	
	public void clicoCheckBoxTermosDePrivacidade() {
		final String msg =
				"\t\t\tLogs: ---- Clico na CheckBox \"I agree to the advantageonlineshopping.com Conditions Of Use and Privacy Notice\" ----";
		System.out.println(msg);
		super.waitElement(cadastroPage.getByCheckBoxConcordoTermos(), 5L);
		super.browser.findElement(this.cadastroPage.getByCheckBoxConcordoTermos()).click();
		this.configEvidencia.gerarScreenshot(super.browser);
	}
	
	
	public void clicoBtnRegistro() {
		final String msg = "\t\t\tLogs: ---- Clico no botão \"Register\" ----";
		System.out.println(msg);
		super.waitElement(cadastroPage.getByBtnRegistrar(), 5L);
		super.browser.findElement(this.cadastroPage.getByBtnRegistrar()).click();
		this.configEvidencia.gerarScreenshot(super.browser);
	}
	
	
	public boolean validarCadastro() {
		final String msg = "\t\t\tLogs: ---- Valido cadastro ----" + ConsoleColors.RESET;
		System.out.println(msg);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.configEvidencia.gerarScreenshot(super.browser);
		this.configEvidencia.fecharPdf();
		return super.browser.getCurrentUrl().equals(CadastroPage.URL_HOME) && 
				super.browser.findElement(this.cadastroPage.getByNomeUsuario()).getText().equals(CadastroPage.NOME_USUARIO);
	}
	
}
