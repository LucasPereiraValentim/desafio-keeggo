package br.com.keeggo.projectkeeggo.step.antes_de_logar;

import static org.junit.Assert.assertTrue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.keeggo.projectkeeggo.logic.AntesDeLogarLogic;
import br.com.keeggo.projectkeeggo.utils.ConfigEvidencia;
import br.com.keeggo.projectkeeggo.utils.WebDriverConfig;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AntesDeLogarStep {
	
private static final Logger LOG = LoggerFactory.getLogger(AntesDeLogarLogic.class);
	
	private AntesDeLogarLogic antesDeLogarLogic;
	
	@Before
	public void setup(Scenario scenario) {
		ConfigEvidencia.nomeCenario = scenario.getName();
		this.antesDeLogarLogic = new AntesDeLogarLogic();
	}

	
	@After
	public void after() {
		WebDriverConfig.quitBrowser();
	}
	
	@Given("home clique no icone de login")
	public void clico_no_icone_para_abrir_tela_de_login() {
		this.antesDeLogarLogic.clickIconeAbrirPopUpLogin();
	}

	@When("preencho campos de com login com dados invalidos")
	public void preencher_campos_de_login_com_dados_incorretos() {		
		this.antesDeLogarLogic.preencherCampoUsuarioComDadosInvalidos();
		this.antesDeLogarLogic.preencherCampoSenhaComDadosInvalidos();
	}
	
	@And("clico no botão de entrar")
	public void clico_no_botao_de_entrar() {
		this.antesDeLogarLogic.clickBtnRealizarLogin();
	}
	
	@Then("valido mensagem de erro ao logar")
	public void validar_msg() {
		boolean testeValido = this.antesDeLogarLogic.validarMsgErroAoLogar();
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
