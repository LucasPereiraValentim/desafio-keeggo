package br.com.keeggo.projectkeeggo.step.cadastro;

import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import br.com.keeggo.projectkeeggo.config.ConfigEvidencia;
import br.com.keeggo.projectkeeggo.config.ConsoleColors;
import br.com.keeggo.projectkeeggo.logic.CadastroLogic;
import br.com.keeggo.projectkeeggo.logic.HomeLogic;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CadastroStep {
	
	private HomeLogic homeLogic;
	private CadastroLogic cadastroLogic;
	
	@Before
	public void setup(Scenario scenario) {
		ConfigEvidencia.nameFile = scenario.getName();
		this.homeLogic = new HomeLogic();
	}

	
	@After
	public void after() {
		this.cadastroLogic.fecharBrowser();
	}
	
	@Given("home clique no icone de login")
	public void click_btn_redireciona_login() {
		String initTestTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
		System.out.println(ConsoleColors.GREEN  + "\t\tLogs: ---- Teste no cenário "
				+"\""+ ConfigEvidencia.nameFile + "\"" + " Iniciado na data de "+ initTestTime +" ----");
		this.homeLogic.clickBtnRedirecionarLogin();
		
	}

	@When("clico btn para redirecionar para criar novo usuario")
	public void click_btn_redirecionar_cadastro() {		
		this.cadastroLogic = this.homeLogic.clickBtnRedirecionarParaCadastro(); 
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
			System.out.println(ConsoleColors.GREEN + "\t\t\t\tLogs: ############ TESTE PASSOU ############");
			assertTrue(testeValido);
		} else {
			System.out.println(ConsoleColors.RED + "\t\t\t\tLogs: ############ TESTE FALHOU ############");
			assertTrue(false);
		}
	}	
	
}
