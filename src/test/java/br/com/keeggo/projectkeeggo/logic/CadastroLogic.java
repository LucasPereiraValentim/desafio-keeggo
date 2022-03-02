package br.com.keeggo.projectkeeggo.logic;

import java.time.Duration;

import org.openqa.selenium.support.ui.Select;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.keeggo.projectkeeggo.page.CadastroPage;
import br.com.keeggo.projectkeeggo.utils.ConfigEvidencia;
import br.com.keeggo.projectkeeggo.utils.UsuarioRandom;
import br.com.keeggo.projectkeeggo.utils.WebDriverConfig;

public class CadastroLogic {
	
	private static final Logger LOG = LoggerFactory.getLogger(AntesDeLogarLogic.class);

	private CadastroPage cadastroPage;

	private ConfigEvidencia configEvidencia;

	public CadastroLogic() {
		this.cadastroPage = new CadastroPage();
		this.configEvidencia = new ConfigEvidencia();
	}
	
	// campo nome usuário
	public void preenchoUsuario() {
		String msg = "Preencho o campo \"Username\"";
		LOG.info(msg);
		WebDriverConfig.waitElementToBeClickable(cadastroPage.getByInputNomeDeUsuario(), Duration.ofSeconds(50));
		WebDriverConfig.browser.findElement(this.cadastroPage.getByInputNomeDeUsuario()).sendKeys(UsuarioRandom.nomeUsuario);
		this.configEvidencia.gerarScreenshot(WebDriverConfig.browser);
	}
	
	// campo de e-mail
	public void preenchoEmail() {
		String msg = "Preencho o campo \"Email\"";
		LOG.info(msg);
		WebDriverConfig.waitElementToBeClickable(cadastroPage.getByInputEmail(), Duration.ofSeconds(50));
		WebDriverConfig.browser.findElement(this.cadastroPage.getByInputEmail()).sendKeys(UsuarioRandom.email);
		this.configEvidencia.gerarScreenshot(WebDriverConfig.browser);
	}

	// campo de senha
	public void preenchoSenha() {
		String msg = "Preencho o campo \"Password\"";
		LOG.info(msg);
		WebDriverConfig.waitElementToBeClickable(cadastroPage.getByInputSenha(), Duration.ofSeconds(50));
		WebDriverConfig.browser.findElement(this.cadastroPage.getByInputSenha()).sendKeys(CadastroPage.senha);
		this.configEvidencia.gerarScreenshot(WebDriverConfig.browser);
	}

	// campos senha de confirmação
	public void preenchoSenhaConfirmacao() {
		String msg = "Preencho o campo \"Confirm password\"";
		LOG.info(msg);
		WebDriverConfig.waitElementToBeClickable(cadastroPage.getByInputConfirmacaoSenha(), Duration.ofSeconds(50));
		WebDriverConfig.browser.findElement(this.cadastroPage.getByInputConfirmacaoSenha()).sendKeys(CadastroPage.senha);
		this.configEvidencia.gerarScreenshot(WebDriverConfig.browser);
	}

	// campo primeiro nome
	public void preenchoPrimeiroNome() {
		String msg = "Preencho o campo \"First Name\"";
		LOG.info(msg);
		WebDriverConfig.waitElementToBeClickable(cadastroPage.getByInputPrimeiroNome(), Duration.ofSeconds(50));
		WebDriverConfig.browser.findElement(this.cadastroPage.getByInputPrimeiroNome()).sendKeys(UsuarioRandom.firstName);
		this.configEvidencia.gerarScreenshot(WebDriverConfig.browser);
	}

	// Campo segundo nome
	public void preenchoSegundoNome() {
		String msg = "Preencho o campo \"Last Name\"";
		LOG.info(msg);
		WebDriverConfig.waitElementToBeClickable(cadastroPage.getByInputSegundoNome(), Duration.ofSeconds(50));
		WebDriverConfig.browser.findElement(this.cadastroPage.getByInputSegundoNome()).sendKeys(UsuarioRandom.lastName);
		this.configEvidencia.gerarScreenshot(WebDriverConfig.browser);
	}

	// Campo telefone
	public void preenchoTelefone() {
		String msg = "Preencho o campo \"Phone Number\"";
		LOG.info(msg);
		WebDriverConfig.waitElementToBeClickable(cadastroPage.getByInputTelefone(), Duration.ofSeconds(50));
		WebDriverConfig.browser.findElement(this.cadastroPage.getByInputTelefone()).sendKeys("(61) 111-111");
		this.configEvidencia.gerarScreenshot(WebDriverConfig.browser);
	}

