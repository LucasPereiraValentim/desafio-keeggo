package br.com.keeggo.projectkeeggo.page;

import org.openqa.selenium.By;

public class LoginPage {
	
	private final By byBtnCriarNovousuario = By.xpath("/html/body/login-modal/div/div/div[3]/a[2]");
	
	private final By byInputUserName = By.xpath("/html/body/login-modal/div/div/div[3]/sec-form/sec-view[1]/div/input");
	
	private final By byInputPassWord = By.xpath("/html/body/login-modal/div/div/div[3]/sec-form/sec-view[2]/div/input");
	
	private final By byBtnSignIn = By.xpath("/html/body/login-modal/div/div/div[3]/sec-form/sec-sender/button");
	
	private final By byNomeUsuario = By.xpath("/html/body/header/nav/ul/li[3]/a/span");
	
	private final By byCategoria = By.xpath("/html/body/div[3]/section/article[1]/div[2]/div[2]/div[3]");
	
	public By getByNomeUsuario() {
		return byNomeUsuario;
	}

	public By getByBtnSignIn() {
		return byBtnSignIn;
	}
	
	public By getByInputPassWord() {
		return byInputPassWord;
	}
	
	public By getByInputUserName() {
		return byInputUserName;
	}
	
	public By getByBtnCriarNovousuario() {
		return byBtnCriarNovousuario;
	}
	
	public By getByCategoria() {
		return byCategoria;
	}
	
}
