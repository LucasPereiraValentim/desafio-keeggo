package br.com.keeggo.projectkeeggo.page;

import org.openqa.selenium.By;

import lombok.Getter;

@Getter
public class LoginPage {
	
	private final By byBtnCriarNovousuario = By.xpath("//a[@href='javascript:void(0)']");
	
	private final By byInputUserName = By.xpath("//input[@name='username']");
	
	private final By byInputPassWord = By.xpath("//input[@name='password']");
	
	private final By byBtnSignIn = By.xpath("//button[@id='sign_in_btnundefined']");
	
	private final By byNomeUsuario = By.xpath("//a[@id='menuUserLink']");
	
	private final By byCategoria = By.xpath("//span[@id='headphonesTxt']");
	
	private final By byIconeCarrinho = By.xpath("//a[@id='shoppingCartLink']");

}
