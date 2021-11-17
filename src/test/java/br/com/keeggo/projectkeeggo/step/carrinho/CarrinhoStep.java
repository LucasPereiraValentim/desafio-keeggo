package br.com.keeggo.projectkeeggo.step.carrinho;

import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import br.com.keeggo.projectkeeggo.config.ConfigEvidencia;
import br.com.keeggo.projectkeeggo.config.ConsoleColors;
import br.com.keeggo.projectkeeggo.logic.CarrinhoLogic;
import br.com.keeggo.projectkeeggo.logic.HomeLogic;
import br.com.keeggo.projectkeeggo.logic.LoginLogic;
import br.com.keeggo.projectkeeggo.logic.ProdutoLogic;
import br.com.keeggo.projectkeeggo.logic.webdriver.WebDriverConfig;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CarrinhoStep{
	
	private HomeLogic homeLogic;
	
	private LoginLogic loginLogic;
	
	private ProdutoLogic produtoLogic;
	
	private CarrinhoLogic carrinhoLogic; 
	
	@Before
	public void setup(Scenario scenario) {
		ConfigEvidencia.nameFile = scenario.getName();
		this.homeLogic = new HomeLogic();
		this.loginLogic = new LoginLogic();
		this.produtoLogic = new ProdutoLogic();
		this.carrinhoLogic = new CarrinhoLogic();
	}
	
	@After
	public void after() {
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
	
	
	@When("seleciono uma categoria")
	public void seleciono_categoria_de_produtos() {
		this.loginLogic.selecionarCategoria();
	}
	
	@And("seleciono um produto")
	public void selecione_um_produto() {
		this.produtoLogic.selecionarProduto();
	}
	
	@When("adiciono o produto ao carrinho de compras")
	public void add_ao_carrinho() {
		this.produtoLogic.addProdutoCarrinho();
	}
	
	@And("Clico no botão para ir para o carrinho")
	public void click_btn_redirecionar_carrinho() {
		this.produtoLogic.clicoBtnIrParaCarrinho();
	}
	
	@Then("valido se foi adicionado ao carrinho")
	public void validar_add_carrinho() {
		boolean testeValido = this.carrinhoLogic.isAddCarrinho();
		if (testeValido) {
			System.out.println(ConsoleColors.GREEN + "\t\t\t\tLogs: ############ TESTE PASSOU ############");
			assertTrue(testeValido);
		} else {
			System.out.println(ConsoleColors.RED + "\t\t\t\tLogs: ############ TESTE FALHOU ############");
			assertTrue(false);
		}
	}
	
	
	@When("clico no icone de carrinho")
	public void click_icone_carrinho() {
		this.loginLogic.clicarIconeCarrinho();
	}
	
	
	@And("clico em remover produto")
	public void click_remove_produto() {
		this.carrinhoLogic.clickBtnRemoveProduto();
	}
	
	@Then("valido se foi removido")
	public void validar_remove_produto() {
		boolean testeValido = this.carrinhoLogic.isRemoveCarrinho();
		if (testeValido) {
			System.out.println(ConsoleColors.GREEN + "\t\t\t\tLogs: ############ TESTE PASSOU ############");
			assertTrue(testeValido);
		} else {
			System.out.println(ConsoleColors.RED + "\t\t\t\tLogs: ############ TESTE FALHOU ############");
			assertTrue(false);
		}
	}
	
}
