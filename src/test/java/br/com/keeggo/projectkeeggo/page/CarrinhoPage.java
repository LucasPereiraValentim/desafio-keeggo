package br.com.keeggo.projectkeeggo.page;

import org.openqa.selenium.By;

public class CarrinhoPage {
	
	private final By byItensCarrinho = By.cssSelector("#userCart > span");
	
	public By getByItensCarrinho() {
		return byItensCarrinho;
	}
	
}
