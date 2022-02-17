package br.com.keeggo.projectkeeggo.step.login;

import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import br.com.keeggo.projectkeeggo.config.ConsoleColors;
import br.com.keeggo.projectkeeggo.logic.HomeLogic;
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

	private HomeLogic homeLogic;
	
	private LoginLogic loginLogic;
	
	private ConfigEvidencia configEvidencia;
	
	@Before
	public void setup(Scenario scenario) {
		ConfigEvidencia.nameFile = scenario.getName();
		this.homeLogic = new HomeLogic();
		this.loginLogic = new LoginLogic();
		this.configEvidencia = new ConfigEvidencia();
	}
	
	
	@After
	public void after() {
		
		this.configEvidencia.fecharPdf();
		WebDriverConfig.browser.close();
	}
	
	@Given("home clique no icone de login")
	public void click_btn_redireciona_login() {
		String initTestTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
		System.out.println(ConsoleColors.GREEN  + "\t\tLogs: ---- Teste no cenário "
				+"\""+ ConfigEvidencia.nameFile + "\"" + " Iniciado na data de "+ initTestTime +" ----");
		this.homeLogic.clickIconeAbrirPopUpLogin();
		
	}
	
	@When("preencho campos de login")
	public void preencho_campos_login() {
		this.homeLogic.preencherCampoUsuario();
		this.homeLogic.preencherCampoSenha();
	}
	
	@And("clico no btn de logar")
	public void click_btn_realizar_login() {
		this.homeLogic.clickBtnRealizarLogin();
	}
	
	
	@When("valido o login")
	public void valido_login() {
		boolean testeValido = this.loginLogic.validarLogin();
		if (testeValido) {
			System.out.println(ConsoleColors.GREEN + "\t\t\t\tLogs: ############ TESTE PASSOU ############");
			assertTrue(testeValido);
		} else {
			System.out.println(ConsoleColors.RED + "\t\t\t\tLogs: ############ TESTE FALHOU ############");
			assertTrue(false);
		}
	}
	
	
}
