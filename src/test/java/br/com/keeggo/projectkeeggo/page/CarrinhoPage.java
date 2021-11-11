package br.com.keeggo.projectkeeggo.page;

import org.openqa.selenium.By;

public class CarrinhoPage {
	
	private final By byItensCarrinho = By.cssSelector("#userCart > span");
	
	private final By byBtnRemove = By.xpath("/html/body/div[3]/section/article/div[1]/table/tbody/tr/td[6]/span/a[3]");
	
	private final By btMsgCarrinho = By.xpath("/html/body/div[3]/section/article/div[1]/div/label");

	public static final String MSG_CARRINHO = "Your shopping cart is empty";
	
	public By getByItensCarrinho() {
		return byItensCarrinho;
	}
	
	public By getByBtnRemove() {
		return byBtnRemove;
	}
	
	public By getBtMsgCarrinho() {
		return btMsgCarrinho;
	}

	
}
