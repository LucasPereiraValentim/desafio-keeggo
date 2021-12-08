package br.com.keeggo.projectkeeggo.logic;

import org.openqa.selenium.support.ui.Select;

import br.com.keeggo.projectkeeggo.config.ConfigEvidencia;
import br.com.keeggo.projectkeeggo.config.ConsoleColors;
import br.com.keeggo.projectkeeggo.config.UsuarioRandom;
import br.com.keeggo.projectkeeggo.logic.webdriver.WebDriverConfig;
import br.com.keeggo.projectkeeggo.page.CadastroPage;

public class CadastroLogic {

	private CadastroPage cadastroPage;

	private ConfigEvidencia configEvidencia;

	public CadastroLogic() {
		this.cadastroPage = new CadastroPage();
		this.configEvidencia = new ConfigEvidencia();
	}
	
	// campo nome usuário
	public void preenchoUsuario() {
		final String msg = "\t\t\tLogs: ---- Preencho o campo \"Username\" ----";
		System.out.println(msg);
		WebDriverConfig.waitElementToBeClickable(cadastroPage.getByInputNomeDeUsuario(), 30);
		WebDriverConfig.browser.findElement(this.cadastroPage.getByInputNomeDeUsuario()).sendKeys(UsuarioRandom.nomeUsuario);
		this.configEvidencia.gerarScreenshot(WebDriverConfig.browser);
	}
	
	// campo de e-mail
	public void preenchoEmail() {
		final String msg = "\t\t\tLogs: ---- Preencho o campo \"Email\" ----";
		System.out.println(msg);
		WebDriverConfig.waitElementToBeClickable(cadastroPage.getByInputEmail(), 30);
		WebDriverConfig.browser.findElement(this.cadastroPage.getByInputEmail()).sendKeys(UsuarioRandom.email + "@teste.com.br");
		this.configEvidencia.gerarScreenshot(WebDriverConfig.browser);
	}

	// campo de senha
	public void preenchoSenha() {
		final String msg = "\t\t\tLogs: ---- Preencho o campo \"Password\" ----";
		System.out.println(msg);
		WebDriverConfig.waitElementToBeClickable(cadastroPage.getByInputSenha(), 30);
		WebDriverConfig.browser.findElement(this.cadastroPage.getByInputSenha()).sendKeys(CadastroPage.senha);
		this.configEvidencia.gerarScreenshot(WebDriverConfig.browser);
	}

	// campos senha de confirmação
	public void preenchoSenhaConfirmacao() {
		final String msg = "\t\t\tLogs: ---- Preencho o campo \"Confirm password\" ----";
		System.out.println(msg);
		WebDriverConfig.waitElementToBeClickable(cadastroPage.getByInputConfirmacaoSenha(), 30);
		WebDriverConfig.browser.findElement(this.cadastroPage.getByInputConfirmacaoSenha()).sendKeys(CadastroPage.senha);
		this.configEvidencia.gerarScreenshot(WebDriverConfig.browser);
	}

	// campo primeiro nome
	public void preenchoPrimeiroNome() {
		final String msg = "\t\t\tLogs: ---- Preencho o campo \"Fist Name\" ----";
		System.out.println(msg);
		WebDriverConfig.waitElementToBeClickable(cadastroPage.getByInputPrimeiroNome(), 30);
		WebDriverConfig.browser.findElement(this.cadastroPage.getByInputPrimeiroNome()).sendKeys(UsuarioRandom.fistName);
		this.configEvidencia.gerarScreenshot(WebDriverConfig.browser);
	}

	// Campo segundo nome
	public void preenchoSegundoNome() {
		final String msg = "\t\t\tLogs: ---- Preencho o campo \"Last Name\" ----";
		System.out.println(msg);
		WebDriverConfig.waitElementToBeClickable(cadastroPage.getByInputSegundoNome(), 30);
		WebDriverConfig.browser.findElement(this.cadastroPage.getByInputSegundoNome()).sendKeys(UsuarioRandom.lastName);
		this.configEvidencia.gerarScreenshot(WebDriverConfig.browser);
	}

	// Campo telefone
	public void preenchoTelefone() {
		final String msg = "\t\t\tLogs: ---- Preencho o campo \"Phone Number\" ----";
		System.out.println(msg);
		WebDriverConfig.waitElementToBeClickable(cadastroPage.getByInputTelefone(), 30);
		WebDriverConfig.browser.findElement(this.cadastroPage.getByInputTelefone()).sendKeys("(61) 111-111");
		this.configEvidencia.gerarScreenshot(WebDriverConfig.browser);
	}

