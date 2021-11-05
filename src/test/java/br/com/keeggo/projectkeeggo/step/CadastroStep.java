package br.com.keeggo.projectkeeggo.step;

import static org.junit.Assert.assertTrue;

import br.com.keeggo.projectkeeggo.logic.CadastroLogic;
import br.com.keeggo.projectkeeggo.logic.HomeLogic;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class CadastroStep {
	
	private HomeLogic homeLogic;
	private CadastroLogic cadastroLogic;
	
	@Before
	public void setup() {
		this.homeLogic = new HomeLogic();
	}
	
//	@After
//	public void after() {
//		this.cadastroLogic.fecharBrowser();
//	}
	
	@Given("home clique btn para redicionar para login")
	public void click_btn_redireciona_login() {
		this.homeLogic.clickBtnRedirecionarLogin();
		
	}

	@Then("clique btn para redirecionar para criar novo usuario")
	public void click_btn_redirecionar_cadastro() {
		this.cadastroLogic = this.homeLogic.clickBtnRedirecionarParaCadastro(); 
	}
	
	@Then("preencho os campos de cadastro")
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
		if (this.cadastroLogic.validarCadastro()) {
			System.out.println("\t\t\tLog: ---- Teste Passou ----");
			assertTrue(this.cadastroLogic.validarCadastro());
		} else {
			System.out.println("\t\t\tLog: ---- Teste Falhou ----");
		}
		
	}
	
}
