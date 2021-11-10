package br.com.keeggo.projectkeeggo.page;

import org.openqa.selenium.By;

public class CadastroPage {
	
	private final By byInputNomeDeUsuario = 
			By.xpath("/html/body/div[3]/section/article/sec-form/div[1]/div[2]/div/div[1]/div[1]/sec-view[1]/div/input");
	
	private final By byInputEmail = 
			By.xpath("/html/body/div[3]/section/article/sec-form/div[1]/div[2]/div/div[1]/div[1]/sec-view[2]/div/input");
	
	private final By byInputSenha = 
			By.xpath("//*[@id=\"formCover\"]/div[1]/div[2]/sec-view[1]/div/input");
	
	private final By byinputSenhaConfirmacao =
			By.xpath("/html/body/div[3]/section/article/sec-form/div[1]/div[2]/div/div[1]/div[2]/sec-view[2]/div/input");
	
	private final By byInputPrimeiroNome = 
			By.xpath("/html/body/div[3]/section/article/sec-form/div[1]/div[2]/div/div[2]/div[1]/sec-view[1]/div/input");
	
	private final By byInputSegundoNome =
			By.xpath("/html/body/div[3]/section/article/sec-form/div[1]/div[2]/div/div[2]/div[1]/sec-view[2]/div/input");
	
	private final By byInputTelefone = 
			By.xpath("/html/body/div[3]/section/article/sec-form/div[1]/div[2]/div/div[2]/div[2]/sec-view/div/input");

	private final By byXpathSelect =
	By.xpath("/html/body/div[3]/section/article/sec-form/div[1]/div[2]/div/div[3]/div[1]/sec-view[1]/div/select");
	
	private final By byInputCidade =
			By.xpath("/html/body/div[3]/section/article/sec-form/div[1]/div[2]/div/div[3]/div[1]/sec-view[2]/div/input");
	
	private final By byInputEndereco = 
			By.xpath("/html/body/div[3]/section/article/sec-form/div[1]/div[2]/div/div[3]/div[2]/sec-view[1]/div/input");
	
	private final By byInputEstado =
			By.xpath("/html/body/div[3]/section/article/sec-form/div[1]/div[2]/div/div[3]/div[2]/sec-view[2]/div/input");
	
	private final By byInputCep = 
			By.xpath("/html/body/div[3]/section/article/sec-form/div[1]/div[2]/div/div[3]/div[3]/sec-view/div/input");
	
	private final By byCheckBoxConcordoTermos = 
			By.xpath("/html/body/div[3]/section/article/sec-form/div[1]/div[2]/div/sec-view/div/input");
	
	private final By byBtnRegistrar = 
			By.xpath("/html/body/div[3]/section/article/sec-form/div[2]/sec-sender/button");
	
	private final By byNomeUsuario = By.xpath("/html/body/header/nav/ul/li[3]/a/span");
	
	public static final String URL_HOME = "https://www.advantageonlineshopping.com/#/";
	
	public static String NOME_USUARIO = "JoaoJorge ";
	
	public By getByInputNomeDeUsuario() {
		return byInputNomeDeUsuario;
	}
	
	public By getByInputEmail() {
		return byInputEmail;
	}
	
	public By getByInputSenha() {
		return byInputSenha;
	}
	
	
	public By getByInputSenhaConfirmacao() {
		return byinputSenhaConfirmacao;
	}
	
	public By getByInputPrimeiroNome() {
		return byInputPrimeiroNome;
	}
	
	public By getByInputSegundoNome() {
		return byInputSegundoNome;
	}
	
	public By getByInputTelefone() {
		return byInputTelefone;
	}

	
	public By getSelectPais() {
		return byXpathSelect;
	}
	
	public By getByBtnRegistrar() {
		return byBtnRegistrar;
	}
	
	public By getByCheckBoxConcordoTermos() {
		return byCheckBoxConcordoTermos;
	}
	
	public By getByInputCep() {
		return byInputCep;
	}
	
	public By getByInputCidade() {
		return byInputCidade;
	}
	
	public By getByInputEndereco() {
		return byInputEndereco;
	}
	
	public By getByInputEstado() {
		return byInputEstado;
	}

	public By getByNomeUsuario() {
		return byNomeUsuario;
	}
	
	
}