	// Campo para selecionar um país
	public void SelecionoBrasilSelect() {
		final String msg = "\t\t\tLogs: ---- Seleciono \"Brazil\" no campo select \"Country\" ----";
		System.out.println(msg);
		Select select = new Select(WebDriverConfig.browser.findElement(this.cadastroPage.getByXpathSelect()));
		select.selectByVisibleText("Brazil");
		this.configEvidencia.gerarScreenshot(WebDriverConfig.browser);
	}

	// Campo cidade
	public void preenchoCidade() {
		final String msg = "\t\t\tLogs: ---- Preencho o campo \"City\" ----";
		System.out.println(msg);
		WebDriverConfig.waitElementToBeClickable(cadastroPage.getByInputCidade(), 30);
		WebDriverConfig.browser.findElement(this.cadastroPage.getByInputCidade()).sendKeys("Planaltina");
		this.configEvidencia.gerarScreenshot(WebDriverConfig.browser);
	}

	// Campo Endereço
	public void preenchoEndereco() {
		final String msg = "\t\t\tLogs: ---- Preencho o campo \"Adress\" ----";
		System.out.println(msg);
		WebDriverConfig.waitElementToBeClickable(cadastroPage.getByInputEndereco(), 30);
		WebDriverConfig.browser.findElement(this.cadastroPage.getByInputEndereco()).sendKeys("Q. 5 Conj. F Lote 90");
		this.configEvidencia.gerarScreenshot(WebDriverConfig.browser);
	}

	// Campo Estado
	public void preenchoEstado() {
		final String msg = "\t\t\tLogs: ---- Preencho o campo \"State/Province/Region\" ----";
		System.out.println(msg);
		WebDriverConfig.waitElementToBeClickable(cadastroPage.getByInputEstado(), 30);
		WebDriverConfig.browser.findElement(this.cadastroPage.getByInputEstado()).sendKeys("Brasília");
		this.configEvidencia.gerarScreenshot(WebDriverConfig.browser);
	}

	// Campo CEP
	public void preenchoCep() {
		final String msg = "\t\t\tLogs: ---- Preencho o campo \"Postal Code\" ----";
		System.out.println(msg);
		WebDriverConfig.waitElementToBeClickable(cadastroPage.getByInputCep(), 30);
		WebDriverConfig.browser.findElement(this.cadastroPage.getByInputCep()).sendKeys("73350-410");
		this.configEvidencia.gerarScreenshot(WebDriverConfig.browser);
	}

	// Clique para aceitar termos de privacidade
	public void clicoCheckBoxTermosDePrivacidade() {
		final String msg = "\t\t\tLogs: ---- Clico na CheckBox \"I agree to the advantageonlineshopping.com Conditions Of Use and Privacy Notice\" ----";
		System.out.println(msg);
		WebDriverConfig.waitElementToBeClickable(cadastroPage.getByCheckBoxConcordoTermos(), 30);
		WebDriverConfig.browser.findElement(this.cadastroPage.getByCheckBoxConcordoTermos()).click();
		this.configEvidencia.gerarScreenshot(WebDriverConfig.browser);
	}

	// Botão para realizar registro de novo usuário
	public void clicoBtnRegistro() {
		final String msg = "\t\t\tLogs: ---- Clico no botão \"Register\" ----";
		System.out.println(msg);
		WebDriverConfig.waitElementToBeClickable(cadastroPage.getByBtnRegistrar(), 30);
		WebDriverConfig.browser.findElement(this.cadastroPage.getByBtnRegistrar()).click();
		this.configEvidencia.gerarScreenshot(WebDriverConfig.browser);
	}

	// Verifica se encontra os elementos para validar
	public boolean validarCadastro() {
		final String msg = "\t\t\tLogs: ---- Valido cadastro ----" + ConsoleColors.RESET;
		System.out.println(msg);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.configEvidencia.gerarScreenshot(WebDriverConfig.browser);
		this.configEvidencia.fecharPdf();
		return WebDriverConfig.browser.getCurrentUrl().equals(CadastroPage.URL_HOME) && WebDriverConfig.browser
				.findElement(this.cadastroPage.getByNomeUsuario()).getText().equals(UsuarioRandom.nomeUsuario);
	}

}
