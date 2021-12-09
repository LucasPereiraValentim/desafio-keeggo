package br.com.keeggo.projectkeeggo.page;

import org.openqa.selenium.By;

import br.com.keeggo.projectkeeggo.utils.UsuarioRandom;
import lombok.Getter;

@Getter
public class CadastroPage {
	
	private final By byInputNomeDeUsuario = 
			By.xpath("/html/body/div[3]/section/article/sec-form/div[1]/div[2]/div/div[1]/div[1]/sec-view[1]/div/input");
	
	private final By byInputEmail = 
			By.xpath("/html/body/div[3]/section/article/sec-form/div[1]/div[2]/div/div[1]/div[1]/sec-view[2]/div/input");
	
	private final By byInputSenha = 
			By.xpath("//*[@id=\"formCover\"]/div[1]/div[2]/sec-view[1]/div/input");
	
	private final By byInputConfirmacaoSenha =
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
	
	private UsuarioRandom usuarioRandom;
	
	public static String senha = "#Pp82369785";
	
	public CadastroPage() {
		this.usuarioRandom = new UsuarioRandom();
		try {
			this.usuarioRandom.consumirApiNomeAleatorio();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.usuarioRandom.gravarUserNameFileTxt();
	}
	
	
}
