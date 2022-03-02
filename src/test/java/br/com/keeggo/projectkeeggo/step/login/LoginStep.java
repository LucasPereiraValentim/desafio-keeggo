package br.com.keeggo.projectkeeggo.step.login;

import static org.junit.Assert.assertTrue;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import br.com.keeggo.projectkeeggo.logic.AntesDeLogarLogic;
import br.com.keeggo.projectkeeggo.logic.LoginLogic;
import br.com.keeggo.projectkeeggo.utils.ConfigEvidencia;
import br.com.keeggo.projectkeeggo.utils.WebDriverConfig;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class LoginStep {
	
	private static final Logger LOG = LoggerFactory.getLogger(AntesDeLogarLogic.class);

	private AntesDeLogarLogic antesDeLogarLogic;
	
	private LoginLogic loginLogic;
	
	
	@Before
	public void setup(Scenario scenario) {
		ConfigEvidencia.nomeCenario = scenario.getName();
		this.antesDeLogarLogic = new AntesDeLogarLogic();
		this.loginLogic = new LoginLogic();
		
	}
	
	
	@After
	public void after() {
		WebDriverConfig.quitBrowser();
	}
	
	@Given("home clique no icone de login")
	public void click_btn_redireciona_login() {
		this.antesDeLogarLogic.clickIconeAbrirPopUpLogin();
		
	}
	
	@When("preencho campos de login")
	public void preencho_campos_login() {
		this.antesDeLogarLogic.preencherCampoUsuario();
		this.antesDeLogarLogic.preencherCampoSenha();
	}
	
	@And("clico no botao para entrar")
	public void click_btn_realizar_login() {
		this.antesDeLogarLogic.clickBtnRealizarLogin();
	}
	
	
	@When("valido o login")
	public void valido_login() {
		boolean testeValido = this.loginLogic.validarLogin();
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
