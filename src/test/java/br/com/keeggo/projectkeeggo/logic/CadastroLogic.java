package br.com.keeggo.projectkeeggo.logic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import br.com.keeggo.projectkeeggo.logic.webdriver.WebDriverConfig;
import br.com.keeggo.projectkeeggo.page.CadastroPage;

public class CadastroLogic extends WebDriverConfig{
	
	private CadastroPage cadastroPage;
	
	public CadastroLogic(WebDriver browser) {
		super(browser);
		this.cadastroPage = new CadastroPage();
	}

	public void preenchoUsuario() {
		final String msg = "\t\t\tLog: ---- Preencho o campo \"Username\" ----";
		System.err.println(msg);
		super.waitElement(cadastroPage.getByInputNomeDeUsuario(), 20L);
		super.browser.findElement(this.cadastroPage.getByInputNomeDeUsuario()).sendKeys(CadastroPage.NOME_USUARIO);	
	}
	public void preenchoEmail() {
		final String msg = "\t\t\tLog: ---- Preencho o campo \"Email\" ----";
		System.err.println(msg);
		super.waitElement(cadastroPage.getByInputEmail(), 5L);
		super.browser.findElement(this.cadastroPage.getByInputEmail()).sendKeys("lucas.costa@pop.com.br");
	}
	
	public void preenchoSenha() {
		final String msg = "\t\t\tLog: ---- Preencho o campo \"Password\" ----";
		System.err.println(msg);
		super.waitElement(cadastroPage.getByInputSenha(), 5L);
		super.browser.findElement(this.cadastroPage.getByInputSenha()).sendKeys("#Pp82369785");
	}
	
	public void preenchoSenhaConfirmacao() {
		final String msg = "\t\t\tLog: ---- Preencho o campo \"Confirm password\" ----";
		System.err.println(msg);
		super.waitElement(cadastroPage.getByInputSenhaConfirmacao(), 5L);
		super.browser.findElement(this.cadastroPage.getByInputSenhaConfirmacao()).sendKeys("#Pp82369785");
	}
	
	public void preenchoPrimeiroNome() {
		final String msg = "\t\t\tLog: ---- Preencho o campo \"Fist Name\" ----";
		System.err.println(msg);
		super.waitElement(cadastroPage.getByInputPrimeiroNome(), 5L);
		super.browser.findElement(this.cadastroPage.getByInputPrimeiroNome()).sendKeys("Lucas");
	}
	
	public void preenchoSegundoNome() {
		final String msg = "\t\t\tLog: ---- Preencho o campo \"Last Name\" ----";
		System.err.println(msg);
		super.waitElement(cadastroPage.getByInputSegundoNome(), 5L);
		super.browser.findElement(this.cadastroPage.getByInputSegundoNome()).sendKeys("Valentim");
	}
	
	public void preenchoTelefone() {
		final String msg = "\t\t\tLog: ---- Preencho o campo \"Phone Number\" ----";
		System.err.println(msg);
		super.waitElement(cadastroPage.getByInputTelefone(), 5L);
		super.browser.findElement(this.cadastroPage.getByInputTelefone()).sendKeys("(61) 111-111");
	}
	
	public void SelecionoBrasilSelect() {
		final String msg = "\t\t\tLog: ---- Seleciono \"Brazil\" no campo select \"Country\" ----";
		System.err.println(msg);
		Select select = new Select(super.browser.findElement(this.cadastroPage.getSelectPais()));
		select.selectByVisibleText("Brazil");
	}
	
	public void preenchoCidade() {
		final String msg = "\t\t\tLog: ---- Preencho o campo \"City\" ----";
		System.err.println(msg);
		super.waitElement(cadastroPage.getByInputCidade(), 5L);
		super.browser.findElement(this.cadastroPage.getByInputCidade()).sendKeys("Planaltina");;
	}
	
	
	public void preenchoEndereco() {
		final String msg = "\t\t\tLog: ---- Preencho o campo \"Adress\" ----";
		System.err.println(msg);
		super.waitElement(cadastroPage.getByInputEndereco(), 5L);
		super.browser.findElement(this.cadastroPage.getByInputEndereco()).sendKeys("Q. 5 Conj. F Lote 90");
	}
	
	public void preenchoEstado() {
		final String msg = "\t\t\tLog: ---- Preencho o campo \"State/Province/Region\" ----";
		System.err.println(msg);
		super.waitElement(cadastroPage.getByInputEstado(), 5L);
		super.browser.findElement(this.cadastroPage.getByInputEstado()).sendKeys("Brasília");
	}
	
	
	public void preenchoCep() {
		final String msg = "\t\t\tLog: ---- Preencho o campo \"Postal Code\" ----";
		System.err.println(msg);
		super.waitElement(cadastroPage.getByInputCep(), 5L);
		super.browser.findElement(this.cadastroPage.getByInputCep()).sendKeys("73350-410");
	}
	
	public void clicoCheckBoxTermosDePrivacidade() {
		final String msg =
				"\t\t\tLog: ---- Clico na CheckBox \"I agree to the advantageonlineshopping.com Conditions Of Use and Privacy Notice\" ----";
		System.err.println(msg);
		super.waitElement(cadastroPage.getByCheckBoxConcordoTermos(), 5L);
		super.browser.findElement(this.cadastroPage.getByCheckBoxConcordoTermos()).click();
	}
	
	
	public void clicoBtnRegistro() {
		final String msg = "\t\t\tLog: ---- Clico no botão \"Register\" ----";
		System.err.println(msg);
		super.waitElement(cadastroPage.getByBtnRegistrar(), 5L);
		super.browser.findElement(this.cadastroPage.getByBtnRegistrar()).click();
	}
	
	
	public boolean validarCadastro() {
		final String msg = "\t\t\tLog: ---- Valido cadastro ----";
		System.err.println(msg);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return super.browser.getCurrentUrl().equals(CadastroPage.URL_HOME) && 
				super.browser.findElement(this.cadastroPage.getByNomeUsuario()).getText().equals(CadastroPage.NOME_USUARIO);
	}
	
}