	// Campo para selecionar um país
	public void SelecionoBrasilSelect() {
		String msg = "Seleciono \"Brazil\" no campo select \"Country\"";
		LOG.info(msg);
		WebDriverConfig.browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		WebDriverConfig.scroll(this.cadastroPage.getByXpathSelect());
		Select select = new Select(WebDriverConfig.browser.findElement(this.cadastroPage.getByXpathSelect()));
		select.selectByVisibleText("Brazil");
		this.configEvidencia.gerarScreenshot(WebDriverConfig.browser);
	}

	// Campo cidade
	public void preenchoCidade() {
		String msg = "Preencho o campo \"City\"";
		LOG.info(msg);
		WebDriverConfig.waitElementToBeClickable(cadastroPage.getByInputCidade(), Duration.ofSeconds(50));
		WebDriverConfig.browser.findElement(this.cadastroPage.getByInputCidade()).sendKeys("Planaltina");
		this.configEvidencia.gerarScreenshot(WebDriverConfig.browser);
	}

	// Campo Endereço
	public void preenchoEndereco() {
		String msg = "Preencho o campo \"Adress\"";
		LOG.info(msg);
		WebDriverConfig.waitElementToBeClickable(cadastroPage.getByInputEndereco(), Duration.ofSeconds(50));
		WebDriverConfig.scroll(this.cadastroPage.getByInputEndereco());
		WebDriverConfig.browser.findElement(this.cadastroPage.getByInputEndereco()).sendKeys("Q. 5 Conj. F Lote 90");
		this.configEvidencia.gerarScreenshot(WebDriverConfig.browser);
	}

	// Campo Estado
	public void preenchoEstado() {
		String msg = "Preencho o campo \"State/Province/Region\"";
		LOG.info(msg);
		WebDriverConfig.waitElementToBeClickable(cadastroPage.getByInputEstado(), Duration.ofSeconds(50));
		WebDriverConfig.browser.findElement(this.cadastroPage.getByInputEstado()).sendKeys("Brasília");
		this.configEvidencia.gerarScreenshot(WebDriverConfig.browser);
	}

	// Campo CEP
	public void preenchoCep() {
		String msg = "Preencho o campo \"Postal Code\"";
		LOG.info(msg);
		WebDriverConfig.waitElementToBeClickable(cadastroPage.getByInputCep(), Duration.ofSeconds(50));
		WebDriverConfig.scroll(this.cadastroPage.getByInputCep());
		WebDriverConfig.browser.findElement(this.cadastroPage.getByInputCep()).sendKeys("73350-410");
		this.configEvidencia.gerarScreenshot(WebDriverConfig.browser);
	}

	// Clique para aceitar termos de privacidade
	public void clicoCheckBoxTermosDePrivacidade() {
		String msg = "Clico na CheckBox \"I agree to the advantageonlineshopping.com Conditions Of Use and Privacy Notice\"";
		LOG.info(msg);
		WebDriverConfig.waitElementToBeClickable(cadastroPage.getByCheckBoxConcordoTermos(), Duration.ofSeconds(50));
		WebDriverConfig.scroll(this.cadastroPage.getByCheckBoxConcordoTermos());
		WebDriverConfig.browser.findElement(this.cadastroPage.getByCheckBoxConcordoTermos()).click();
		this.configEvidencia.gerarScreenshot(WebDriverConfig.browser);
	}

	// Botão para realizar registro de novo usuário
	public void clicoBtnRegistro() {
		String msg = "Clico no botão \"Register\"";
		LOG.info(msg);
		WebDriverConfig.waitElementToBeClickable(cadastroPage.getByBtnRegistrar(), Duration.ofSeconds(50));
		WebDriverConfig.browser.findElement(this.cadastroPage.getByBtnRegistrar()).click();
		this.configEvidencia.gerarScreenshot(WebDriverConfig.browser);
	}

	// Verifica se encontra os elementos para validar
	public boolean validarCadastro() {
		String msg = "Válido cadastro";
		LOG.info(msg);
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.configEvidencia.gerarScreenshot(WebDriverConfig.browser);
		this.configEvidencia.fecharPdf();
		return WebDriverConfig.browser.getCurrentUrl().equals(WebDriverConfig.URL_HOME) && WebDriverConfig.browser
				.findElement(this.cadastroPage.getByNomeUsuario()).getText().equals(UsuarioRandom.nomeUsuario);
	}

}
