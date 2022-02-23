package br.com.keeggo.projectkeeggo.page;

import org.openqa.selenium.By;

import br.com.keeggo.projectkeeggo.utils.UsuarioRandom;
import lombok.Getter;

@Getter
public class CadastroPage {
	
	private final By byInputNomeDeUsuario = 
			By.xpath("//input[@name='usernameRegisterPage']");
	
	private final By byInputEmail = 
			By.xpath("//input[@name='emailRegisterPage']");
	
	private final By byInputSenha = 
			By.xpath("//input[@name='passwordRegisterPage']");
	
	private final By byInputConfirmacaoSenha =
			By.xpath("//input[@name='confirm_passwordRegisterPage']");
	
	private final By byInputPrimeiroNome = 
			By.xpath("//input[@name='first_nameRegisterPage']");
	
	private final By byInputSegundoNome =
			By.xpath("//input[@name='last_nameRegisterPage']");
	
	private final By byInputTelefone = 
			By.xpath("//input[@name='phone_numberRegisterPage']");
	
	private final By byXpathSelect =
	By.xpath("//select[@name='countryListboxRegisterPage']");
	
	private final By byInputCidade =
			By.xpath("//input[@name='cityRegisterPage']");
	
	private final By byInputEndereco = 
			By.xpath("//input[@name='addressRegisterPage']");
	
	private final By byInputEstado =
			By.xpath("//input[@name='state_/_province_/_regionRegisterPage']");
	
	private final By byInputCep = 
			By.xpath("//input[@name='postal_codeRegisterPage']");
	
	private final By byCheckBoxConcordoTermos = 
			By.xpath("//input[@name='i_agree']");
	
	private final By byBtnRegistrar = 
			By.xpath("//button[@id='register_btnundefined']");
	
	private final By byNomeUsuario = By.xpath("//a[@id='menuUserLink']");
	
	private UsuarioRandom usuarioRandom;
	
	public static String senha = "#Pp82369785";
	
	public CadastroPage() {
		this.usuarioRandom = new UsuarioRandom();
		try {
			this.usuarioRandom.consumirApiNomeAleatorio();
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.usuarioRandom.gravarUserNameFileTxt();
	}
	
	
}
