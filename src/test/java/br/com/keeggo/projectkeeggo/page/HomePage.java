package br.com.keeggo.projectkeeggo.page;

import org.openqa.selenium.By;

public class HomePage {
	
	private final By byRedirecionaLogin = By.xpath("//*[@id=\"menuUser\"]");

	public By getByRedirecionaLogin() {
		return byRedirecionaLogin;
	}
	
	
	
	
}
