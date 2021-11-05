package br.com.keeggo.projectkeeggo.page;

import org.openqa.selenium.By;


public class LoginPage {
	
	private final By byBtnCriarNovoUsuario = By.xpath("//*[text()='CREATE NEW ACCOUNT']");

	public By getByBtnCriarNovoUsuario() {
		return byBtnCriarNovoUsuario;
	}
	
	
	
	
}
