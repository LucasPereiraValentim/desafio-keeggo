package br.com.keeggo.projectkeeggo.step.cadastro;

import static org.junit.Assert.assertTrue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.keeggo.projectkeeggo.logic.CadastroLogic;
import br.com.keeggo.projectkeeggo.logic.HomeLogic;
import br.com.keeggo.projectkeeggo.utils.ConfigEvidencia;
import br.com.keeggo.projectkeeggo.utils.WebDriverConfig;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CadastroStep {
	
	private static final Logger LOG = LoggerFactory.getLogger(HomeLogic.class);
	
	private HomeLogic homeLogic;
	private CadastroLogic cadastroLogic;
	
	@Before
	public void setup(Scenario scenario) {
		ConfigEvidencia.nameFile = scenario.getName();
		this.homeLogic = new HomeLogic();
		this.cadastroLogic = new CadastroLogic();
	}

	
	@After
	public void after() {
		WebDriverConfig.browser.close();
	}
	
	@Given("home clique no icone de login")
	public void click_btn_redireciona_login() {
		String msg = "Teste no cenário " + ConfigEvidencia.nameFile;
		LOG.info(msg);
		this.homeLogic.clickIconeAbrirPopUpLogin();
		
	}

	@When("clico no botao para redirecionar para tela de cadastro")
	public void click_btn_redirecionar_cadastro() {		
		this.homeLogic.clickBtnRedirecionarParaCadastro(); 
	}
	
	@And("preencho os campos de cadastro")
	public void preencho_campos_cadastro() {
		this.cadastroLogic.preenchoUsuario();
		this.cadastroLogic.preenchoEmail();
		this.cadastroLogic.preenchoSenha();
		this.cadastroLogic.preenchoSenhaConfirmacao();
		this.cadastroLogic.preenchoPrimeiroNome();
		this.cadastroLogic.preenchoSegundoNome();
		this.cadastroLogic.preenchoTelefone();
		this.cadastroLogic.SelecionoBrasilSelect();
		this.cadastroLogic.preenchoCidade();
		this.cadastroLogic.preenchoEndereco();
		this.cadastroLogic.preenchoEstado();
		this.cadastroLogic.preenchoCep();
	}
	
	@And("clico no checkbox de termos de privacidade")
	public void clico_checkbox_privacidade() {
		this.cadastroLogic.clicoCheckBoxTermosDePrivacidade();
	}
	
	@And("clico no botao de registrar novo usuario")
	public void clico_btn_registrar_usuario() {
		this.cadastroLogic.clicoBtnRegistro();
	}
	
	@Then("valido cadastro")
	public void validar_cadastro() {
		boolean testeValido = this.cadastroLogic.validarCadastro();
		if (testeValido) {
			String msg = "TEST PASSED";
			LOG.info(msg);
			assertTrue(testeValido);
		} else {
			String msg = "TEST FALEID";
			LOG.error(msg);
			assertTrue(false);
		}
	}	
	
}
